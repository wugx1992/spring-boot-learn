package indi.gxwu.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: gx.wu
 * @Date: 2020/3/27 12:11
 * @Description: 开启一个线程，单独检测是否需要更新分表规则信息
 */
@Configuration
@EnableAsync
public class TaskPoolConfig {


    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor ();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setKeepAliveSeconds(0);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("initial-main-table-map");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //数据初始化
        executor.initialize();
        return executor;
    }

}
