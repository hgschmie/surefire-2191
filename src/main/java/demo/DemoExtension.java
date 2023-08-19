package demo;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class DemoExtension
    implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback,
    ParameterResolver {

  private boolean afterAll = false;
  private boolean beforeAll = false;
  private boolean afterEach = false;
  private boolean beforeEach = false;

  @Override
  public void afterAll(ExtensionContext extensionContext) throws Exception {
    System.out.println("afterAll");
    afterAll = true;
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    System.out.println("afterEach");
    afterEach = true;
    beforeEach = false;
  }

  @Override
  public void beforeAll(ExtensionContext extensionContext) throws Exception {
    System.out.println("beforeAll");
    beforeAll = true;
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    System.out.println("beforeEach");
    beforeEach = true;
    afterEach = false;
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return false;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return null;
  }

  public boolean afterAll() {
    return afterAll;
  }

  public boolean beforeAll() {
    return beforeAll;
  }

  public boolean afterEach() {
    return afterEach;
  }

  public boolean beforeEach() {
    return beforeEach;
  }
}
