package ExpressionEvaluation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;



import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.MainMethod;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		btnNormalCalculator.setBounds(80, 109, 157, 34);
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
		btnFormulaEvaluation.setBounds(80, 154, 157, 34);
		frame.getContentPane().add(btnFormulaEvaluation);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					 
						HelpScreen window = new HelpScreen();
						window.frame1.setVisible(true);
					
				}
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, "pls select option2");
				}
			}
		});
		btnHelp.setBounds(241, 11, 67, 23);
		frame.getContentPane().add(btnHelp);
		
		JLabel lblIcalculator = new JLabel("iCalculator");
		lblIcalculator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblIcalculator.setBounds(107, 69, 149, 14);
		frame.getContentPane().add(lblIcalculator);
		
//		JLabel lblIcalculator = new JLabel("iCalculator");
//		lblIcalculator.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
//		lblIcalculator.setBounds(80, 46, 157, 34);
//		frame.getContentPane().add(lblIcalculator);
//		Image img1 = new ImageIcon(this.getClass().getResource("/i.png")).getImage();
//	
		}
}
