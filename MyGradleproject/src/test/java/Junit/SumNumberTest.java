package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SumNumberTest {
private final SumNumber obj=new SumNumber();
	@Disabled// help to disable test method no failure will be shown
	@Test
	void testSum() {
		assertEquals(5, obj.sum(2,3));
	}// this will check for correct value is returned or not
	@Test
	@RepeatedTest(10)// stress test
	void testSumNegative() {
		assertNotEquals(7,obj.sum(2, 3));
	}// this method check for negative case
	
}
