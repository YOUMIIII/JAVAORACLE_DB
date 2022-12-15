package Login;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class Login extends WindowAdapter implements ActionListener{
	private Frame f;
	private Panel p;
	private Label lid, lpwd;
	private TextField id, pwd, result;
	private Button loginbt, signupbt;
	LoginDao dao = new LoginDao();
	
	Login(){
		f = new Frame("Login");
		p = new Panel();
		lid = new Label("              ID", Label.RIGHT);
		lpwd = new Label("Password", Label.RIGHT);
		id = new TextField(30);
		pwd = new TextField(30);
		pwd.setEchoChar('*');
		loginbt = new Button("Login");
		signupbt = new Button("Sign Up");
		result = new TextField(40);
	
	}
	
	void loginFrame() {
		f.setLayout(new BorderLayout());
		p.setLayout(new FlowLayout());
		f.add(p, "Center");
		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(loginbt);
		loginbt.addActionListener(this);
		p.add(signupbt);
		signupbt.addActionListener(this);
		f.add(result, "South");
		f.addWindowListener(this);
		f.setSize(350, 180);
		f.setVisible(true);
		
		f.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		Dimension d = f.getSize();
		f.setLocation(screenSize.width / 2 - (int)(d.getWidth()) / 2, screenSize.height / 2 - (int)(d.getHeight()));
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		ArrayList<LoginVo> list = dao.list();
		
		if(e.getActionCommand().equals("Login")) {
			String getid = "", getpwd = "";
			for(int i = 0; i<list.size(); i++) {
				LoginVo data = (LoginVo) list.get(i);
				getid = data.getMemid();
				getpwd = data.getMempwd();
			}
			
			if(id.getText().equals(getid) && pwd.getText().equals(getpwd)) {
				result.setText("로그인 되었습니다.");
			}else {
				result.setText("입력하신 id나 pwd가 틀렸습니다.");
			}
		}
		
		if(e.getActionCommand().equals("Sign Up")) {
			f.setVisible(false);
			new Signup();
		}
	}
}
