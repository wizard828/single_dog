package com.slide.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class SlideTest {

	public static void main(String[] args) throws IOException {
		SlideJDBCDAO dao = new SlideJDBCDAO();

		// ·s¼W
		// Slide slide1 = new Slide();
		// byte[] slideImg =
		// getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
		// slide1.setSlideImg(slideImg);
		// slide1.setSlideCategory("³o¬O¤@­ÓÃþ§O");
		// slide1.setSlideTitle("³o¬O¤@­Ó©ïÀY");
		// dao.insert(slide1);
		// System.out.println("·s¼W§¹·S");

		// ­×§ï
		// Slide slide2 = new Slide();
		// byte[] slideImg =
		// getPictureByteArray("C:\\Users\\Phate\\Downloads\\IMG_4099.jpg");
		// slide2.setSlideImg(slideImg);
		// slide2.setSlideCategory("§ë¼v¤ùªºÃþ§O");
		// slide2.setSlideTitle("§ë¼v¤ùªº©ïÀY");
		// slide2.setSlideNo(1);
		// dao.update(slide2);
		// System.out.println("­×¸Ó§¹·S");

		// §R°£
		// dao.delete(3);
		// System.out.println("§R±¼·S,ÁV¿|");

		// ¬d¸ß
		// Slide slide3 = dao.findByPrimaryKey(4);
		// System.out.println(slide3.getSlideNo());
		// System.out.println(slide3.getSlideImg());
		// System.out.println(slide3.getSlideCategory());
		// System.out.println(slide3.getSlideTitle());
		// System.out.println("§ä§¹·S");

		// ¬d¥þ³¡ƒ¨
		List<Slide> slideList = dao.getAll();
		for (Slide slide : slideList) {
			System.out.println(slide.getSlideNo());
			System.out.println(slide.getSlideImg());
			System.out.println(slide.getSlideCategory());
			System.out.println(slide.getSlideTitle());
			System.out.println("===================");
		}

	}

	// ¨Ï¥Îbyte[]¤èªk
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