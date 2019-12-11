package com.arundhati.device.repo

import android.content.Context
import com.arundhati.domain.repo.DeviceRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceRepoImpl @Inject constructor(private val context: Context) : DeviceRepo {
}