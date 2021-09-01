package Junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
@TestInstance(Lifecycle.PER_CLASS)
public class DynamicValuesTest {
	private SumNumber obj;
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		
		System.out.println("In the beginning");
		obj=new SumNumber();
	}
	@TestFactory
	public Stream<DynamicTest> testAdddition(){
		int [][] data=new int[][] {{1,2,3},{5,3,8},{6,7,13}};
		return Arrays.stream(data).map(entry->{
			int a=entry[0];
			int b=entry[1];
			int sum=entry[2];
			return dynamicTest(a + " + "+b+" = "+sum,()->{
				assertEquals(sum,obj.sum(a, b));
			});
		});
	}

}
