package android.example.tng.profile

import android.example.domain.model.profile.User
import android.example.tng.R
import android.example.tng.databinding.ItemEditUserBinding
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
class EditProfileAdapter() :
    RecyclerView.Adapter<EditProfileAdapter.EditProfileViewHolder>(

    ) {
    private val listUserInfo = mutableListOf<User>()
    private lateinit var binding: ItemEditUserBinding

    inner class EditProfileViewHolder(
        private val itemBinding: ItemEditUserBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(user: User) {

            itemBinding.etName.setText(user.name)
            itemBinding.tvUserNameProfile.text = user.username
            itemBinding.tvTelephoneNumber.text = user.phone


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditProfileViewHolder {
        binding = ItemEditUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EditProfileViewHolder, position: Int) {
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