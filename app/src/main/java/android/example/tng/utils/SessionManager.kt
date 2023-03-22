package android.example.tng.utils
import android.content.Context
import android.content.SharedPreferences


/**
 * Session manager to save and fetch data from SharedPreferences
 */
const val TOKEN_PREF = "TOKEN PREF"
class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(TOKEN_PREF, Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}