package chuco.joel.gapsi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GapsiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}