package daggerok.spring.rest;

import daggerok.spring.events.SpringEvent1;
import daggerok.spring.events.SpringEvent2;
import daggerok.spring.publishsubscriber.SpringEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequiredArgsConstructor
public class SpringEventResource {

  final SpringEventPublisher publisher;

  @ResponseStatus(ACCEPTED)
  @GetMapping("/api/v1/spring/event1/{event}")
  public void publishSpringEvent1(@PathVariable("event") final String event1) {
    publisher.publish(new SpringEvent1(event1));
  }

  @ResponseStatus(ACCEPTED)
  @GetMapping("/api/v1/spring/event2/{event}")
  public void publishSpringEvent2(@PathVariable("event") final String event2) {
    publisher.publish(new SpringEvent2(event2));
  }
}
