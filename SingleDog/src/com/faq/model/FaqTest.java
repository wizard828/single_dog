package com.faq.model;

import java.util.List;

public class FaqTest {

	public static void main(String[] args) {
		FaqJDBCDAO dao = new FaqJDBCDAO();

		// �s�W
		// Faq faq1 = new Faq();
		// faq1.setEmpNo(1);
		// faq1.setFaqCategory("�d������");
		// faq1.setFaqTitle("�ڪ��d�������F����");
		// faq1.setFaqAnswer("��ĵ���o��");
		// dao.insert(faq1);
		// System.out.println("�s�W���S");

		// �ק�
		// Faq faq2 = new Faq();
		// faq2.setEmpNo(2);
		// faq2.setFaqCategory("�R��`�����D");
		// faq2.setFaqTitle("����گ�������");
		// faq2.setFaqAnswer("�֨ӥӶD");
		// faq2.setFaqNo(2);
		// dao.update(faq2);
		// System.out.println("�ק粒�S");

		// �R�� ����n�DPKFK�H�~���R
		// dao.delete(6);
		// System.out.println("�R���S,�V�|");

		// �d��
		// Faq faq3 = dao.findByPrimaryKey(4);
		// System.out.println(faq3.getFaqNo());
		// System.out.println(faq3.getEmpNo());
		// System.out.println(faq3.getFaqCategory());
		// System.out.println(faq3.getFaqTitle());
		// System.out.println(faq3.getFaqAnswer());
		// System.out.println("�䧹�S");

		// �d����
		// List<Faq> faqList=dao.getAll();
		// for(Faq faq:faqList){
		// System.out.println(faq.getFaqNo());
		// System.out.println(faq.getEmpNo());
		// System.out.println(faq.getFaqCategory());
		// System.out.println(faq.getFaqTitle());
		// System.out.println(faq.getFaqAnswer());
		// System.out.println("===================");
		// }
	}

}