package android.example.domain.model.profile

import android.example.domain.BaseModel
import android.example.domain.BaseModelPayload

data class User(
    val avatar: String,
    val avatars: Avatar,
    val birthday: String,
    val city: String,
    val completedTask: Int,
    val created: String,
    val id: Int,
    val instagram: String,
    val last: String,
    val name: String,
    val online: Boolean,
    val phone: String,
    val status: String,
    val username: String,
    val vk: String
): BaseModel {
//    override fun isIdDiff(other: BaseModel): Boolean {
//        return other is User
//    }
//
//    override fun isContentDiff(other: BaseModel): Boolean {
//        if (other !is User) return false
//        if (other.name != this.name) return false
//        if (other.dateBirth != this.dateBirth) return false
//        if (other.avatarUrl != this.avatarUrl) return false
//        return true
//    }
//
//    override fun getPayloadDiff(other: BaseModel): MutableList<Any> {
//        val payloads = mutableListOf<Any>()
//        if (other !is User) return payloads
//        if (other.name != this.name) payloads.add(BaseModelPayload.NAME)
//        if (other.dateBirth != this.dateBirth) payloads.add(BaseModelPayload.BIRTH)
//        if (other.avatarUrl != this.avatarUrl) payloads.add(BaseModelPayload.AVATAR)
//        return payloads
//    }
}
