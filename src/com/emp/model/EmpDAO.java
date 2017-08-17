package com.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.empauth.model.EmpAuth;
import com.empauth.model.EmpAuthDAO;
import com.empauth.model.EmpAuthJDBCDAO;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Emp2;

public class EmpDAO implements EmpDAO_interface{

	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/petym");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private int currSeq;
	
	private static final String INSERT_STMT = "INSERT INTO EMP(EMPNO,EMPNAME,EMPJOB,EMPID,EMPPWD,EMPPWDSALT,EMPSTATUS,EMPHIREDATE,EMPEMAIL)"
			+ " VALUES(EMPNO_SQ.NEXTVAL,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE EMP SET EMPNO = ?, EMPNAME = ?, EMPJOB = ?, "
			+ "EMPID = ?, EMPPWD = ?, EMPPWDSALT = ?,EMPSTATUS = ?,EMPHIREDATE = ?,EMPEMAIL= ? WHERE EMPNO =�@?";
	private static final String UPDATE_AUTH_STMT = "UPDATE EMPAUTH SET EMPNO = ?, EMPNAME = ?, EMPJOB = ?, "
			+ "EMPID = ?, EMPPWD = ?,EMPSTATUS = ?,EMPHIREDATE = ?,EMPEMAIL= ? WHERE EMPNO =�@?";
	private static final String DELETE_STMT = "UPDATE EMP SET EMPSTATUS = 1 WHERE EMPNO =�@?";
	private static final String FIND_BY_PK = "SELECT * FROM EMP WHERE EMPNO = ?";
	private static final String FIND_BY_ID = "SELECT * FROM EMP WHERE EMPID = ? AND EMPSTATUS = 0";
	private static final String GET_ALL = "SELECT * FROM EMP WHERE EMPSTATUS = 0";
	private static final String GET_AUTH_BY_EMPNO = "SELECT * FROM EMPAUTH WHERE EMPNO = ?";
	
