package me.daemon.http

import java.util.concurrent.ThreadPoolExecutor

/**
 * @author daemon
 * @since 2019-07-07 21:53
 */
interface IThreadPoolFactory {

    fun newExecutor(): ThreadPoolExecutor

}
