package com.ujian.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.LaporanPerkara;

public interface LaporanPerkaraRepo extends JpaRepository<LaporanPerkara, Long> {
		public LaporanPerkara findByIdPelapor(Long id);
}
