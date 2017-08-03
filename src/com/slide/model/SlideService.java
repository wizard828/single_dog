package com.slide.model;

import java.util.List;

public class SlideService {
	
	private SlideDAO_Interface dao;
	
	public SlideService(){
		dao = new SlideDAO();
	}
	
	public Slide insert(int slideNo, byte[] slideImg, String slideCategory, String slideTitle){
		Slide slide = new Slide();
		
		slide.setSlideNo(slideNo);
		slide.setSlideImg(slideImg);
		slide.setSlideCategory(slideCategory);
		slide.setSlideTitle(slideTitle);
		dao.insert(slide);
		
		return slide;
	}
	
	public Slide update(int slideNo, byte[] slideImg, String slideCategory, String slideTitle){
		Slide slide = new Slide();
		
		slide.setSlideNo(slideNo);
		slide.setSlideImg(slideImg);
		slide.setSlideCategory(slideCategory);
		slide.setSlideTitle(slideTitle);
		dao.update(slide);
		
		return slide;
	}
	
	public void delete(Integer slideNo){
		dao.delete(slideNo);
	}
	
	public Slide findByPrimaryKey(Integer slideNo){
		return dao.findByPrimaryKey(slideNo);				
	}
	
	public List<Slide> getAll(){
		return dao.getAll();		
	}

}
