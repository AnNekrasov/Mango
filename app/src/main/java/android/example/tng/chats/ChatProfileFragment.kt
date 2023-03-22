package android.example.tng.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.tng.R
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class ChatProfileFragment : Fragment() {
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigation = getView()!!.findViewById(R.id.nav_view_chat)

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
    }
}


