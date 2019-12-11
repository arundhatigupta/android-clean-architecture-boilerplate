package com.arundhati.androidcleanarchitectureboilerplate.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arundhati.domain.socketio.ISocket

abstract class BaseSocketViewModel : BaseViewModel() {

    private val socketState = MutableLiveData<ISocket.SocketState>()

    fun getSocketStateLv(): LiveData<ISocket.SocketState> {
        return socketState
    }
}