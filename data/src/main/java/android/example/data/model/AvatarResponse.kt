package android.example.data.model

import android.example.data.IResponse
import android.example.domain.model.profile.Avatar

data class AvatarResponse(
    val avatar: String,
    val bigAvatar: String,
    val miniAvatar: String
): IResponse<Avatar>{
    override fun toDomainObject() = Avatar (
        avatar,
        bigAvatar,
        miniAvatar
    )
}