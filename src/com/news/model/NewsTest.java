package com.news.model;

import java.util.ArrayList;
import java.util.List;

public class NewsTest {

	public static void main(String[] args) {
		NewsJDBCDAO dao = new NewsJDBCDAO();

		// �s�W
		// News news1 = new News();
		// news1.setEmpNo(1);
		// news1.setNewsTitle("�o�O���i");
		// news1.setNewsContent("���e�b�o���");
		// news1.setNewsDate(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		// dao.insert(news1);
		// System.out.println("�s�W���S");

		// �ק�
		// News news2 = new News();
		// news2.setNewsTitle("���i���D��F");
		// news2.setNewsContent("���i���e��F");
		// news2.setNewsDate(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		// news2.setNewsNo(1);
		// dao.update(news2);
		// System.out.println("�ק粒�S");

		// �R��
		// dao.delete(3);
		// System.out.println("�R���S,�V�|");

		// �d��
		// News news3 = dao.findByPrimaryKey(1);
		// System.out.println(news3.getNewsNo());
		// System.out.println(news3.getEmpNo());
		// System.out.println(news3.getNewsTitle());
		// System.out.println(news3.getNewsContent());
		// System.out.println(news3.getNewsDate());
		// System.out.println("�䧹�S");

		// title�d��
		// News news4 = dao.findByTitle("�o�O���i");
		// System.out.println(news4.getNewsNo());
		// System.out.println(news4.getEmpNo());
		// System.out.println(news4.getNewsTitle());
		// System.out.println(news4.getNewsContent());
		// System.out.println(news4.getNewsDate());
		// System.out.println("�䧹�S");

		// content�d��
		List<News> newsList = new ArrayList<>();
		for (News news : newsList) {
		News news5 = dao.findByContent("���i���e�b�o");
		System.out.println(news5.getNewsNo());
		System.out.println(news5.getEmpNo());
		System.out.println(news5.getNewsTitle());
		System.out.println(news5.getNewsContent());
		System.out.println(news5.getNewsDate());
		System.out.println("�䧹�S");
		}
		
		// �d����
		// List<News> newsList = new ArrayList<>();
		// for (News news : newsList) {
		// System.out.println(news.getNewsNo());
		// System.out.println(news.getEmpNo());
		// System.out.println(news.getNewsTitle());
		// System.out.println(news.getNewsContent());
		// System.out.println(news.getNewsDate());
		// System.out.println("===================");
		// }

	}

}