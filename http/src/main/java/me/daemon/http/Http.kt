package me.daemon.http

import me.daemon.http.impl.DefaultHttpImpl

/**
 * @author daemon
 * @since 2019-07-07 21:45
 */
class Http {

    private var threadPoolFactory: IThreadPoolFactory? = ThreadPoolFactory()

    fun <T> enqueue(callback: IHttpCallback<T>) {}

    fun <T> execute(callback: IHttpCallback<T>) {}

    var httpImpl: IHttp = DefaultHttpImpl()

    fun get() = Req().method(Method.GET)

    fun post() = Req().method(Method.POST)

}