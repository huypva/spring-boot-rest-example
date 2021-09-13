package io.codebyexample.springbootrest.entrypoint;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import io.codebyexample.springbootrest.core.entity.Greeting;
import io.codebyexample.springbootrest.core.usecase.GreetUseCase;
import io.codebyexample.springbootrest.core.usecase.GreetUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetUseCaseImpl greetUseCase;

  @Test
  void givenExistingGreetingWhenGetMapping() throws Exception {
    String api = "/api/get-mapping";

    //Init
    int userId = 0;
    String name = "GetMapping";
    Greeting greeting = new Greeting(userId, String.format("Hello %s!", name));

    //Mock
    given(greetUseCase.greet(userId, name)).willReturn(greeting);

    //Test
    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());
    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(greeting.getId())))
        .andExpect(jsonPath("$.message", is(greeting.getMessage())));
  }
}