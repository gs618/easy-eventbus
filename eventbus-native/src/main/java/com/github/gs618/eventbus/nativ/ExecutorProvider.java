package com.github.gs618.eventbus.nativ;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author s.c.gao
 */
enum ExecutorProvider {

    /**
     * 5 线程的线程池
     */
    SINGLETON_THREAD_POOL_5 {

        private final String THREAD_POOL_NAME_SINGLETON_5 = "from_singleton_thread_pool_5";

        private final Integer POOL_SIZE = 5;

        private final Integer KEEP_ALIVE_TIME = 0;

        private final transient Executor executor = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new DefaultThreadFactory(THREAD_POOL_NAME_SINGLETON_5));

        @Override
        Executor getExecutor() {
            return executor;
        }

    };

    abstract Executor getExecutor();
}
