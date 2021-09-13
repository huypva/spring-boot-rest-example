package io.codebyexample.springbootrest.core.usecase;


import io.codebyexample.springbootrest.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(int userId, String name);
}
