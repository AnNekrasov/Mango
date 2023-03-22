package android.example.data.model

import android.example.data.IResponse
import android.example.domain.model.AuthorisationSuccessDomainModel

data class AuthorizationSuccessResponse(
    val is_success : Boolean
) : IResponse<AuthorisationSuccessDomainModel>{
    override fun toDomainObject() =  AuthorisationSuccessDomainModel(
        isSuccess = is_success
    )
}