package com.userquestion.model;

import java.util.List;

public class UserQuestionTest {

	public static void main(String[] args) {
		UserQuestionJDBCDAO dao = new UserQuestionJDBCDAO();

		// // �s�W
		// UserQuestion uq1 = new UserQuestion();
		// uq1.setUserQNo(1);
		// uq1.setFaqNo(1);
		// uq1.setUserQCategory("�n�J���D");
		// uq1.setUserQTitle("�ڨS��k�n�J������");
		// uq1.setUserQContent("�����W��S��k�n�J��");
		// dao.insert(uq1);
		// System.out.println("�s�W���S");

		// // �ק�
		// UserQuestion uq2 = new UserQuestion();
		// uq2.setFaqNo(2);
		// uq2.setUserQCategory("�n�J�S���D");
		// uq2.setUserQTitle("�����N�S���D");
		// uq2.setUserQContent("�N�A���D�̦h");
		// uq2.setUserQNo(5);
		// dao.update(uq2);
		// System.out.println("�ק粒�S");

		// // �R��
		// dao.delete(3);
		// System.out.println("�R���S,�V�|");

		// // �d��
		// UserQuestion uq3 = dao.findByPrimaryKey(1);
		// System.out.println(uq3.getUserQNo());
		// System.out.println(uq3.getFaqNo());
		// System.out.println(uq3.getUserQCategory());
		// System.out.println(uq3.getUserQTitle());
		// System.out.println(uq3.getUserQContent());
		// System.out.println("�䧹�S");

		// �d����
		List<UserQuestion> uqList = dao.getAll();
		for (UserQuestion uq : uqList) {
			System.out.println("===================");
			System.out.println(uq.getUserQNo());
			System.out.println(uq.getFaqNo());
			System.out.println(uq.getUserQCategory());
			System.out.println(uq.getUserQTitle());
			System.out.println(uq.getUserQContent());
		}

	}

}