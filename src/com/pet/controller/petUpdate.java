package com.pet.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.member.model.Member;
import com.member.model.MemberService;
import com.pet.model.Pet;
import com.pet.model.PetService;


@WebServlet("/petUpdate")
@MultipartConfig
public class petUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session=req.getSession();
		PetService petSvc = new PetService();
		
		if ("petUpdate".equals(action)) {
		
			List<String> errorMsgs = new LinkedList<String>();
			
			try {
				/***************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer petNo = null;
				try {
					petNo = Integer.parseInt(req.getParameter("petNo").trim());
				} catch (IllegalArgumentException e) {
					errorMsgs.add("�t�ο��~");
				}
				
				Pet pet=petSvc.getOnePet(petNo);
					
				String petName = req.getParameter("petName");
				if (petName == null || petName.trim().isEmpty()) {
					errorMsgs.add("�ж�g�d���m�W");
				}

				String petSpecies = req.getParameter("petSpecies");
				if (petSpecies == null || petSpecies.trim().isEmpty()) {
					errorMsgs.add("�ж�g�d���~��");
				}

				java.sql.Date petBday = null;
				try {
					petBday = java.sql.Date.valueOf(req.getParameter("petBday"));
				} catch (IllegalArgumentException e) {
					errorMsgs.add("����榡���~");
				}
				

				String petIntro = req.getParameter("petIntro");
				if (petIntro == null || petIntro.trim().isEmpty()) {
					errorMsgs.add("�п�J���T���a�}");
				}
				
				Pet fPet = new Pet();
				fPet.setPetNo(pet.getPetNo());
				fPet.setMemNo(pet.getMemNo());
				fPet.setPetName(petName);
				fPet.setPetGender(pet.getPetGender());
				fPet.setPetKind(pet.getPetKind());
				fPet.setPetSpecies(petSpecies);
				fPet.setPetBday(petBday);
				fPet.setPetIntro(petIntro);
				fPet.setPetImg(pet.getPetImg());
				fPet.setPetStatus(pet.getPetStatus());
				byte[] petImg = pet.getPetImg();
				Collection<Part> parts = req.getParts();

				for (Part part : parts) {
					if (part.getName().equals("petImg") && getFileNameFromPart(part) != null
							&& part.getContentType().startsWith("image")) {
						petImg = getPictureByteArray(part.getInputStream());
						fPet.setPetImg(petImg);
					}
					if (getFileNameFromPart(part) != null && part.getName().equals("petImg")
							&& !(part.getContentType().startsWith("image"))) {
						errorMsgs.add("�Ӥ��榡���~");
					}
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("front_end/pet/petInfoUpdate.jsp");
					req.setAttribute("errorMsgs", errorMsgs);
					req.setAttribute("pet", fPet);
					dispatcher.forward(req, res);
					return;
				}

				/*************************** 2.�}�l�ק��� *****************************************/
				
		
				petSvc.updatePet(petNo, pet.getMemNo(), petName, pet.getPetKind(), pet.getPetGender(), petSpecies, petIntro, 
						petBday, petImg, pet.getPetStatus());
				

				/***************************
				 * 3.�ק粒��,�ǳ����(Send the Success view)
				 *************/
				//�b���@�� ���b�W��petSvc���O�]���W����Pet �|��PETNO
				res.sendRedirect(req.getContextPath() + "/front_end/pet/petInfo.jsp");
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		
		
		if ("petDisable".equals(action)) {
			
			/***************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
			Integer petNo = null;
			try {
				petNo = Integer.parseInt(req.getParameter("petNo").trim());
			} catch (IllegalArgumentException e) {
				
			}
			Pet pet=petSvc.getOnePet(petNo);
			/*************************** 2.�}�l�ק��� *****************************************/
			petSvc.updatePet(petNo, pet.getMemNo(), pet.getPetName(), pet.getPetKind(), pet.getPetGender(), 
					pet.getPetSpecies(), pet.getPetIntro(), pet.getPetBday(),pet.getPetImg(), 1);
			
			/**************************** 3.�ק粒��,�ǳ����(Send the Success view)*************/
			res.sendRedirect(req.getContextPath()+"/front_end/pet/petInfo.jsp");
			
			
		}
		
		
		if ("petRegister".equals(action)) {
			
			Member member=(Member)session.getAttribute("member");
			Integer memNo=null;
			if(member!=null){
				memNo=member.getMemNo();
			}
			List<String> errorMsgs = new LinkedList<String>();
			
			/***************************** 1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
			
			
			//�ˬd�O�_�W�L�T���d��
			MemberService memSvc=new MemberService();
			List<Pet> petList=memSvc.getPetsByMemNo(memNo);
			if(petList.size()>3){
				errorMsgs.add("�d������W�L�T��");
			}
			
			
			String petName=req.getParameter("petName");
			if (petName == null || petName.trim().isEmpty()) {
				errorMsgs.add("�ж�g�d���m�W");
			}
			
			
			String petKind=null;
			try {
				petKind = req.getParameter("petKind").trim();
			} catch (IllegalArgumentException e) {
				petKind = "��";
				errorMsgs.add("�п�J�d������");
			}
			
			Integer petGender=null;
			try {
				petGender = Integer.parseInt(req.getParameter("petGender").trim());
			} catch (IllegalArgumentException e) {
				petGender = 0;
				errorMsgs.add("�п�J�d���ʧO");
			}
			
			
			Pet fPet=new Pet();
			fPet.setMemNo(memNo);
			fPet.setPetName(petName);
			fPet.setPetGender(petGender);
			fPet.setPetKind(petKind);
			
			byte[] petImg=null;
			Collection<Part> parts = req.getParts();

			for (Part part : parts) {
				if (part.getName().equals("petImg") && getFileNameFromPart(part) != null
						&& part.getContentType().startsWith("image")) {
					petImg = getPictureByteArray(part.getInputStream());
					fPet.setPetImg(petImg);
				}
				if (getFileNameFromPart(part) != null && part.getName().equals("petImg")
						&& !(part.getContentType().startsWith("image"))) {
					errorMsgs.add("�Ӥ��榡���~");
				}
			}
			
			if(petImg==null){
				errorMsgs.add("�ФW���d���Ϥ�");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/front_end/pet/petRegister.jsp");
				req.setAttribute("errorMsgs", errorMsgs);
				req.setAttribute("pet", fPet);
				dispatcher.forward(req, res);
				return;
			}
			
			/*************************** 2.�}�l�ק��� *****************************************/
			petSvc.addPet(memNo, petName, petKind, petGender, "�п�J�d������"
					, "�п�J�d������",java.sql.Date.valueOf("2000-01-01"), petImg, 0);
			
			/**************************** 3.�ק粒��,�ǳ����(Send the Success view)*************/
			res.sendRedirect(req.getContextPath()+"/front_end/pet/petInfo.jsp");
			
			
		}
		
		
		
		
		

	}

	
	
	public static byte[] getPictureByteArray(InputStream fis) throws IOException {
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

	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
	
	
	
	
	
	
	
	
	
	
	
}
