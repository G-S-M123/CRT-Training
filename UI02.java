import java.awt.*;
import java.awt.event.*;

public class UI02 extends Frame{
	UI02(){
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		Label L = new Label("Window Closing Example");
		this.add(L);
		
		setTitle("Window");
		setSize(300, 350);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	public static void main(String[] args) {
	new UI02();
	}
}
