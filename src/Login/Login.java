package Login;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class Login extends WindowAdapter implements ActionListener{
	private Frame f;
	private Label lid, lpwd;
	private TextField id, pwd, result;
	private Button loginbt;
	LoginDao dao = new LoginDao();
	
	Login(){
		f = new Frame("Login Form");
		lid = new Label("ID ", Label.RIGHT);
		lpwd = new Label("Password ", Label.RIGHT);
		id = new TextField(10);
		pwd = new TextField(10);
		pwd.setEchoChar('*');
		loginbt = new Button("Login");
		result = new TextField(40);
	
	}
	
	void loginFrame() {
		f.setLayout(new FlowLayout());
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(loginbt);
		f.add(result);
		loginbt.addActionListener(this);
		f.addWindowListener(this);
		f.setSize(400, 300);
		f.setVisible(true);
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
	}
}
