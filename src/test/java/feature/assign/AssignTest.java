package feature.assign;

import com.intuit.karate.junit5.Karate;

public class AssignTest {
	
	@Karate.Test
	Karate testAssing() {
		return Karate.run("assign-post").relativeTo(getClass());
	}
}
