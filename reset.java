import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class reset extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user1;
    private JPasswordField pass1;
    private JPasswordField cpass1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    reset frame = new reset();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public reset() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1292, 770);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel userf = new JLabel("USER NAME");
        userf.setForeground(new Color(255, 255, 255));
        userf.setFont(new Font("Serif", Font.BOLD, 25));
        userf.setBounds(142, 169, 153, 40);
        contentPane.add(userf);
        
        JLabel newpass1 = new JLabel("NEW PASSWORD");
        newpass1.setForeground(new Color(255, 255, 255));
        newpass1.setFont(new Font("Serif", Font.BOLD, 25));
        newpass1.setBounds(82, 274, 213, 40);
        contentPane.add(newpass1);
        
        JLabel confirmpass = new JLabel("CONFIRM PASSWORD");
        confirmpass.setForeground(new Color(255, 255, 255));
        confirmpass.setFont(new Font("Serif", Font.BOLD, 25));
        confirmpass.setBounds(29, 356, 266, 40);
        contentPane.add(confirmpass);
        
        user1 = new JTextField();
        user1.setBounds(339, 169, 344, 40);
        contentPane.add(user1);
        user1.setColumns(10);
        
        pass1 = new JPasswordField();
        pass1.setBounds(339, 274, 344, 40);
        contentPane.add(pass1);
        pass1.setColumns(10);
        
        cpass1 = new JPasswordField();
        cpass1.setBounds(339, 356, 344, 40);
        contentPane.add(cpass1);
        cpass1.setColumns(10);
        
        JButton btnNewButton = new JButton("   SET PASSWORD");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\reset.png"));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            private int i = 0;

            public void actionPerformed(ActionEvent e) {
                try {
                    String us1 = user1.getText();
                    String np = new String(pass1.getPassword());
                    String cp = new String(cpass1.getPassword());
                    
                    // Check if password meets the constraints
                    if (!isValidPassword(np)) {
                        JOptionPane.showMessageDialog(btnNewButton, "Password must contain at least 8 characters, one uppercase letter, one number, and one special character", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!np.equals(cp)) {
                        JOptionPane.showMessageDialog(btnNewButton, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");

                    Statement st1 = con1.createStatement();
                    String sql1 = "Select * from loginpage";
                    ResultSet res1 = st1.executeQuery(sql1);
                      
                    while (res1.next()) {
                        String use1 = res1.getString("username");
                        if (us1.equals(use1) && np.equals(cp)) {
                            String sql2 = "update loginpage set password = ? where username = ?";
                            PreparedStatement pts = con1.prepareStatement(sql2);
                            pts.setString(1, np);
                            pts.setString(2, us1);
                            pts.executeUpdate();
                            JOptionPane.showMessageDialog(btnNewButton, "Password updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                            project_DBMS newframe = new project_DBMS();
                            newframe.setVisible(true);
                            SwingUtilities.windowForComponent(btnNewButton).dispose();
                        }
                    }
                } catch (Exception os) {
                    os.printStackTrace();
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(338, 476, 354, 70);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    project_DBMS sf1 = new project_DBMS();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton_1).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\back (2).png"));
        btnNewButton_1.setBounds(10, 628, 150, 46);
        contentPane.add(btnNewButton_1);
        
        JRadioButton showPasswordButton = new JRadioButton("Show Password");
        showPasswordButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        showPasswordButton.setBounds(708, 288, 150, 21);
        contentPane.add(showPasswordButton);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 77, 1258, 8);
        contentPane.add(separator);
        
        JLabel lblNewLabel_2 = new JLabel("Reset your Password ");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNewLabel_2.setBounds(278, 10, 606, 57);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblPasswordMustContain = new JLabel("Password must contain Maximum 8 Characters with 1 Uppercase, 1 Special Character and1 Number");
        lblPasswordMustContain.setForeground(new Color(255, 255, 255));
        lblPasswordMustContain.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPasswordMustContain.setBounds(339, 237, 580, 25);
        contentPane.add(lblPasswordMustContain);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\balaj\\Downloads\\e389757d-c98a-4a6e-aea2-430ff67ca0a0.jpeg"));
        lblNewLabel_3.setBounds(0, 0, 1292, 770);
        contentPane.add(lblNewLabel_3);
        
        showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordButton.isSelected()) {
                    pass1.setEchoChar((char) 0);
                   // cpass1.setEchoChar((char) 0);
                } else {
                    pass1.setEchoChar('*');
                    cpass1.setEchoChar('*');
                }
            }
        });
    }
    
    private boolean isValidPassword(String password) {
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") && 
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
