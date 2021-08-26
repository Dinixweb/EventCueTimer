package com.timer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class Display {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
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
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 50));
		frame.setBounds(260, 120, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel displayTime_min = new JLabel();
		displayTime_min.setForeground(Color.WHITE);
		displayTime_min.setText("00");
		displayTime_min.setFont(new Font("Tahoma", Font.PLAIN, 120));
		displayTime_min.setBounds(169, 98, 195, 253);
		panel.add(displayTime_min);
		
		JLabel displayTime_blink = new JLabel();
		displayTime_blink.setForeground(Color.WHITE);
		displayTime_blink.setText(":");
		displayTime_blink.setFont(new Font("Tahoma", Font.PLAIN, 120));
		displayTime_blink.setBounds(363, 100, 66, 253);
		panel.add(displayTime_blink);
		
		JLabel displayTime_sec = new JLabel();
		displayTime_sec.setForeground(Color.WHITE);
		displayTime_sec.setText("00");
		displayTime_sec.setFont(new Font("Tahoma", Font.PLAIN, 120));
		displayTime_sec.setBounds(421, 103, 195, 253);
		panel.add(displayTime_sec);
	
		
		
		}
}
