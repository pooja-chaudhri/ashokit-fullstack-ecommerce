package com.example.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPwdDTO {

	private String name;
	private String email;
	private String oldPwd;
	private String newPwd;
	private String confirmPwd;
}
