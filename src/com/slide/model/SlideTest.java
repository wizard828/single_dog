package com.slide.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class SlideTest {

	public static void main(String[] args) throws IOException {
		SlideJDBCDAO dao = new SlideJDBCDAO();

		// �s�W
		// Slide slide1 = new Slide();
		// byte[] slideImg =
		// getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
		// slide1.setSlideImg(slideImg);
		// slide1.setSlideCategory("�o�O�@�����O");
		// slide1.setSlideTitle("�o�O�@�ө��Y");
		// dao.insert(slide1);
		// System.out.println("�s�W���S");

		// �ק�
		// Slide slide2 = new Slide();
		// byte[] slideImg =
		// getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
		// slide2.setSlideImg(slideImg);
		// slide2.setSlideCategory("��v�������O");
		// slide2.setSlideTitle("��v�������Y");
		// slide2.setSlideNo(1);
		// dao.update(slide2);
		// System.out.println("�׸ӧ��S");

		// �R��
		// dao.delete(3);
		// System.out.println("�R���S,�V�|");

		// �d��
		// Slide slide3 = dao.findByPrimaryKey(4);
		// System.out.println(slide3.getSlideNo());
		// System.out.println(slide3.getSlideImg());
		// System.out.println(slide3.getSlideCategory());
		// System.out.println(slide3.getSlideTitle());
		// System.out.println("�䧹�S");

		// �d������
		List<Slide> slideList = dao.getAll();
		for (Slide slide : slideList) {
			System.out.println(slide.getSlideNo());
			System.out.println(slide.getSlideImg());
			System.out.println(slide.getSlideCategory());
			System.out.println(slide.getSlideTitle());
			System.out.println("===================");
		}

	}

	// �ϥ�byte[]��k
	public static byte[] getPictureByteArray(String path) throws IOException {
		File file = new File(path);
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