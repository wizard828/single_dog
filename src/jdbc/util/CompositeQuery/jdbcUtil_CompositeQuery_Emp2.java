/*
 *  1. �U�νƦX�d��-�i�ѫȤ���H�N�W�����Q�d�ߪ����
 *  2. ���F�קK�v�T�į�:
 *        �ҥH�ʺA���͸U��SQL������,���d�ҵL�N�ĥ�MetaData���覡,�]�u�w��ӧO��Table�ۦ���ݭn�ӭӧO�s�@��
 * */


package jdbc.util.CompositeQuery;

import java.util.*;

public class jdbcUtil_CompositeQuery_Emp2 {

	public static String get_aCondition_For_Oracle(String columnName, String value) {

		String aCondition = null;

		if ("empNo".equals(columnName)||"memGender".equals(columnName)||"petGender".equals(columnName)|| "memNo".equals(columnName)||"memGender".equals(columnName)) // �Ω��L
			aCondition = columnName + "=" + value;
		else if ("empName".equals(columnName) || "empId".equals(columnName)|| "empName".equals(columnName)
				|| "empJob".equals(columnName)|| "memId".equals(columnName)|| "memName".equals(columnName)
				|| "memEmail".equals(columnName)|| "petKind".equals(columnName)) // �Ω�varchar
			aCondition = columnName + " like '%" + value + "%'";
		else if ("empHireDate".equals(columnName)|| "dateMeetingTime".equals(columnName))                          // �Ω�Oracle��date
			aCondition = "to_char(" + columnName + ",'yyyy-mm-dd')='" + value + "'";

		return aCondition + " ";
	}

	public static String get_WhereCondition(Map<String, String[]> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0	&& !"action".equals(key)) {
				count++;
				String aCondition = get_aCondition_For_Oracle(key, value.trim());

				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);

				System.out.println("���e�X�d�߸�ƪ�����count = " + count);
			}
		}
		
		return whereCondition.toString();
	}

	public static void main(String argv[]) {

		// �t�X req.getParameterMap()��k �^�� java.util.Map<java.lang.String,java.lang.String[]> ������
		Map<String, String[]> map = new TreeMap<String, String[]>();
		map.put("empno", new String[] { "7001" });
		map.put("ename", new String[] { "KING" });
		map.put("job", new String[] { "PRESIDENT" });
		map.put("hiredate", new String[] { "1981-11-17" });
		map.put("sal", new String[] { "5000.5" });
		map.put("comm", new String[] { "0.0" });
		map.put("deptno", new String[] { "10" });
		map.put("action", new String[] { "getXXX" }); // �`�NMap�̭��|�t��action��key

		String finalSQL = "select * from emp2 "
				          + jdbcUtil_CompositeQuery_Emp2.get_WhereCondition(map)
				          + "order by empno";
		System.out.println("����finalSQL = " + finalSQL);

	}
}
