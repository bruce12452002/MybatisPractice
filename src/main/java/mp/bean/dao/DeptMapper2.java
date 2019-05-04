package mp.bean.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import mp.bean.Dept2;
import mp.bean.MyProvider;

@Mapper
public interface DeptMapper2 {
	@Results(id = "d2", value = { 
		@Result(id = true, column = "deptno", property = "dno"),
//		@Result(column = "dname", property = "name"), 
		@Result(column = "loc", property = "loc") })
	@Select("select * from dept where deptno = #{deptNo}")
	public Dept2 getDeptById(int id);

	@ResultMap("d2")
	@Select("select * from dept")
	public List<Dept2> getAllDept2();
	
	@ResultMap("d2")
	@SelectProvider(type = MyProvider.class, method="noParam")
	public List<Dept2> providerTest();
	
	@ResultMap("d2")
	@SelectProvider(type = MyProvider.class, method="param")
	public Dept2 providerTest2(@Param("xxx") int id);
}
