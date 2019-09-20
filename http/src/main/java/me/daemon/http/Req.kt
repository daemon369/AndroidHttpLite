package me.daemon.http

/**
 * @author daemon
 * @since 2019-09-20 11:59
 */
class Req {

    private var method: Method = Method.GET

    fun method(method: Method) = apply { this.method = method }

}