package ExpressionEvaluation;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class HelpScreen {

	public JFrame frame1;

	
	public HelpScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	   frame1 = new JFrame("Help");

	    // Create the StyleContext, the document and the pane
	    StyleContext sc = new StyleContext();
	    final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
	    JTextPane pane = new JTextPane(doc);

	    // Create and add the style
	    final Style heading2Style = sc.addStyle("Heading2", null);
	    heading2Style.addAttribute(StyleConstants.Foreground, Color.blue);
	    heading2Style.addAttribute(StyleConstants.FontSize, new Integer(16));
	    heading2Style.addAttribute(StyleConstants.FontFamily, "calibri");
	    heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));

	    try {
	      SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          try {
	            // Add the text to the document
	            doc.insertString(0, text, null);

	            // Finally, apply the style to the heading
	            doc.setParagraphAttributes(0, 1, heading2Style, false);
	          } catch (BadLocationException e) {
	          }
	        }
	      });
	    } catch (Exception e) {
	      System.out.println("Exception when constructing document: " + e);
	      System.exit(1);
	    }

	    frame1.getContentPane().add(new JScrollPane(pane));
	    frame1.setSize(400, 500);
	    frame1.setVisible(true);
	}
	 public static final String text = "Features and Help guide\n\n\n"
		      + "The two main functions of this calculator are:\n"
			  +"1.	Normal Calculator\n"
		      +"2.	Formula evaluation\n"
		      + "Normal Calculator has all the functions which include basic operations like "
		      + "add (+), subtract (-), multiply (*), divide (/), percentage (%), inverse (1/x), power (x^n)etc.\n "
		      + "This calculator accepts input from both keyboard and the keypad provided.\n "
		      + "Backspace- edit the most recent entered value\n "
		      + "CE- start a new session\n "
		      + "Home- to get back to home screen\n "
		      + "Back - Go back to previous screen\n\n "
		      + "Formula evaluator is a module which enables user to review formulae given by the "
		      + "application and also enter customized formulae.Additionally, user can also "
		      + "use these formulae to calculate its numeric value by inserting values to the variables.\n\n "
		      + "Viewing stored formulae: The button on the window named ‘View formulae’ directs you to "
		      + "the page with different pre-saved formulae.\n"
		      + " The user can use these formulae to find a numeric value by entering values to the variables. "
		      + "Entering an expression: The software accepts a maximum of 4 variables named a, b, c, d. "
		      + "It accepts algebraic expressions. ";
		      
}