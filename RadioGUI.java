// Universidad del Valle de Guatemala //
// Algoritmos y Estructuras de datos  //
// Seccion 70                         //
// 									  //
// M. Alejandro Alvarez Vidal - 12429 //
// Daniela Villamar 			      //
// Mirka Monzon - 18139               //

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class RadioGUI {

	private JFrame frmRadio;
	private JTextField txtRadio;

	/**
	 * Launch the application
	 */
	// Creation of variables
	int am = 530;
	double fm = 87.90;
	double saveButtons[];
	boolean power = false;
	String display;
	boolean frequency = true;
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioGUI window = new RadioGUI();
					window.frmRadio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRadio = new JFrame();
		frmRadio.setTitle("Radio");
		frmRadio.setResizable(false);
		frmRadio.getContentPane().setBackground(new Color(0, 0, 0));
		frmRadio.setBounds(100, 100, 502, 300);
		frmRadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRadio.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 260, 434, 1);
		frmRadio.getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(375, 136, 46, 14);
		frmRadio.getContentPane().add(lblNewLabel);
		if (power == false) {
			lblNewLabel.setText("");
		}
		
		// Power Button
		
				JButton btnNewButton_6 = new JButton("POWER");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (power == false) { 
							power = true;
							if (frequency == true) {
							display = String.valueOf(numberFormat.format(fm));
							txtRadio.setText(display);
							lblNewLabel.setText("FM");
							} else {
								display = String.valueOf(numberFormat2.format(am));
								txtRadio.setText(display);
								lblNewLabel.setText("AM");
							}
						} else {
							power = false;
							txtRadio.setText("");
							lblNewLabel.setText("");
									
						}
					}
				});
				
				
				// Previous station Button
				JButton button = new JButton("<");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (power == true) {
							if (frequency == true) {
								fm = fm-0.20;
								display = String.valueOf(numberFormat.format(fm));
								txtRadio.setText(display);
								if (fm < 87.90) {
									fm = 107.90;
									display = String.valueOf(numberFormat.format(fm));
									txtRadio.setText(display);
								} else {
									
								}
							} else {
								am = am - 10;
								display = String.valueOf(am);
								txtRadio.setText(display);
								if (am < 530) {
									am = 1610;
									display = String.valueOf(am);
									txtRadio.setText(display);
								} else {
									
								}
							} 
						}else { txtRadio.setText("");
						
						}
					}
				});
		
				// Next/forward station button
				JButton btnNewButton_8 = new JButton(">");
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (power == true) {
							if (frequency == true) {
								fm = fm+0.20;
								display = String.valueOf(numberFormat.format(fm));
								txtRadio.setText(display);
								lblNewLabel.setText("FM");
								if (fm > 107.90) {
									fm = 87.90;
									display = String.valueOf(numberFormat.format(fm));
									txtRadio.setText(display);
								} else {
									
								}
									
							} else {
								am = am + 10;
								display = String.valueOf(numberFormat2.format(am));
								txtRadio.setText(display);
								if (am > 1610) {
									am = 530;
									display = String.valueOf(am);
									txtRadio.setText(display);
								} else {
									
								}
								
							} 
						}else { txtRadio.setText("");
						
						}
					}
				});
				
				
				// AM button 
				JButton btnNewButton_7 = new JButton("AM");
				btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnNewButton_7.setForeground(Color.RED);
				btnNewButton_7.setBackground(Color.DARK_GRAY);
				btnNewButton_7.setBounds(10, 86, 69, 21);
				frmRadio.getContentPane().add(btnNewButton_7);
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (power == true) {
							frequency = false;
							display = String.valueOf(am);
							txtRadio.setText(display);
							lblNewLabel.setText("AM");
						} else {
						
						}
					
					}
				});
				
				// FM Button
				
				JButton btnFm = new JButton("FM");
				btnFm.setForeground(Color.RED);
				btnFm.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnFm.setBackground(Color.DARK_GRAY);
				btnFm.setBounds(10, 113, 69, 21);
				frmRadio.getContentPane().add(btnFm);
				btnFm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (power == true) {
							frequency = true;
							display = String.valueOf(numberFormat.format(fm));
							txtRadio.setText(display);
							lblNewLabel.setText("FM");
						} else {
							
						}
					}
				});
				
		JButton btnNewButton = new JButton("SET 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SET 2");
		btnNewButton_1.setBounds(89, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SET 3");
		btnNewButton_2.setBounds(168, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SET 4");
		btnNewButton_3.setBounds(247, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SET 5");
		btnNewButton_4.setBounds(326, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("SET 6");
		btnNewButton_5.setBounds(405, 188, 69, 23);
		frmRadio.getContentPane().add(btnNewButton_5);
		
		txtRadio = new JTextField();
		txtRadio.setEditable(false);

		txtRadio.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadio.setFont(new Font("Tahoma", Font.PLAIN, 72));
		txtRadio.setForeground(new Color(255, 255, 255));
		txtRadio.setBackground(new Color(0, 0, 0));
		txtRadio.setBounds(89, 11, 306, 123);
		frmRadio.getContentPane().add(txtRadio);
		
		JButton btnSet_1 = new JButton("SET 8");
		btnSet_1.setBounds(89, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet_1);
		
		JButton btnSet_2 = new JButton("SET 9");
		btnSet_2.setBounds(168, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet_2);
		
		JButton btnSet = new JButton("SET 7");
		btnSet.setBounds(10, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet);
		
		JButton btnSet_3 = new JButton("SET 10");
		btnSet_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_3.setBounds(247, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet_3);
		
		JButton btnSet_4 = new JButton("SET 11");
		btnSet_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_4.setBounds(326, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet_4);
		
		JButton btnSet_5 = new JButton("SET 12");
		btnSet_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_5.setBounds(405, 222, 69, 23);
		frmRadio.getContentPane().add(btnSet_5);
		
		
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.setBounds(2, 11, 82, 36);
		frmRadio.getContentPane().add(btnNewButton_6);
		
		
		
		
		
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_8.setBackground(Color.DARK_GRAY);
		btnNewButton_8.setForeground(Color.RED);
		btnNewButton_8.setBounds(413, 11, 48, 23);
		frmRadio.getContentPane().add(btnNewButton_8);
		
		
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(413, 45, 48, 23);
		frmRadio.getContentPane().add(button);
		
		
		
	}
}
