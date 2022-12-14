package Dao;

import java.util.ArrayList;

public class MemberTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = dao.list(); // 원래 ArrayList는 타입을 다양하게 넣을 수 있는 배열(?)인데 <MemberVo>를 쓰면 MemberVo 타입만 넣을 수 있음

		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i); // get은 list에서 하나씩 꺼내오는 역할.
			String empno = data.getEmpno();
			String ename = data.getEname();
			int sal = data.getSal();

			System.out.println(empno + " : " + ename + " : " + sal);
		}
	}
}
