package mp.bean;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) {
		InputStream is = null;
		SqlSession sqlSession = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			sqlSession = factory.openSession();
			Dept dept = sqlSession.selectOne("Dept.getDeptById", 40);
			System.out.println("dept=" + dept);
			System.out.println("deptNo=" + dept.getDeptNo());
			System.out.println("dName=" + dept.getdName());
			System.out.println("loc=" + dept.getLoc());
		} catch (IOException e) {
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
