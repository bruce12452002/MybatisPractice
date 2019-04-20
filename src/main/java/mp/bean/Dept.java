package mp.bean;

import java.io.Serializable;
import java.util.Set;

import org.apache.ibatis.type.Alias;

//@Alias("xxx")
public class Dept implements Serializable{
	private int deptNo;
	private String dName;
	private String loc;
	private Set<Emp> emps;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}
