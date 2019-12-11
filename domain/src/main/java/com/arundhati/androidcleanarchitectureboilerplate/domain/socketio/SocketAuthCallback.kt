package com.arundhati.androidcleanarchitectureboilerplate.domain.socketio

interface SocketAuthCallback {
        fun onAuthenticated(baseUrl: String, token: String)
        fun onAuthenticationError()
}