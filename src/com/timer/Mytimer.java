package com.timer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Mytimer {

	private JFrame frame;
	private final Integer startTime = 10;
	int seconds, minute;
	private JLabel label;
	JComboBox min, sec;
	JButton addTime;
	JLabel setSec, setMin;
	Timer timer;
	boolean flag = true;
	DefaultTableModel tm = new DefaultTableModel();
	Object[] tb = { "Title", "Anchor", "Time" };
	JTable mytable;
	private JTextField userInput;
	private JTextField Anchor;
	private JLabel achorTime;
	private JButton projectButton;
	
	

	static Object sel;
	JPanel displayMain;
	static String minTime;

	JLabel displayTime, section;
	private JButton startPro, stopButton;

	JLabel displayTime_blink, displayTime_min, displayTime_sec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mytimer window = new Mytimer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Mytimer() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		initialize();
		// Pup min
		for (int i = 0; i < 60; i++) {
			if (i < 10) {
				min.addItem("0" + i);
			} else {
				min.addItem(i);
			}

		}
		// pup sec
		for (int i = 0; i < 60; i++) {
			if (i < 10) {
				sec.addItem("0" + i);
			} else {
				sec.addItem(i);
			}

		}
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		frame.setResizable(false);
		frame.setTitle("Event Timer - by Dennis");

		JLabel lblNewLabel = new JLabel("COUNT DOWN TIMER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(160, 26, 342, 41);
		frame.getContentPane().add(lblNewLabel);

		JLabel setMin = new JLabel("00");
		setMin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		setMin.setBounds(67, 181, 41, 26);
		frame.getContentPane().add(setMin);

		setSec = new JLabel("00");
		setSec.setFont(new Font("Tahoma", Font.PLAIN, 30));
		setSec.setBounds(141, 181, 55, 26);
		frame.getContentPane().add(setSec);

		addTime = new JButton("Add");
		addTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minTime = setMin.getText();
				String anchor = Anchor.getText();
				String title = userInput.getText();

				tm.addRow(new Object[] { title, anchor, minTime });

			}
		});
		addTime.setBounds(33, 267, 106, 26);
		frame.getContentPane().add(addTime);

		min = new JComboBox();
		min.setBounds(70, 221, 49, 22);
		frame.getContentPane().add(min);
		min.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setMin.setText("" + min.getSelectedItem());

			}

		});

		sec = new JComboBox();
		sec.setBounds(138, 221, 49, 22);
		frame.getContentPane().add(sec);
		sec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSec.setText("" + sec.getSelectedItem());

			}

		});

		JLabel lblNewLabel_2 = new JLabel(":");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_2.setBounds(114, 180, 17, 26);
		frame.getContentPane().add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBounds(294, 93, 363, 257);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 347, 245);
		panel.add(scrollPane);

		mytable = new JTable();
		scrollPane.setViewportView(mytable);
		mytable.setModel(tm);

		userInput = new JTextField();
		userInput.setBounds(29, 139, 124, 26);
		frame.getContentPane().add(userInput);
		userInput.setColumns(10);

		JLabel timeTime = new JLabel("Time Title");
		timeTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timeTime.setBounds(33, 114, 86, 14);
		frame.getContentPane().add(timeTime);

		Anchor = new JTextField();
		Anchor.setColumns(10);
		Anchor.setBounds(160, 139, 124, 26);
		frame.getContentPane().add(Anchor);

		achorTime = new JLabel("Anchor");
		achorTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		achorTime.setBounds(160, 116, 86, 14);
		frame.getContentPane().add(achorTime);

		JButton remove = new JButton("Remove");

		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel removeItem = (DefaultTableModel) mytable.getModel();
				int remove = mytable.getSelectedRow();

				if (remove >= 0) {

					if (JOptionPane.showConfirmDialog(null, "are you sure you want to remove the item", "warning",
							JOptionPane.YES_NO_OPTION) != JOptionPane.INFORMATION_MESSAGE) {
						removeItem.removeRow(remove);
					}
				}

			}
		});
		remove.setBounds(160, 267, 106, 26);
		frame.getContentPane().add(remove);

		projectButton = new JButton("Project");
		projectButton.setBounds(529, 361, 106, 26);
		frame.getContentPane().add(projectButton);
		projectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectorScreen();
			}

		});

		tm.setColumnIdentifiers(tb);

		startPro = new JButton("Start");
		startPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				timer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (seconds ==0) {
							seconds = 60;
							minute--;
						}
						if (minute < 0) {

							minute = 0;
							seconds = 0;
							timer.stop();

						} else {
							seconds--;
							if (seconds < 10) {
								displayTime_sec.setText("0" + seconds);
								flag = false;
								
							}else if (minute < 10) {
								displayTime_min.setText("0" + minute);
							
							if (seconds < 10) {
									displayTime_sec.setText("0" + seconds);
									
								} else {
									displayTime_sec.setText("" + seconds);
									flag = false;

								}
							}

						}
						if (minute <=3) {
							displayMain.setBackground(Color.ORANGE);

						}
						if(minute <2) {
							displayMain.setBackground(Color.RED);
						}

						// seconds--;
						//displayTime_sec.setText("" + seconds);

					}

				});
				timer.start();

			}
		});
		startPro.setBounds(396, 361, 106, 26);
		frame.getContentPane().add(startPro);
		
		stopButton = new JButton("stop current");
		stopButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			timer.stop();
			timer.setRepeats(false);
	
		}
		});
		
		stopButton.setBounds(250, 361, 120, 26);
		frame.getContentPane().add(stopButton);

	}

	public void projectorScreen() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xsize = (int) tk.getScreenSize().getWidth();
		int ysize = (int) tk.getScreenSize().getHeight();
		
		int X_Pos;
		int Y_Pos;
		int r_pan = xsize/2;
		int l_pan = ysize/4;
		
		int blinkx = xsize/3+200;
		int blinky = ysize/4;
		int pan_x = xsize/4;
		int pan_y = ysize/4;
		
		
		int txt = xsize/4;
		int txty = ysize/2;
		
		int pan_w;
		int pan_h;

