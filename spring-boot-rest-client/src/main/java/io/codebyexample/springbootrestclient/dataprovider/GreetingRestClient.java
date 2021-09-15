package io.codebyexample.springbootrestclient.dataprovider;

import io.codebyexample.springbootrestclient.entrypoint.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huypva
 */
@FeignClient(value = "greeting", url = "${greeingservice.url}")
public interface GreetingRestClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/get-mapping")
  public Greeting getMapping();

  @RequestMapping(method = RequestMethod.GET, value = "/api/path-variable/{user_id}")
  public Greeting pathVariable(@PathVariable(name = "user_id") int userId);

  @RequestMapping(method = RequestMethod.GET, value = "/api/request-param")
  public Greeting requestParam(@RequestParam(name = "user_id") int userId);

  @RequestMapping(method = RequestMethod.POST, value ="/api/request-body")
  public Greeting requestBody(@RequestBody User user);

}
