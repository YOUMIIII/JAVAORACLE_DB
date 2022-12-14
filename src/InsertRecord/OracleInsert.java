package InsertRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String sql3 = "SELECT MIN(DEPTNO) FROM DEPT";
			ResultSet rs2 = stmt.executeQuery(sql3);
//			while (rs2.next()) {
//				System.out.print(rs2.getInt("max(deptno)") + "\t");
//			}

			int maxDeptNo = 0;
			while (rs2.next()) {
				maxDeptNo = rs2.getInt("min(deptno)");
			}

			String ideptno = maxDeptNo + 5 + " ";
			String sdname = "IT", sloc = "SEOUL";
			String sql = "INSERT INTO dept Values ('" + ideptno + "','" + sdname + "','" + sloc + "')";
			boolean b = stmt.execute(sql);
			if (!b) {
				System.out.println("Insert sucess.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

			String sql2 = "SELECT deptno, dname, loc From dept";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
