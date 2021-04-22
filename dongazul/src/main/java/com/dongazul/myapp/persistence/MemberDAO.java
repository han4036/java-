package com.dongazul.myapp.persistence;

import com.dongazul.myapp.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void signUp(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO signIn(MemberVO vo) throws Exception;
	
	//이메일 중복 체크
	public int emailCheck(MemberVO vo) throws Exception;
	
	// 회원 정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	
	// 회원탈퇴
	public void memberDelete(MemberVO vo) throws Exception;
	
	// 이메일 찾기
	public String findId(Integer phonenumber) throws Exception;
	
	// 비밀번호 찾기
	public String findPw(String email) throws Exception;
} // end interface
