package novalogics.android.discoverylab.app.navigation

sealed class Screens(val route: String) {
    data object Home : Screens(NavigationRoutes.HOME)
    data object Details : Screens(NavigationRoutes.DETAILS)
}

object NavigationRoutes {
    const val HOME = "home"
    const val DETAILS = "detail"
}
