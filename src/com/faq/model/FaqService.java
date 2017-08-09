package com.faq.model;

import java.util.List;

import com.ad.model.Ad;
import com.news.model.News;

public class FaqService {
	
	private FaqDAO_Interface dao;
	
	public FaqService(){
		dao = new FaqDAO();
	}
	
	public Faq insert(int faqNo, int empNo, String faqCategory, String faqTitle, String faqAnswer){
		Faq faq = new Faq();
		
//		faq.setFaqNo(faqNo);
		faq.setEmpNo(empNo);
		faq.setFaqCategory(faqCategory);
		faq.setFaqTitle(faqTitle);
		faq.setFaqAnswer(faqAnswer);
		
		return faq;
	}
	
	public Faq update(int faqNo, int empNo, String faqCategory, String faqTitle, String faqAnswer){
		Faq faq = new Faq();
		
		faq.setFaqNo(faqNo);
		faq.setEmpNo(empNo);
		faq.setFaqCategory(faqCategory);
		faq.setFaqTitle(faqTitle);
		faq.setFaqAnswer(faqAnswer);
		
		return faq;
	}
	
	public void delete(Integer faqNo){
		dao.delete(faqNo);
	}
	
	public Faq findByPrimaryKey(Integer faqNo){
		return dao.findByPrimaryKey(faqNo);
	}
	
	public List<Faq> findByCategory(String faqCategory){
		return dao.findByCategory(faqCategory);
	}
	
	public List<Faq> findByTitle(String faqTitle){
		return dao.findByTitle(faqTitle);
	}

	public List<Faq> findByAnswer(String faqAnswer){
		return dao.findByAnswer(faqAnswer);
	}
	
	public List<Faq> getAll(){
		return dao.getAll();
	}

}
