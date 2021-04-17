package com.ujian.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.repository.AdminUserRepo;

@Service
public class ModelAdminUser {
	
		@Autowired
		AdminUserRepo adminUserRepo;
}
