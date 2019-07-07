package me.daemon.http

/**
 * @author daemon
 * @since 2019-07-06 23:05
 */
interface IHttpCallback<T> {

    fun onSuccess(data: T?)

    fun onFail(error: HttpError)
}