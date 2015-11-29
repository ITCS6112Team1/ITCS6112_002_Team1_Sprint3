package ExpressionEvaluation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import FormulaeEval.iCalculator;

//import FormulaeEval.Formulae;

//import FormulaeEval.Formulae;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseOption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseOption frame = new ChooseOption();
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
	public ChooseOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewFormula = new JButton("Add new formula");
		btnAddNewFormula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					AddFormula frm=new AddFormula();
					frm.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option2");
				}
				
				
			}
		});
		btnAddNewFormula.setBounds(39, 131, 151, 23);
		contentPane.add(btnAddNewFormula);
		
		JButton btnUseSavedFormula = new JButton("Use Saved Formula");
		btnUseSavedFormula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					EvaluateFormula frm=new EvaluateFormula();
					frm.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e12)
				{
				JOptionPane.showMessageDialog(null, "pls select option1");
				}
			}
		});
		btnUseSavedFormula.setBounds(39, 60, 151, 23);
		contentPane.add(btnUseSavedFormula);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
					CloseFrame();
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnBack.setBounds(0, 0, 64, 23);
		contentPane.add(btnBack);
	}
}
