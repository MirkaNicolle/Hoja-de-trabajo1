//Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RadioGUI {
	
	//Attributes set 
	MaquinaRadio funcion1 = new MaquinaRadio();
	MaquinaRadio funcion3 = new MaquinaRadio();
	MaquinaRadio funcion2 = new MaquinaRadio();
	double estacion =  0.0;
	boolean tipo = true;	
	boolean estado =false;
	double fm = 87.9;
	double am = 500.00;
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	DecimalFormat numberFormat2 = new DecimalFormat("#");
	String AMsaveButtons[] = new String[12];
	String FMsaveButtons[] = new String[12];


	private JFrame frame;
	private JTextField textField;
	private JButton button;
	private JButton btnPower;
	private JButton btnAmfm;
	private JButton btnSet;
	private JButton btnSet_1;
	private JButton button_1;
	private JButton btnSet_2;
	private JButton btnSet_3;
	private JButton btnSet_4;
	private JButton btnSet_5;
	private JButton button_3;
	private JButton btnSet_6;
	private JButton btnSet_7;
	private JButton btnSet_8;
	private JButton btnSet_9;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					RadioGUI window = new RadioGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		;
	

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
		frame.setTitle("Radio");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		textField = new JTextField();
		textField.setForeground(Color.CYAN);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 85));
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(78, 11, 295, 117);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//Next Station Button
		JButton subir = new JButton(">");
		subir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true) {
					estacion = funcion1.cambioEstacion(true, tipo);
				textField.setText(String.valueOf(numberFormat.format(estacion)));
				}
				else if(estado == true & tipo == false) {
					estacion = funcion1.cambioEstacion(true, tipo);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
				}
				
			}
		});
		subir.setBounds(383, 11, 41, 23);
		frame.getContentPane().add(subir);
		
		//Previous Station Button
		button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true) {
					estacion = funcion1.getEstacion();
					estacion = funcion1.cambioEstacion(false, tipo);
					textField.setText(String.valueOf(numberFormat.format(estacion)));
				}
				else if(estado == true & tipo == false) {
					estacion = funcion1.getEstacion();
					estacion = funcion1.cambioEstacion(false, tipo);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
				}
			}
		});
		
		//POWER Button - ON/OFF Function
		button.setBounds(383, 47, 41, 23);
		frame.getContentPane().add(button);
		
		btnPower = new JButton("POWER");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estado == true) {
					estado = funcion1.encenderApagar(estado);
					textField.setText(null);					
				}
				else {
					estado = funcion1.encenderApagar(estado);
					if(tipo == true) {
						estacion = funcion1.fm;
						textField.setText(String.valueOf(numberFormat.format(funcion1.fm)));
					}
					else {
						estacion = funcion1.am;
						textField.setText(String.valueOf(numberFormat2.format(funcion1.am)));
					}
					
					
					
				}
					
				
			}
		});
		
		btnPower.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPower.setBounds(10, 11, 62, 23);
		frame.getContentPane().add(btnPower);
		
		//Change frequency type - AM/FM
		btnAmfm = new JButton("AM/FM");
		btnAmfm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estado == true) {
						am = funcion1.am;
						fm = funcion1.fm;
						funcion1.cambioTipoFrecuencia(tipo);
						tipo = funcion1.getTipoFrecuencia();
					if (tipo == true) {
						textField.setText(String.valueOf(numberFormat.format(fm)));
					}
					else {
						textField.setText(String.valueOf(numberFormat2.format(am)));
						
						
					}
									
				}
				else {
				 //Do nothing						
				}
		}
		});
		btnAmfm.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAmfm.setBounds(10, 60, 62, 23);
		frame.getContentPane().add(btnAmfm);
		
		
		//Button 1 - Save Station
		btnSet = new JButton("SET 1");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[0] == null) {
					funcion1.guardarEstacion(estacion, tipo, 0);
					FMsaveButtons[0] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 0)));
					textField.setText(String.valueOf(FMsaveButtons[0]));
					estacion = Double.parseDouble(FMsaveButtons[0]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[0] == null) {
					funcion1.guardarEstacion(estacion, tipo, 0);
					AMsaveButtons[0] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 0)));
					textField.setText(String.valueOf(AMsaveButtons[0]));
					estacion = Double.parseDouble(AMsaveButtons[0]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[0] != null) {
					AMsaveButtons[0] = String.valueOf(funcion1.seleccionarEstacion(tipo, 0));
					estacion = Double.parseDouble(AMsaveButtons[0]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[0] != null) {
					FMsaveButtons[0] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 0)));
					estacion = Double.parseDouble(FMsaveButtons[0]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet.setBounds(10, 174, 62, 23);
		frame.getContentPane().add(btnSet);
		
		
		//Button 2 - Save Station
		btnSet_1 = new JButton("SET 2");
		btnSet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if (estado == true && tipo == true && FMsaveButtons[1] == null) {
				funcion1.guardarEstacion(estacion, tipo, 1);
				FMsaveButtons[1] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 1)));
				textField.setText(String.valueOf(FMsaveButtons[1]));
				estacion = Double.parseDouble(FMsaveButtons[1]);
			
			}
			else if (estado == true && tipo == false && AMsaveButtons[1] == null) {
				funcion1.guardarEstacion(estacion, tipo, 1);
				AMsaveButtons[1] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 1)));
				textField.setText(String.valueOf(AMsaveButtons[1]));
				estacion = Double.parseDouble(AMsaveButtons[1]);
			}
			else if (estado == true && tipo == false && AMsaveButtons[1] != null) {
				AMsaveButtons[1] = String.valueOf(funcion1.seleccionarEstacion(tipo, 1));
				estacion = Double.parseDouble(AMsaveButtons[1]);
				textField.setText(String.valueOf(numberFormat2.format(estacion)));
				
				
			}
			else if (estado == true && tipo == true && FMsaveButtons[1] != null) {
				FMsaveButtons[1] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 1)));
				estacion = Double.parseDouble(FMsaveButtons[1]);
				textField.setText(String.valueOf(numberFormat.format(estacion)));}
			
			
			
		else {
			
		}}
		});
		btnSet_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_1.setBounds(78, 174, 62, 23);
		frame.getContentPane().add(btnSet_1);
		
		
		
		//Button 3 - Save Station
		button_1 = new JButton("SET 3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[2] == null) {
					funcion1.guardarEstacion(estacion, tipo, 2);
					FMsaveButtons[2] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 2)));
					textField.setText(String.valueOf(FMsaveButtons[2]));
					estacion = Double.parseDouble(FMsaveButtons[2]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[2] == null) {
					funcion1.guardarEstacion(estacion, tipo, 2);
					AMsaveButtons[2] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 2)));
					textField.setText(String.valueOf(AMsaveButtons[2]));
					estacion = Double.parseDouble(AMsaveButtons[2]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[2] != null) {
					AMsaveButtons[2] = String.valueOf(funcion1.seleccionarEstacion(tipo, 2));
					estacion = Double.parseDouble(AMsaveButtons[2]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[2] != null) {
					FMsaveButtons[2] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 2)));
					estacion = Double.parseDouble(FMsaveButtons[2]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_1.setBounds(150, 174, 62, 23);
		frame.getContentPane().add(button_1);
		
		//Button 4 - Save Station
		btnSet_2 = new JButton("SET 4");
		btnSet_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[3] == null) {
					funcion1.guardarEstacion(estacion, tipo, 3);
					FMsaveButtons[3] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 3)));
					textField.setText(String.valueOf(FMsaveButtons[3]));
					estacion = Double.parseDouble(FMsaveButtons[3]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[3] == null) {
					funcion1.guardarEstacion(estacion, tipo, 3);
					AMsaveButtons[3] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 3)));
					textField.setText(String.valueOf(AMsaveButtons[3]));
					estacion = Double.parseDouble(AMsaveButtons[3]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[3] != null) {
					AMsaveButtons[3] = String.valueOf(funcion1.seleccionarEstacion(tipo, 3));
					estacion = Double.parseDouble(AMsaveButtons[3]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[3] != null) {
					FMsaveButtons[3] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 3)));
					estacion = Double.parseDouble(FMsaveButtons[3]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_2.setBounds(218, 174, 62, 23);
		frame.getContentPane().add(btnSet_2);
		
		
		//Button 5 - Save Station
		btnSet_3 = new JButton("SET 5");
		btnSet_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[4] == null) {
					funcion1.guardarEstacion(estacion, tipo, 4);
					FMsaveButtons[4] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 4)));
					textField.setText(String.valueOf(FMsaveButtons[4]));
					estacion = Double.parseDouble(FMsaveButtons[4]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[4] == null) {
					funcion1.guardarEstacion(estacion, tipo, 4);
					AMsaveButtons[4] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 4)));
					textField.setText(String.valueOf(AMsaveButtons[4]));
					estacion = Double.parseDouble(AMsaveButtons[4]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[4] != null) {
					AMsaveButtons[4] = String.valueOf(funcion1.seleccionarEstacion(tipo, 4));
					estacion = Double.parseDouble(AMsaveButtons[4]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[4] != null) {
					FMsaveButtons[4] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 4)));
					estacion = Double.parseDouble(FMsaveButtons[4]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_3.setBounds(290, 174, 62, 23);
		frame.getContentPane().add(btnSet_3);
		
		//Button 6 - Save Station
		btnSet_4 = new JButton("SET 6");
		btnSet_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[5] == null) {
					funcion1.guardarEstacion(estacion, tipo, 5);
					FMsaveButtons[5] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 5)));
					textField.setText(String.valueOf(FMsaveButtons[5]));
					estacion = Double.parseDouble(FMsaveButtons[5]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[5] == null) {
					funcion1.guardarEstacion(estacion, tipo, 5);
					AMsaveButtons[5] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 5)));
					textField.setText(String.valueOf(AMsaveButtons[5]));
					estacion = Double.parseDouble(AMsaveButtons[5]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[5] != null) {
					AMsaveButtons[5] = String.valueOf(funcion1.seleccionarEstacion(tipo, 5));
					estacion = Double.parseDouble(AMsaveButtons[5]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[5] != null) {
					FMsaveButtons[5] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 5)));
					estacion = Double.parseDouble(FMsaveButtons[5]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_4.setBounds(362, 174, 62, 23);
		frame.getContentPane().add(btnSet_4);
		
		//Button 7 - Save Station
		btnSet_5 = new JButton("SET 7");
		btnSet_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[6] == null) {
					funcion1.guardarEstacion(estacion, tipo, 6);
					FMsaveButtons[6] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 6)));
					textField.setText(String.valueOf(FMsaveButtons[6]));
					estacion = Double.parseDouble(FMsaveButtons[6]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[6] == null) {
					funcion1.guardarEstacion(estacion, tipo, 6);
					AMsaveButtons[6] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 6)));
					textField.setText(String.valueOf(AMsaveButtons[6]));
					estacion = Double.parseDouble(AMsaveButtons[6]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[6] != null) {
					AMsaveButtons[6] = String.valueOf(funcion1.seleccionarEstacion(tipo, 6));
					estacion = Double.parseDouble(AMsaveButtons[6]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[6] != null) {
					FMsaveButtons[6] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 6)));
					estacion = Double.parseDouble(FMsaveButtons[6]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_5.setBounds(10, 208, 62, 23);
		frame.getContentPane().add(btnSet_5);
		
		//Button 8 - Save Station
		button_3 = new JButton("SET 8");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[7] == null) {
					funcion1.guardarEstacion(estacion, tipo, 7);
					FMsaveButtons[7] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 7)));
					textField.setText(String.valueOf(FMsaveButtons[7]));
					estacion = Double.parseDouble(FMsaveButtons[7]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[7] == null) {
					funcion1.guardarEstacion(estacion, tipo, 7);
					AMsaveButtons[7] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 7)));
					textField.setText(String.valueOf(AMsaveButtons[7]));
					estacion = Double.parseDouble(AMsaveButtons[7]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[7] != null) {
					AMsaveButtons[7] = String.valueOf(funcion1.seleccionarEstacion(tipo, 7));
					estacion = Double.parseDouble(AMsaveButtons[7]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[7] != null) {
					FMsaveButtons[7] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 7)));
					estacion = Double.parseDouble(FMsaveButtons[7]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_3.setBounds(78, 208, 62, 23);
		frame.getContentPane().add(button_3);
		
		//Button 9 - Save Station
		btnSet_6 = new JButton("SET 9");
		btnSet_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[8] == null) {
					funcion1.guardarEstacion(estacion, tipo, 8);
					FMsaveButtons[8] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 8)));
					textField.setText(String.valueOf(FMsaveButtons[8]));
					estacion = Double.parseDouble(FMsaveButtons[8]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[8] == null) {
					funcion1.guardarEstacion(estacion, tipo, 8);
					AMsaveButtons[8] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 8)));
					textField.setText(String.valueOf(AMsaveButtons[8]));
					estacion = Double.parseDouble(AMsaveButtons[8]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[8] != null) {
					AMsaveButtons[8] = String.valueOf(funcion1.seleccionarEstacion(tipo, 8));
					estacion = Double.parseDouble(AMsaveButtons[8]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[8] != null) {
					FMsaveButtons[8] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 8)));
					estacion = Double.parseDouble(FMsaveButtons[8]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_6.setBounds(150, 207, 62, 23);
		frame.getContentPane().add(btnSet_6);
		
		//Button 10 - Save Station
		btnSet_7 = new JButton("SET 10");
		btnSet_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[9] == null) {
					funcion1.guardarEstacion(estacion, tipo, 9);
					FMsaveButtons[9] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 9)));
					textField.setText(String.valueOf(FMsaveButtons[9]));
					estacion = Double.parseDouble(FMsaveButtons[9]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[9] == null) {
					funcion1.guardarEstacion(estacion, tipo, 9);
					AMsaveButtons[9] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 9)));
					textField.setText(String.valueOf(AMsaveButtons[9]));
					estacion = Double.parseDouble(AMsaveButtons[9]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[9] != null) {
					AMsaveButtons[9] = String.valueOf(funcion1.seleccionarEstacion(tipo, 9));
					estacion = Double.parseDouble(AMsaveButtons[9]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[9] != null) {
					FMsaveButtons[9] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 9)));
					estacion = Double.parseDouble(FMsaveButtons[9]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
							else {
				
			}
			}
		});
		btnSet_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_7.setBounds(218, 207, 62, 23);
		frame.getContentPane().add(btnSet_7);
		
		//Button 11 - Save Station
		btnSet_8 = new JButton("SET 11");
		btnSet_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[10] == null) {
					funcion1.guardarEstacion(estacion, tipo, 10);
					FMsaveButtons[10] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 10)));
					textField.setText(String.valueOf(FMsaveButtons[10]));
					estacion = Double.parseDouble(FMsaveButtons[10]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[10] == null) {
					funcion1.guardarEstacion(estacion, tipo, 10);
					AMsaveButtons[10] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 10)));
					textField.setText(String.valueOf(AMsaveButtons[10]));
					estacion = Double.parseDouble(AMsaveButtons[10]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[10] != null) {
					AMsaveButtons[10] = String.valueOf(funcion1.seleccionarEstacion(tipo, 10));
					estacion = Double.parseDouble(AMsaveButtons[10]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[10] != null) {
					FMsaveButtons[10] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 10)));
					estacion = Double.parseDouble(FMsaveButtons[10]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_8.setBounds(290, 207, 62, 23);
		frame.getContentPane().add(btnSet_8);
		
		//Button 12 - Save Station
		btnSet_9 = new JButton("SET 12");
		btnSet_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == true && tipo == true && FMsaveButtons[11] == null) {
					funcion1.guardarEstacion(estacion, tipo, 11);
					FMsaveButtons[11] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 11)));
					textField.setText(String.valueOf(FMsaveButtons[11]));
					estacion = Double.parseDouble(FMsaveButtons[11]);
				
				}
				else if (estado == true && tipo == false && AMsaveButtons[11] == null) {
					funcion1.guardarEstacion(estacion, tipo, 11);
					AMsaveButtons[11] = String.valueOf(numberFormat2.format(funcion1.seleccionarEstacion(tipo, 11)));
					textField.setText(String.valueOf(AMsaveButtons[11]));
					estacion = Double.parseDouble(AMsaveButtons[11]);
				}
				else if (estado == true && tipo == false && AMsaveButtons[11] != null) {
					AMsaveButtons[11] = String.valueOf(funcion1.seleccionarEstacion(tipo, 11));
					estacion = Double.parseDouble(AMsaveButtons[11]);
					textField.setText(String.valueOf(numberFormat2.format(estacion)));
					
					
				}
				else if (estado == true && tipo == true && FMsaveButtons[11] != null) {
					FMsaveButtons[11] = String.valueOf(numberFormat.format(funcion1.seleccionarEstacion(tipo, 11)));
					estacion = Double.parseDouble(FMsaveButtons[11]);
					textField.setText(String.valueOf(numberFormat.format(estacion)));}
				
				
				
			else {
				
			}
			}
		});
		btnSet_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSet_9.setBounds(362, 207, 62, 23);
		frame.getContentPane().add(btnSet_9);
		
		
	}
}
