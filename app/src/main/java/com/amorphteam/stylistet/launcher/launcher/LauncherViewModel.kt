package com.amorphteam.stylistet.launcher.launcher

import android.graphics.Color
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.amorphteam.stylistet.R

class LauncherViewModel : ViewModel() {

    }


class LauncherView {
    val randomEnumWelcomeClass: Welcome = Welcome.randomDirection()

    var launcherTitle = ObservableField(Color.BLUE)
    var launcherTitleTwo = ObservableField(Color.BLUE)
    var launcherStartNow = ObservableField(Color.BLACK)
    var launcherSignIn = ObservableField(Color.WHITE)
    var launcherYouHaveAnAccount = ObservableField(Color.WHITE)
    var launcherMainLayout = ObservableField(R.drawable.launcher_one)

    fun onValueChanged() =
        when (randomEnumWelcomeClass) {
            Welcome.ONE -> {
                launcherTitle.set(Color.BLUE)
                launcherTitleTwo.set(Color.BLUE)
                launcherSignIn.set(Color.WHITE)
                launcherYouHaveAnAccount.set(Color.WHITE)
                launcherStartNow.set(Color.BLACK)
                launcherMainLayout.set(R.drawable.launcher_one)
            }

            Welcome.TWO -> {
                launcherTitle.set(Color.WHITE)
                launcherTitleTwo.set(Color.WHITE)
                launcherSignIn.set(Color.WHITE)
                launcherYouHaveAnAccount.set(Color.WHITE)
                launcherStartNow.set(Color.RED)
                launcherMainLayout.set(R.drawable.launcher_two)
            }

            Welcome.THREE -> {
                launcherTitle.set(Color.BLUE)
                launcherTitleTwo.set(Color.BLUE)
                launcherSignIn.set(Color.WHITE)
                launcherYouHaveAnAccount.set(Color.WHITE)
                launcherStartNow.set(Color.GRAY)
                launcherMainLayout.set(R.drawable.launcher_three)

            }
        }

}
