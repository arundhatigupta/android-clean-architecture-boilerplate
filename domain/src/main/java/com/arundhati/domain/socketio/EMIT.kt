package com.arundhati.domain.socketio

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class EMIT(val event: String = "")