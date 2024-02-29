package engine_helpers

// Navigation anchors
sealed class Navi {
    data object MainScnA : Navi()
    data object MainScnB : Navi()
    data object SettingScn : Navi()
}