

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class book extends JFrame {
	
	 private String movieName;

	   
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton[] seatButtons = new JButton[50];
    private JTextArea textArea;
    private JLabel lblAvailable;
    private JLabel lblSelected;
    private JLabel lblSold;
    private int availableCount = 50;
    private int selectedCount = 0;
    private int soldCount = 0;
    private static final int VIP_PRICE = 300;
    private static final int PREMIUM_PRICE = 200;
    private static final int REGULAR_PRICE = 100;

    String[] seatNames = {
        "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
        "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
        "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
        "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
        "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10"
    };


	private JComboBox comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    book frame = new book();
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
    public book() {
    	movieName = (String) info.comboBox.getSelectedItem();
        setTitle("Seat Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 153, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 764, 300);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(5, 10, 5, 5)); // 5 rows x 10 columns

        for (int i = 0; i < 50; i++) {
            seatButtons[i] = new JButton(seatNames[i]);
            if (i < 10) {
                seatButtons[i].setBackground(Color.ORANGE); // Regular seats color
            } else if (i < 30) {
                seatButtons[i].setBackground(Color.GREEN); // Premium seats color
            } else {
                seatButtons[i].setBackground(Color.CYAN); // VIP seats color
            }
            seatButtons[i].setActionCommand(seatNames[i]);
            seatButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if ("Booked".equals(button.getText())) {
                        button.setText(button.getActionCommand());
                        if (button.getActionCommand().startsWith("A") || button.getActionCommand().startsWith("B")) {
                            button.setBackground(Color.ORANGE); // Revert to available color
                        } else if (button.getActionCommand().startsWith("C") || button.getActionCommand().startsWith("D")) {
                            button.setBackground(Color.GREEN); // Revert to available color
                        } else {
                            button.setBackground(Color.CYAN); // Revert to available color
                        }
                        availableCount++;
                        selectedCount--;
                    } else {
                        button.setText("Booked");
                        button.setBackground(Color.YELLOW); // Selected seats color
                        availableCount--;
                        selectedCount++;
                    }
                    updateSeatCountLabels();
                }
            });
            panel.add(seatButtons[i]);
        }

        JLabel lblRegular = new JLabel("Regular ($100)");
        lblRegular.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRegular.setForeground(Color.ORANGE);
        lblRegular.setBounds(10, 320, 100, 25);
        contentPane.add(lblRegular);

        JLabel lblPremium = new JLabel("Premium ($200)");
        lblPremium.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPremium.setForeground(Color.GREEN);
        lblPremium.setBounds(120, 320, 100, 25);
        contentPane.add(lblPremium);

        JLabel lblVip = new JLabel("VIP ($300)");
        lblVip.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblVip.setForeground(Color.CYAN);
        lblVip.setBounds(230, 320, 100, 25);
        contentPane.add(lblVip);

        lblAvailable = new JLabel("Available: 50");
        lblAvailable.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAvailable.setBounds(10, 360, 100, 25);
        contentPane.add(lblAvailable);

        lblSelected = new JLabel("Selected: 0");
        lblSelected.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSelected.setBounds(120, 360, 100, 25);
        contentPane.add(lblSelected);

        lblSold = new JLabel("Sold: 0");
        lblSold.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSold.setBounds(230, 360, 100, 25);
        contentPane.add(lblSold);

        textArea = new JTextArea();
        textArea.setBounds(10, 400, 300, 150);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.setBounds(433, 530, 89, 23);
        contentPane.add(btnNewButton);
        
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(696, 347, 78, 19);
        contentPane.add(dateChooser);
        
        JButton btnNewButton_1 = new JButton("Print");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					textArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton_1.setBounds(433, 486, 85, 21);
        contentPane.add(btnNewButton_1);
        
         comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "06:00 AM", "10:00 AM", "02:00 PM", "06:30 PM", "10:30 PM"}));
        comboBox.setBounds(575, 347, 89, 21);
        contentPane.add(comboBox);
        
        JLabel lblNewLabel = new JLabel("Movie :"+movieName);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(371, 406, 217, 41);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton_2 = new JButton("Back");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new info().setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.setBounds(652, 529, 85, 21);
        contentPane.add(btnNewButton_2);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookedSeats = new StringBuilder("Booked Seats:\n");
                int totalPrice = 0;
                for (int i = 0; i < 50; i++) {
                    if ("Booked".equals(seatButtons[i].getText())) {
                    	
                    	
                        seatButtons[i].setText("Sold");
                        seatButtons[i].setBackground(Color.RED); // Final booked color
                        bookedSeats.append(seatNames[i]).append("\n");
                        if (i < 10) {
                            totalPrice += REGULAR_PRICE;
                        } else if (i < 30) {
                            totalPrice += PREMIUM_PRICE;
                        } else {
                            totalPrice += VIP_PRICE;
                        }
                        selectedCount--;
                        soldCount++;
                    }
                }
                bookedSeats.append("\nTotal Price: $").append(totalPrice);
                textArea.setText("\nMovie Name: "+movieName+"\nTime: "+comboBox.getSelectedItem()+"\n"+bookedSeats.toString());
                updateSeatCountLabels();
            }
        });
    }

    private void updateSeatCountLabels() {
        lblAvailable.setText("Available: " + availableCount);
        lblSelected.setText("Selected: " + selectedCount);
        lblSold.setText("Sold: " + soldCount);
    }
}
