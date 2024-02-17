package engine_helpers

// Navigation anchors
sealed class Navi {
    // Main screens
    data object MainScn : Navi()
    data object SettingScn : Navi()
}