package employee;

import com.intuit.karate.junit5.Karate;

public class EmployeeTest {
	
	@Karate.Test
	Karate assingCalendar() {
		return Karate.run("assingCalendar").relativeTo(getClass());
	}
	
	@Karate.Test
	Karate updateContacts() {
		return Karate.run("updateContacts").relativeTo(getClass());
	}
	
	@Karate.Test
	Karate updateWorkShift() {
		return Karate.run("updateWorkShift").relativeTo(getClass());
	}
}
