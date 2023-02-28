package android.example.tng.profile

import android.example.domain.model.profile.User
import android.example.tng.R
import android.example.tng.databinding.ItemUserBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//class ProfileAdapter(
//    //select: (event: Event) -> Unit = {}
//) : BaseRecyclerAdapter(
//    listOf(
//        UserDelegate(),
//    )
//)
class ProfileAdapter(
    private var itemClickListener: (id : Int) -> Unit
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    private val listUserInfo = mutableListOf<User>()
    private lateinit var binding: ItemUserBinding

    inner class ProfileViewHolder(
        private val itemBinding: ItemUserBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(user: User) {

            itemBinding.tvName.text = user.name
            itemBinding.tvUserNameProfile.text = user.username
            itemBinding.tvTelephoneNumber.text = user.phone

            itemBinding.ivEditProfile.setOnClickListener {
                itemClickListener(R.id.iv_edit_profile)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = listUserInfo[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listUserInfo.size
    }

    fun setList(list: List<User>) {
        listUserInfo.addAll(list)
    }
}