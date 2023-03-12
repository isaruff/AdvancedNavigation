package com.example.advancednavigation.ui.util

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun NavController.safeNavigate(directions: NavDirections) {
    try {
        this.navigate(directions = directions)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}