package chuco.joel.gapsi.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface GapsiRoute {

    @Serializable
    object Home : GapsiRoute

}