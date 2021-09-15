package io.codebyexample.springbootrestclient.entrypoint.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author huypva
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @JsonAlias("user_id")
  private int userId;

}
