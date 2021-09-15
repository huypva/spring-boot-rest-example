package io.codebyexample.springbootrestclient.dataprovider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author huypva
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Greeting {

  private int id;
  private String message;

}
