package ExpressionEvaluation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import SQL.sqlConnection;

public class AddFormula extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection connection=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFormula frame = new AddFormula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void CloseFrame(){
	    super.dispose();
	}
	/**
	 * Create the frame.
	 */
	public AddFormula() {
		connection=sqlConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterFormula = new JLabel("Enter Formula");
		lblEnterFormula.setBounds(36, 78, 97, 14);
		contentPane.add(lblEnterFormula);
		
		textField = new JTextField();
		textField.setBounds(163, 75, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				try{
					String expression = str;
//					JOptionPane.showMessageDialog(null, expression);
					expression = expression.replaceAll("[a-z0-9]","?");
					  expression = expression.replaceAll(" ","");
					  if(expression.matches("^??$")) {
						  JOptionPane.showMessageDialog(null, "Enter valid expression");
					  }
					  //consider about the "()"
					  int num = 0;
					  char[] expChars = expression.toCharArray();
					  for(int i = 0; i < expChars.length; i ++) {
					   char temp = expChars[i];
					   if(temp == '(') {
					    num++;
					   } else if(temp == ')') {
					    num--;
					   }
					   if(num < 0) {
						   JOptionPane.showMessageDialog(null, "Enter valid expression");
					   }
					  }
					  if(num > 0) {
						  JOptionPane.showMessageDialog(null, "Enter valid expression");
					  }
					  expression = expression.replaceAll("\\(|\\)", "");
					  System.out.println(expression);

					  if(expression.matches("^\\?((\\+|-|\\*|\\/)\\?)*$")) {
//						  JOptionPane.showMessageDialog(null, "Is valid expression");
							String query="insert into formula (formula) values (?)";
							PreparedStatement pst=connection.prepareStatement(query);
							pst.setString(1,textField.getText());
							pst.execute();
							JOptionPane.showMessageDialog(null, "Formula Saved");
							pst.close();
					  } else {
						  JOptionPane.showMessageDialog(null, "Enter valid expression");
					  }


					}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, "Enter Formula");
				}
			}
		});
		btnSave.setBounds(190, 124, 89, 23);
		contentPane.add(btnSave);
		
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
		btnBack.setBounds(0, 0, 68, 23);
		contentPane.add(btnBack);
	}

}
