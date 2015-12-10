package Model;

import static org.junit.Assert.*;
import java.util.Stack;
import org.junit.Test;

public class NiBoLanTest {

		@Test
	public void testHigherPriority() {
		NiBoLan n=new NiBoLan();
		int a=n.getPriority("*");
		int b=n.getPriority("-");
		boolean c=n.higherPriority("*","-");
		assertEquals(true,c);
		
		
	}

	@Test
	public void testReverse() {
		NiBoLan n=new NiBoLan();
		n.reverse("1+1");
		Stack<String> test=new Stack<String>();
		Stack<String> output=new Stack<String>();
		test.push("1");
		test.push("1");
		test.push("+");
		output= n.getReversedExpression();
		assertEquals(test,output);
		
			
	}
	
	@Test
	public void testReverse2() {
		NiBoLan n=new NiBoLan();
		n.reverse("1+(2*3+1)");
		Stack<String> test=new Stack<String>();
		Stack<String> output=new Stack<String>();
		test.push("1");
		test.push("2");
		test.push("3");
		test.push("*");
		test.push("1");
		test.push("+");
		test.push("+");
		output= n.getReversedExpression();
		assertEquals(test,output);
	}
	
	@Test
	public void testReverse3() {
		NiBoLan n=new NiBoLan();
		n.reverse("(2+(1*3-1))/2");
		Stack<String> test=new Stack<String>();
		Stack<String> output=new Stack<String>();
		test.push("2");
		test.push("1");
		test.push("3");
		test.push("*");
		test.push("1");
		test.push("-");
		test.push("+");
		test.push("2");
		test.push("/");
		output= n.getReversedExpression();
		assertEquals(test,output);
	}
	
	@Test
	public void testCalculate() {
		NiBoLan n=new NiBoLan();
		Stack<String> testStack=new Stack<String>();
		testStack.push("2");
		testStack.push("3");
		testStack.push("*");
		float output=n.calculate(testStack);
		assertEquals(6,output,0.0);
		
		
	}

}