package com.nkot.mvvmandrepositorysample

import android.app.Application
import com.nkot.mvvmandrepositorysample.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}
