package com.dongazul.myapp.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileVO;
import com.dongazul.myapp.mapper.ProfileMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@NoArgsConstructor

@Repository
public class ProfileDAOImpl implements ProfileDAO{

	@Setter(onMethod_=@Autowired)
	private ProfileMapper mapper;
	
	
	@Override
	public void pfCreate(ProfileVO profile) throws Exception {
		log.debug("pfCreate(profile) invoked.");
		
		assert this.mapper != null;
		
		this.mapper.insert(profile);
		
	} // pfCreate
	
//	@Override
//	public Integer pfCheck(ProfileVO vo) throws Exception {
//		log.debug("pfCheck(vo) invoked.");
//		
//		assert this.mapper != null;
//		
//		Integer result = this.mapper.profileCheck(vo);
//		
//		return result;
//	}
	
	@Override
	public ProfileVO pfSelect(ProfileVO vo) throws Exception {
		log.debug("pfSelect(vo) invoked.");
		
		assert this.mapper != null;
		
		ProfileVO profile = this.mapper.profileSelect(vo);
		
		return profile;
	}
	
	@Override
	public List<ProfileVO> mSelect(ProfileVO m) throws Exception {
		log.debug("mSelect(m) invoked.");
		
		List<ProfileVO> man = this.mapper.mSelect(m);
		
		return man;
		
	}
	
	@Override
	public List<ProfileVO> wSelect(ProfileVO w) throws Exception {
		log.debug("wSelect(w) invoked.");
		
		List<ProfileVO> woman = this.mapper.wSelect(w);
		
		return woman;
	}
	
	
	
} // end class
