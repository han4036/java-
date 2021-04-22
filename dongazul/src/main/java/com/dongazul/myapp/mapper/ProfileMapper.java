package com.dongazul.myapp.mapper;

import java.util.List;

import com.dongazul.myapp.domain.ProfileVO;

public interface ProfileMapper {
	// 프로필 생성
	public abstract void insert(ProfileVO vo) throws Exception;
	
//	public abstract Integer profileCheck(ProfileVO vo) throws Exception;
	
	public abstract ProfileVO profileSelect(ProfileVO vo) throws Exception;
	
	public abstract List<ProfileVO> mSelect(ProfileVO m) throws Exception;
	
	public abstract List<ProfileVO> wSelect(ProfileVO w) throws Exception;

} // end interface 
