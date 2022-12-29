package android.example.data.model

import android.example.data.IResponse
import android.example.domain.model.profile.User

data class UserResponse(
    val profile_data: ProfileData
): IResponse<User>{
    override fun toDomainObject() = User(
        avatar = profile_data.avatar,
        avatars = profile_data.avatars.toDomainObject(),
        birthday = profile_data.birthday,
        city = profile_data.city,
        completedTask = profile_data.completed_task,
        created = profile_data.created,
        id = profile_data.id,
        instagram = profile_data.instagram,
        last = profile_data.last,
        name = profile_data.name,
        online = profile_data.online,
        phone = profile_data.phone,
        status = profile_data.status,
        username = profile_data.username,
        vk = profile_data.vk
    )
}