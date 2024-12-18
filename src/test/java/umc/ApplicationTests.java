package umc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import umc.study.StudyApplication;

@SpringBootTest
@ContextConfiguration(classes = {StudyApplication.class})

class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
