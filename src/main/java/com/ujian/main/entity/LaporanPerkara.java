package com.ujian.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="laporanperkara")
public class LaporanPerkara {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPelapor;
	private String namaPelapor;
	private String kejadian;
	private String alamat;
	@Column(nullable = true)
	private String gambar;
	private String status;
	private String keterangan;
}
