package daggerok.async.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

  @Override
  public void handleUncaughtException(final Throwable ex, final Method method, final Object... params) {

    log.error("custom error handler: {} method: {}, params: '{}'",
              ex.getLocalizedMessage(), method.getName(), Arrays.asList(params)
                                                                .parallelStream()
                                                                .map(String::valueOf)
                                                                .collect(joining(",")));
  }
}
