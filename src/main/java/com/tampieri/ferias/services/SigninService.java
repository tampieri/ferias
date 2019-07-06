package com.tampieri.ferias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SigninService {

	@Autowired
	private BCryptPasswordEncoder pe;
}
