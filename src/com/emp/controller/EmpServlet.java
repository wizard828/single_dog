package com.emp.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.emp.model.*;

@WebServlet("/back_end/emp/EmpServlet.do")
public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("empno");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���u�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer empno = null;
				try {
					empno = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("���u�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				EmpService empSvc = new EmpService();
				Emp empVO = empSvc.getOneEmp(empno);
				if (empVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("empVO", empVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/emp/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp ���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j		
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer empno = new Integer(req.getParameter("empno"));
				
				/***************************2.�}�l�d�߸��****************************************/
				EmpService empSvc = new EmpService();
				Emp empVO = empSvc.getOneEmp(empno);
				List<Integer> auth=empSvc.getAuthByEmpNo(empno);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("empVO", empVO); // ��Ʈw���X��empVO����,�s�Jreq
				req.setAttribute("auth", auth);
				String url = "/back_end/emp/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���update_emp_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƨ��X�ɥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j �� �i /emp/listEmps_ByCompositeQuery.jsp�j
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer empNo = new Integer(req.getParameter("empNo").trim());
				String empName = req.getParameter("empName").trim();
				String empJob = req.getParameter("empJob").trim();				
				
				java.sql.Date empHireDate = null;
				try {
					empHireDate = java.sql.Date.valueOf(req.getParameter("empHireDate").trim());
				} catch (IllegalArgumentException e) {
					empHireDate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}

				String empEmail = req.getParameter("empEmail");
				
				
				String[] empAuthb=req.getParameterValues("empAuth");	
				if(empAuthb==null){
					errorMsgs.add("�Цܤֵ������u�@���v��");
				}
				
				List<Integer> empAuthNos=new ArrayList<Integer>( );
				System.out.println("���b���ק��v���p�U:");
				for(String eAuth:empAuthb){
					empAuthNos.add(Integer.parseInt(eAuth));
					System.out.println(eAuth);
				};
				
				

				Emp empVO = new Emp();
				empVO.setEmpNo(empNo);
				empVO.setEmpName(empName);
				empVO.setEmpJob(empJob);
				empVO.setEmpHireDate(empHireDate);
				empVO.setEmpEmail(empEmail);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("empVO", empVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/emp/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				EmpService empSvc = new EmpService();
				Emp empc=empSvc.getOneEmp(empNo);
				empVO = empSvc.updateEmpWithAuth(empNo, empName, empJob, empc.getEmpId(), empc.getEmpPwd(),empc.getEmpPwdSalt(), 0, empHireDate, empEmail, empAuthNos);
						
						
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/				

				
				if(requestURL.equals("/emp/listEmps_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Emp> list  = empSvc.getAll(map);
					req.setAttribute("listEmps_ByCompositeQuery",list); //  �ƦX�d��, ��Ʈw���X��list����,�s�Jrequest
				}
                
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url);   // �ק令�\��,���^�e�X�ק諸�ӷ�����
				successView.forward(req, res);
 
				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/emp/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}


		
       
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�R�����ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j �� �i /emp/listEmps_ByCompositeQuery.jsp�j

			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer empno = new Integer(req.getParameter("empno"));
				
				/***************************2.�}�l�R�����***************************************/
				EmpService empSvc = new EmpService();
				Emp empVO = empSvc.getOneEmp(empno);
				empSvc.deleteEmp(empno);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/

				
				if(requestURL.equals("/emp/listEmps_ByCompositeQuery.jsp")){
					HttpSession session = req.getSession();
					Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
					List<Emp> list  = empSvc.getAll(map);
					req.setAttribute("listEmps_ByCompositeQuery",list); //  �ƦX�d��, ��Ʈw���X��list����,�s�Jrequest
				}
				
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
		
		
		if ("listEmps_ByCompositeQuery".equals(action)) { // �Ӧ�select_page.jsp���ƦX�d�߽ШD
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				
				/***************************1.�N��J����ରMap**********************************/ 
				//�ĥ�Map<String,String[]> getParameterMap()����k 
				//�`�N:an immutable java.util.Map 
				//Map<String, String[]> map = req.getParameterMap();
				HttpSession session = req.getSession();
				Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
				if (req.getParameter("whichPage") == null){
					System.out.println("22222222222222222222");
					HashMap<String, String[]> map1 = (HashMap<String, String[]>)req.getParameterMap();
					System.out.println("11111111111111111");
					HashMap<String, String[]> map2 = new HashMap<String, String[]>();
					System.out.println("33333333333333333");
					map2 = (HashMap<String, String[]>)map1.clone();
					session.setAttribute("map",map2);
					map = (HashMap<String, String[]>)req.getParameterMap();
				} 
				
				/***************************2.�}�l�ƦX�d��***************************************/
				EmpService empSvc = new EmpService();
				List<Emp> list  = empSvc.getAll(map);
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("listEmps_ByCompositeQuery", list); // ��Ʈw���X��list����,�s�Jrequest
				RequestDispatcher successView = req.getRequestDispatcher("/back_end/emp/listEmps_ByCompositeQuery.jsp"); // ���\���listEmps_ByCompositeQuery.jsp
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/emp/authManage.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
