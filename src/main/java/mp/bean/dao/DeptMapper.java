package mp.bean.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import mp.bean.Dept;

public interface DeptMapper {
	public Dept getDeptById(int id);

	public Dept getDeptByIdAndLoc(@Param("id") int id, @Param("loc") String loc);

	public Dept getDeptByList(@Param("ids") List<Integer> ids);
	
	public Dept getDeptByMap(Map<String, Object> map);
	
	public List<Dept> getListByName(String name);
	
	public Map<String, Object> getMapById(int id);
	
	@MapKey("deptNo")
	public Map<Integer, Dept> getMapByName(String name);
	
}
