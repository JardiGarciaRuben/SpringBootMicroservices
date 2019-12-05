package com.royben.photoapp.api.passwordreset.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forgotten")
public class PasswordResetController {

	@GetMapping("/password")
	public String resetPassword() {
		return "bla bla password";
	}
}
