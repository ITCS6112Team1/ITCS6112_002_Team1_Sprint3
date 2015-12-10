package ExpressionEvaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluateFormulaTest {

	
		@Test
		public void testMain() {
			System.out.println("main");
			String[] args= null;
			EvaluateFormula e=new EvaluateFormula();
			e.main(args);
		}

		@Test
		public void testCloseFrame() {
			System.out.println("Close");
			EvaluateFormula e=new EvaluateFormula();
			e.CloseFrame();
		}

}
