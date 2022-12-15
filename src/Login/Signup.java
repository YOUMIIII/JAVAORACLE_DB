package Login;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Signup extends WindowAdapter{
	private Frame f = new Frame("Sign Up Form");

	Signup(){
		f.addWindowListener(this);
		f.setSize(400, 500);
		f.setVisible(true);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension d = f.getSize();
		f.setLocation(screenSize.width / 2 - (int)(d.getWidth()) / 2, 250);
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
