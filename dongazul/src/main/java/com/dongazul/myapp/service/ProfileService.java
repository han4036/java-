package com.dongazul.myapp.service;

import java.util.List;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileVO;

public interface ProfileService {
	
	// 프로필 생성
	public void pfCreate(ProfileVO profile) throws Exception;
	
//	public Integer pfCheck(ProfileVO vo) throws Exception;
	
	public ProfileVO pfSelect(ProfileVO vo) throws Exception;
	
	public List<ProfileVO> mSelect(ProfileVO m) throws Exception;
	
	public List<ProfileVO> wSelect(ProfileVO w) throws Exception;
	

} // end interface
