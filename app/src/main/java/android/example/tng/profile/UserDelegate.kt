package android.example.tng.profile

import android.example.domain.BaseModel
import android.example.domain.BaseModelPayload
import android.example.domain.model.profile.User
import android.example.tng.R
import android.example.tng.base.AdapterDelegate
import android.example.tng.base.BaseViewHolder
import android.example.tng.databinding.ItemUserBinding
import android.view.ViewGroup

class EventViewHolder(
    private val parent: ViewGroup,
    // val example: (example: String) -> Unit = {}
) : BaseViewHolder(parent, R.layout.item_user) {

    private lateinit var binding: ItemUserBinding

    override fun bind(model: BaseModel, viewHolder: BaseViewHolder) {
        binding = ItemUserBinding.bind(itemView)
        with(binding) {
            model as User
            bindName(model)
            bindAvatar(model)
            bindBirth(model)
        }
    }

    private fun bindName(model: BaseModel) {
        model as User
        with(binding) {
        }
    }

    private fun bindAvatar(model: BaseModel) {
        model as User
        with(binding) {
        }
    }

    private fun bindBirth(model: BaseModel) {
        model as User
        with(binding) {
        }
    }

    override fun bindPayload(
        model: BaseModel,
        viewHolder: BaseViewHolder,
        payloads: MutableList<Any>
    ) {
        payloads.forEach {
            when (it) {
                BaseModelPayload.NAME -> bindName(model)
                BaseModelPayload.AVATAR -> bindName(model)
                BaseModelPayload.BIRTH -> bindName(model)
            }
        }
    }
}

class UserDelegate(
    //private val selectEventType: () -> Unit = {}
) : AdapterDelegate {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder =
        EventViewHolder(
            parent,
            // selectEventType
        )

    override fun isValidType(baseModel: BaseModel): Boolean = baseModel is User
}