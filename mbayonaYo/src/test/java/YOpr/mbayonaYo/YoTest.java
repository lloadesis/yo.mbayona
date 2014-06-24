package YOpr.mbayonaYo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml"})
public class YoTest {
	
	@Autowired
	YOservice YO;
	
	@Test 
	public void test(){
		
		final boolean yoResult = YO.YO("mbayona");
		
		Assert.assertEquals(yoResult, true);
	}
	
	

}
