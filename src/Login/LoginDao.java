package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	ResultSet rs;

	public ArrayList<LoginVo> list() {
		ArrayList<LoginVo> list = new ArrayList<LoginVo>();
		try {
			connDB();
			String query = "Select * from member";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String memid = rs.getString("mem_id");
				String mempwd = rs.getString("mem_pwd");

				LoginVo data = new LoginVo(memid, mempwd);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
//			System.out.println("jdbc driver loading success");
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("oracle connection success.");
			stmt = con.createStatement();
//			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
