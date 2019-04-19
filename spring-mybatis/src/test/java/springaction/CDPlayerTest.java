package springaction;

import noodles.springaction.bean.CompactDisc;
import noodles.springaction.bean.MediaPlayer;
import noodles.springaction.config.CDPlayerJavaConfig;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: CDPlayerTest
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 15:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 15:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerJavaConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void cdShouleNotBeNull(){
        Assert.assertNotNull(compactDisc);
    }

    @Test
    public void play(){
        player.play();
        Assert.assertEquals( "Playing Sgt.Pepper's Lonely Hearts Club Bank" +
        " by The Beatles\r\n", log.getLog());
    }
}
