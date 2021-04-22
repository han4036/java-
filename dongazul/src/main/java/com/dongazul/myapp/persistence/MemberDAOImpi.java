package com.dongazul.myapp.persistence;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.mapper.MemberMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Repository
public class MemberDAOImpi implements MemberDAO {

	
	   @Setter(onMethod_=@Autowired)
	   private MemberMapper mapper;
	
	
	//회원가입
	@Override
	public void signUp(MemberVO vo) throws Exception {
		log.info("signUp(vo) invoked.");
		
		Objects.requireNonNull(mapper);
		
		log.info("\t+ mapper" + this.mapper);
		this.mapper.insert(vo);
		  
	} // register
	// 로그인
	@Override
	public MemberVO signIn(MemberVO vo) throws Exception {
		log.info("signIn(vo) invoked.");
		
		return this.mapper.select(vo);
	
	}
	// 이메일 중복 체크
	@Override
	public int emailCheck(MemberVO vo) throws Exception {
		
		log.info("emailCheck(vo) invoked.");	
	
		return this.mapper.emailCheck(vo);
	}
	// 회원 정보 수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		log.info("memberUpdate(vo) invoked.");
		
		this.mapper.memberUpdate(vo);
	
	}
	
	// 회원탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		log.info("memberUpdate(vo) invoked.");
		
		this.mapper.memberDelete(vo);
	}
	
	
	// 아이디 찾기
	@Override
	public String findId(Integer phonenumber) throws Exception {
		log.debug("findId(vo) invoked.");
		
		assert this.mapper != null;
		
		log.info("\t+ mapper : " + mapper);
		
		return this.mapper.findId(phonenumber);
		
	} // findId
	
	
	@Override
	public String findPw(String email) throws Exception {
		log.debug("findPw(email, phonenumber) invoked.");
		
		assert this.mapper != null;
		
		log.info("\t+ mapper : " + mapper);
		
		return this.mapper.findPw(email);
		
	} // findPw
	
	
} // end class
