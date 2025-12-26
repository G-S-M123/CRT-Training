import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI04EventHandling extends JFrame implements ActionListener{
	JFrame jf;
	JPanel pp;
	CardLayout cd;
	
	UI04EventHandling(){
		jf = new JFrame("Card Layout Example");
		cd = new CardLayout();
		
		// Creating a main parent panel that will 
		// contain two child panels.
		
		pp = new JPanel();
		
		// Creating two child panels.
		JPanel cp1 = new JPanel();
		JPanel cp2 = new JPanel();
		
		// Creating two parent buttons
		// 1. Numbers
		// 2. Alphabets
		JButton b1 = new JButton("Numbers");
		JButton b2 = new JButton("Alphabets");
		
		// Creating three child buttons for Numbers button.
		JButton b3 = new JButton("1");
		JButton b4 = new JButton("2");
		JButton b5 = new JButton("3");
		
		// Creating four child buttons for Alphabets button.
		JButton b6 = new JButton("A");
		JButton b7 = new JButton("B");
		JButton b8 = new JButton("C");
		JButton b9 = new JButton("D");
		
		// Adding b3, b4, b5 to cp1.
		cp1.add(b3);
		cp1.add(b4);
		cp1.add(b5);

		// Adding b6, b7, b8, b9 to cp2.
		cp2.add(b6);
		cp2.add(b7);
		cp2.add(b8);
		cp2.add(b9);
		
		// Setting the positioning of the components in parent panel pp
		// (that contains cp1 and cp2) to cardLayout.
		pp.setLayout(cd);
		
		// Adding cp1 and cp2 to parent panel
		pp.add(cp1, "Numbers");
		pp.add(cp2, "Alphabets");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		// Setting container JFrame's Layout to FlowLayout.
		jf.setLayout(new FlowLayout());
		
		// Adding two buttons to JFrame, 
		// these buttons will remain commonly visible to all panels.
		jf.add(b1);
		jf.add(b2);
		
		// Adding pp to JFrame.
		jf.add(pp);
		
		jf.setSize(300, 200);
		jf.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		// if "Numbers" button is clicked
		// open the child panel with button (1, 2, 3)
		if(ae.getActionCommand() == "Numbers") {
			cd.show(pp, "Numbers");
		}
		else {
			cd.show(pp, "Alphabets");
		}
		
	}
	public static void main(String[] args) {
		new UI04EventHandling();
	}

	
}
