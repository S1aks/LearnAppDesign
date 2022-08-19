package com.s1aks.learnappdesign.ui.skype_work_classes

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

class SkypeHelper(private val context: Context) {
    fun openInSkype(skypeUri: String) {
        if (!isSkypeClientInstalled()) {
            goToMarket()
            return
        }
        val uri: Uri = Uri.parse(skypeUri)
        val myIntent = Intent(Intent.ACTION_VIEW, uri)
        myIntent.component = ComponentName(SKYPE_PKG, SKYPE_CLS)
        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(myIntent)
        return
    }

    private fun isSkypeClientInstalled(): Boolean {
        val myPackageMgr = context.packageManager
        try {
            myPackageMgr.getPackageInfo(SKYPE_PKG, PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
        return true
    }

    private fun goToMarket() {
        val marketUri = Uri.parse(SKYPE_MARKET_URI)
        val myIntent = Intent(Intent.ACTION_VIEW, marketUri)
        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(myIntent)
        return
    }

    companion object {
        const val SKYPE_PKG = "com.skype.raider"
        const val SKYPE_CLS = "com.skype4life.MainActivity"
        const val SKYPE_MARKET_URI = "market://details?id=com.skype.raider"
    }
}