package android.example.tng.authorization

import android.example.domain.model.CountryModel
import android.example.tng.R
import android.example.tng.databinding.FragmentAutorizationBinding
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.redmadrobot.inputmask.MaskedTextChangedListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAutorizationBinding
    private lateinit var maskListener: MaskedTextChangedListener
    private val vm: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAutorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPhoneInput()
        initCountryPicker()
        vm.isPhonePostLiveData.observe(viewLifecycleOwner) {
            binding.etSmsCode.isVisible = it
            if (!it) {
                // show error
            }
        }
        vm.isUserExist.observe(viewLifecycleOwner) { isUserExists ->
            if (isUserExists) {
                findNavController().navigate(R.id.profileFragment)
            } else {
                // safeArgs, pass phoneNumber in params
                findNavController().navigate(R.id.registrationFragment)
            }
        }
    }

    private fun initPhoneInput() {
        maskListener =
            MaskedTextChangedListener.installOn(binding.etPhoneInput, "([000]) [000]-[00]-[00]")

        binding.btnNext.setOnClickListener {
            vm.processPhone(
                binding.tvCountryCode.text.toString() + " " + binding.etPhoneInput.text.toString()
            )
        }
        binding.etPhoneInput.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                vm.processPhone(
                    binding.tvCountryCode.text.toString() + " " + binding.etPhoneInput.text.toString(),
                )
            }
            false
        }
        binding.etPhoneInput.doOnTextChanged { text, _, _, _ ->
            val phoneLengths = vm.currentCountryModel.value?.phoneLengths ?: listOf(8, 10)
            vm.phoneCorrect =
                phoneLengths.contains(text?.filterNot { c -> c.toString() == ")" || c.toString() == "(" || c.toString() == "-" || c.toString() == " " }?.length)
            binding.btnNext.isEnabled =
                text?.filterNot { c -> c.toString() == ")" || c.toString() == "(" || c.toString() == "-" || c.toString() == " " }?.length == 10
        }

        binding.etSmsCode.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.toString().length == 6) {
                    vm.onCodeEntered(s.toString())
                }
            }
        })
    }

    private fun initCountryPicker() {
        binding.countryPick.setOnClickListener {
            fragmentManager?.let {
                CountryPickBottomSheetFragment(this::updateCurrentCountry).show(it, "countries")
            }
        }
    }

    private fun updateCurrentCountry(country: CountryModel) {
        vm.currentCountryModel.value = country
        binding.tvCountryCode.text = country.code
        binding.etPhoneInput?.text?.clear()
        when (country.phoneLengths.maxOrNull()) {
            7 -> maskListener.primaryFormat = "[000]-[00]-[00]"
            8 -> maskListener.primaryFormat = "[00]-[00]-[00]-[00]"
            9 -> maskListener.primaryFormat = "[000]-[000]-[000]"
            else -> maskListener.primaryFormat = "([000]) [000]-[00]-[00]"
        }
    }
}