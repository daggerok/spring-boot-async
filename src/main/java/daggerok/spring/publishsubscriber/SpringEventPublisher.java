package daggerok.spring.publishsubscriber;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpringEventPublisher {

  final ApplicationEventPublisher emitter;

  public void publish(final ApplicationEvent event) {
    log.info("publish sync event: {}", event);
    emitter.publishEvent(event);
  }
}
