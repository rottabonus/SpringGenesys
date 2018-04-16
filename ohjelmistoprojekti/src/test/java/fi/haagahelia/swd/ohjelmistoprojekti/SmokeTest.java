package fi.haagahelia.swd.ohjelmistoprojekti;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.swd.ohjelmistoprojekti.web.QController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	
@Autowired
QController control;
	
@Test
public void contextLoads() throws Exception{
	assertThat(control).isNotNull();
}


}
