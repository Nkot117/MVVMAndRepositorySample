package com.nkot.mvvmandrepositorysample

import android.app.Application
import com.nkot.mvvmandrepositorysample.database.AppDatabase

class BaseApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}
