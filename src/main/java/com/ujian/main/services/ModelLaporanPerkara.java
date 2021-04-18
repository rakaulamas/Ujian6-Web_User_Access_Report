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

		@Override
		public LaporanPerkara getLaporanByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LaporanPerkara getLaporanPerkaraById(String id) {
			// TODO Auto-generated method stub
			return laporanPerkaraRepo.findByIdPelapor(Long.parseLong(id));
		}

		
		
		@Override
		public LaporanPerkara cariApprove() {
			// TODO Auto-generated method stub
			return this.laporanPerkaraRepo.findApprove();
		}

		@Override
		public LaporanPerkara cariProses() {
			// TODO Auto-generated method stub
			return this.laporanPerkaraRepo.findProccess();
		}

		public void save(LaporanPerkara updateStatus) {
			// TODO Auto-generated method stub
			this.laporanPerkaraRepo.save(updateStatus);
		}
	 
		
}