	@Override
	public void add(Emp emp) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpJob());
			pstmt.setString(3, emp.getEmpId());
			pstmt.setString(4,emp.getEmpPwd());
			pstmt.setString(5, emp.getEmpPwdSalt());
			pstmt.setInt(6, emp.getEmpStatus());
			pstmt.setDate(7, emp.getEmpHireDate());
			pstmt.setString(8, emp.getEmpEmail());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void addWithAuth(Emp emp, List<Integer> authNo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			
			// 1���]�w�� pstm.executeUpdate()���e
    		con.setAutoCommit(false);
			
    		// ���s�W�|��
			String cols[] = {"EMPNO"};
			pstmt = con.prepareStatement(INSERT_STMT , cols);			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpJob());
			pstmt.setString(3, emp.getEmpId());
			pstmt.setString(4,emp.getEmpPwd());
			pstmt.setString(5, emp.getEmpPwdSalt());
			pstmt.setInt(6, emp.getEmpStatus());
			pstmt.setDate(7, emp.getEmpHireDate());
			pstmt.setString(8, emp.getEmpEmail());
			pstmt.executeUpdate();
			//�����������ۼW�D���
			String next_memno = null;
			Integer empNo=null;
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				next_memno = rs.getString(1);
				empNo=Integer.parseInt(next_memno);
				System.out.println("�ۼW�D���= " + next_memno +"(��s�W���\�����u�s��)");
			} else {
				System.out.println("�����o�ۼW�D���");
			}
			rs.close();
			// �A�P�ɷs�W���u
			EmpAuthJDBCDAO dao = new EmpAuthJDBCDAO();
			for(Integer authN:authNo){
				EmpAuth empAuth=new EmpAuth(empNo,authN);
				dao.add2(empAuth,con);
			}
			// 2���]�w�� pstm.executeUpdate()����
			con.commit();
			con.setAutoCommit(true);
			
			// Handle any driver errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3���]�w���exception�o�ͮɤ�catch�϶���
					System.err.print("Transaction is being ");
					System.err.println("rolled back-��-dept");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	
	
	
	
	@Override
	public void update(Emp emp) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			
			con=ds.getConnection();
			pstmt=con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpJob());
			pstmt.setString(4, emp.getEmpId());
			pstmt.setString(5, emp.getEmpPwd());
			pstmt.setString(6, emp.getEmpPwdSalt());
			pstmt.setInt(7, emp.getEmpStatus());
			pstmt.setDate(8, emp.getEmpHireDate());
			pstmt.setString(9, emp.getEmpEmail());
			pstmt.setInt(10, emp.getEmpNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	//�h�Ӫ�ɧR����  EMP���h��TABLE���ѷ�   ���@����u���A
	@Override
	public void delete(int empNo) {
		PreparedStatement pstmt=null;
		Connection con=null;
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, empNo);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public Emp findByPk(int empNo) {
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		Emp emp=null;
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, empNo);
			rs=pstmt.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpJob(rs.getString("empJob"));
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpPwd(rs.getString("empPwd"));
				emp.setEmpPwdSalt(rs.getString("empPwdSalt"));
				emp.setEmpStatus(rs.getInt("empStatus"));
				emp.setEmpHireDate(rs.getDate("empHireDate"));
				emp.setEmpEmail(rs.getString("empEmail"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return emp;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList = new ArrayList<>();
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(GET_ALL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Emp emp=new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpJob(rs.getString("empJob"));
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpPwd(rs.getString("empPwd"));
				emp.setEmpPwdSalt(rs.getString("empPwdSalt"));
				emp.setEmpStatus(rs.getInt("empStatus"));
				emp.setEmpHireDate(rs.getDate("empHireDate"));
				emp.setEmpEmail(rs.getString("empEmail"));
				empList.add(emp);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empList;
	}

	@Override
	public Emp findById(String empId) {
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		Emp emp=null;
		
		try {

			con=ds.getConnection();
			pstmt=con.prepareStatement(FIND_BY_ID);
			pstmt.setString(1, empId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpJob(rs.getString("empJob"));
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpPwd(rs.getString("empPwd"));
				emp.setEmpPwdSalt(rs.getString("empPwdSalt"));
				emp.setEmpStatus(rs.getInt("empStatus"));
				emp.setEmpHireDate(rs.getDate("empHireDate"));
				emp.setEmpEmail(rs.getString("empEmail"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return emp;
	}

	@Override
	public List<Emp> getAll(Map<String, String[]> map) {
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			con = ds.getConnection();
			String finalSQL = "select * from emp "
		          + jdbcUtil_CompositeQuery_Emp2.get_WhereCondition(map)
		          + "order by empno";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("����finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpJob(rs.getString("empJob"));
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpPwd(rs.getString("empPwd"));
				emp.setEmpPwdSalt(rs.getString("empPwdSalt"));
				emp.setEmpStatus(rs.getInt("empStatus"));
				emp.setEmpHireDate(rs.getDate("empHireDate"));
				emp.setEmpEmail(rs.getString("empEmail"));
				list.add(emp); // Store the row in the List
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<Integer> getAuthByEmpNo(Integer empNo) {
		List<Integer> authList = new ArrayList<>();
		PreparedStatement pstmt=null;
		Connection con=null;
		ResultSet rs=null;
		
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(GET_AUTH_BY_EMPNO);
			pstmt.setInt(1, empNo);
			rs=pstmt.executeQuery();
			while(rs.next()){
				authList.add(rs.getInt("authNo"));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return authList ;
	}

	@Override
	public void updateWithAuth(Emp emp, List<Integer> auth) {
		PreparedStatement pstmt=null;

		Connection con=null;
		
		try {
			
			con=ds.getConnection();
			pstmt=con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpJob());
			pstmt.setString(4, emp.getEmpId());
			pstmt.setString(5, emp.getEmpPwd());
			pstmt.setString(6, emp.getEmpPwdSalt());
			pstmt.setInt(7, emp.getEmpStatus());
			pstmt.setDate(8, emp.getEmpHireDate());
			pstmt.setString(9, emp.getEmpEmail());
			pstmt.setInt(10, emp.getEmpNo());
			pstmt.executeUpdate();
			EmpAuthDAO dao=new EmpAuthDAO();
			//��ӭ��u�ª��v�������R�� �A�����s�v��
			dao.delete2(emp.getEmpNo());
			for(Integer aut:auth){
				EmpAuth eAu=new EmpAuth(emp.getEmpNo(),aut);
				dao.add(eAu);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}


}


