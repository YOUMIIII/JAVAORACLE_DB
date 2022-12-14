package Select;

import java.sql.*; // ojdbc8.jar 추가해서 가능해짐.

public class OracleInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver"; // 오라클을 쓰기 때문에 적는 라인
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 내컴퓨터 네트워크 주소(ipv4) = 127.0.0.1 써도 됨, 1521 = 오라클의 포트번호(tnsnames.ora에서 확인가능)
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");

			Statement stmt = conn.createStatement();

			String sql = "SELECT * FROM dept";
			ResultSet rs = stmt.executeQuery(sql); // DB의 테이블을 JAVA에서 받아주기 위한 방법
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + " ");
				System.out.print(rs.getString("dname") + " ");
				System.out.println(rs.getString("loc") + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("oracle connection fail.");
			e.printStackTrace();
		} 
	}
}
