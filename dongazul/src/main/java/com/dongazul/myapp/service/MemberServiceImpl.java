package com.dongazul.myapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.persistence.MemberDAO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@NoArgsConstructor

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;
	
	
	// 회원가입
	@Override
	public void signUp(MemberVO vo) throws Exception {
		
		log.info("signUp(vo) invoked.");
		
		dao.signUp(vo);
	} // signUp
	
	// 로그인
	@Override
	public MemberVO signIn(MemberVO vo) throws Exception {
		
		log.info("signIn(vo) invoked.");
		
		return dao.signIn(vo);	
	} // signIn
	
	// 이메일 중복 체크
	@Override
	public int emailCheck(MemberVO vo) throws Exception {
		log.info("emailCheck(vo) invoked.");
		int result = dao.emailCheck(vo);
		return result;
	}
	// 회원정보수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception{
		dao.memberUpdate(vo);
	}
	
	// 회원탈퇴
	public void memberDelete(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
	}
	
	// 이메일 찾기
	@Override
	public String findId(Integer phonenumber) throws Exception {
		log.debug("findId(vo) invoked.");
		
		String find = dao.findId(phonenumber);
		
		return find;
		
	} // findId
	
	
	// 비밀번호 찾기
	@Override
	public String findPw(String email) throws Exception {
		log.debug("findPw(vo) invoked.");
		
		String pw = dao.findPw(email);
		
		return pw;
		
	} // findPw
} // end class
