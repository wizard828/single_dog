package com.member.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.pet.model.Pet;

public class MemberTest {

	public static void main(String[] args) throws IOException {
		MemberJDBCDAO dao=new MemberJDBCDAO();
		
		
		//�s�W
//		Member member=new Member();
//		member.setMemId("chrisyen8342");
//		member.setMemPwd("d656545");
//		member.setMemName("�C���a");
//		member.setMemSname("�p�C");
//		member.setMemGender("�k");
//		member.setMemIdNo("F128546845");
//		member.setMemBday(java.sql.Date.valueOf("2017-07-10"));
//		member.setMemPhone("0930160401");
//		member.setMemAddress("���c�Ƥ�����65��");
//		member.setMemEmail("chrisyen8341@gmail.com");
//		member.setMemImg(new byte[1231654]);
//		member.setMemReported(10);
//		member.setMemStatus(0);
//		member.setMemRelation("�樭");
//		member.setMemSelfintro("�o�O���եΪ���ơA�ڦb�ۧڤ���");
//		member.setMemFollowed(0);
//		member.setMemPoint(0);
//		member.setMemSaleRank(1);
//		member.setMemLongtitude(7.666);
//		member.setMemLatitude(25.2222);
//		member.setMemLocTime(new Timestamp((new Date()).getTime()));
//		member.setMemLocStatus(0);
//		dao.add(member);
//		System.out.println("���槹��");
		
		
		//�s�W���d���|��
//		Member member=new Member();
//		Pet pet=new Pet();
//		member.setMemId("QWPPQWEsd5648");
//		member.setMemPwd("d656545");
//		member.setMemName("�C���a");
//		member.setMemSname("�p�C");
//		member.setMemGender(0);
//		member.setMemIdNo("F128546845");
//		member.setMemBday(java.sql.Date.valueOf("2017-07-10"));
//		member.setMemPhone("0930160401");
//		member.setMemAddress("���c�Ƥ�����65��");
//		member.setMemEmail("chrisyen8341@gmail.com");
//		member.setMemImg(getPictureByteArray(new File("WebContent/DummyImg/member/m6.png")));
//		member.setMemReported(10);
//		member.setMemStatus(0);
//		member.setMemRelation(1);
//		member.setMemSelfintro("�o�O���եΪ���ơA�ڦb�ۧڤ���");
//		member.setMemFollowed(0);
//		member.setMemPoint(0);
//		member.setMemSaleRank(1);
//		member.setMemLongtitude(7.666);
//		member.setMemLatitude(25.2222);
//		member.setMemLocTime(new Timestamp((new Date()).getTime()));
//		member.setMemLocStatus(0);
//		pet.setPetName("�p�p��");
//		pet.setPetKind("��");
//		pet.setPetGender(0);
//		pet.setPetSpecies("�x�W�g��");
//		pet.setPetIntro("�����d������");
//		pet.setPetBday(java.sql.Date.valueOf("2012-06-10"));
//		pet.setPetImg(getPictureByteArray(new File("WebContent/DummyImg/pet/p1.jpg")));
//		dao.addWithPet(member, pet);
//		System.out.println("���槹��");
//		
		
		
		
		//�ק�
//		Member member2=new Member();
//		member2.setMemNo(4);
//		member2.setMemId("changeinthere");
//		member2.setMemPwd("d656545");
//		member2.setMemName("�C���a");
//		member2.setMemSname("�p�C");
//		member2.setMemGender("�k");
//		member2.setMemIdNo("F128546845");
//		member2.setMemBday(java.sql.Date.valueOf("2017-07-10"));
//		member2.setMemPhone("0930160401");
//		member2.setMemAddress("changeinthere");
//		member2.setMemEmail("chrisyen8341@gmail.com");
//		member2.setMemImg(new byte[1231654]);
//		member2.setMemReported(10);
//		member2.setMemStatus(0);
//		member2.setMemRelation("�樭");
//		member2.setMemSelfintro("���ƭק�");
//		member2.setMemFollowed(0);
//		member2.setMemPoint(0);
//		member2.setMemSaleRank(1);
//		member2.setMemLongtitude(7.666);
//		member2.setMemLatitude(25.2222);
//		member2.setMemLocTime(new Timestamp((new Date()).getTime()));
//		member2.setMemLocStatus(0);
//		dao.update(member2);
//		System.out.println("���槹��");
		
		
		//�R�� �h�Ӫ�R���� member���h��table�ѷ�
//		dao.delete(3);
//		System.out.println("���槹��");
		
		//�d��
//		Member member3=dao.findByPk(5);
//		System.out.println(member3.getMemNo()+",");
//		System.out.println(member3.getMemId()+",");
//		System.out.println(member3.getMemPwd()+",");
//		System.out.println(member3.getMemName()+",");
//		System.out.println(member3.getMemSname()+",");
//		System.out.println(member3.getMemGender()+",");
//		System.out.println(member3.getMemIdNo()+",");
//		System.out.println(member3.getMemBday()+",");
//		System.out.println(member3.getMemPhone()+",");
//		System.out.println(member3.getMemAddress()+",");
//		System.out.println(member3.getMemEmail()+",");
//		System.out.println(member3.getMemImg()+",");
//		System.out.println(member3.getMemReported()+",");
//		System.out.println(member3.getMemStatus()+",");
//		System.out.println(member3.getMemRelation()+",");
//		System.out.println(member3.getMemSelfintro()+",");
//		System.out.println(member3.getMemFollowed()+",");
//		System.out.println(member3.getMemPoint()+",");
//		System.out.println(member3.getMemSaleRank()+",");
//		System.out.println(member3.getMemLongtitude()+",");
//		System.out.println(member3.getMemLatitude()+",");
//		System.out.println(member3.getMemLocTime()+"�C");
//		System.out.println(member3.getMemLocStatus()+"�C");
		
		//�d�ߥ���
//		List<Member> memberList=dao.getAll();
//		for(Member member4:memberList){
//			System.out.println(member4.getMemNo()+",");
//			System.out.println(member4.getMemId()+",");
//			System.out.println(member4.getMemPwd()+",");
//			System.out.println(member4.getMemName()+",");
//			System.out.println(member4.getMemSname()+",");
//			System.out.println(member4.getMemGender()+",");
//			System.out.println(member4.getMemIdNo()+",");
//			System.out.println(member4.getMemBday()+",");
//			System.out.println(member4.getMemPhone()+",");
//			System.out.println(member4.getMemAddress()+",");
//			System.out.println(member4.getMemEmail()+",");
//			System.out.println(member4.getMemImg()+",");
//			System.out.println(member4.getMemReported()+",");
//			System.out.println(member4.getMemStatus()+",");
//			System.out.println(member4.getMemRelation()+",");
//			System.out.println(member4.getMemSelfintro()+",");
//			System.out.println(member4.getMemFollowed()+",");
//			System.out.println(member4.getMemPoint()+",");
//			System.out.println(member4.getMemSaleRank()+",");
//			System.out.println(member4.getMemLongtitude()+",");
//			System.out.println(member4.getMemLatitude()+",");
//			System.out.println(member4.getMemLocTime()+"�C");
//		}
		
		//�d�|���n����(ID,PWD)
//		System.out.println("�b�K���T");
//		Member member3=dao.findById("OOOOOOO");
//		if(member3!=null){
//		System.out.println(member3.getMemNo()+",");
//		System.out.println(member3.getMemId()+",");
//		System.out.println(member3.getMemPwd()+",");
//		System.out.println(member3.getMemName()+",");
//		System.out.println(member3.getMemSname()+",");
//		System.out.println(member3.getMemGender()+",");
//		System.out.println(member3.getMemIdNo()+",");
//		System.out.println(member3.getMemBday()+",");
//		System.out.println(member3.getMemPhone()+",");
//		System.out.println(member3.getMemAddress()+",");
//		System.out.println(member3.getMemEmail()+",");
//		System.out.println(member3.getMemImg()+",");
//		System.out.println(member3.getMemReported()+",");
//		System.out.println(member3.getMemStatus()+",");
//		System.out.println(member3.getMemRelation()+",");
//		System.out.println(member3.getMemSelfintro()+",");
//		System.out.println(member3.getMemFollowed()+",");
//		System.out.println(member3.getMemPoint()+",");
//		System.out.println(member3.getMemSaleRank()+",");
//		System.out.println(member3.getMemLongtitude()+",");
//		System.out.println(member3.getMemLatitude()+",");
//		System.out.println(member3.getMemLocTime()+"�C");
//		System.out.println(member3.getMemLocStatus()+"�C");
//		}
//		

		
		
		//�d�ߥ���
		List<Member> memberList=dao.findByIdAndName("�C���a");
		for(Member member4:memberList){
			System.out.println(member4.getMemNo()+",");
			System.out.println(member4.getMemId()+",");
			System.out.println(member4.getMemPwd()+",");
			System.out.println(member4.getMemName()+",");
			System.out.println(member4.getMemSname()+",");
			System.out.println(member4.getMemGender()+",");
			System.out.println(member4.getMemIdNo()+",");
			System.out.println(member4.getMemBday()+",");
			System.out.println(member4.getMemPhone()+",");
			System.out.println(member4.getMemAddress()+",");
			System.out.println(member4.getMemEmail()+",");
			System.out.println(member4.getMemImg()+",");
			System.out.println(member4.getMemReported()+",");
			System.out.println(member4.getMemStatus()+",");
			System.out.println(member4.getMemRelation()+",");
			System.out.println(member4.getMemSelfintro()+",");
			System.out.println(member4.getMemFollowed()+",");
			System.out.println(member4.getMemPoint()+",");
			System.out.println(member4.getMemSaleRank()+",");
			System.out.println(member4.getMemLongtitude()+",");
			System.out.println(member4.getMemLatitude()+",");
			System.out.println(member4.getMemLocTime()+"�C");
			System.out.println("================================");
		}
		System.out.println("���槹��");
		
		
		
	}
	
	public static byte[] getPictureByteArray(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int i;
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	}
	

}
