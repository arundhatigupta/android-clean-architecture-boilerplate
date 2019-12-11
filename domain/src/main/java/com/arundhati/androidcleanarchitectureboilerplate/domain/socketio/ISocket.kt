package com.arundhati.androidcleanarchitectureboilerplate.domain.socketio

import io.reactivex.Observable

interface ISocket{

    enum class SocketState(val value: String){
        NOT_INITIALIZED("not_initialized"),
        INITIALIZED("initialized"),
        EVENT_CONNECTING("connecting"),
        EVENT_CONNECT_TIMEOUT("connect_timeout"),
        EVENT_CONNECT_ERROR("connect_error"),
        EVENT_CONNECT ("connect"),
        EVENT_ERROR("error"),
        EVENT_AUTH_ERROR("auth_error"),
        EVENT_DISCONNECT("disconnect")
    }

    interface EmitterListener{
        fun onReceived(vararg args: Any?)
    }

    // create new socket also  before calling this call unsubscribe and disconnect
    fun initializeSocket(url: String, token: String)

    //initialize socket state to  NOT_INITIALIZED
    fun reset()

    //connect socket
    fun connect()

    //disconnect socket
    fun disconnect()

    fun hasSubscribed(eventName: String): Boolean

    fun subscribe(event: String, listener: EmitterListener): ISocket

    fun unSubscribe(event: String,  listener: EmitterListener? = null): ISocket

    fun unSubscribeAll()

    fun sendEvent(event: String, vararg args: Any?)

    fun isConnected(): Boolean

    fun getSocketStateObservable(): Observable<SocketState>

    fun getState(): SocketState
}