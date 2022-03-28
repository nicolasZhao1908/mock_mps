package org.mps.mock.exercises;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockingExamplesTest {

  private class ExampleClass1 {
  }

  @Test
  public void test() {
    ExampleClass1 example = Mockito.mock(ExampleClass1.class) ;

    assertNotNull(example) ;
  }
}
