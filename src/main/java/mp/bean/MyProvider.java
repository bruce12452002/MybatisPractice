package mp.bean;

import java.util.Map;

public class MyProvider {
	public String noParam() {
		return "select * from dept";
	}
	
	public static String param(Map<String, Integer> map) {
		return "select * from dept where deptno = " + map.get("xxx");
	}
	
}
