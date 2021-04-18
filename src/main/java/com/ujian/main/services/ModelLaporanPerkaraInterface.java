package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.LaporanPerkara;

public interface ModelLaporanPerkaraInterface {
	public List<LaporanPerkara> getAllLaporanPerkara();
	public LaporanPerkara addLaporanPerkara (LaporanPerkara laporanPerkara);
	public LaporanPerkara getLaporanByName(String name);
	
	
	public LaporanPerkara getLaporanPerkaraById(String id);
	
	
	public LaporanPerkara cariApprove();
	public LaporanPerkara cariProses();
}
