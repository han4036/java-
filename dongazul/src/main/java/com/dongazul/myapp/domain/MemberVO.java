package com.dongazul.myapp.domain;

import lombok.Value;

@Value
public class MemberVO {
	private String email;
	private String passwd;
	private Integer phonenumber;
} // end class
