package com.dongazul.myapp.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongazul.myapp.domain.MemberVO;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MemberMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;

	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.mapper != null;
		log.info("\t+ mapper : " + mapper);
		
	} // setup
	
	
	@Test
	public void testInsert() throws Exception {
		log.debug("testInsert() invoked.");
		
		MemberVO member = new MemberVO(
				"3333a@naver.com",
				"qwe123",
				01011123334);
		
		this.mapper.insert(member);
		
	} // testInsert
	
	@Test
	public void testSignIn() throws Exception {
		log.debug("testSignIn() invoked.");
		
		MemberVO member = new MemberVO(
				"bompig@pig.bom",
				"8520",
				1088889999);
		
		this.mapper.select(member);
		
	} // testSignIn
	
	@Test
	public void testMemberUpdate() throws Exception {
		log.debug("testMemberUpdate() invoked.");
		
		MemberVO member = new MemberVO(
				"bompig@pig.bom",
				"1234",
				1088888888);
		
		this.mapper.memberUpdate(member);
		
	} // testMemberUpdate
	
	
	@Test
	public void testMemberDelete() throws Exception {
		log.debug("testMemberDelete() invoked.");
		
		MemberVO member = new MemberVO(
				"bompig@pig.bom",
				"8520",
				1088889999);
		
		this.mapper.memberDelete(member);
		
	} // testMemberDelete()
	
	
	@Test
	public void testFindId() throws Exception {
		log.debug("testFindId() invoked.");
		
		MemberVO member = new MemberVO(
				"bompig@pig.bom",
				"8520",
				1088889999);
		
		Integer number = member.getPhonenumber();
		
		this.mapper.findId(number);
		
	} // testFindId
	
	
	@Test
	public void testFindPw() throws Exception {
		log.debug("testFindPw() invoked.");
		
		MemberVO member = new MemberVO(
				"bompig@pig.bom",
				"8520",
				1088889999);
		
		String email = member.getEmail();
		
		this.mapper.findPw(email);
		
	} // testFindPw
	
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
		
	} // tearDown
	
} // end class
