package me.daemon.http

/**
 * @author daemon
 * @since 2019-07-06 23:06
 */
class HttpError(builder: Builder) : Throwable(builder.message, builder.cause) {

    val httpCode = builder.httpCode
    val previous: HttpError? = builder.previous

    class Builder() {
        internal var message: String? = null
        internal var cause: Throwable? = null
        internal var httpCode: Int = 200
        internal var previous: HttpError? = null

        constructor(httpError: HttpError) : this() {
            this.message = httpError.message
            this.cause = httpError.cause
            this.httpCode = httpError.httpCode
            this.previous = httpError.previous
        }

        fun message(message: String?) = apply { this.message = message }
        fun cause(cause: Throwable?) = apply { this.cause = cause }
        fun httpCode(httpCode: Int) = apply { this.httpCode = httpCode }
        fun previous(previous: HttpError?) = apply { this.previous = previous }

        fun build() = HttpError(this)
    }

    companion object {
        fun builder() = Builder()
        fun builder(message: String) = builder().message(message)
        fun builder(cause: Throwable) = builder().cause(cause)
        fun builder(message: String, cause: Throwable) = builder().message(message).cause(cause)
        fun builder(httpError: HttpError) = Builder(httpError)
    }
}