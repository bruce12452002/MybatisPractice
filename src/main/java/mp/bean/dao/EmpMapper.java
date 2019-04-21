package mp.bean.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import mp.bean.Emp;

public interface EmpMapper {
	public List<Emp> getEmp();

	public Emp getEmpById(int id);

	public Emp getEmp2Step(int id);
	
	public Set<Emp> getEmpByDeptno(int deptno);
	
	public void bigInsert1(@Param("emp") List<Emp> list);
	
	public void bigInsert2(@Param("emp") List<Emp> list);
	
	public void bigUpdate(List<String> list);
	
	public void bigDelete(List<String> list);
	
}
