package daggerok.spring.events;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class SpringEvent1 extends ApplicationEvent {

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public SpringEvent1(final Object source) {
    super(source);
  }
}
