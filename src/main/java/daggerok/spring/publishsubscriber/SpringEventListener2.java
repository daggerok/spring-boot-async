package daggerok.spring.publishsubscriber;

import daggerok.spring.events.SpringEvent2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static daggerok.utils.Util.sleep;

@Slf4j
@Component
public class SpringEventListener2 implements ApplicationListener<SpringEvent2> {

  @Override
  public void onApplicationEvent(final SpringEvent2 event) {
    log.info("start sync event handler: {}", event);
    sleep(event.toString());
    log.info("stop sync event handler: {}", event);
  }
}
