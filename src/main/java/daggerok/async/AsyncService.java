package daggerok.async;

import daggerok.async.error.AsyncException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class AsyncService {

  static final AtomicLong counter = new AtomicLong(0);

  private static Long id() {
    return counter.incrementAndGet();
  }

  @Async
  @SneakyThrows
  public String asyncMethod(final String string) {

    val id = id();

    log.info("{} Async.start", id);
    TimeUnit.SECONDS.sleep(5);
    log.info("{} Async.end", id);

    return nonNull(string) ? string.toUpperCase() : "null";
  }

  @Async
  @SneakyThrows
  public void asyncErrorMethod() {

    val id = id();

    log.info("{} Async.error.start", id);
    TimeUnit.SECONDS.sleep(5);
    log.info("{} Async.error.end", id);

    AsyncException.throwById(id);
  }
}
