package com.pet.model;

import java.util.List;

public class PetTest {

	public static void main(String[] args) {
		PetJDBCDAO dao=new PetJDBCDAO();
		
		//�s�W
//		Pet pet1 =new Pet();
//		pet1.setMemNo(5010);
//		pet1.setPetName("�p�p��");
//		pet1.setPetKind("��");
//		pet1.setPetGender(1);
//		pet1.setPetSpecies("�x�W�g��");
//		pet1.setPetIntro("�����d������");
//		pet1.setPetBday(java.sql.Date.valueOf("2012-06-10"));
//		pet1.setPetImg(new byte[123]);
//		pet1.setPetStatus(0);
//		dao.add(pet1);
//		System.out.println("���槹��");
		
		//�ק�
//		Pet pet2=new Pet();
//		pet2.setPetNo(1006);
//		pet2.setMemNo(5003);
//		pet2.setPetName("�p�p��");
//		pet2.setPetKind("��");
//		pet2.setPetGender(0);
//		pet2.setPetSpecies("�樭��");
//		pet2.setPetIntro("�����d������");
//		pet2.setPetBday(java.sql.Date.valueOf("2011-02-10"));
//		pet2.setPetImg(new byte[123]);
//		pet2.setPetStatus(0);
//		dao.update(pet2);
//		System.out.println("���槹��");
		
		//�R��
//		dao.delete(1006);
//		System.out.println("���槹��");
		
		//�d��
//		Pet pet3=dao.findByPk(1004);
//		System.out.println(pet3.getPetNo());
//		System.out.println(pet3.getMemNo());
//		System.out.println(pet3.getPetName());
//		System.out.println(pet3.getPetKind());
//		System.out.println(pet3.getPetGender());
//		System.out.println(pet3.getPetSpecies());
//		System.out.println(pet3.getPetIntro());
//		System.out.println(pet3.getPetBday());
//		System.out.println(pet3.getPetImg());
//		System.out.println(pet3.getPetStatus());
//		System.out.println("���槹��");
		
		
		//�d����
//		List<Pet> petList=dao.getAll();
//		for(Pet pet:petList){
//			System.out.println(pet.getPetNo());
//			System.out.println(pet.getMemNo());
//			System.out.println(pet.getPetName());
//			System.out.println(pet.getPetKind());
//			System.out.println(pet.getPetGender());
//			System.out.println(pet.getPetSpecies());
//			System.out.println(pet.getPetIntro());
//			System.out.println(pet.getPetBday());
//			System.out.println(pet.getPetImg());
//			System.out.println("===================");
//			System.out.println(pet.getPetStatus());
//		}
		
		
		//�j�M
		List<Pet> petList=dao.findByPetName("�ѧL");
		for(Pet pet:petList){
			System.out.println(pet.getPetNo());
			System.out.println(pet.getMemNo());
			System.out.println(pet.getPetName());
			System.out.println(pet.getPetKind());
			System.out.println(pet.getPetGender());
			System.out.println(pet.getPetSpecies());
			System.out.println(pet.getPetIntro());
			System.out.println(pet.getPetBday());
			System.out.println(pet.getPetImg());
			System.out.println(pet.getPetStatus());
			System.out.println("===================");
		}
		System.out.println("���槹��");
		
		
	}

}
