package io.codebyexample.springbootrestserver.entrypoint.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author huypva
 */
@Getter
@Setter
@NoArgsConstructor
public class User {

  @JsonAlias("user_id")
  private int userId;

}
