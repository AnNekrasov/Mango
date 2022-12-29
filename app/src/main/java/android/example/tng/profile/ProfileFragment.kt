package android.example.tng.profile

import android.example.tng.base.BaseFragment
import android.example.tng.base.viewBinding
import android.example.tng.databinding.FragmentBaseRecyclerBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment() {

    private val viewModel by viewModels<ProfileViewModel>()

    override val binding by viewBinding { FragmentBaseRecyclerBinding.bind(bindingCreate()) }

    private val mainScreenAdapter by lazy {
        ProfileAdapter(
//            select = {
//                viewModel.handleEventTypeSelection(it)
//            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

        }
//        viewModel.populateList()
//
//        viewModel.itemList.observe(viewLifecycleOwner) {
//            mainScreenAdapter.submitList(it)
//        }
    }
}