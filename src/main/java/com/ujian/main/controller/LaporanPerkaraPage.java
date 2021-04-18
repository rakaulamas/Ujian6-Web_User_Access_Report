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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.ujian.main.entity.LaporanPerkara;
import com.ujian.main.services.ModelLaporanPerkara;
import com.ujian.main.utility.FileUtility;

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
	public String home(Model model) {
		model.addAttribute("totalLaporan", modelLaporanPerkara.getAllLaporanPerkara().size());
		model.addAttribute("listLP", modelLaporanPerkara.getAllLaporanPerkara());
//		model.addAttribute("ditanggapi", modelLaporanPerkara.cariApprove());
//		model.addAttribute("proses", modelLaporanPerkara.cariProses());
		model.addAttribute("active", 1);
		return "dashboard";
	}
	
	@GetMapping("/laporan/adminview")
	public String viewLaporanPerkara(Model model) {
		model.addAttribute("listLP",modelLaporanPerkara.getAllLaporanPerkara());
		model.addAttribute("fieldDisabled","Selesai");
		model.addAttribute("active", 3);
		return "view_laporanperkara";
	}
	
	@GetMapping("/laporan/add")
	public String viewTambahLaporan(Model model) {
		
		// untuk menampung data mahasiswa di halaman html nya.
		model.addAttribute("laporanperkara", new LaporanPerkara());
		model.addAttribute("active", 2);
		return "tambah_laporan";
	}
	
	@PostMapping("/laporan/view")
	public String addLaporanPerkara(@RequestParam(value = "file")MultipartFile file,@ModelAttribute LaporanPerkara laporanperkara, Model model)throws IOException {{ 
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
         
	        String uploadDir = "user-photos/" ;
	
	       FileUtility.saveFile(uploadDir, fileName, file);
	 
       laporanperkara.setGambar("/"+uploadDir + fileName);
        
       this.modelLaporanPerkara.addLaporanPerkara(laporanperkara);

		model.addAttribute("listLP",modelLaporanPerkara.getAllLaporanPerkara());
		
		return "redirect:/laporan/view";
	  }
	}

	@GetMapping("/laporan/approve/{id}")
    public String approveLaporan(@PathVariable String id, Model model) {

        LaporanPerkara updateStatus = modelLaporanPerkara.getLaporanPerkaraById(id);
        updateStatus.setStatus("Approve");
        modelLaporanPerkara.save(updateStatus);
        
        return "redirect:/korban/Adminview";
    }
	
	@GetMapping("/korban/reject/{id}")
    public String rejectLaporan(@PathVariable String id, Model model) {

       LaporanPerkara updateStatus = modelLaporanPerkara.getLaporanPerkaraById(id);
        updateStatus.setStatus("Reject");
        modelLaporanPerkara.save(updateStatus);

        return "redirect:/korban/Adminview";
    }

	
}