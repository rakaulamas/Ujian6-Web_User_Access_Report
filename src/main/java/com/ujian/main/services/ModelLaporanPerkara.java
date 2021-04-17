package com.ujian.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.entity.LaporanPerkara;
import com.ujian.main.repository.LaporanPerkaraRepo;

@Service
public class ModelLaporanPerkara implements ModelLaporanPerkaraInterface {
		
		
		@Autowired
		LaporanPerkaraRepo laporanPerkaraRepo;

		@Override
		public List<LaporanPerkara> getAllLaporanPerkara() {
		return (List<LaporanPerkara>)  this.laporanPerkaraRepo.findAll();
		}

		@Override
		public LaporanPerkara addLaporanPerkara(LaporanPerkara laporanPerkara) {
		return this.laporanPerkaraRepo.save(laporanPerkara);
		}

		
}
