package daggerok.async;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncResource {

  final AsyncService asyncService;

  @SneakyThrows
  @GetMapping("/api/v1/async")
  public String asyncUpperCase(@RequestBody final String string) {

    log.info("Sync.start");
    asyncService.asyncMethod(string);
    log.info("{} Sync.end");

    return "done.";
  }

  @SneakyThrows
  @GetMapping("/api/v1/async-error")
  public String asyncError() {

    log.info("Sync.error.start");
    asyncService.asyncErrorMethod();
    log.info("Sync.error.end");

    return "done.";
  }
}
