package me.daemon.http

/**
 * @author daemon
 * @since 2019-07-06 23:06
 */
class HttpError(message: String?, cause: Throwable?) : Throwable(message, cause) {

    var httpCode = 200
    var previous: HttpError? = null

    constructor(message: String?) : this(message, null)

    constructor(cause: Throwable?) : this(cause?.toString(), cause)

    constructor() : this(null, null)

    fun httpCode(httpCode: Int) = apply { this.httpCode = httpCode }

    fun previous(previous: HttpError?) = apply { this.previous = previous }

}