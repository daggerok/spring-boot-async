package daggerok.spring.publishsubscriber;

import daggerok.spring.events.SpringEvent1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static daggerok.utils.Util.sleep;

@Slf4j
@Component
public class SpringEventListener1 {

  @EventListener
  public void onSpringAsyncEvent(final SpringEvent1 event) {
    log.info("start async event: {}", event);
    sleep(event.toString());
    log.info("stop async event: {}", event);
  }
}
