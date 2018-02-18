package daggerok.spring;

import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;

import java.util.concurrent.Executor;

// testing async:
// uncomment to enable async
@Configuration
public class SpringAsyncConfig {

  @Bean
  public ApplicationEventMulticaster applicationEventMulticaster() {
    val eventMulticaster = new SimpleApplicationEventMulticaster();
    eventMulticaster.setErrorHandler(TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);
    eventMulticaster.setTaskExecutor(taskExecutor());
    return eventMulticaster;
  }

  @Bean
  public Executor taskExecutor() {
    val executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(7);
    executor.setMaxPoolSize(432);
    executor.setQueueCapacity(11);
    executor.setThreadNamePrefix("AsyncSpringExecutor-");
    executor.initialize();
    return executor;
  }
}
