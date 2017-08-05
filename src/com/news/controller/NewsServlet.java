package com.news.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.news.model.NewsService;
import com.news.model.News;

@WebServlet({"/back_end/news/news.do"})
public class NewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		��pk�d
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("newsNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer newsNo = null;
				try {
					newsNo = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
				if (newsNo == null) {
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
				req.setAttribute("news", news); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/news/listRealtive.jsp";
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

//		��title�d
		if ("getRealtive_For_Title".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String newsTitle = req.getParameter("newsTitle");
				if (newsTitle == null || (newsTitle.trim()).length() == 0) {
					errorMsgs.add("�п�J���D");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				NewsService newsService = new NewsService();
				List<News> newsList = newsService.findByTitle(newsTitle);
				if (newsList.isEmpty()) {
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
				req.setAttribute("newsList", newsList); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/news/listRealtive.jsp";
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
		
//		��content�d
		if ("getRealtive_For_Content".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String newsContent = req.getParameter("newsContent");
				if (newsContent == null || (newsContent.trim()).length() == 0) {
					errorMsgs.add("�п�J���e");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				NewsService newsService = new NewsService();
				List<News> newsList = newsService.findByContent(newsContent);
				if (newsList.isEmpty()) {
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
				req.setAttribute("newsList", newsList); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back_end/about_us/news/listRealtive.jsp";
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
		
//		�٨S�粒
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp ���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�ק諸�ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j		
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer newsNo = new Integer(req.getParameter("newsNo"));
				
				/***************************2.�}�l�d�߸��****************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("news", news); // ��Ʈw���X��empVO����,�s�Jreq
//				�o���٨S��
				String url = "/back_end/about_us/news/update_News.jsp";
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
			Integer newsNo = new Integer(req.getParameter("newsNo"));
			NewsService newsService = new NewsService();
			News updateByPk = newsService.findByPrimaryKey(newsNo);
			req.setAttribute("newsUpdate", updateByPk);
			RequestDispatcher update = req.getRequestDispatcher("/back_end/about_us/news/update_News.jsp");
			update.forward(req, res);
		}
			
//		update success
		if("updateSuccess".equals(action)){
			Integer newsNo = new Integer(req.getParameter("newsNo"));
			Integer empNo = new Integer(req.getParameter("empNo"));
			String newsTitle = new String(req.getParameter("newsTitle"));
			String newsContent = new String(req.getParameter("newsContent"));
			Timestamp newsDate = java.sql.Timestamp.valueOf(req.getParameter("newsDate"));
			
			NewsService newsService = new NewsService();
			newsService.update(newsNo, empNo, newsTitle, newsContent, newsDate);
			
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

//        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//				Integer newsNo = new Integer(req.getParameter("newsNo").trim());
//				Integer empNo = new Integer(req.getParameter("empNo").trim());				
//								
//				String newsTitle = req.getParameter("newsTitle").trim();
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("�ж�J���D");
//				}
//							
//				String newsContent = req.getParameter("newsContent").trim();								
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("�ж�J���e");
//				}
//				
//				Timestamp newsDate = null;
//				try {
//					newsDate = Timestamp.valueOf(req.getParameter("newsDate"));
//				} catch (IllegalArgumentException e) {					
//					errorMsgs.add("����榡���~");
//				}
//				
//				News news = new News();
//				news.setNewsNo(newsNo);
//				news.setEmpno(empno);
//				news.setNewsTitle(newsTitle);
//				news.setNewsContent(newsContent);
//				news.setNewsDate(newsDate);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("news", news); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�s�W���***************************************/
//				NewsService newsService = new NewsService();
//				news = newsService.update(newsNo, empNo, newsTitle, newsContent, newsDate);
//				
//				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
//				
////				�o���٨S��
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
//				successView.forward(req, res);				
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//     
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp ��  /dept/listEmps_ByDeptno.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // �e�X�R�����ӷ��������|: �i�ର�i/emp/listAllEmp.jsp�j ��  �i/dept/listEmps_ByDeptno.jsp�j �� �i /dept/listAllDept.jsp�j

			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer newsNo = new Integer(req.getParameter("newsNo"));
				
				/***************************2.�}�l�R�����***************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
				newsService.delete(newsNo);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/
				
//				�o���٨S��
				if(requestURL.equals("/news/listAllNews.jsp")){
					List<News> newsList = newsService.getAll();
					req.setAttribute("listAllNews", news);  //��Ʈw���X��list����,�s�Jrequest
				}
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
//				req.setAttribute("news", news); // ��Ʈw���X��empVO����,�s�Jreq
				
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