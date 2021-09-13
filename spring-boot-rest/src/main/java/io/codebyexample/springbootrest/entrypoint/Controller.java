package io.codebyexample.springbootrest.entrypoint;

import io.codebyexample.springbootrest.core.entity.Greeting;
import io.codebyexample.springbootrest.core.usecase.GreetUseCase;
import io.codebyexample.springbootrest.entrypoint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
@RequestMapping("/api")
public class Controller {

  @Autowired
  GreetUseCase greetUseCase;

  @GetMapping("/get-mapping")
  public Greeting getMapping() {
    return greetUseCase.greet(0, "GetMapping");
  }

  @PostMapping("/path-variable/{user_id}")
  public Greeting pathVariable(@PathVariable(name = "user_id") int userId) {
    return greetUseCase.greet(userId, "PathVariable");
  }

  @PostMapping("/request-param")
  public Greeting requestParam(@RequestParam(name = "user_id") int userId) {
    return greetUseCase.greet(userId, "RequestParam");
  }


  @PostMapping("/request-body")
  public Greeting requestBody(@RequestBody User user) {
    return greetUseCase.greet(user.getUserId(), "RequestBody");
  }
}
