package com.ad.model;

import java.sql.Timestamp;
import java.util.List;

public class AdService {
	
	private AdDAO_Interface dao;
	
	public AdService(){
		dao = new AdDAO();
	}
	
	public Ad insert(int adNo, String adContent, byte[] adImg, Timestamp adOnline, Timestamp adOffline, double adFee){
		Ad ad = new Ad();
		
		ad.setAdNo(adNo);
		ad.setAdContent(adContent);
		ad.setAdImg(adImg);
		ad.setAdOnline(adOnline);
		ad.setAdOffline(adOffline);
		ad.setAdFee(adFee);
		dao.insert(ad);
		
		return ad;
		
	}
	
	public Ad update(int adNo, String adContent, byte[] adImg, Timestamp adOnline, Timestamp adOffline, double adFee){
		Ad ad = new Ad();
		
		ad.setAdNo(adNo);
		ad.setAdContent(adContent);
		ad.setAdImg(adImg);
		ad.setAdOnline(adOnline);
		ad.setAdOffline(adOffline);
		ad.setAdFee(adFee);
		dao.update(ad);
		
		return ad;
		
	}
	
	public void delete(Integer adNo){
		dao.delete(adNo);
	}
	
	public Ad findByPrimaryKey(Integer adNo){
		return dao.findByPrimaryKey(adNo);
	}
	
	public List<Ad> getAll(){
		return dao.getAll();
	}

}
