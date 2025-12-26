import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UI_JDBC extends JFrame implements ActionListener{
	
	// UI
	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JButton b1, b2, b3, b4;
	
	// Database
	ResultSet rs;
	Statement st;
	Connection con;
	
	UI_JDBC(){
		setLayout(null);
		
		l1 = new JLabel("std_no");
		l2 = new JLabel("std_name");
		l3 = new JLabel("std_salary");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		
		b1 = new JButton("First");
		b2 = new JButton("Next");
		b3 = new JButton("Prev");
		b4 = new JButton("Last");
		
		l1.setBounds(100, 100, 100, 30);
		l2.setBounds(100, 140, 100, 30);
		l3.setBounds(100, 180, 100, 30);
		
		tf1.setBounds(220, 100, 100, 30);
		tf2.setBounds(220, 140, 100, 30);
		tf3.setBounds(220, 180, 100, 30);
		
		tf1.setEditable(false);
		
		b1.setBounds(100, 220, 100, 30);
		b2.setBounds(220, 220, 100, 30);
		
		b3.setBounds(100, 260, 100, 30);
		b4.setBounds(220, 260, 100, 30);
		
		this.add(l1);
		this.add(l2);
		this.add(l3);
		
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "somesh";
		String password = "somesh";
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = st.executeQuery("SELECT * FROM rcoem_student");
			
			if(rs.next()) {
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			JButton b = (JButton) ae.getSource();;
			if(b == b1) {
				rs.first();
			}
			else if(b == b2) {
				if(!rs.isLast()) {
					rs.next();
				}
				
			}
			else if(b == b3) {
				if(!rs.isFirst()) {
					rs.previous();
				}
				
			}
			else if(b == b4) {
				rs.last();
				
			}
			tf1.setText(rs.getString(1));
			tf2.setText(rs.getString(2));
			tf3.setText(rs.getString(3));
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		UI_JDBC e = new UI_JDBC();
		e.setVisible(true);
		e.setSize(600, 600);
		
		e.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
}