//		pan_x = (int) Math.round(xsize * 0.12);
//		pan_y = (int) Math.round(ysize * 0.12);
				
		int currentScreenHeight, currentScreenWidth;
		
		//pan_x = currenScreenHeight.
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 50));
		frame.setBounds(400, 500, xsize , xsize);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		
		
		

		displayMain = new JPanel();
		displayMain.setBackground(Color.BLACK);
		displayMain.setForeground(Color.WHITE);
		displayMain.setBounds(0, 0, xsize, ysize);
		frame.getContentPane().add(displayMain);
		displayMain.setLayout(null);
		
		section =  new JLabel();
		section.setBounds(txt, txty, 8000, 400);
		section.setVisible(true);
		section.setForeground(Color.WHITE);
		section.setFont(new Font("Tahoma", Font.PLAIN, 100));
		section.setText(userInput.getText());
		displayMain.add(section);
		
		displayTime_blink = new JLabel();
		displayTime_blink.setFont(new Font("Tahoma", Font.PLAIN, 120));
		displayTime_blink.setBounds(blinkx, blinky, 400, 500);
		displayTime_blink.setForeground(Color.WHITE);
		displayMain.add(displayTime_blink);
		displayTime_blink.setText(":");

		displayTime_min = new JLabel();
		displayTime_min.setText("00");
		displayTime_min.setFont(new Font("Tahoma", Font.PLAIN, 200));
		displayTime_min.setForeground(Color.WHITE);
		displayTime_min.setBounds(pan_x, pan_y, 400, 500);
		displayMain.add(displayTime_min);
		DefaultTableModel retrieveRow = (DefaultTableModel) mytable.getModel();
		int get = mytable.getSelectedRow();
		
		 X_Pos = displayTime_min.getLocation().x;
		 Y_Pos = displayTime_min.getLocation().y;
		
//		int pan_x = xsize/4;
//		int pan_y = ysize/4;
//		int pan_w;
//		int pan_h;
		
		System.out.println(X_Pos);
		System.out.println(Y_Pos);

		if (get >= 0) {

			sel = mytable.getValueAt(get, 2);
			// retrieveRow.getValueAt(0, 2);

			displayTime_min.setText("" + sel);
			minute = Integer.parseInt(displayTime_min.getText());

		}

		displayTime_sec = new JLabel();
		displayTime_sec.setText("00");
		displayTime_sec.setFont(new Font("Tahoma", Font.PLAIN, 200));
		displayTime_sec.setBounds(r_pan, l_pan, 400, 500);
		displayTime_sec.setForeground(Color.WHITE);
		displayMain.add(displayTime_sec);
	}
}
