package com.news.model;

import java.sql.Timestamp;
import java.util.List;

import com.news.model.News;

public class NewsService {
	
	private NewsDAO_Interface dao;
	
	public NewsService(){
		dao = new NewsDAO();
	}
	
	public News insert(int newsNo, int empNo, String newsTitle, String newsContent, Timestamp newsDate){
		News news = new News();
		
		news.setNewsNo(newsNo);
		news.setEmpNo(empNo);
		news.setNewsTitle(newsTitle);
		news.setNewsContent(newsContent);
		news.setNewsDate(newsDate);
		dao.insert(news);
		
		return news;
	}
	
	public News update(int newsNo, int empNo, String newsTitle, String newsContent, Timestamp newsDate){
		News news = new News();
		
		news.setNewsNo(newsNo);
		news.setEmpNo(empNo);
		news.setNewsTitle(newsTitle);
		news.setNewsContent(newsContent);
		news.setNewsDate(newsDate);
		dao.update(news);
		
		return news;
	}
	
	public void delete(Integer newsNo){
		dao.delete(newsNo);
	}
	
	public News findByPrimaryKey(Integer newsNo){
		return dao.findByPrimaryKey(newsNo);
	}
	
	public News findByTitle(String newsTitle){
		return dao.findByTitle(newsTitle);
	}

	public News findByContent(String newsContent){
		return dao.findByContent(newsContent);
	}

	public List<News> getAll(){
		return dao.getAll();
	}

}
