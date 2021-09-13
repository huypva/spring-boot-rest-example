package io.codebyexample.springbootrest.dataprovider.id;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huypva
 */
@SpringBootTest
class RandomIdProviderTest {

  @Autowired
  RandomIdProvider randomIdProvider;

  @BeforeEach
  void setup() {
//    this.randomIdProvider = new RandomIdProvider();
  }

  @Test
  void genId() {
    assertThat(randomIdProvider).isNotNull();
    assertThat(randomIdProvider.genId()).isGreaterThan(0);
    assertThat(randomIdProvider.genId()).isLessThan(Integer.MAX_VALUE);
  }
}