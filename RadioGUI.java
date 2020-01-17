// Universidad del Valle de Guatemala //
// Algoritmos y Estructuras de datos  //
// Sección 70                         //
// 									  //
// M. Alejandro Alvarez Vidal - 12429 //
// Daniela Villamar 			      //
// Mirka Monzon                       //
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

	private JFrame frame;
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
	boolean frequency = false;
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioGUI window = new RadioGUI();
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
	public RadioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 502, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 260, 434, 1);
		frame.getContentPane().add(desktopPane);
		
		JButton btnNewButton = new JButton("SET 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 188, 69, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SET 2");
		btnNewButton_1.setBounds(89, 188, 69, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SET 3");
		btnNewButton_2.setBounds(168, 188, 69, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SET 4");
		btnNewButton_3.setBounds(247, 188, 69, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SET 5");
		btnNewButton_4.setBounds(326, 188, 69, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("SET 6");
		btnNewButton_5.setBounds(405, 188, 69, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		txtRadio = new JTextField();
		txtRadio.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadio.setFont(new Font("Tahoma", Font.PLAIN, 72));
		txtRadio.setForeground(new Color(255, 255, 255));
		txtRadio.setBackground(new Color(0, 0, 0));
		txtRadio.setBounds(89, 11, 306, 123);
		frame.getContentPane().add(txtRadio);
		
		JButton btnSet_1 = new JButton("SET 8");
		btnSet_1.setBounds(89, 222, 69, 23);
		frame.getContentPane().add(btnSet_1);
		
		JButton btnSet_2 = new JButton("SET 9");
		btnSet_2.setBounds(168, 222, 69, 23);
		frame.getContentPane().add(btnSet_2);
		
		JButton btnSet = new JButton("SET 7");
		btnSet.setBounds(10, 222, 69, 23);
		frame.getContentPane().add(btnSet);
		
		JButton btnSet_3 = new JButton("SET 10");
		btnSet_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_3.setBounds(247, 222, 69, 23);
		frame.getContentPane().add(btnSet_3);
		
		JButton btnSet_4 = new JButton("SET 11");
		btnSet_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_4.setBounds(326, 222, 69, 23);
		frame.getContentPane().add(btnSet_4);
		
		JButton btnSet_5 = new JButton("SET 12");
		btnSet_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSet_5.setBounds(405, 222, 69, 23);
		frame.getContentPane().add(btnSet_5);
		
		JButton btnNewButton_6 = new JButton("POWER");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (power == false) { 
					power = true;
					frequency = true;
					txtRadio.setText("Welcome");
					display = String.valueOf(numberFormat.format(fm));
					txtRadio.setText(display);
				} else {
					power = false;
					txtRadio.setText("");
							
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.setBounds(2, 11, 82, 36);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("AM");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_7.setForeground(Color.RED);
		btnNewButton_7.setBackground(Color.DARK_GRAY);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequency = false;
				display = String.valueOf(am);
				txtRadio.setText(display);
			}
		});
		btnNewButton_7.setBounds(10, 86, 69, 21);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnFm = new JButton("FM");
		btnFm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frequency = true;
				display = String.valueOf(numberFormat.format(fm));
				txtRadio.setText(display);
			}
		});
		btnFm.setForeground(Color.RED);
		btnFm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFm.setBackground(Color.DARK_GRAY);
		btnFm.setBounds(10, 113, 69, 21);
		frame.getContentPane().add(btnFm);
		
		JButton btnNewButton_8 = new JButton(">");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (power == true) {
					if (frequency == true) {
						fm = fm+0.20;
						display = String.valueOf(numberFormat.format(fm));
						txtRadio.setText(display);
					} else {
						am = am + 10;
						display = String.valueOf(numberFormat2.format(am));
						txtRadio.setText(display);
					} 
				}else { txtRadio.setText("");
				
				}
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_8.setBackground(Color.DARK_GRAY);
		btnNewButton_8.setForeground(Color.RED);
		btnNewButton_8.setBounds(413, 11, 48, 23);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (power == true) {
					if (frequency == true) {
						fm = fm-0.20;
						display = String.valueOf(numberFormat.format(fm));
						txtRadio.setText(display);
					} else {
						am = am - 10;
						display = String.valueOf(am);
						txtRadio.setText(display);
					} 
				}else { txtRadio.setText("");
				
				}
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(413, 45, 48, 23);
		frame.getContentPane().add(button);
	}
}
