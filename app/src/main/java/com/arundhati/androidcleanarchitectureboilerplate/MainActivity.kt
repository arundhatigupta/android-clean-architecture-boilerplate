package com.arundhati.androidcleanarchitectureboilerplate

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * This is the main launcher activity.
 */
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}