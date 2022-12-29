package android.example.tng.profile

import android.example.domain.usecase.AuthByPhoneUseCase
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val authUseCase: AuthByPhoneUseCase
) : ViewModel() {

}