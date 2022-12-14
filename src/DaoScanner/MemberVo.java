package DaoScanner;

public class MemberVo {
	private String empno;
	private String ename;
	private int sal;

	public MemberVo() {

	}

	public MemberVo(String empno, String ename, int sal) {
		this.empno = empno; // set
		this.ename = ename;
		this.sal = sal;
	}

	public String getEmpno() { // get
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public int getSal() {
		return sal;
	}
}
