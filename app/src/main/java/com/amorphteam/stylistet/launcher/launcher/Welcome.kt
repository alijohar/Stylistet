package com.amorphteam.stylistet.launcher.launcher

import java.util.*

enum class Welcome {
    ONE,
    TWO,
    THREE;

    companion object {
        private val PRNG: Random = Random()
        fun randomDirection(): Welcome {
            val directions = Welcome.values()
            return directions[PRNG.nextInt(directions.size)]
        }
    }
}

