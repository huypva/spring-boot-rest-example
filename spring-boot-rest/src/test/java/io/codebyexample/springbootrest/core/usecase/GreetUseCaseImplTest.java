package io.codebyexample.springbootrest.core.usecase;

import static org.assertj.core.api.Assertions.assertThat;

import io.codebyexample.springbootrest.core.entity.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huypva
 */
@ExtendWith(SpringExtension.class)
@Import(GreetUseCaseImpl.class)
class GreetUseCaseImplTest {

  @Autowired
  GreetUseCaseImpl greetUseCase;

  @Test
  void greet() {
    int userId = 1;
    String name = "Name";
    Greeting valueDefault = new Greeting(userId, String.format("Hello %s!", name));

    Greeting greeting = greetUseCase.greet(userId, name);

    assertThat(valueDefault).usingRecursiveComparison().isEqualTo(greeting);
  }
}