package com.member.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.email.MailService;
import com.member.model.Member;
import com.member.model.MemberService;
import com.pet.model.Pet;
import com.pet.model.PetService;

@WebServlet("/Update")
@MultipartConfig
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("member");
		MemberService memSvc = new MemberService();

		if ("memUpdate".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			try {
				/*****************************
				 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
				 **********************/
				String memSname = req.getParameter("memSname");
				if (memSname == null || memSname.trim().isEmpty()) {
					errorMsgs.add("�ж�g�ʺ�");
				}

				String memName = req.getParameter("memName");
				if (memName == null || memName.trim().isEmpty()) {
					errorMsgs.add("�ж�g�m�W");
				}

				java.sql.Date memBday = null;
				try {
					memBday = java.sql.Date.valueOf(req.getParameter("memBday"));
				} catch (IllegalArgumentException e) {
					errorMsgs.add("����榡���~");
				}

				String memPhone = req.getParameter("memPhone");
				if (!(memPhone.matches("[09]{2}[0-9]{2}-[0-9]{6}") || memPhone.matches("[09]{2}[0-9]{8}"))) {
					errorMsgs.add("����榡���~");
				}

				Integer memGender = null;
				try {
					memGender = Integer.parseInt(req.getParameter("memGender").trim());
				} catch (IllegalArgumentException e) {
					memGender = 2;
					errorMsgs.add("�п�J�ʧO");
				}

				Integer memRelation = null;
				try {
					memRelation = Integer.parseInt(req.getParameter("memRelation").trim());
				} catch (IllegalArgumentException e) {
					memRelation = 2;
					errorMsgs.add("�п�J�P�����A");
				}

				String memEmail = req.getParameter("memEmail");
				if (!memEmail.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")) {
					errorMsgs.add("�п�J���T��Email�H�c");
				}

				String memAddress = req.getParameter("memAddress");
				if (memAddress == null || memAddress.trim().isEmpty()) {
					errorMsgs.add("�п�J���T���a�}");
				}

				String memSelfintro = req.getParameter("memSelfintro");
				if (memSelfintro == null || memSelfintro.trim().isEmpty()) {
					errorMsgs.add("�п�J���T���a�}");
				}

				Member memberU = new Member();
				memberU.setMemSname(memSname);
				memberU.setMemName(memName);
				memberU.setMemBday(memBday);
				memberU.setMemPhone(memPhone);
				memberU.setMemGender(memGender);
				memberU.setMemRelation(memRelation);
				memberU.setMemEmail(memEmail);
				memberU.setMemAddress(memAddress);
				memberU.setMemSelfintro(memSelfintro);
				byte[] memImg = member.getMemImg();
				Collection<Part> parts = req.getParts();

				for (Part part : parts) {
					if (part.getName().equals("memImg") && getFileNameFromPart(part) != null
							&& part.getContentType().startsWith("image")) {
						memImg = getPictureByteArray(part.getInputStream());
						memberU.setMemImg(memImg);
					}
					if (getFileNameFromPart(part) != null && part.getName().equals("memImg")
							&& !(part.getContentType().startsWith("image"))) {
						errorMsgs.add("�Ӥ��榡���~");
					}
				}

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("/front_end/member/memberInfoUpdate.jsp");
					req.setAttribute("errorMsgs", errorMsgs);
					req.setAttribute("member", memberU);
					dispatcher.forward(req, res);
					return;
				}

				/*************************** 2.�}�l�ק��� *****************************************/

				memSvc.updateMember(member.getMemNo(), member.getMemId(), member.getMemPwd(), memName, memSname,
						memGender, member.getMemIdNo(), memBday, memPhone, memAddress, memEmail, memImg,
						member.getMemReported(), member.getMemStatus(), memRelation, memSelfintro,
						member.getMemFollowed(), member.getMemPoint(), member.getMemSaleRank(),
						member.getMemLongtitude(), member.getMemLatitude(), member.getMemLocTime(),
						member.getMemLocStatus());
				/***************************
				 * 3.�ק粒��,�ǳ����(Send the Success view)
				 *************/
				Integer memNo = member.getMemNo();
				session.removeAttribute("member");
				Member newMember = memSvc.getOneMember(memNo);
				session.setAttribute("member", newMember);
				res.sendRedirect(req.getContextPath() + "/front_end/member/memberInfo.jsp");
			} catch (Exception e) {
				System.out.println("error");
			}
		}

		// �ק�K�X
		if ("pwdChange".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			/*****************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/

			String memPwd = req.getParameter("memPwd");
			if (!memPwd.equals(member.getMemPwd())) {
				errorMsgs.add("�ثe���K�X���~");
			}

			String memNewPwd = req.getParameter("memNewPwd");
			if (!(memNewPwd.matches(".*[a-zA-Z]+.*") && memNewPwd.trim().length() > 5)) {
				errorMsgs.add("�s�K�X�榡����");
			}

			Map<String, String> falsePwd = new HashMap<String, String>();
			falsePwd.put("memPwd", memPwd);
			falsePwd.put("memNewPwd", memNewPwd);

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/front_end/member/memPwdChange.jsp");
				req.setAttribute("falsePwd", falsePwd);
				req.setAttribute("errorMsgs", errorMsgs);
				dispatcher.forward(req, res);
				return;
			}

			/*************************** 2.�}�l�ק��� *****************************************/
			memSvc.updateMember(member.getMemNo(), member.getMemId(), memNewPwd, member.getMemName(),
					member.getMemSname(), member.getMemGender(), member.getMemIdNo(), member.getMemBday(),
					member.getMemPhone(), member.getMemAddress(), member.getMemEmail(), member.getMemImg(),
					member.getMemReported(), member.getMemStatus(), member.getMemRelation(), member.getMemSelfintro(),
					member.getMemFollowed(), member.getMemPoint(), member.getMemSaleRank(), member.getMemLongtitude(),
					member.getMemLatitude(), member.getMemLocTime(), member.getMemLocStatus());

			/****************************
			 * 3.�ק粒��,�ǳ����(Send the Success view)
			 *************/
			Integer memNo = member.getMemNo();
			session.removeAttribute("member");
			Member newMember = memSvc.getOneMember(memNo);
			session.setAttribute("member", newMember);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front_end/member/memPwdChange.jsp");
			req.setAttribute("success", "�K�X�ק令�\");
			dispatcher.forward(req, res);

		}

		// �|�����U
		if ("register".equals(action)) {

			/****************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/
			String memId = req.getParameter("memId").trim();
			String memPwd = req.getParameter("memPwd").trim();
			String memName = req.getParameter("memName").trim();
			String memSname = req.getParameter("memSname").trim();
			String memIdNo = req.getParameter("memIdNo").trim();
			String memPhone = req.getParameter("memPhone").trim();
			String memAddress = req.getParameter("memAddress").trim();
			String memEmail = req.getParameter("memEmail").trim();

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			if (memId == null || memId.isEmpty()) {
				errorMsgs.add("�ж�g�b��");
			}
			if (memPwd == null || memPwd.isEmpty()) {
				errorMsgs.add("�ж�g�K�X");
			}
			if (memName == null || memName.isEmpty()) {
				errorMsgs.add("�ж�g�m�W");
			}
			if (memSname == null || memSname.isEmpty()) {
				errorMsgs.add("�ж�g�ʺ�");
			}

			Integer memGender = null;
			try {
				memGender = Integer.parseInt(req.getParameter("memGender").trim());
			} catch (IllegalArgumentException e) {
				memGender = 1;
				errorMsgs.add("�п�J�ʧO");
			}

			if (memIdNo == null || memIdNo.isEmpty()) {
				errorMsgs.add("�ж�g�����Ҧr��");
			}

			java.sql.Date memBday = null;
			try {
				memBday = java.sql.Date.valueOf(req.getParameter("memBday").trim());
			} catch (IllegalArgumentException e) {
				memBday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("�п�J�ͤ�!");
			}

			if (memPhone == null || memPhone.isEmpty()) {
				errorMsgs.add("�ж�g���");
			}
			if (memAddress == null || memAddress.isEmpty()) {
				errorMsgs.add("�ж�g�a�}");
			}
			if (memEmail == null || memEmail.isEmpty()) {
				errorMsgs.add("�ж�g�H�c");
			}

			byte[] memImg = null;
			Collection<Part> parts = req.getParts();
			for (Part part : parts) {
				if (part.getName().equals("memImg") && getFileNameFromPart(part) != null) {
					memImg = getPictureByteArrayNoChangeSize(part.getInputStream());
				}
//				if (getFileNameFromPart(part) != null && part.getName().equals("memImg")
//						&& !(part.getContentType().startsWith("image"))) {
//					errorMsgs.add("�|���Ӥ��榡���~");
//				}
			}

			/****************** ���d���|����U�� *****************/
			String petName = null;
			String petKind = null;
			Integer petGender = null;
			byte[] petImg = null;

			if (((String) req.getParameter("petOrNot")).equals("1")) {
				petName = req.getParameter("petName").trim();
				if (petName == null || petName.isEmpty()) {
					errorMsgs.add("�п�J�d���m�W");
				}

				petKind = req.getParameter("petKind").trim();
				if (petKind == null || petKind.isEmpty()) {
					errorMsgs.add("�п�J�d�����O");
				}

				petGender = Integer.parseInt(req.getParameter("petGender").trim());

				for (Part part : parts) {
					if (part.getName().equals("petImg") && getFileNameFromPart(part) != null
							&& part.getContentType() != null) {
						petImg = getPictureByteArray(part.getInputStream());
					}
					if (getFileNameFromPart(part) != null && part.getName().equals("petImg")
							&& !(part.getContentType().startsWith("image"))) {
						errorMsgs.add("�d���Ӥ��榡���~");
					}
				}
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/memberInfo.jsp");
				req.setAttribute("errorMsgs", errorMsgs);
				failureView.forward(req, res);
				return;// �{�����_
			}

			/*************************** 2.�}�l�ק��� *****************************************/

			// �P�_�O�_���i�d��
			if (((String) req.getParameter("petOrNot")).equals("0")) {
				memSvc.addMember(memId, memPwd, memName, memSname, memGender, memIdNo, memBday, memPhone, memAddress,
						memEmail, memImg, 0, 0, 2, "test", 0, 0, 0, 0.00, 0.00,
						new Timestamp((new java.util.Date()).getTime()), 0);
			} else {

				memSvc.addMemberWithPet(memId, memPwd, memName, memSname, memGender, memIdNo, memBday, memPhone,
						memAddress, memEmail, memImg, 0, 0, 2, "test", 0, 0, 0, 0.00, 0.00,
						new Timestamp((new java.util.Date()).getTime()), 0, petName, petKind, petGender, "test", "test",
						new Date(2010 - 05 - 02), petImg, 0);
			}

			/***************************
			 * 3.�ק粒��,�ǳ����(Send the Success view)
			 *************/
			Member memberR = memSvc.getOneMemberById(memId);
			session.setAttribute("member", memberR);
			res.sendRedirect(req.getContextPath() + "/front_end/index.jsp");

		}

		if ("login".equals(action)) {

			// �P�_�O�_���ŭ�
			String memId = req.getParameter("memId");
			String memPwd = req.getParameter("memPwd");

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			if (allowUser(memId, memPwd) == null) {
				Member errMember = new Member();
				errMember.setMemId(memId);
				errMember.setMemPwd(memPwd);

				errorMsgs.add("�b���K�X���~");
				req.setAttribute("member", errMember);
				RequestDispatcher sendBackView = req.getRequestDispatcher("/front_end/member/login.jsp");
				sendBackView.forward(req, res);
			} else {
				Member memberl = memSvc.getOneMemberById(memId);
				session.setAttribute("member", memberl);
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location");
					res.sendRedirect(location);
					return;
				}
				res.sendRedirect(req.getContextPath() + "/front_end/index.jsp");
			}

		}

		// �|���n�X
		if ("logout".equals(action)) {
			session.removeAttribute("member");
			res.sendRedirect(req.getContextPath() + "/front_end/index.jsp");

		}

		// �|���d��
		if ("search".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			/*****************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/
			String search = req.getParameter("search");
			if (search == null || search.trim().isEmpty()) {
				errorMsgs.add("�ж�g�j�M���e");
			}

			String type = req.getParameter("type");

			String loc = req.getParameter("loc");

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher(loc);
				req.setAttribute("errorMsgs", errorMsgs);
				failureView.forward(req, res);
				return;// �{�����_
			}

			/***************************
			 * 2.�ק粒��,�ǳ����(Send the Success view)
			 *************/
			RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/searchResult.jsp");

			req.setAttribute("type", type);

			req.setAttribute("search", search);

			failureView.forward(req, res);

		}

		// �|����T�y��
		if ("viewOtherMem".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			/*****************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/
			Integer memNo=null;
			try {
				memNo = Integer.parseInt(req.getParameter("memNo"));
			} catch (Exception e) {
				errorMsgs.add("�t�ΰ��D�A�ȮɵL�k�w��");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/searchResult");
				req.setAttribute("errorMsgs", errorMsgs);
				failureView.forward(req, res);
				return;// �{�����_
			}

			/***************************
			 * 2.�ק粒��,�ǳ����(Send the Success view)
			 *************/
			RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/viewMemInfo.jsp");

			req.setAttribute("memNo", memNo);

			failureView.forward(req, res);

		}
		
		
		// �ѰO�K�X
		if ("forgetPwd".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			/*****************************
			 * 1.�����ШD�Ѽ� - ��J�榡�����~�B�z
			 **********************/
			String memEmail = req.getParameter("memEmail");
			if (memEmail == null || memEmail.trim().isEmpty()) {
				errorMsgs.add("�ж�gEmail");
			}

			Member memberf=memSvc.getMemberByEmail(memEmail);
			if(memberf==null){
				errorMsgs.add("�d�L��Email");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/forgetPwd.jsp");
				req.setAttribute("errorMsgs", errorMsgs);
				failureView.forward(req, res);
				return;// �{�����_
			}
			
			
			
			/*************************** 2.�}�l�ק��� *****************************************/
			
			String memPwd=memberf.getMemPwd();;




		      
		    String subject = "Pet You&Me �ѰO�K�X�q��";
		      
		    java.util.Date current=new java.util.Date();
		    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String c=sdf.format(current);
		    String messageText = "��! " + memberf.getMemName()+"�z�b"+c+"���o�e�ѰO�b���K�X�ШD�C "+ "\n" 
		    +"�z���b���� : "+memberf.getMemId() + "�A �z���K�X�� : " + memPwd + "\n"
		    +"�p���ШD�ëD�ѱz�o�X�A�ЦܫȪA�ϬM"; 
		       
		    MailService mailService = new MailService();
		    mailService.sendMail(memEmail, subject, messageText);
			
			
			

			/***************************
			 * 2.�ק粒��,�ǳ����(Send the Success view)
			 *************/
			RequestDispatcher failureView = req.getRequestDispatcher("/front_end/member/forgetPwd.jsp");

			req.setAttribute("success", "Email�w�H�X�A�ЦܫH�c�T�{");

			failureView.forward(req, res);

		}
		

	}

	public static byte[] getPictureByteArray(InputStream fis) throws IOException {

		BufferedImage originalImage = ImageIO.read(fis);
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizeImageJpg, "jpg", baos);
		baos.flush();
		baos.close();
		return baos.toByteArray();
	}
	
	
	public static byte[] getPictureByteArrayNoChangeSize(InputStream fis) throws IOException {
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

	protected Member allowUser(String memId, String memPwd) {
		MemberService memSvc = new MemberService();
		Member member = memSvc.getOneMemberById(memId);

		if (member == null) {
			return null;
		} else if (!member.getMemPwd().equals(memPwd)) {
			return null;
		} else {
			return member;
		}
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(400, 300, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 400, 300, null);
		g.dispose();

		return resizedImage;
	}
}
