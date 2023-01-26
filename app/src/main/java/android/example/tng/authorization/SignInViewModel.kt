package android.example.tng.authorization

import android.example.domain.model.CountryModel
import android.example.domain.usecase.AuthByPhoneUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCase: AuthByPhoneUseCase,
) : ViewModel() {

    val isPhonePostLiveData = MutableLiveData<Boolean>()
    val isUserExist = MutableLiveData<Boolean>()
    var phoneNumber: String = ""
    private val userPhone = MutableLiveData<String>()
    var userPhoneMasked: String = ""

    var phoneCorrect: Boolean = false
    val currentCountryModel = MutableLiveData<CountryModel>()

    fun processPhone(phoneNum: String) {
        if (phoneCorrect) {
            userPhoneMasked = phoneNum
            phoneNumber = phoneNum.filterNot { c ->
                c.toString() == ")" || c.toString() == "(" || c.toString() == "-" || c.toString() == " "
            }
//            userPhone.value = phoneNum.filterNot { c ->
//                c.toString() == ")" || c.toString() == "(" || c.toString() == "-" || c.toString() == " "
//            }
            viewModelScope.launch {
                isPhonePostLiveData.value = authUseCase.postPhoneNumber(phoneNumber).isSuccess
            }
        } else {
            isPhonePostLiveData.value = false
            // show error
        }
    }

    fun onCodeEntered(code: String) {
        viewModelScope.launch {
            val checkSmsResult = authUseCase.checkSmsCode(code = code, phone = phoneNumber)
            isUserExist.value = checkSmsResult.isUserExists
            if (checkSmsResult.isUserExists) {
                // авторизовать пользователя, перейти на экран профиля, отправить там запрос getUser
                // сохранить куда - то
            } else {
                // отправить на экран регистрации
            }
        }
    }
}