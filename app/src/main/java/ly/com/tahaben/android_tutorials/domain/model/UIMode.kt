package ly.com.tahaben.android_tutorials.domain.model

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

enum class UIMode {
    LIGHT, DARK, FOLLOW_SYSTEM;

    fun getDisplayName(): String {
        return when (this) {
            LIGHT -> "Light Mode"
            DARK -> "Dark Mode"
            FOLLOW_SYSTEM -> "Follow System"
        }
    }
}