package com.ujian.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.ujian.main.entity.LaporanPerkara;
import com.ujian.main.services.ModelLaporanPerkara;

@Controller
public class LaporanPerkaraPage {
	
	@Autowired
	ModelLaporanPerkara modelLaporanPerkara;
	
	private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";	
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		

		return "login";
	}
	
	@GetMapping("/laporan/view")
	public String viewLaporanPerkara(Model model) {
		model.addAttribute("listLP",modelLaporanPerkara.getAllLaporanPerkara());
		return "view_laporanperkara";
	}
	
	@GetMapping("/laporan/add")
	public String viewTambahLaporan(Model model) {
		
		// untuk menampung data mahasiswa di halaman html nya.
		model.addAttribute("laporanperkara", new LaporanPerkara());
		return "tambah_laporan";
	}
	
	@PostMapping("/laporan/view")
	public String addLaporanPerkara(@RequestParam(value = "file")MultipartFile file,@ModelAttribute LaporanPerkara laporanperkara, Model model) { 
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println(file.getOriginalFilename());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
	 
        laporanperkara.setGambar("/uploads/" + fileName);
        this.modelLaporanPerkara.addLaporanPerkara(laporanperkara);

		model.addAttribute("laporanperkara", new LaporanPerkara());
		return "redirect:/laporan/view";
	  }
	

	

	
}