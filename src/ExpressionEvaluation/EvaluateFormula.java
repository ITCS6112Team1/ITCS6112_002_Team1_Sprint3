package ExpressionEvaluation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.NiBoLan;
import Model.expressionReverse;
import SQL.sqlConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class EvaluateFormula extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	
	Connection connection=null;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluateFormula frame = new EvaluateFormula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillComboBox()
	{
		try {
			String query="select * from formula";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("formula"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CloseFrame(){
	    super.dispose();
	}

	/**
	 * Create the frame.
	 */
	public EvaluateFormula() {
		connection=sqlConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseFormula = new JLabel("Choose Formula");
		lblChooseFormula.setBounds(124, 28, 108, 31);
		contentPane.add(lblChooseFormula);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from formula where formula=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs=pst.executeQuery();	
				
					while(rs.next())
					{
						textField_6.setText(rs.getString("formula"));
						String frm = (rs.getString("formula"));
						
				   if((rs.getString("formula")).contains("a"))
					   
					   try{
						   //JOptionPane.showMessageDialog(null, "contains a");
						   textField.setEditable(true);
							}
						catch(Exception e1)
						{
						JOptionPane.showMessageDialog(null, "catch for a");
						}
				   
				   else
						
					   //JOptionPane.showMessageDialog(null, "opps!");
					   textField.setEditable(false);
				   
				   if((rs.getString("formula")).contains("b"))
					   try{
						   //JOptionPane.showMessageDialog(null, "contains b");
						   textField_1.setEditable(true);
							}
						catch(Exception e1)
						{
						JOptionPane.showMessageDialog(null, "catch for b");
						}
				   else
						
					   //JOptionPane.showMessageDialog(null, "opps!");
					   textField_1.setEditable(false);
				   
				   if((rs.getString("formula")).contains("c"))
					   try{
						   //JOptionPane.showMessageDialog(null, "contains c");
						   textField_2.setEditable(true);
							}
						catch(Exception e1)
						{
						JOptionPane.showMessageDialog(null, "catch for c");
						}
				   else
						
					   //JOptionPane.showMessageDialog(null, "opps!");
					   textField_2.setEditable(false);
				   
				   
				   if((rs.getString("formula")).contains("d"))
					   try{
						   //JOptionPane.showMessageDialog(null, "contains d");
						   textField_3.setEditable(true);
						   
						   
							}
						catch(Exception e1)
						{
						JOptionPane.showMessageDialog(null, "catch for ds");
						}
								
				
				   else
						
				   //JOptionPane.showMessageDialog(null, "opps!");
				   textField_3.setEditable(false);
					
						
					}}
				catch(Exception e){
					e.printStackTrace();
					}
			}
		});
		comboBox.setBounds(121, 70, 111, 20);
		contentPane.add(comboBox);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(20, 205, 46, 14);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("b");
		lblB.setBounds(20, 230, 46, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("c");
		lblC.setBounds(20, 255, 46, 14);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("d");
		lblD.setBounds(20, 280, 46, 14);
		contentPane.add(lblD);
		
		JLabel lblEnterValues = new JLabel("Enter Values ");
		lblEnterValues.setBounds(20, 180, 80, 14);
		contentPane.add(lblEnterValues);
		
		textField = new JTextField();
		textField.setBounds(30, 202, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 227, 46, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(30, 252, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(30, 277, 46, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEvaluate = new JButton("Save Values");
		btnEvaluate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField_6.getText();
				try {
//					JOptionPane.showMessageDialog(null, textField.getText());
//					JOptionPane.showMessageDialog(null, textField_1.getText());
//					JOptionPane.showMessageDialog(null, textField_2.getText());
//					JOptionPane.showMessageDialog(null, textField_3.getText());
//					
//					int num = Integer.parseInt(str);
//					JOptionPane.showMessageDialog(null, "is integer");
//					
//					float = float.ValueOf(str.replace("a", textField.getText()O));
					
					//str = str.replace("a", Integer.valueOf(textField.getText()));
//					
//					if(textField.getText().equals(""))
//					{
//						JOptionPane.showMessageDialog(null, "is empty");	
//					}
//					
//					Integer.parseInt(textField.getText());
//					JOptionPane.showMessageDialog(null, "is integer");
//					Integer.parseInt(textField_1.getText());
//					JOptionPane.showMessageDialog(null, "is integer");
//					Integer.parseInt(textField_2.getText());
//					JOptionPane.showMessageDialog(null, "is integer");
//					Integer.parseInt(textField_3.getText());
//					JOptionPane.showMessageDialog(null, "is integer");
					
					if(!(textField.getText().equals("")))
					{
						
						//JOptionPane.showMessageDialog(null, "is empty");
						//Integer.parseInt(textField.getText());
						Float.parseFloat(textField.getText());
						if((Float.parseFloat(textField.getText()))<0)
							str = str.replace("a","("+textField.getText()+")");
						else
						str = str.replace("a", textField.getText());
					}
					if(!(textField_1.getText().equals("")))
					{
						//JOptionPane.showMessageDialog(null, "is empty");
						//Integer.parseInt(textField_1.getText());
						Float.parseFloat(textField_1.getText());
						if((Float.parseFloat(textField_1.getText()))<0)
							str = str.replace("b","("+textField_1.getText()+")");
						else
						str = str.replace("b", textField_1.getText());
					}
					if(!(textField_2.getText().equals("")))
					{
						//JOptionPane.showMessageDialog(null, "is empty");	
						//Integer.parseInt(textField_2.getText());
						Float.parseFloat(textField_2.getText());
						if((Float.parseFloat(textField_2.getText()))<0)
							str = str.replace("c","("+textField_2.getText()+")");
						else
						str = str.replace("c", textField_2.getText());
					}
					if(!(textField_3.getText().equals("")))
					{
						//JOptionPane.showMessageDialog(null, "is empty");
						//Integer.parseInt(textField_3.getText());
						Float.parseFloat(textField_3.getText());
						if((Float.parseFloat(textField_3.getText()))<0)
							str = str.replace("d","("+textField_3.getText()+")");
						else
						str = str.replace("d", textField_3.getText());
					}
//					str = str.replace("a", textField.getText());
//					str = str.replace("b", textField_1.getText());
//					str = str.replace("c", textField_2.getText());
//					str = str.replace("d", textField_3.getText());
					
					textField_4.setText(str);
					
				} catch (Exception e14) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "pls enter integer");
				}
				
			}
		});
		btnEvaluate.setBounds(10, 305, 108, 23);
		contentPane.add(btnEvaluate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					ChooseOption frm=new ChooseOption();
					frm.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnBack.setBounds(0, 0, 72, 23);
		contentPane.add(btnBack);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 138, 108, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(219, 306, 108, 20);
		contentPane.add(textField_5);
		
		JLabel lblExpression = new JLabel("Expression");
		lblExpression.setBounds(219, 113, 108, 14);
		contentPane.add(lblExpression);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expression = textField_4.getText();
				expressionReverse sr = new expressionReverse();
				String text = sr.reverse(expression);
				NiBoLan nb=new NiBoLan();
				float result= nb.cal(text);
				//JOptionPane.showMessageDialog(null, "Result is"+ " "+ result);
				textField_5.setText(String.valueOf(result));
//				Stack<String> abc = (nb.getReversedExpression());
//				JOptionPane.showMessageDialog(null, abc);
			}
			
		});
		btnCalculate.setBounds(219, 176, 89, 23);
		contentPane.add(btnCalculate);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(219, 280, 46, 14);
		contentPane.add(lblResult);
		
		JLabel lblChoosenFormula = new JLabel("Choosen Formula");
		lblChoosenFormula.setBounds(20, 113, 108, 14);
		contentPane.add(lblChoosenFormula);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(20, 138, 108, 20);
		contentPane.add(textField_6);
		fillComboBox();
	}

}
