package io.codebyexample.springbootrestserver.core.usecase;


import io.codebyexample.springbootrestserver.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(int userId, String name);
}
