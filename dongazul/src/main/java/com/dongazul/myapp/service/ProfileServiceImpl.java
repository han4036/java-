package com.dongazul.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongazul.myapp.domain.ProfileVO;
import com.dongazul.myapp.persistence.ProfileDAO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Service
public class ProfileServiceImpl implements ProfileService{

	@Setter(onMethod_=@Autowired)
	private ProfileDAO dao;
	
	@Override
	public void pfCreate(ProfileVO profile) throws Exception {
		log.debug("pfCreate(profile) invoked.");
		
		dao.pfCreate(profile);
		
	} // pfCreate
	
//	@Override
//	public Integer pfCheck(ProfileVO vo) throws Exception {
//		log.debug("pfCheck(vo) invoked.");
//		
//		Integer result = dao.pfCheck(vo);
//		
//		return result;
//	}
	
	
	@Override
	public ProfileVO pfSelect(ProfileVO vo) throws Exception {
		log.debug("pfSelect(vo) invoked.");
		
		ProfileVO profile = dao.pfSelect(vo);
		
		return profile;
	}
	
	
	@Override
	public List<ProfileVO> mSelect(ProfileVO m) throws Exception {
		log.debug("mSelect(m) invoked.");
		
		List<ProfileVO> man = dao.mSelect(m);
		
		return man;
		
	}
	
	
	@Override
	public List<ProfileVO> wSelect(ProfileVO w) throws Exception {
		log.debug("wSelect(w) invoked.");
		
		List<ProfileVO> woman = dao.wSelect(w);
		
		return woman;
		
	}
	
	
	
	
} // end class
