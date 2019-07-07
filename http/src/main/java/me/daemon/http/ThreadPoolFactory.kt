package me.daemon.http

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author daemon
 * @since 2019-07-07 21:54
 */
class ThreadPoolFactory : IThreadPoolFactory {

    override fun newExecutor(): ThreadPoolExecutor {
        return ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE,
            1L,
            TimeUnit.SECONDS,
            LinkedBlockingQueue(30),
            RejectedHandler()
        )
    }

    private class RejectedHandler : RejectedExecutionHandler {

        override fun rejectedExecution(r: Runnable, executor: ThreadPoolExecutor) {
        }

    }

    companion object {
        private val CPU_COUNT = Runtime.getRuntime().availableProcessors()
        private val CORE_POOL_SIZE = CPU_COUNT + 1
        private val MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1
    }
}
