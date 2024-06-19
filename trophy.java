import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class tropy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	static JTextField textField;
	static JComboBox comboBox;
	static JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tropy frame = new tropy();
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
	public tropy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(536, 459, 300, 150);
		
		contentPane.add(textArea);
		
		
		JLabel lblNewLabel = new JLabel("5 KM TROPHY CHALLENGE");
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNewLabel.setBounds(95, 40, 638, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Suramangalam - Sona College - New Bus Stand - 4 roads - Collector Office");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(51, 135, 771, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PERSONS");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(86, 243, 128, 35);
		contentPane.add(lblNewLabel_2);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(236, 245, 93, 31);
		contentPane.add(comboBox);
		
		
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Total Amount");
		lblNewLabel_2_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(73, 368, 160, 35);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(254, 368, 128, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		calculateButton.setBounds(86, 300, 154, 35);
		contentPane.add(calculateButton);
		
		
		
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numOfTravellers = Integer.parseInt(comboBox.getSelectedItem().toString());
				int totalAmount = numOfTravellers * 200;
				textField.setText(Integer.toString(totalAmount));
			}
		});
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new activity().setVisible(true);
				//dispose();
				textArea.append("5 KM TROPHY CHALLENGE\nSuramangalam - Sona College - New Bus Stand - 4 roads - Collector Office\nTotal Person"+comboBox.getSelectedItem()+"\nAmount: "+textField.getText());
			}
		});
		btnNewButton.setBounds(452, 368, 138, 35);
		contentPane.add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPrint.setBounds(363, 574, 138, 35);
		contentPane.add(btnPrint);
	}
}