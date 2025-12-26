import javax.swing.*;
import java.awt.*;

public class UI03Form extends JFrame{
	JFrame jf;
	JLabel l1, l2;
	JTextField tf1, tf2;
	JButton b1, b2, b3;
	
	UI03Form(){
		jf = new JFrame("Flow Layout Example");
		jf.setSize(300, 150);
		
		l1 = new JLabel("Enter Name");
		l2 = new JLabel("Enter City");
		
		tf1 = new JTextField(15); // default 20
		tf2 = new JTextField(15); // default 20
		
		b1 = new JButton("Clear");
		b2 = new JButton("Submit");
		b3 = new JButton("Exit");
		
		jf.setLayout(new FlowLayout());
		
		jf.add(l1);
		jf.add(tf1);
		
		jf.add(l2);
		jf.add(tf2);
		
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);

		jf.setVisible(true);

	}
	
	public static void main(String[] args) {
		new UI03Form();
	}
}
