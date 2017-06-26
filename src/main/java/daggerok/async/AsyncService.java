package daggerok.async;

import daggerok.async.error.AsyncException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static daggerok.utils.Util.sleep;
import static java.util.Objects.nonNull;

@Slf4j
@Service
public class AsyncService {

  @Async
  public String asyncMethod(final String string) {

    sleep(string);
    return nonNull(string) ? string.toUpperCase() : "null";
  }

  @Async
  public void asyncErrorMethod() {

    sleep("*");
    AsyncException.throwById(-1L);
  }
}
