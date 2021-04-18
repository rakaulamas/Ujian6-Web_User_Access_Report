package com.ujian.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ujian.main.entity.LaporanPerkara;

public interface LaporanPerkaraRepo extends JpaRepository<LaporanPerkara, Long> {
		public LaporanPerkara findByIdPelapor(Long id);

		@Query(value = "SELECT id_user FROM laporanperkara WHERE status = 'Approve'",nativeQuery = true)
		public LaporanPerkara findApprove();
		
		@Query(value = "SELECT id_user FROM laporanperkara WHERE status IS NULL",nativeQuery = true)
		public LaporanPerkara findProccess();
}
