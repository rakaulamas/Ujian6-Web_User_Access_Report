package com.ujian.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ujian.main.entity.LaporanPerkara;
import com.ujian.main.repository.LaporanPerkaraRepo;
import com.ujian.main.services.ModelLaporanPerkaraInterface;

@SpringBootApplication
public class Ujian6WuarApplication implements CommandLineRunner {

		@Autowired
		LaporanPerkaraRepo lpRepo;
	public static void main(String[] args) {
		SpringApplication.run(Ujian6WuarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	
	 	LaporanPerkara laporanperkara1 = new LaporanPerkara();
		laporanperkara1.setNamaPelapor("Raka");
		laporanperkara1.setKejadian("Pencurian Sepeda");
		laporanperkara1.setAlamat("Jaktim");
		laporanperkara1.setKeterangan("Hilang siang hari tadi");
		this.lpRepo.save(laporanperkara1);
		
	*/	
	}
	 
}
