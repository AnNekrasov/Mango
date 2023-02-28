package android.example.tng.profile

//import android.example.tng.base.BaseFragment
import android.example.tng.R
import android.example.tng.databinding.FragmentBaseRecyclerBinding
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

// Объединить два айтема, сделать CollapsableToolBar, указать behavior в NestedScrollView


@AndroidEntryPoint
class ProfileFragment : Fragment() {
    var TAG = "blablaProfile"
    val args: ProfileFragmentArgs by navArgs()
    private val viewModel by viewModels<ProfileViewModel>()
    private lateinit var binding: FragmentBaseRecyclerBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var adapter: ProfileAdapter

    // override val binding by viewBinding { FragmentBaseRecyclerBinding.bind(bindingCreate()) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseRecyclerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

//    private val mainScreenAdapter by lazy {
//        ProfileAdapter(
////            select = {
////                viewModel.handleEventTypeSelection(it)
////            }
//        )
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //   val a =  activity as MainActivity
        //   a.initBottomNav()
        val refreshToken = arguments?.get("refresh_token")
        Log.d(TAG, "refreshToken=${refreshToken}")
        val accessToken = arguments?.get("accessToken")
        Log.d(TAG, "accessToken=${accessToken}")
        val userId = arguments?.get("userID")
        Log.d(TAG, "userId = $userId")
        viewModel.getUserInfo()
        adapter = ProfileAdapter {
            findNavController().navigate(R.id.editProfileFragment)
            //разобраться с навигацией!!!
        }

        binding.rvRecycler.adapter = adapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.rvRecycler.layoutManager = linearLayoutManager
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
        //bottomNavigation = binding.navView
        bottomNavigation = getView()!!.findViewById(R.id.nav_view)

        bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.profile_menu -> {
                    findNavController().navigate(R.id.profileFragment)
                }
                R.id.chat_fragment -> {
                    findNavController().navigate(R.id.chatProfileFragment)
                }

            }

        }


//        val ivToEditProfile = getView()?.findViewById<ImageView>(R.id.iv_edit_profile)
//        ivToEditProfile?.setOnClickListener{
//            findNavController().navigate(R.id.editProfileFragment)
//
//        }

        with(binding) {

        }
//        viewModel.populateList()
//
//        viewModel.itemList.observe(viewLifecycleOwner) {
//            mainScreenAdapter.submitList(it)
//        }
    }
}
/* "refresh_token": "8e60755d-4dbb-4949-b1df-214dd2b13397",
"access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjM4NiwidXNlcm5hbWUiOiJzdHJpbmdnaCIsInBob25lIjoiODkzNDU2Nzg3MzQiLCJpYXQiOjE2NzU2OTk0NDYsImV4cCI6MTY3NTcwMDA0Nn0.OKAUs9vOV7P1PSIaZQbbQ-cMp6bi4gxNH1HWdjL_mUM",*/