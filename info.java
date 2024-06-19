

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class info extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    static JComboBox<String> comboBox; // Declare comboBox as a class member
    static double totalPrice;
    private JLabel imagelabel; // Declare imagelabel as a class member
    private JTextField namefield;
    private JTextField languagefield;
    private JTextField genrefield;
    private JTextField timingfield;
    private JTextField ratingfield;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    info frame = new info();
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
    public info() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1412, 730);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 153, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 204, 598, 300);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[] {
                "movie_id", "movie_name", "language", "genre", "timing", "rating"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class, String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        comboBox = new JComboBox<>();
        comboBox.setBounds(736, 129, 177, 46);
        contentPane.add(comboBox);

        imagelabel = new JLabel("");
        imagelabel.setBounds(698, 214, 262, 349);
        contentPane.add(imagelabel);

        JButton confirm = new JButton("Confirm");
        confirm.setBounds(949, 129, 133, 46);
        contentPane.add(confirm);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 100, 1370, 2);
        contentPane.add(separator);
        
        JLabel lblNewLabel = new JLabel("Movie Name:");
        lblNewLabel.setBounds(970, 244, 112, 24);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(lblNewLabel);
        
        JLabel lblLanguage = new JLabel("Language:");
        lblLanguage.setBounds(970, 317, 112, 24);
        lblLanguage.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(lblLanguage);
        
        JLabel lblGenre = new JLabel("Genre:");
        lblGenre.setBounds(970, 383, 112, 24);
        lblGenre.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(lblGenre);
        
        JLabel lblTiming = new JLabel("Timing:");
        lblTiming.setBounds(970, 448, 112, 24);
        lblTiming.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(lblTiming);
        
        JLabel lblRating = new JLabel("Rating:");
        lblRating.setBounds(970, 522, 112, 24);
        lblRating.setFont(new Font("Times New Roman", Font.BOLD, 15));
        contentPane.add(lblRating);
        
        namefield = new JTextField();
        namefield.setBounds(1076, 240, 205, 36);
        contentPane.add(namefield);
        namefield.setColumns(10);
        
        languagefield = new JTextField();
        languagefield.setBounds(1076, 305, 205, 36);
        languagefield.setColumns(10);
        contentPane.add(languagefield);
        
        genrefield = new JTextField();
        genrefield.setBounds(1076, 371, 205, 36);
        genrefield.setColumns(10);
        contentPane.add(genrefield);
        
        timingfield = new JTextField();
        timingfield.setBounds(1076, 448, 205, 36);
        timingfield.setColumns(10);
        contentPane.add(timingfield);
        
        ratingfield = new JTextField();
        ratingfield.setBounds(1076, 510, 205, 36);
        contentPane.add(ratingfield);
        ratingfield.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("CINE MAGIC BOOKINGS");
        lblNewLabel_2.setBounds(162, 10, 1162, 71);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(0, 0, 102));
        lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("Movies On streaming:");
        lblNewLabel_1.setBounds(53, 158, 269, 36);
        lblNewLabel_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
        lblNewLabel_1.setBackground(new Color(240, 240, 240));
        contentPane.add(lblNewLabel_1);
        
        JButton booking = new JButton("Book Ticket");
        booking.setBounds(875, 624, 250, 35);
        contentPane.add(booking);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new dash().setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBounds(53, 631, 112, 28);
        contentPane.add(btnNewButton);
        
        booking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedMovie = comboBox.getSelectedItem().toString();
                    book sf1 = new book();
                    sf1.setVisible(true);
                    SwingUtilities.windowForComponent(booking).dispose();
                } catch (Exception rt) {
                    rt.printStackTrace();
                }
            }
        });

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayImage();
            }
        });

        loadData();
    }

    private void loadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_book", "root", "velsrI@22");
            String sql = "SELECT * FROM movies";
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            dt.setRowCount(0);

            comboBox.removeAllItems(); // Clear existing items in the comboBox

            while (rs.next()) {
                Object[] row = {
                    rs.getString("movie_id"),
                    rs.getString("movie_name"),
                    rs.getString("language"),
                    rs.getString("genre"),
                    rs.getString("timing"),
                    rs.getString("rating")
                };
                dt.addRow(row);
                comboBox.addItem(rs.getString("movie_name")); // Add movie names to the comboBox
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data loading error");
            e.printStackTrace();
        }
    }

    private void displayImage() {
        String selectedMovie = (String) comboBox.getSelectedItem();
        String imagePath = "";
        String movieName = "";
        String language = "";
        String genre = "";
        String timing = "";
        String rating = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_book", "root", "velsrI@22");
            String sql = "SELECT * FROM movies WHERE movie_name = ?";
            PreparedStatement pts = con.prepareStatement(sql);
            pts.setString(1, selectedMovie);
            ResultSet rs = pts.executeQuery();
            
            if (rs.next()) {
                movieName = rs.getString("movie_name");
                language = rs.getString("language");
                genre = rs.getString("genre");
                timing = rs.getString("timing");
                rating = rs.getString("rating");
            }
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving movie details");
            e.printStackTrace();
        }

        switch (selectedMovie) {
            case "Garudan":
                imagePath = "C:\\Users\\balaj\\Downloads\\karudan_1.jpeg";
                break;
            case "Bad Boys 4":
                imagePath = "C:\\Users\\balaj\\Downloads\\bb_1.jpg";
                break;
            case "Maharaja":
                imagePath = "C:\\Users\\balaj\\Downloads\\maha_1.jpg";
                break;
            case "Inside Out":
                imagePath = "C:\\Users\\balaj\\Downloads\\p_insideout2_798_9b5e9941 (2).jpeg";
                break;
            case "P.T sir":
                imagePath = "C:\\Users\\balaj\\Downloads\\lkjnx (1).jpg";
                break;
            case "Aranmanai 4":
                imagePath = "C:\\Users\\balaj\\Downloads\\Aranmanai_4 (1).jpg";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Image not found for the selected movie");
                return;
        }

        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(imagelabel.getWidth(), imagelabel.getHeight(), Image.SCALE_SMOOTH);
        imagelabel.setIcon(new ImageIcon(image));

        namefield.setText(movieName);
        languagefield.setText(language);
        genrefield.setText(genre);
        timingfield.setText(timing);
        ratingfield.setText(rating);
    }
}
