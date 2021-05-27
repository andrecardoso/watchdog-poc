package com.example.android.watchdog

import android.app.Application
import android.content.Intent
import kotlin.system.exitProcess

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)

            exitProcess(0);
        }
    }
}