package mp.bean.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mp.bean.Dept;

//@Mapper
public interface DeptMapper {
	//@Select("select * from dept where deptno = #{deptNo}")
	public Dept getDeptById(int id);

	public Dept getDeptByIdAndLoc(@Param("id") int id, @Param("loc") String loc);

	public Dept getDeptByList(@Param("ids") List<Integer> ids);
	
	public Dept getDeptByMap(Map<String, Object> map);
	
	public List<Dept> getListByName(String name);
	
	public Map<String, Object> getMapById(int id);
	
	@MapKey("deptNo")
	public Map<Integer, Dept> getMapByName(String name);
	
	public boolean insertDept(String name);
	
	public Dept getDeptAndEmpsById(int id);
	
	public Dept getDept2Step(int id);
}
