package com.faq.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faq.model.*;
import com.faq.model.FaqService;

@WebServlet("/back_end/faq/faq.do")
public class FaqServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		��pk�d
		if ("getFaqNo_For_Display".equals(action)) { // �Ӧ�back_end/about_us/back_end/about_us/faq/faq_select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("faqNo");
				System.out.println(str);
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer faqNo = null;
				try {
					faqNo = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				FaqService faqService = new FaqService();
				Faq faq = faqService.findByPrimaryKey(Integer.valueOf(faqNo));
				if (faqNo == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("faq", faq); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/faq/listFaqNo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
//		��category�d
		if ("getRealtive_For_Category".equals(action)) { // �Ӧ�back_end/about_us/faq/faq_select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String faqCategory = req.getParameter("faqCategory");
				if (faqCategory == null || (faqCategory.trim()).length() == 0) {
					errorMsgs.add("�п�J���O");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				FaqService faqService = new FaqService();
				List<Faq> faqList = faqService.findByCategory(faqCategory);
				if (faqList.isEmpty()) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("faqList", faqList); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/faq/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
				failureView.forward(req, res);
			}
		}

//		��title�d
		if ("getRealtive_For_Title".equals(action)) { // �Ӧ�back_end/about_us/faq/faq_select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String faqTitle = req.getParameter("faqTitle");
				if (faqTitle == null || (faqTitle.trim()).length() == 0) {
					errorMsgs.add("�п�J���D");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				FaqService faqService = new FaqService();
				List<Faq> faqList = faqService.findByTitle(faqTitle);
				if (faqList.isEmpty()) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("faqList", faqList); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/faq/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
//		��answer�d
		if ("getRealtive_For_Answer".equals(action)) { // �Ӧ�back_end/about_us/faq/faq_select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String faqAnswer = req.getParameter("faqAnswer");
				if (faqAnswer == null || (faqAnswer.trim()).length() == 0) {
					errorMsgs.add("�п�J�ѵ�");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				FaqService faqService = new FaqService();
				List<Faq> faqList = faqService.findByAnswer(faqAnswer);
				if (faqList.isEmpty()) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("faqList", faqList); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/faq/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\���listOneEmp.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back_end/about_us/faq/faq_select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
//		�٨S�粒
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp ���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j		
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer faqNo = new Integer(req.getParameter("faqNo"));
				
				/***************************2.�}�l�d�߸��****************************************/
				FaqService faqService = new FaqService();
				Faq faq = faqService.findByPrimaryKey(faqNo);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("faq", faq); // ��Ʈw���X��empVO����,�s�Jreq
//				�o���٨S��
				String url = "/back_end/about_us/faq/update_Faq.jsp";
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
		
		
//		update
		if("update".equals(action)){
			Integer faqNo = new Integer(req.getParameter("faqNo"));
			FaqService faqService = new FaqService();
			Faq updateByPk = faqService.findByPrimaryKey(faqNo);
			req.setAttribute("faqUpdate", updateByPk);
			RequestDispatcher update = req.getRequestDispatcher("/back_end/about_us/faq/faq_News.jsp");
			update.forward(req, res);
		}
			
//		update success
		if("updateSuccess".equals(action)){
			Integer faqNo = new Integer(req.getParameter("faqNo"));
			Integer empNo = new Integer(req.getParameter("empNo"));
			String faqCategory = new String(req.getParameter("faqCategory"));
			String faqTitle = new String(req.getParameter("faqTitle"));
			String faqContent = new String(req.getParameter("faqContent"));
			
			FaqService faqService = new FaqService();
			faqService.update(faqNo, empNo, faqCategory, faqTitle, faqContent);
			
//			req.setAttribute("list", safeUpdate);
			RequestDispatcher backToList = req.getRequestDispatcher("/back_end/about_us/news/listAllNews.jsp");
			backToList.forward(req, res);
		}

//		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
//						
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			String requestURL = req.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j
//			
//			RequestDispatcher update_news = req.getRequestDispatcher("/back_end/news/update_News.jsp");
//			update_news.forward(req,res);
//			
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				String newsTitle = req.getParameter("newsTitle").trim();
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("�ж�J���D");
//				}
//							
//				String newsContent = req.getParameter("newsContent").trim();								
//				if(newsContent.isEmpty()){
//					errorMsgs.add("�ж�J���e");
//				}
//				
//				News news = new News();
//				news.setNewsTitle(newsTitle);
//				news.setNewsContent(newsContent);
//				
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("news", news); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back_end/news/update_News.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�ק���*****************************************/
//				NewsService newsService = new NewsService();
//				Integer newsNo = new Integer(req.getParameter("newsNo"));
//				Integer empNo = new Integer(req.getParameter("empNo"));
//				String newsTitle = new String(req.getParameter("newsTitle"));
//				String newsContent = new String (req.getParameter("newsContent"));
//				Timestamp newsDate = java.sql.Timestamp.valueOf(req.getParameter("newsDate"));
//				news = newsService.update(newsNo, empNo, newsTitle, newsContent, newsDate);
//				
//				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/				
//				if(requestURL.equals("/back_end/news/listAllNews.jsp"))
//					req.setAttribute("/back_end/news/listAllNews.jsp", newsService.getAll()); // ��Ʈw���X��list����,�s�Jrequest
//
//                String url = requestURL;
//				RequestDispatcher successView = req.getRequestDispatcher(url);   // �ק令�\��,���^�e�X�ק諸�ӷ�����
//				successView.forward(req, res);
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/back_end/about_us/news/update_News.jsp");
//				failureView.forward(req, res);
//			}
//		}

//		�s�W�٨S�粒
//        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//				Integer faqNo = new Integer(req.getParameter("newsNo").trim());
//				Integer empNo = new Integer(req.getParameter("empNo").trim());				
//				
//				String faqCategory = req.getParameter("faqCategory").trim();
//				if(faqCategory.isEmpty()){
//					errorMsgs.add("�ж�J���D");
//				}
//				
//				String faqTitle = req.getParameter("faqTitle").trim();
//				if(faqTitle.isEmpty()){
//					errorMsgs.add("�ж�J���D");
//				}
//							
//				String faqAnswer = req.getParameter("faqAnswer").trim();								
//				if(faqTitle.isEmpty()){
//					errorMsgs.add("�ж�J���e");
//				}
//				
//				Faq faq = new Faq();
//				faq.setFaqNo(faqNo);
//				faq.setEmpNo(empNo);
//				faq.setFaqCategory(faqCategory);
//				faq.setFaqTitle(faqTitle);
//				faq.setFaqAnswer(faqAnswer);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("faq", faq); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back_end/about_us/faq/addFaq.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�s�W���***************************************/
//				FaqService faqService = new FaqService();
//				faq = FaqService.insert(faqNo, empNo, faqCategory, faqTitle, faqAnswer);
//				
//				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
//				
//				String url = "/back_end/about_us/faq/listAllFaq.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
//				successView.forward(req, res);				
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/back_end/about_us/faq/addFaq.jsp");
//				failureView.forward(req, res);
//			}
//		}
		
     
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�R�����ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j

			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer faqNo = new Integer(req.getParameter("faqNo"));
				
				/***************************2.�}�l�R�����***************************************/
				FaqService faqService = new FaqService();
				Faq faq = faqService.findByPrimaryKey(faqNo);
				faqService.delete(faqNo);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/
				
//				�o���٨S��
				if(requestURL.equals("/faq/listAllFaq.jsp")){
					List<Faq> faqList = faqService.getAll();
					req.setAttribute("listAllFaq", faq);  //��Ʈw���X��list����,�s�Jrequest
				}
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
//				req.setAttribute("faq", faq); // ��Ʈw���X��empVO����,�s�Jreq
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
	}
}