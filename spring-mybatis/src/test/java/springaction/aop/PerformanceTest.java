package springaction.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PerformanceConfig.class)
public class PerformanceTest {

  @Autowired
  private Performance performance;

  /*
   * This test will fail until you set a "magic" property.
   * You can set this property as an environment variable, a JVM system property, by adding a @BeforeClass
   * method and calling System.setProperty() or one of several other options.
   */
  @Test
  public void testPerform(){
      System.out.println("testPerform");
      performance.perform();
  }

  @Test
  public void testPerformEncoReable(){
      Encoreable encoreable = (Encoreable)performance;
      encoreable.performEncore();
      performance.perform();

  }

}
