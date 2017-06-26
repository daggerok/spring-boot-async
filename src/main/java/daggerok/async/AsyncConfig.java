package daggerok.async;

import daggerok.async.error.AsyncExceptionHandler;
import lombok.val;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

  @Override
  public Executor getAsyncExecutor() {
    val executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(7);
    executor.setMaxPoolSize(432);
    executor.setQueueCapacity(11);
    executor.setThreadNamePrefix("AsyncExecutor-");
    executor.initialize();
    return executor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new AsyncExceptionHandler();
  }
}
