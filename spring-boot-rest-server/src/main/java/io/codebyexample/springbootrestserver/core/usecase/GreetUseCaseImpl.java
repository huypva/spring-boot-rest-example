package io.codebyexample.springbootrestserver.core.usecase;

import io.codebyexample.springbootrestserver.core.entity.Greeting;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class GreetUseCaseImpl implements GreetUseCase {

  @Override
  public Greeting greet(int userId, String name) {
    return new Greeting(userId, String.format("Hello %s!", name));
  }
}
