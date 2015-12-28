import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: SpringQuartzTest
 * Author: DIYILIU
 * Update: 2015-12-28 10:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringQuartzTest {

    @Test
    public void testJob(){

        Assume.assumeTrue(Boolean.TRUE);
    }
}
