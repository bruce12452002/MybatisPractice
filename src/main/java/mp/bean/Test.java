package mp.bean;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import mp.bean.dao.DeptMapper;
import mp.bean.dao.EmpMapper;

public class Test {
	public static void main(String[] args) {
		InputStream is = null;
		SqlSession sqlSession = null;
		// SqlSession sqlSession2 = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			// Dept dept = sqlSession.selectOne("Dept.getDeptById", 40);
			// DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

			// 一級快取(SqlSession快取)
			// Dept dept1 = mapper.getDeptById(40);
			// sqlSession.clearCache();清一級快取
			// 增刪改操作之後也不會有快取
			// Dept dept2 = mapper.getDeptById(40);
			// Dept dept2 = mapper.getDeptByIdAndLoc(40, "BOSTON");
			// System.out.println(dept1 == dept2);

			// 二級快取
			/*
			 * sqlSession.close();
			 * 
			 * sqlSession2 = factory.openSession(); DeptMapper mapper2 =
			 * sqlSession2.getMapper(DeptMapper.class); Dept dept3 =
			 * mapper2.getDeptById(40); // System.out.println(dept1 == dept3);
			 * System.out.println(dept1 == dept3); System.out.println(dept2 == dept3);
			 */

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

			// bind tag
			/*
			 * Dept d = new Dept(); d.setdName("O"); List<Dept> bind =
			 * mapper.getDeptsByDeptUseBind(d); bind.stream().forEach(x -> {
			 * System.out.println(x.getdName()); });
			 */

			/*
			 * Map<String, String> map = new HashMap<>(); map.put("kkk", "O"); List<Dept>
			 * bind = mapper.getDeptsByMapUseBind(map); bind.stream().forEach(x -> {
			 * System.out.println(x.getdName()); });
			 */

			// Set<Dept> listById = mapper.getListByIds(Arrays.asList(10, 20));
			// Set<Dept> listById = mapper.getListById(new Integer[] {10, 20});
			// System.out.println(listById.size());

			/*
			 * Map<String, List<Integer>> map = new HashMap<>(); map.put("kkk",
			 * Arrays.asList(10, 20)); List<Dept> listById = mapper.getListByIdsForMap(map);
			 * System.out.println(listById.size());
			 */

			EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
			/*
			Page<Object> page = PageHelper.startPage(2, 3); // 每頁三條記錄，顯示第二頁，
			List<Emp> emp = mapper.getEmp();
			emp.stream().forEach(x -> System.out.println(x.getEname()));
			// SELECT * FROM ( SELECT TMP_PAGE.*, ROWNUM ROW_ID FROM ( select * from emp ) TMP_PAGE) WHERE ROW_ID <= ? AND ROW_ID > ? 
			System.out.println("當前頁:" + page.getPageNum()); // 2
			System.out.println("每頁顯示幾條記錄:" + page.getPageSize()); // 3
			System.out.println("總共幾筆記錄:" + page.getTotal());
			System.out.println("總共有幾頁:" + page.getPages());
			*/
			
			PageHelper.startPage(3, 5);
			List<Emp> emp = mapper.getEmp();
			PageInfo<Emp> pageInfo = new PageInfo<>(emp);
			emp.stream().forEach(x -> System.out.println(x.getEname()));
			System.out.println("當前頁:" + pageInfo.getPageNum());
			System.out.println("每頁顯示幾條記錄:" + pageInfo.getPageSize());
			System.out.println("當前頁有幾條記錄(最後一頁時，可能和 PageSize()不同):" + pageInfo.getSize());
			System.out.println("總共幾筆記錄:" + pageInfo.getTotal());
			System.out.println("總共有幾頁:" + pageInfo.getPages());
			
			System.out.println("當前頁的第一筆是全部記錄的第幾筆記錄:" + pageInfo.getStartRow());
			System.out.println("當前頁的最後一筆是全部記錄的第幾筆記錄:" + pageInfo.getEndRow());
			System.out.println("上一頁是第幾頁:" + pageInfo.getPrePage()); // 沒有上一頁顯示 0
			System.out.println("下一頁是第幾頁:" + pageInfo.getNextPage()); // 沒有下一頁顯示 0
			System.out.println("是否是第一頁:" + pageInfo.isIsFirstPage());
			System.out.println("是否是最後一頁:" + pageInfo.isIsLastPage());
			System.out.println("是否有上一頁:" + pageInfo.isHasPreviousPage());
			System.out.println("是否有下一頁:" + pageInfo.isHasNextPage());
			
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

			/*
			 * Emp e1 = new Emp(); e1.setEname("ccc"); e1.setDeptno(20); Emp e2 = new Emp();
			 * e2.setEname("ddd"); e2.setDeptno(30); List<Emp> list = new ArrayList<>();
			 * list.add(e1); list.add(e2);
			 */
			// mapper.bigInsert1(list);
			// mapper.bigInsert2(list);
			// mapper.bigUpdate(Arrays.asList("xxx", "ooo"));
//			mapper.bigDelete(Arrays.asList("xxx", "ooo"));
//			mapper.getEmp().stream().forEach(x -> {
//				System.out.println(x.getEname());
//			});
			// sqlSession.commit();//上面只是測試用，就不 commit了
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
