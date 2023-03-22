package android.example.tng.registration

import android.example.domain.usecase.RegUserUseCase
import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val regUserUseCase: RegUserUseCase
) : ViewModel() {
    val ldRefreshToken = MutableLiveData<String?>()
    val ldAccessToken = MutableLiveData<String?>()
    val ldUserId = MutableLiveData<Int?>()
    val mediatorLiveData = MediatorLiveData<String?>()
    var TAG = "blablaVM"

    var refreshToken : String? = ""
    var accessToken : String? = ""
    var userId : Int? = 0


    fun postRegistration(phone: String?, name: String?, username: String?) {
        viewModelScope.launch {
            val response = regUserUseCase.postUserRegistration(phone, name, username)

            refreshToken = response.refresh_token
            Log.d(TAG,"refresh = =$refreshToken")
            ldRefreshToken.postValue(refreshToken)
            Log.d(TAG,"ldRefresh = ${ldRefreshToken.value}")

            accessToken = response.access_token
            Log.d(TAG,"access = =$accessToken")

            userId = response.user_id
            Log.d(TAG,"userID = =$userId")

            //    Log.d(TAG,"token = $accessToken")

//            ldRefreshToken.postValue(response.refresh_token)
//            ldUserId.postValue(response.user_id)
//            ldAccessToken.postValue(response.access_token)


//            refreshToken = response.refresh_token
//            val refreshToken = ldRegistrationResponse.postValue(response.refresh_token)
//            val accessToken = ldRegistrationResponse.postValue(response.access_token)
//            val userID = ldRegistrationResponse.postValue(response.user_id.toString())
//
//            accessToken = response.access_token
//            lvAccessToken.postValue(response.access_token)
//           userId = response.user_id
//            ldUserId.postValue(response.user_id)


        }
    }
}
/* mediatorLiveData.addSource(lvRefreshToken, object : Observer<String?> {
                override fun onChanged(@Nullable s: String?) {
                    Log.d(TAG, "liveDataChange  = $s")

                    //  val refreshValue = lvRefreshToken.postValue(response.refresh_token)
                    mediatorLiveData.postValue(s)
                }
            })
            mediatorLiveData.addSource(lvAccessToken, object : Observer<String?> {
                override fun onChanged(@Nullable s: String?) {
                    mediatorLiveData.postValue(s)
                }
            })
            mediatorLiveData.addSource(ldUserId, object : Observer<Int?> {
                override fun onChanged(t: Int?) {
                    mediatorLiveData.postValue(t.toString())
                }

            })*/