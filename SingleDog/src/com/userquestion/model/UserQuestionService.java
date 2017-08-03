package com.userquestion.model;

import java.util.List;

import com.ad.model.Ad;

public class UserQuestionService {
	
	private UserQuestionDAO_Interface dao;
	
	public UserQuestionService(){
		dao = new UserQuestionDAO();
	}
	
	public UserQuestion insert(int userQNo, int faqNo, String userQCategory, String userQTitle, String userQContent){
		UserQuestion uq = new UserQuestion();
		
		uq.setUserQNo(userQNo);
		uq.setFaqNo(faqNo);
		uq.setUserQCategory(userQCategory);
		uq.setUserQTitle(userQTitle);
		uq.setUserQContent(userQContent);
		dao.insert(uq);
		
		return uq;
	}
	
	public UserQuestion update(int userQNo, int faqNo, String userQCategory, String userQTitle, String userQContent){
		UserQuestion uq = new UserQuestion();
		
		uq.setUserQNo(userQNo);
		uq.setFaqNo(faqNo);
		uq.setUserQCategory(userQCategory);
		uq.setUserQTitle(userQTitle);
		uq.setUserQContent(userQContent);
		dao.update(uq);
		
		return uq;
	}
	
	public void delete(Integer userQNo){
		dao.delete(userQNo);
	}
	
	public UserQuestion findByPrimaryKey(Integer userQNo){
		return dao.findByPrimaryKey(userQNo);
	}
	
	public List<UserQuestion> getAll(){
		return dao.getAll();
	}


}
