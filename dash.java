
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class dash extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField textField;
private int counter;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				dash frame = new dash();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public dash() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1241, 764);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textField = new JTextField();
	textField.setBounds(227, 108, 720, 47);
	contentPane.add(textField);
	textField.setColumns(10);
	
	JSeparator separator = new JSeparator();
	separator.setForeground(new Color(178, 34, 34));
	separator.setBackground(Color.RED);
	separator.setBounds(10, 81, 1217, 2);
	contentPane.add(separator);
	
	JButton btnNewButton = new JButton("search");
	btnNewButton.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\loupe (2).png"));
	btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 18));
	btnNewButton.setBounds(974, 108, 148, 47);
	contentPane.add(btnNewButton);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(new Color(178, 34, 34));
	separator_1.setBackground(Color.RED);
	separator_1.setBounds(10, 181, 1217, 2);
	contentPane.add(separator_1);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));
	panel.setBounds(10, 197, 1217, 72);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JButton btnNewButton_1 = new JButton("Movies\r\n");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
                info sf1 = new info();
                sf1.setVisible(true);
                SwingUtilities.windowForComponent(btnNewButton_1).dispose();
            } catch (Exception rt) {
                rt.printStackTrace();
            }
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\film-slate.png"));
	btnNewButton_1.setBackground(new Color(240, 240, 240));
	btnNewButton_1.setBounds(59, 10, 160, 55);
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("snacks");
	btnNewButton_1_1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
                snacks sf1 = new snacks();
                sf1.setVisible(true);
                SwingUtilities.windowForComponent(btnNewButton_1_1).dispose();
            } catch (Exception rt) {
                rt.printStackTrace();
            }
		}
		
	});
	btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\live-streaming.png"));
	btnNewButton_1_1.setBounds(500, 10, 160, 55);
	panel.add(btnNewButton_1_1);
	
	JButton btnNewButton_1_5 = new JButton("activities");
	btnNewButton_1_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new activity().setVisible(true);
			dispose();
		}
	});
	btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1_5.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\ferris.png"));
	btnNewButton_1_5.setBounds(979, 10, 160, 55);
	panel.add(btnNewButton_1_5);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 322, 1207, 395);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setBackground(new Color(240, 240, 240));
	lblNewLabel_1.setBounds(10, 10, 256, 385);
	panel_1.add(lblNewLabel_1);
	
	counter = 0;
	
	Timer tm = new Timer(2000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(counter%3==0) {
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\garudan_2.jpeg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==1) {
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\karudan_1.jpeg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==2) {
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\karudan_3.jpeg"));
				System.out.println(counter);
				counter++;
			}
			else {
				
			}
			
		}
	});
	tm.start();
	
	JLabel lblNewLabel_1_1 = new JLabel("");
	lblNewLabel_1_1.setBounds(326, 10, 256, 385);
	panel_1.add(lblNewLabel_1_1);
	
counter = 0;
	
	Timer tm1 = new Timer(2000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(counter%3==0) {
				lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\maha_1.jpg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==1) {
				lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\maha_2.jpeg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==2) {
				lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\maha_3.jpg"));
				System.out.println(counter);
				counter++;
			}
			else {
				
			}
			
		}
	});
	tm1.start();
	
	JLabel lblNewLabel_1_2 = new JLabel("");
	lblNewLabel_1_2.setBounds(649, 0, 256, 385);
	panel_1.add(lblNewLabel_1_2);
	
counter = 0;
	
	Timer tm2 = new Timer(2000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(counter%3==0) {
				lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\bb_1.jpg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==1) {
				lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\bb_2.jpg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==2) {
				lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\bb_3.jpeg"));
				System.out.println(counter);
				counter++;
			}
			else {
				
			}
			
		}
	});
	tm2.start();
	
	JLabel lblNewLabel_1_3 = new JLabel("");
	lblNewLabel_1_3.setBounds(941, 0, 256, 385);
	panel_1.add(lblNewLabel_1_3);
	
counter = 0;
	
	Timer tm3 = new Timer(2000,new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(counter%3==0) {
				lblNewLabel_1_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\io_1.jpg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==1) {
				lblNewLabel_1_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\p_insideout2_798_9b5e9941 (2).jpeg"));
				System.out.println(counter);
				counter++;
			}
			else if(counter%3==2) {
				lblNewLabel_1_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\io_2.jpg"));
				System.out.println(counter);
				counter++;
			}
			else {
				
			}
			
		}
	});
	tm3.start();
	
	JLabel lblNewLabel = new JLabel("Recomended Movies\r\n");
	lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
	lblNewLabel.setBounds(23, 279, 186, 33);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("CINE MAGIC BOOKINGS");
	lblNewLabel_2.setForeground(new Color(0, 0, 102));
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
	lblNewLabel_2.setBounds(23, 0, 1162, 71);
	contentPane.add(lblNewLabel_2);
}
}
