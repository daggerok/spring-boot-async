package daggerok.utils;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class Util {

  static final AtomicLong counter = new AtomicLong(0);

  private static Long id() {
    return counter.incrementAndGet();
  }

  @SneakyThrows
  public static void sleep(final String string) {

    val id = id();
    log.info("{} Async.{}.start", id, string);
    TimeUnit.SECONDS.sleep(5);
    log.info("{} Async.{}.end", id, string);
  }
}
