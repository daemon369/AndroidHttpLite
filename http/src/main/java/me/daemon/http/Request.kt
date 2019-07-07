package me.daemon.http

import java.util.*


/**
 * @author daemon
 * @since 2019-07-07 21:58
 */
abstract class Request<REQ, RSP>(val url: String) {

    val uuid = UUID.randomUUID().toString()
    var retry: Boolean = false
    var maxRetryTimes = MAX_RETRY_TIMES
    var userAgent = DEFAULT_USER_AGENT
    var connectTimeout = DEFAULT_CONNECT_TIMEOUT

    open fun headers(): Map<String, String>? = null

    val paramsEncoding: String
        get() = DEFAULT_ENCODING

    open val bodyContentType: String
        get() = "application/x-www-form-urlencoded; charset=$paramsEncoding"

    open fun body(): ByteArray? = null

    fun userAgent(userAgent: String) = apply { userAgent.trim().let { if (it.isNotEmpty()) this.userAgent = it } }

    fun connectTimeout(connectTimeout: Int) = apply { if (connectTimeout > 0) this.connectTimeout = connectTimeout }

    fun maxRetryTimes(maxRetryTimes: Int) = apply { this.maxRetryTimes = maxRetryTimes }

    fun retry(retry: Boolean) = apply { this.retry = retry }

    @Throws(Exception::class)
    abstract fun parseResponse(data: ByteArray): RSP?

    fun briefInfo(): String {
        return "uuid=$uuid, url=$url"
    }

    override fun toString(): String {
        return super.toString() + "{ " + briefInfo() + "}"
    }

    companion object {
        const val DEFAULT_USER_AGENT = "Android"
        const val DEFAULT_CONNECT_TIMEOUT = 25 * 1000
        private const val DEFAULT_ENCODING = "UTF-8"
        const val MAX_RETRY_TIMES = 3
    }
}