<?php 

	require_once('koneksi.php');
	$data_kec=array();

	$kec = "SELECT * FROM KECAMATAN";
	$r1 = mysqli_query($con,$kec);
	
	$a_kecamatan = array();
	
	while($row1 = mysqli_fetch_array($r1)){
		array_push($a_kecamatan,array(
			"id"=>$row1['ID_KECAMATAN'],
			"ket"=>$row1['KET_KECAMATAN'],
			"batas_wilayah"=>$row1['BATAS_WILAYAH_KECAMATAN'],
			"koordinat"=>$row1['KOORDINAT_KECAMATAN'],
			"luas_wilayah"=>$row1['LUAS_WILAYAH_KECAMATAN'],
			"jum_desa"=>$row1['JUMLAH_DESA'],
		));
	}
	$i=0;
	foreach ($a_kecamatan as $row1){
		// echo $row1['id']."<br>";
		$id=$row1['id'];
		$sql = "SELECT * FROM `DATA_KEPENDUDUKAN_KECAMATAN` 
		JOIN DATA_KEPENDUDUKAN ON DATA_KEPENDUDUKAN_KECAMATAN.ID_KEPENDUDUKAN=DATA_KEPENDUDUKAN.ID_KEPENDUDUKAN 
		JOIN DATA_AGAMA on DATA_KEPENDUDUKAN.ID_AGAMA=DATA_AGAMA.ID_AGAMA 
		JOIN DATA_GOLONGAN_DARAH on DATA_KEPENDUDUKAN.ID_GOLDAR=DATA_GOLONGAN_DARAH.ID_GOLDAR 
		JOIN DATA_JENIS_KELAMIN on DATA_KEPENDUDUKAN.ID_JK=DATA_JENIS_KELAMIN.ID_JK 
		JOIN DATA_PEKERJAAN on DATA_KEPENDUDUKAN.ID_PEKERJAAN=DATA_PEKERJAAN.ID_PEKERJAAN 
		JOIN DATA_RIWAYAT_SEKOLAH on DATA_KEPENDUDUKAN.ID_RIWAYAT_SEKOLAH=DATA_RIWAYAT_SEKOLAH.ID_RIWAYAT_SEKOLAH 
		JOIN DATA_STATUS_PERNIKAHAN ON DATA_KEPENDUDUKAN.ID_STATUS_PERNIKAHAN=DATA_STATUS_PERNIKAHAN.ID_STATUS_PERNIKAHAN 
		JOIN DATA_USIA on DATA_KEPENDUDUKAN.ID_USIA=DATA_USIA.ID_USIA 
		JOIN DATA_USIA_PENDIDIKAN on DATA_KEPENDUDUKAN.ID_USIA_PENDIDIKAN=DATA_USIA_PENDIDIKAN.ID_USIA_PENDIDIKAN
		JOIN KECAMATAN on DATA_KEPENDUDUKAN_KECAMATAN.ID_KECAMATAN=KECAMATAN.ID_KECAMATAN
		JOIN TAHUN on DATA_KEPENDUDUKAN.ID_TAHUN=TAHUN.ID_TAHUN
		WHERE DATA_KEPENDUDUKAN_KECAMATAN.ID_DATA_KECAMATAN LIKE '%$id' ORDER BY TAHUN.KET_TAHUN DESC";
		$r = mysqli_query($con,$sql);
		$data=false;
		$row = mysqli_fetch_array($r);
		if (mysqli_num_rows($r)>0) {
			$detail=$row['ISLAM'].",".$row['KRISTEN'].",".$row['KATHOLIK'].",".$row['HINDU'].",".$row['BUDHA'].",".$row['KONGHUCU'].",".$row['KEPERCAYAAN'].",".$row['A'].",".$row['B'].",".$row['AB'].",".$row['O'].",".$row['A_PLUS'].",".$row['A_MIN'].",".$row['B_PLUS'].",".$row['B_MIN'].",".$row['AB_PLUS'].",".$row['AB_MIN'].",".$row['O_PLUS'].",".$row['O_MIN'].",".$row['TIDAK_DIKETAHUI'].",".$row['PRIA'].",".$row['WANITA'].",".$row['BELUM_BEKERJA'].",".$row['APARATUR_PEJABAT_NEGARA'].",".$row['WIRASWASTA'].",".$row['PERTANIAN_DAN_PETERNAKAN'].",".$row['NELAYAN'].",".$row['AGAMA_DAN_KEPERCAYAAN'].",".$row['PELAJAR_DAN_MAHASISWA'].",".$row['TENAGA_KESEHATAN'].",".$row['PENSIUNAN'].",".$row['PEKERJAAN_LAINNYA'].",".$row['BELUM_SEKOLAH'].",".$row['BELUM_TAMAT_SD'].",".$row['TAMAT_SD'].",".$row['SLTP'].",".$row['SLTA'].",".$row['D1_DAN_D2'].",".$row['D3'].",".$row['S1'].",".$row['S2'].",".$row['S3'].",".$row['BELUM_KAWIN'].",".$row['KAWIN'].",".$row['CERAI_MATI'].",".$row['CERAI_HIDUP'].",".$row['USIA_0_4'].",".$row['USIA_5_9'].",".$row['USIA_10_14'].",".$row['USIA_15_19'].",".$row['USIA_20_24'].",".$row['USIA_25_29'].",".$row['USIA_30_34'].",".$row['USIA_35_39'].",".$row['USIA_40_44'].",".$row['USIA_45_49'].",".$row['USIA_50_54'].",".$row['USIA_55_59'].",".$row['USIA_60_64'].",".$row['USIA_65_69'].",".$row['USIA_70_74'].",".$row['USIA_75'].",".$row['UP_3_4'].",".$row['UP_5'].",".$row['UP_6_11'].",".$row['UP_12_14'].",".$row['UP_15_17'].",".$row['UP_18_22'].",".$row['JUMLAH_PENDUDUK'].",".$row['JUMLAH_KK'].",".$row['KEPADATAN_PENDUDUK'].",".$row['PERPINDAHAN_PENDUDUK'].",".$row['JUMLAH_MENINGGAL'].",".$row['WAJIB_KTP'].",".$row['KELAHIRAN'].",".$row['KET_TAHUN'];
			array_push($data_kec,array(
			"data"=>"true",
			"id"=>$row['ID_KECAMATAN'],
			"ket"=>$row['KET_KECAMATAN'].",".$row['LUAS_WILAYAH_KECAMATAN'].",".$row['JUMLAH_DESA'],
			"batas_wilayah"=>$row['BATAS_WILAYAH_KECAMATAN'],
			"koordinat"=>$row['KOORDINAT_KECAMATAN'],
			"data_detail"=>$detail,
			));
			$data=true;
		}
		if (!$data) {
			$array_data=$a_kecamatan[$i];
			array_push($data_kec,array(
			"data"=>"false",
			"id"=>$array_data['id'],
			"ket"=>$array_data['ket'].",".$array_data['luas_wilayah'].",".$array_data['jum_desa'],
			"batas_wilayah"=>$array_data['batas_wilayah'],
			"koordinat"=>$array_data['koordinat'],
			"data_detail"=>"",
			));
		}
		$i++;
	}
	echo json_encode(array('result'=>$data_kec));
	
	mysqli_close($con);
?>