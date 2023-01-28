package android.example.tng.registration

import android.example.tng.R
import android.example.tng.databinding.FragmentRegistrationBinding
import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment() {
    val args: RegistrationFragmentArgs by navArgs()
    private lateinit var binding: FragmentRegistrationBinding
    private val vm: RegistrationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val phoneNumber = binding.tvPhoneNumber
        phoneNumber.text =
            args.telephoneNumber                   // получаем номер телефона с экрана  авторизации
        var filter =
            InputFilter { source, start, end, dest, dstart, dend ->
                for (i in start until end) {
                    if (!Character.isLetterOrDigit(source[i]) &&
                        Character.toString(source[i]) != "_" &&
                        Character.toString(source[i]) != "-"
                    ) {
                        return@InputFilter ""
                    }
                }
                null
            }
        binding.etUserName.filters = arrayOf(filter)

        binding.btRegistration.setOnClickListener {
            vm.postRegistration(
              binding.tvPhoneNumber.text.toString(),
                binding.etName.text.toString(),
                binding.etUserName.text.toString()
            )
            findNavController().navigate(R.id.action_registrationFragment_to_profileFragment2)
        }
    }
}
