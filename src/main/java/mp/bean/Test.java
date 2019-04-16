package mp.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mp.bean.dao.DeptMapper;
import mp.bean.dao.EmpMapper;

public class Test {
	public static void main(String[] args) {
		InputStream is = null;
		SqlSession sqlSession = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			// Dept dept = sqlSession.selectOne("Dept.getDeptById", 40);
			//DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
			
			/*
			Dept dept = mapper.getDeptById(40);
			System.out.println("dept=" + dept);
			System.out.println("deptNo=" + dept.getDeptNo());
			System.out.println("dName=" + dept.getdName());
			System.out.println("loc=" + dept.getLoc());
			*/
			
			/*
			Dept dept = mapper.getDeptByIdAndLoc(40, "BOSTON");
			System.out.println("dept=" + dept);
			*/
			
			/*
			List<Integer> list = new ArrayList<>();
			list.add(40);
			Dept dept = mapper.getDeptByList(list);
			System.out.println("dept=" + dept);
			*/
			
			/*
			Map<String, Object> map = new HashMap<>();
			map.put("xxx", 40);
			map.put("loc", "BOSTON");
			Dept dept = mapper.getDeptByMap(map);
			System.out.println("dept=" + dept);
			*/
			
			/*
			List<Dept> listByName = mapper.getListByName("%O%");
			System.out.println(listByName);//找不到不是null，是空的 list
			listByName.forEach((dept) -> {
				System.out.println(dept.getdName());
			});
			*/
			
			/*
			Map<String, Object> mapById = mapper.getMapById(40);
			System.out.println(mapById);// 找不到為null
			*/
			
			/*
			Map<Integer, Dept> mapByName = mapper.getMapByName("%O%");
			System.out.println(mapByName);// 找不到不是null，是空的 map
			*/
			
			
			
			
			EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//			List<Emp> emp = mapper.getEmp();
//			emp.forEach((e)-> {
//				System.out.println(e.getEmpno());
//			});
			
			
//			Emp empById = mapper.getEmpById(7369);
			Emp empById = mapper.getEmp2Step(7369);
			System.out.println(empById.getEmpno());
			System.out.println(empById.getDeptno());
			//System.out.println(empById.getDept());
			//System.out.println(empById.getDept().getdName());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
