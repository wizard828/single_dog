package com.emp.model;

import java.util.ArrayList;
import java.util.List;

public class EmpTest {

	public static void main(String[] args) {
		EmpJDBCDAO dao=new EmpJDBCDAO();
	
		//�s�W
//		Emp emp1=new Emp();
//		emp1.setEmpName("�L�ת��T");
//		emp1.setEmpJob("�u�{�v");
//		emp1.setEmpId("dGRTG");
//		emp1.setEmpPwd("RTGRTGE");
//		emp1.setEmpStatus(0);
//		emp1.setEmpHireDate(java.sql.Date.valueOf("2000-01-01"));
//		emp1.setEmpEmail("chrisyen8341@gmail.com");
//		dao.add(emp1);
//		System.out.println("���槹��");

		
		//�s�W���u�[�v��
//		Emp emp1=new Emp();
//		emp1.setEmpName("�L�ת��T");
//		emp1.setEmpJob("�u�{�v");
//		emp1.setEmpId("dQQQTyi");
//		emp1.setEmpPwd("RTGUIE");
//		emp1.setEmpStatus(0);
//		emp1.setEmpHireDate(java.sql.Date.valueOf("2000-01-01"));
//		emp1.setEmpEmail("chrisyen8341@gmail.com");
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(4001);
//		list.add(4002);
//		list.add(4003);
//		dao.addWithAuth(emp1, list);
//		System.out.println("���槹��");
		
		
		//�ק�
//		Emp emp2=new Emp();
//		emp2.setEmpNo(6003);
//		emp2.setEmpName("�B�ʪ��v");
//		emp2.setEmpJob("�u�{�v");
//		emp2.setEmpId("werTG");
//		emp2.setEmpPwd("qweE");
//		emp2.setEmpStatus(0);
//		emp2.setEmpEmail("chros@qweqw.com");
//		emp2.setEmpHireDate(java.sql.Date.valueOf("1985-01-01"));
//		dao.update(emp2);;
//		System.out.println("���槹��");
		
		//�R�� �h��table�����F emp���h��table�ѷ�
//		dao.delete(4);
//		System.out.println("���槹��");
		
		
		//�d��
//		Emp emp3=dao.findByPk(6001);
//		System.out.println(emp3.getEmpNo());
//		System.out.println(emp3.getEmpName());
//		System.out.println(emp3.getEmpJob());
//		System.out.println(emp3.getEmpPwd());
//		System.out.println(emp3.getEmpId());
//		System.out.println(emp3.getEmpStatus());
//		System.out.println(emp3.getEmpEmail());
//		System.out.println(emp3.getEmpHireDate());
		
		//�d����
//		List<Emp> empList=dao.getAll();
//		for(Emp emp:empList){
//			System.out.println(emp.getEmpNo());
//			System.out.println(emp.getEmpName());
//			System.out.println(emp.getEmpJob());
//			System.out.println(emp.getEmpPwd());
//			System.out.println(emp.getEmpId());
//			System.out.println(emp.getEmpStatus());
//			System.out.println(emp.getEmpEmail());
//			System.out.println(emp.getEmpHireDate());
//			System.out.println("========================");
//		}
		
		
		//�d�� �HID
		Emp emp3=dao.findById("CHOUFAN");
		System.out.println(emp3.getEmpNo());
		System.out.println(emp3.getEmpName());
		System.out.println(emp3.getEmpJob());
		System.out.println(emp3.getEmpPwd());
		System.out.println(emp3.getEmpId());
		System.out.println(emp3.getEmpStatus());
		System.out.println(emp3.getEmpEmail());
		System.out.println(emp3.getEmpHireDate());
		
		
		
	}

}
