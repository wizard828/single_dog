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
		
//		用pk查
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("newsNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer newsNo = null;
				try {
					newsNo = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
				if (newsNo == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("news", news); // 資料庫取出的empVO物件,存入req
				String url = "/back_end/about_us/news/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

//		用title查
		if ("getRealtive_For_Title".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String newsTitle = req.getParameter("newsTitle");
				if (newsTitle == null || (newsTitle.trim()).length() == 0) {
					errorMsgs.add("請輸入標題");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				NewsService newsService = new NewsService();
				List<News> newsList = newsService.findByTitle(newsTitle);
				if (newsList.isEmpty()) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("newsList", newsList); // 資料庫取出的empVO物件,存入req
				String url = "/back_end/about_us/news/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
//		用content查
		if ("getRealtive_For_Content".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String newsContent = req.getParameter("newsContent");
				if (newsContent == null || (newsContent.trim()).length() == 0) {
					errorMsgs.add("請輸入內容");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				NewsService newsService = new NewsService();
				List<News> newsList = newsService.findByContent(newsContent);
				if (newsList.isEmpty()) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("newsList", newsList); // 資料庫取出的empVO物件,存入req
				String url = "/back_end/about_us/news/listRealtive.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
//		還沒改完
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer newsNo = new Integer(req.getParameter("newsNo"));
				
				/***************************2.開始查詢資料****************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("news", news); // 資料庫取出的empVO物件,存入req
//				這邊還沒改
				String url = "/back_end/about_us/news/update_News.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料取出時失敗:"+e.getMessage());
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
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//						
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
//			
//			RequestDispatcher update_news = req.getRequestDispatcher("/back_end/news/update_News.jsp");
//			update_news.forward(req,res);
//			
//			try {
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				String newsTitle = req.getParameter("newsTitle").trim();
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("請填入標題");
//				}
//							
//				String newsContent = req.getParameter("newsContent").trim();								
//				if(newsContent.isEmpty()){
//					errorMsgs.add("請填入內容");
//				}
//				
//				News news = new News();
//				news.setNewsTitle(newsTitle);
//				news.setNewsContent(newsContent);
//				
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("news", news); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/back_end/news/update_News.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				NewsService newsService = new NewsService();
//				Integer newsNo = new Integer(req.getParameter("newsNo"));
//				Integer empNo = new Integer(req.getParameter("empNo"));
//				String newsTitle = new String(req.getParameter("newsTitle"));
//				String newsContent = new String (req.getParameter("newsContent"));
//				Timestamp newsDate = java.sql.Timestamp.valueOf(req.getParameter("newsDate"));
//				news = newsService.update(newsNo, empNo, newsTitle, newsContent, newsDate);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
//				if(requestURL.equals("/back_end/news/listAllNews.jsp"))
//					req.setAttribute("/back_end/news/listAllNews.jsp", newsService.getAll()); // 資料庫取出的list物件,存入request
//
//                String url = requestURL;
//				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("修改資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/back_end/about_us/news/update_News.jsp");
//				failureView.forward(req, res);
//			}
//		}

//        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				Integer newsNo = new Integer(req.getParameter("newsNo").trim());
//				Integer empNo = new Integer(req.getParameter("empNo").trim());				
//								
//				String newsTitle = req.getParameter("newsTitle").trim();
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("請填入標題");
//				}
//							
//				String newsContent = req.getParameter("newsContent").trim();								
//				if(newsTitle.isEmpty()){
//					errorMsgs.add("請填入內容");
//				}
//				
//				Timestamp newsDate = null;
//				try {
//					newsDate = Timestamp.valueOf(req.getParameter("newsDate"));
//				} catch (IllegalArgumentException e) {					
//					errorMsgs.add("日期格式錯誤");
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
//					req.setAttribute("news", news); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始新增資料***************************************/
//				NewsService newsService = new NewsService();
//				news = newsService.update(newsNo, empNo, newsTitle, newsContent, newsDate);
//				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				
////				這邊還沒改
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/emp/addEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
//		
//     
		if ("delete".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】

			try {
				/***************************1.接收請求參數***************************************/
				Integer newsNo = new Integer(req.getParameter("newsNo"));
				
				/***************************2.開始刪除資料***************************************/
				NewsService newsService = new NewsService();
				News news = newsService.findByPrimaryKey(newsNo);
				newsService.delete(newsNo);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
				
//				這邊還沒改
				if(requestURL.equals("/news/listAllNews.jsp")){
					List<News> newsList = newsService.getAll();
					req.setAttribute("listAllNews", news);  //資料庫取出的list物件,存入request
				}
				String url = requestURL;
				RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
//				req.setAttribute("news", news); // 資料庫取出的empVO物件,存入req
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher(requestURL);
				failureView.forward(req, res);
			}
		}
	}
}