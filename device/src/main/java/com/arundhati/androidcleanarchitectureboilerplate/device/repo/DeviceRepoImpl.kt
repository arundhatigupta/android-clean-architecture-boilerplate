package com.arundhati.androidcleanarchitectureboilerplate.device.repo

import android.content.Context
import com.arundhati.androidcleanarchitectureboilerplate.domain.repo.DeviceRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceRepoImpl @Inject constructor(private val context: Context) : DeviceRepo {
}