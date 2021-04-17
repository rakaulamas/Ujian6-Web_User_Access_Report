package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.AdminUser;

public interface AdminUserRepo extends JpaRepository<AdminUser, Long> {
	public AdminUser findByUsername(String username);
}
