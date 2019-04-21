package mp.bean;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
		SqlSession sqlSession2 = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			// Dept dept = sqlSession.selectOne("Dept.getDeptById", 40);
			DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

			// 一級快取(SqlSession快取)
			Dept dept1 = mapper.getDeptById(40);
			// sqlSession.clearCache();清一級快取
			// 增刪改操作之後也不會有快取
			Dept dept2 = mapper.getDeptById(40);
			// Dept dept2 = mapper.getDeptByIdAndLoc(40, "BOSTON");
			System.out.println(dept1 == dept2);

			
			sqlSession.close();

			sqlSession2 = factory.openSession();
			DeptMapper mapper2 = sqlSession2.getMapper(DeptMapper.class);
			Dept dept3 = mapper2.getDeptById(40);
			// System.out.println(dept1 == dept3);
			System.out.println(dept1 == dept3);
			System.out.println(dept2 == dept3);
			 
			
			/*
			 * Dept dept = mapper.getDeptById(40); System.out.println("dept=" + dept);
			 * System.out.println("deptNo=" + dept.getDeptNo()); System.out.println("dName="
			 * + dept.getdName()); System.out.println("loc=" + dept.getLoc());
			 */

			/*
			 * Dept dept = mapper.getDeptByIdAndLoc(40, "BOSTON");
			 * System.out.println("dept=" + dept);
			 */

			/*
			 * List<Integer> list = new ArrayList<>(); list.add(40); Dept dept =
			 * mapper.getDeptByList(list); System.out.println("dept=" + dept);
			 */

			/*
			 * Map<String, Object> map = new HashMap<>(); map.put("xxx", 40); map.put("loc",
			 * "BOSTON"); Dept dept = mapper.getDeptByMap(map); System.out.println("dept=" +
			 * dept);
			 */

			/*
			 * List<Dept> listByName = mapper.getListByName("%O%");
			 * System.out.println(listByName);//找不到不是null，是空的 list listByName.forEach((dept)
			 * -> { System.out.println(dept.getdName()); });
			 */

			/*
			 * Map<String, Object> mapById = mapper.getMapById(40);
			 * System.out.println(mapById);// 找不到為null
			 */

			/*
			 * Map<Integer, Dept> mapByName = mapper.getMapByName("%O%");
			 * System.out.println(mapByName);// 找不到不是null，是空的 map
			 */

			// Dept deptAndEmp = mapper.getDeptAndEmpsById(10);
			/*
			 * Dept deptAndEmp = mapper.getDept2Step(10);
			 * System.out.println(deptAndEmp.getDeptNo());
			 * System.out.println(deptAndEmp.getdName());
			 * System.out.println(deptAndEmp.getLoc());
			 */
//			deptAndEmp.getEmps().stream().forEach(data -> {
//				System.out.println("============");
//				System.out.println(data.getEname());
//				System.out.println(data.getJob());
//			});

			// EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//			List<Emp> emp = mapper.getEmp();
//			emp.forEach((e)-> {
//				System.out.println(e.getEmpno());
//			});

//			Emp empById = mapper.getEmpById(7369);
//			Emp empById = mapper.getEmp2Step(7369);
//			System.out.println(empById.getEmpno());
//			System.out.println(empById.getDeptno());
			// System.out.println(empById.getDept());
			// System.out.println(empById.getDept().getdName());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
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
