package ExpressionEvaluation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.MainMethod;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeScreen {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen window = new HomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 334, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNormalCalculator = new JButton("Normal Calculator");
		btnNormalCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					frame.dispose();
					MainMethod nw = new MainMethod();
					MainMethod.Redirect();
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnNormalCalculator.setBounds(80, 52, 157, 34);
		frame.getContentPane().add(btnNormalCalculator);
		
		JButton btnFormulaEvaluation = new JButton("Formula Evaluation");
		btnFormulaEvaluation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					frame.dispose();
					ChooseOption frm=new ChooseOption();
					frm.setVisible(true);
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option");
				}
			}
		});
		btnFormulaEvaluation.setBounds(80, 130, 157, 34);
		frame.getContentPane().add(btnFormulaEvaluation);
	}
}
