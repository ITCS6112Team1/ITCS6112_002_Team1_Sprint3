package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class NormalCalculatorModelTest {

	@Test
	public void testHandleBackspace() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text="testing";
		boolean firstDigit=true;
		String[] t=ncm.handleBackspace(text, firstDigit);
		String e[]={"testin","true"};
		assertArrayEquals(e,t);
	}
	@Test
	public void testHandleC() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String t=ncm.handleC();
		assertEquals("0",t);
	}

	@Test
	public void testHandleCE() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text=null;
		boolean firstDigit=true;
		String[] t=ncm.handleCE(text, firstDigit);
	}


	@Test
	public void testHandleNumber() {
	NormalCalculatorModel ncm=new NormalCalculatorModel();
	String text =null;
	String key = "b";
	String[] t=ncm.handleNumber(true,text,"b");
	String[] e={key,String.valueOf(false)};
	assertArrayEquals(e,t);
	}
	
	@Test
	public void testHandleNumber2() {
		NormalCalculatorModel ncm2=new NormalCalculatorModel();
		String text ="12";
		String key = ".";
		String[] t=ncm2.handleNumber(false,text,key);
		String[] e={"12.",String.valueOf(false)};
		assertArrayEquals(e,t);
		}
	@Test
	public void testHandleNumber3() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text ="12";
		String key = "1";
		String[] t=ncm.handleNumber(false,text,key);
		String[] e={"121",String.valueOf(false)};
		assertArrayEquals(e,t);
		}
	

	@Test
	public void testHandleOperator() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text=String.valueOf(5),preOperater=null,key="+/-";
		float processNumber=0;
		boolean firstDigit=false;
		String[] t=ncm.handleOperator(text, processNumber, firstDigit, preOperater, key);
		String[] e={String.valueOf(-5),"+/-",String.valueOf(true)};
		assertEquals(e[1],t[1]);
	}
	
	@Test
	public void testHandleOperator2() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text=String.valueOf(25),preOperater=null,key="sqrt";
		float processNumber=0;
		boolean firstDigit=false;
		String[] t=ncm.handleOperator(text, processNumber, firstDigit, preOperater, key);
		String[] e={String.valueOf(5),"sqrt",String.valueOf(true)};
		assertEquals(e[1],t[1]);
	}
	@Test
	public void testHandleOperator3() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text=String.valueOf(20),preOperater=null,key="%";
		float processNumber=0;
		boolean firstDigit=false;
		String[] t=ncm.handleOperator(text, processNumber, firstDigit, preOperater, key);
		String[] e={String.valueOf(0.2),"%",String.valueOf(true)};
		assertArrayEquals(e,t);
	}
	@Test
	public void testHandleOperator4() {
		NormalCalculatorModel ncm=new NormalCalculatorModel();
		String text=String.valueOf(2),preOperater=null,key="1/x";
		float processNumber=0;
		boolean firstDigit=false;
		String[] t=ncm.handleOperator(text, processNumber, firstDigit, preOperater, key);
		String[] e={String.valueOf(0.5),"1/x",String.valueOf(true)};
		assertArrayEquals(e,t);
	}
}