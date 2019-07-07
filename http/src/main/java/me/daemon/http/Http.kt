package me.daemon.http

/**
 * @author daemon
 * @since 2019-07-07 21:45
 */
class Http {

    private var threadPoolFactory: IThreadPoolFactory? = ThreadPoolFactory()

    fun <T> enqueue(callback: IHttpCallback<T>) {}

    fun <T> execute(callback: IHttpCallback<T>) {}


}