package com.news.model;

import java.util.List;

public interface NewsDAO_Interface {
	
	public void insert(News news);
	public void update(News news);
	public void delete(int newsNo);
	public News findByPrimaryKey(int newsNo);
//	public List<News> findByEmpNo(int empNo);
	public List<News> findByTitle(String newsTitle);
	public List<News> findByContent(String newsContent);
	public List<News> getAll();	
}