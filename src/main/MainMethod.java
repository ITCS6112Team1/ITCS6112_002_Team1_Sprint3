package main;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import controller.NormalCalculatorController;

import view.CalculatorView;
import Model.NormalCalculatorModel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import view.CalculatorView;



public class MainMethod {

	private JFrame frmNewWindow;

	/**
	 * Launch the application.
	 */
	public static void Redirect() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					NormalCalculatorModel theModel = new NormalCalculatorModel();
					CalculatorView theView = new CalculatorView();
					NormalCalculatorController theController = new NormalCalculatorController(theModel, theView);
					
					theView.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMethod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewWindow = new JFrame();
		frmNewWindow.setTitle("New Window");
		frmNewWindow.setBounds(100, 100, 450, 300);
		frmNewWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewWindow.getContentPane().setLayout(null);
	}

}

