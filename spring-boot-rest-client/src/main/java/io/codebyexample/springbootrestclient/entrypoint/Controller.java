package io.codebyexample.springbootrestclient.entrypoint;

import io.codebyexample.springbootrestclient.dataprovider.Greeting;
import io.codebyexample.springbootrestclient.dataprovider.GreetingRestClient;
import io.codebyexample.springbootrestclient.entrypoint.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@Slf4j
@RestController
public class Controller {

  @Autowired
  GreetingRestClient greetingRestClient;

  @GetMapping("/helloword")
  public String getMapping() {
    Greeting getResponse = greetingRestClient.getMapping();
    log.info(getResponse.toString());

    Greeting pathVariableResponse = greetingRestClient.pathVariable(1);
    log.info(pathVariableResponse.toString());

    Greeting requestParamResponse = greetingRestClient.requestParam(1);
    log.info(requestParamResponse.toString());

    Greeting requestBodyResponse = greetingRestClient.requestBody(new User(1));
    log.info(requestBodyResponse.toString());

    return "Hello world!";
  }
}
