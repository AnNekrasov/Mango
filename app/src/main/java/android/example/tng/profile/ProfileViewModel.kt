package android.example.tng.profile

import android.example.domain.model.profile.User
import android.example.domain.usecase.GetUserInfoUseCase
import android.example.domain.usecase.RegUserUseCase
import android.example.tng.registration.RegistrationViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userProfileUseCase: GetUserInfoUseCase,
    private val regUserUseCase: RegUserUseCase

) : ViewModel() {
    val liveData = MutableLiveData<List<User>>()  // убрать лист юзер

    fun getUserInfo() {
        val vmReg = RegistrationViewModel(regUserUseCase)
        viewModelScope.launch {

           val response =  userProfileUseCase.getUserInfo(vmReg.refreshToken.toString())
            liveData.postValue(listOf(response))
        }
    }
}