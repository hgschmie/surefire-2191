package demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class TestDemoExtension {

  @Nested
  public class TestExtensionDefault {

    @RegisterExtension
    public DemoExtension extension = new DemoExtension();

    @Test
    public void defaultTest() {
      assertThat(extension.beforeAll()).isFalse();
      assertThat(extension.afterAll()).isFalse();
    }
  }

  @Nested
  public class TestExtensionCustom {

    @RegisterExtension
    public DemoExtension extension = new DemoExtension();

    @Test
    public void customTest() {
      assertThat(extension.beforeEach()).isTrue();
      assertThat(extension.afterEach()).isFalse();
    }
  }
}
