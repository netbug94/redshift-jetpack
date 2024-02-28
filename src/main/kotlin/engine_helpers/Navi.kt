package engine_helpers

// Navigation anchors
sealed class Navi {
    data object MainScn : Navi()
    data object SettingScn : Navi()
}