import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class snacks extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel p_name;
    private JLabel p_brand;
    private JLabel p_id;
    private JTable table;
    private JPanel panel_1;
    private JScrollPane scrollPane;
    private JButton btnExit;
    private JButton btnaddcart;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e1;
    private JTextField q;
    private int i;
    private JButton button;
    private JButton button_1;
    private JComboBox<String> comboBox_1;
    private JButton showbutton;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    snacks frame = new snacks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public snacks() {
        setTitle("Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1020, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 222, 173));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 222, 173));
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        panel.setBackground(new Color(255, 153, 51));
        panel.setBounds(10, 0, 1120, 760);
        contentPane.add(panel);
        panel.setLayout(null);

        p_id = new JLabel("PRODUCT ID: ");
        p_id.setBounds(432, 267, 377, 28);
        p_id.setForeground(new Color(0, 0, 0));
        p_id.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(p_id);

        p_name = new JLabel("PRODUCT NAME: ");
        p_name.setBounds(432, 319, 377, 28);
        p_name.setForeground(new Color(0, 0, 0));
        p_name.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(p_name);

        p_brand = new JLabel("Price:");
        p_brand.setBounds(432, 357, 377, 28);
        p_brand.setForeground(new Color(0, 0, 0));
        p_brand.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(p_brand);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 53, 986, 2);
        panel.add(separator);

        JButton btnshow = new JButton("Show All");
        btnshow.setBounds(30, 119, 343, 31);
        btnshow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "select * from snaks";
                    ResultSet rs = st.executeQuery(sql);
                    DefaultTableModel dt = (DefaultTableModel) table.getModel();
                    dt.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = { rs.getString("ID"), rs.getString("name"),
                                rs.getString("price") };
                        dt.addRow(o);
                    }
                    con.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(null, "Error: " + ec.getMessage());
                }
            }
        });
        btnshow.setForeground(new Color(0, 0, 0));
        btnshow.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnshow.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnshow.setBackground(new Color(255, 255, 255));
        panel.add(btnshow);

        btnExit = new JButton("Back To Home");
        btnExit.setBounds(0, 588, 241, 28);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dash sf1 = new dash();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(button_1).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
            }
        });

        JTextPane textPane = new JTextPane();
        textPane.setBounds(0, 418, 399, 74);
        panel.add(textPane);

        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnExit.setBackground(new Color(178, 34, 34));
        panel.add(btnExit);

        btnaddcart = new JButton("Add To Cart");
        btnaddcart.setBounds(486, 504, 241, 28);
        btnaddcart.setEnabled(false); // Initially disable the button
        btnaddcart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String qs = q.getText();
                if (qs.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter quantity!");
                    return;
                }
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    Statement st = con.createStatement();
                    String sql = "insert into add1 values(?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, a);
                    pst.setString(2, b);
                    pst.setString(3, c);
           
                    pst.setString(4, qs);
                   
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Added to cart successfully");

                    // Append the product details to the textPane
                    textPane.setText(textPane.getText() + "\n" + b +  " - Price: " + e1 + " - Qty: " + qs +  " is successfully added");
                    
                    con.close();
                } catch (Exception ed) {
                    JOptionPane.showMessageDialog(null, "Error: " + ed.getMessage());
                }
            }
        });

        btnaddcart.setForeground(new Color(72, 61, 139));
        btnaddcart.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnaddcart.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btnaddcart.setBackground(new Color(255, 255, 255));
        panel.add(btnaddcart);

        q = new JTextField();
        q.setBounds(555, 450, 126, 28);
        q.setFont(new Font("Tahoma", Font.PLAIN, 14));
        q.setColumns(10);
        panel.add(q);

        JLabel lblNewLabel_2 = new JLabel("Enter Quantity :");
        lblNewLabel_2.setBounds(400, 453, 153, 22);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_2.setBackground(Color.BLACK);
        panel.add(lblNewLabel_2);

        button = new JButton("SHOW PRODUCT DETAILS");
        button.setBounds(602, 181, 220, 22);
        button.setEnabled(false); // Initially disable the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
                    String pname = comboBox_1.getSelectedItem().toString();
                    String sql = "select * from snaks where name=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, pname);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        a = rs.getString("ID");
                        b = rs.getString("name");
                        c = rs.getString("price");
             
                        p_id.setText("PRODUCT ID: " + a);
                        p_name.setText("PRODUCT NAME: " + b);
                        p_brand.setText("BRAND: " + c);
                        p_brand.setText("BRAND: " + c);
                        
                      
                        btnaddcart.setEnabled(true); // Enable the add to cart button
                    } else {
                        JOptionPane.showMessageDialog(null, "No data found for the selected product.");
                    }
                    con.close();
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Error: " + ee.getMessage());
                }
            }
        });
        button.setForeground(new Color(0, 0, 0));
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        button.setBackground(new Color(255, 255, 255));
        panel.add(button);

        comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(432, 173, 160, 40);
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        comboBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button.setEnabled(comboBox_1.getSelectedItem() != null); // Enable the show details button
            }
        });
        panel.add(comboBox_1);

        // Populate the combo box with product names
        populateComboBox();

        panel_1 = new JPanel();
        panel_1.setBounds(10, 160, 380, 236);
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBackground(new Color(255, 222, 173));
        panel.add(panel_1);
        panel_1.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 380, 236);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "name", "price" }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(91);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(101);
        scrollPane.setViewportView(table);

        button_1 = new JButton("");
        button_1.setBounds(836, 61, 160, 28);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{
					MyCart sf1 = new  MyCart();
				sf1.setVisible(true);
				SwingUtilities.windowForComponent(button_1).dispose();}
				catch(Exception rt) {
					rt.printStackTrace();				}
                // Code to view the cart
            }
        });
        button_1.setForeground(new Color(0, 0, 0));
        button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        button_1.setBackground(new Color(255, 255, 255));
        panel.add(button_1);
        
        lblNewLabel_1 = new JLabel("Snacks");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 46));
        lblNewLabel_1.setBounds(281, -14, 427, 74);
        panel.add(lblNewLabel_1);
        
        lblNewLabel = new JLabel("MY CART");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(865, 99, 106, 13);
        panel.add(lblNewLabel);
    }

    private void populateComboBox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindetails", "root", "velsrI@22");
            Statement st = con.createStatement();
            String sql = "select name from snaks";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                comboBox_1.addItem(rs.getString("name"));
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
