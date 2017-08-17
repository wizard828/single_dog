package com.context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PutMap")
public class PutMap extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
    	ServletContext context=getServletContext();
    	
    	//�|���ʧO
    	Map<String,String> mGender=new HashMap<String,String>();
    	mGender.put("0", "�k");
    	mGender.put("1", "�k");
    	mGender.put("2", "���@�z�S");
    	context.setAttribute("mGender", mGender);
    	
    	//�|���P�����A
    	Map<String,String> mRelation=new HashMap<String,String>();
    	mRelation.put("0", "�樭");
    	mRelation.put("1", "í�w�橹");
    	mRelation.put("2", "�����}");
    	System.out.println(mRelation.get(0));
    	context.setAttribute("mRelation", mRelation);
    	
    	
    	//�d���ʧO
    	Map<String,String> pGender=new HashMap<String,String>();
    	pGender.put("0", "��");
    	pGender.put("1", "��");
    	context.setAttribute("pGender", pGender);
    	System.out.println("===============");
    	
      }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
