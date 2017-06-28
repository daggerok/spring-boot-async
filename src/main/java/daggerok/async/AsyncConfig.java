package daggerok.async;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import static java.lang.Integer.MAX_VALUE;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

  @Override
  public Executor getAsyncExecutor() {
    val executor = new ThreadPoolTaskExecutor();
    executor.setThreadNamePrefix("AsyncExecutor-");
    executor.setCorePoolSize(MAX_VALUE);
    executor.initialize();
    return executor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return (e, method, params) ->
        log.error("custom error handler: {} method: {}, params: '{}'",
                  e.getLocalizedMessage(), method.getName(), params);
  }
}
