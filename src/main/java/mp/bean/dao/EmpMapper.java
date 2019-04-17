package mp.bean.dao;

import java.util.List;
import java.util.Set;

import mp.bean.Emp;

public interface EmpMapper {
	public List<Emp> getEmp();

	public Emp getEmpById(int id);

	public Emp getEmp2Step(int id);
	
	public Set<Emp> getEmpByDeptno(int deptno);
}
