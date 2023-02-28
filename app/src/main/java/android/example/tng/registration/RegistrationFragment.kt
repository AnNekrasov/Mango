package android.example.tng.registration

import android.example.tng.R
import android.example.tng.databinding.FragmentRegistrationBinding
import android.example.tng.profile.ProfileViewModel
import android.example.tng.utils.SessionManager
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistrationFragment : Fragment() {
    var TAG = "blabla"
    val bundle = Bundle()

    val args: RegistrationFragmentArgs by navArgs()
    private val profileVm :ProfileViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding
    private val vm: RegistrationViewModel by viewModels()
    var mediatorLiveData: MediatorLiveData<String> = MediatorLiveData()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sessionManager  = SessionManager(requireContext())

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

            vm.ldRefreshToken.observe(viewLifecycleOwner){
                sessionManager.saveAuthToken(vm.accessToken.toString())
            bundle.putString("refresh_token", vm.refreshToken)
            bundle.putString("accessToken", vm.accessToken)
            bundle.putString("userID", vm.userId.toString())
            findNavController().navigate(R.id.profileFragment, bundle)
        }}
    }
}
//            vm.ldAccessToken.observe(viewLifecycleOwner){
//                Log.d(TAG,"accessTokenValue = ${vm.ldAccessToken.value}")
//                val actionAccess = vm.ldAccessToken.value?.let {
//                    it->
//                    RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(it)
//                    Log.d(TAG,"it = $it")
//                }
//                if (actionAccess!=null){
//                    findNavController().navigate(actionAccess)
//                }
//
//                vm.ldUserId.observe(viewLifecycleOwner){
//                    Log.d(TAG,"userIDValue = ${vm.ldUserId.value}")
//                    val actionUserId = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(vm.ldUserId.value.toString())
//                    findNavController().navigate(actionUserId)
//                }
//            }
//            val action =
//                vm.ldAccessToken.value?.let { it1 ->
//                    vm.ldRefreshToken.value?.let { it2 ->
//                        vm.ldUserId.value?.let { it3 ->
//                            RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(
//                                it1, it2, it3
//                            )
//                        }
//                    }
//                }
//            Log.d(TAG,"accessToken = ${vm.ldAccessToken.value}")
//            if (action != null) {
//                findNavController().navigate(action)
//            }
//        }
//    }
//}


//
//            vm.registrationResponse.observe(viewLifecycleOwner){
//                val accessResponse = vm.registrationResponse.value
//                val action = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(accessResponse)
//            }
//            vm.lvAccessToken.observe(viewLifecycleOwner){
//                val  accessToken = vm.lvAccessToken.value
//                val action = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(accessToken,"sd",1)
//                findNavController().navigate(action)
//            }
//            vm.lvRefreshToken.observe(viewLifecycleOwner){
//                val refreshToken = vm.lvRefreshToken.value
//                val action = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(refreshToken)
//                findNavController().navigate(action)
//
//            }
//            vm.ldUserId.observe(viewLifecycleOwner){
//                val userId = vm.ldUserId.value
//                val action = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment2(userId)
//                findNavController().navigate(action)
//
//            }

/*    mediatorLiveData.observe(viewLifecycleOwner, object : Observer<String?> {

                override fun onChanged(t: String?) {
                    val userID = t
                    val refreshToken = t
                    val accessToken = t.toString()
                }
            })

//            vm.mediatorLiveData.observe(viewLifecycleOwner) {
//                val userID = vm.ldUserId
//                val accessToken = vm.lvAccessToken
//                val refreshToken = vm.lvRefreshToken
////                val action =

*/
