package com.jangyuyuseo.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserDTO {
	private int user_idx;
	
	@NotBlank
	@Size(min=2, max=6)
	@Pattern(regexp = "[가-힣]*")
	private String user_name;
	
	@NotBlank
	@Size(min=2, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;
	
	@NotBlank
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_password;
	
	@NotBlank
	private String user_address;
	
	@NotBlank
	private String user_phone;
	
}
