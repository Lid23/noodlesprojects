package springaction.aop;

import noodles.springaction.aop.aspects.TrackCounter;
import noodles.springaction.bean.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TrackCounterConfig.class)
public class TrackCountTest {

  @Autowired
  private CompactDisc compactDisc;

  @Autowired
  private TrackCounter trackCounter;
  
  /*
   * This test will fail until you set a "magic" property.
   * You can set this property as an environment variable, a JVM system property, by adding a @BeforeClass
   * method and calling System.setProperty() or one of several other options.
   */
  @Test
  public void testTrackCounter(){
      System.out.println("testTrackCounter");

      compactDisc.playTrack( 1 );
      compactDisc.playTrack( 1 );
      compactDisc.playTrack( 2 );
      compactDisc.playTrack( 2 );
      compactDisc.playTrack( 2 );

      System.out.println(trackCounter.getPlayCount( 1 ));
      System.out.println(trackCounter.getPlayCount( 2 ));
  }

}
