<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('koneksi.php');
		$id = $_POST['id'];
		$data_desa=array();

		$desa = "SELECT * FROM DESA JOIN KECAMATAN ON DESA.ID_KECAMATAN=KECAMATAN.ID_KECAMATAN WHERE DESA.ID_DESA='$id'";
		$r1 = mysqli_query($con,$desa);
		
		$a_desa = array();
		
		while($row1 = mysqli_fetch_array($r1)){
			array_push($a_desa,array(
				"id"=>$row1['ID_DESA'],
				"ket"=>$row1['KET_DESA'],
				"luas_wilayah"=>$row1['LUAS_WILAYAH_DESA'],
				"kecamatan"=>$row1['KET_KECAMATAN'],
			));
		}
		$i=0;
		foreach ($a_desa as $row1){
			// echo $row1['id']."<br>";
			$id=$row1['id'];
			$sql = "SELECT * FROM `DATA_KEPENDUDUKAN_DESA` 
			JOIN DATA_KEPENDUDUKAN ON DATA_KEPENDUDUKAN_DESA.ID_KEPENDUDUKAN=DATA_KEPENDUDUKAN.ID_KEPENDUDUKAN 
			JOIN DATA_AGAMA on DATA_KEPENDUDUKAN.ID_AGAMA=DATA_AGAMA.ID_AGAMA 
			JOIN DATA_GOLONGAN_DARAH on DATA_KEPENDUDUKAN.ID_GOLDAR=DATA_GOLONGAN_DARAH.ID_GOLDAR 
			JOIN DATA_JENIS_KELAMIN on DATA_KEPENDUDUKAN.ID_JK=DATA_JENIS_KELAMIN.ID_JK 
			JOIN DATA_PEKERJAAN on DATA_KEPENDUDUKAN.ID_PEKERJAAN=DATA_PEKERJAAN.ID_PEKERJAAN 
			JOIN DATA_RIWAYAT_SEKOLAH on DATA_KEPENDUDUKAN.ID_RIWAYAT_SEKOLAH=DATA_RIWAYAT_SEKOLAH.ID_RIWAYAT_SEKOLAH 
			JOIN DATA_STATUS_PERNIKAHAN ON DATA_KEPENDUDUKAN.ID_STATUS_PERNIKAHAN=DATA_STATUS_PERNIKAHAN.ID_STATUS_PERNIKAHAN 
			JOIN DATA_USIA on DATA_KEPENDUDUKAN.ID_USIA=DATA_USIA.ID_USIA 
			JOIN DATA_USIA_PENDIDIKAN on DATA_KEPENDUDUKAN.ID_USIA_PENDIDIKAN=DATA_USIA_PENDIDIKAN.ID_USIA_PENDIDIKAN
			JOIN DESA on DATA_KEPENDUDUKAN_DESA.ID_DESA=DESA.ID_DESA
			JOIN KECAMATAN on KECAMATAN.ID_KECAMATAN=DESA.ID_KECAMATAN
			JOIN TAHUN on DATA_KEPENDUDUKAN.ID_TAHUN=TAHUN.ID_TAHUN
			WHERE DATA_KEPENDUDUKAN_DESA.ID_DATA_DESA LIKE '%$id' ORDER BY TAHUN.KET_TAHUN DESC";
			$r = mysqli_query($con,$sql);
			$data=false;
			while ($row = mysqli_fetch_array($r)) {
				$detail=$row['ISLAM'].",".$row['KRISTEN'].",".$row['KATHOLIK'].",".$row['HINDU'].",".$row['BUDHA'].",".$row['KONGHUCU'].",".$row['KEPERCAYAAN'].",".$row['A'].",".$row['B'].",".$row['AB'].",".$row['O'].",".$row['A_PLUS'].",".$row['A_MIN'].",".$row['B_PLUS'].",".$row['B_MIN'].",".$row['AB_PLUS'].",".$row['AB_MIN'].",".$row['O_PLUS'].",".$row['O_MIN'].",".$row['TIDAK_DIKETAHUI'].",".$row['PRIA'].",".$row['WANITA'].",".$row['BELUM_BEKERJA'].",".$row['APARATUR_PEJABAT_NEGARA'].",".$row['WIRASWASTA'].",".$row['PERTANIAN_DAN_PETERNAKAN'].",".$row['NELAYAN'].",".$row['AGAMA_DAN_KEPERCAYAAN'].",".$row['PELAJAR_DAN_MAHASISWA'].",".$row['TENAGA_KESEHATAN'].",".$row['PENSIUNAN'].",".$row['PEKERJAAN_LAINNYA'].",".$row['BELUM_SEKOLAH'].",".$row['BELUM_TAMAT_SD'].",".$row['TAMAT_SD'].",".$row['SLTP'].",".$row['SLTA'].",".$row['D1_DAN_D2'].",".$row['D3'].",".$row['S1'].",".$row['S2'].",".$row['S3'].",".$row['BELUM_KAWIN'].",".$row['KAWIN'].",".$row['CERAI_MATI'].",".$row['CERAI_HIDUP'].",".$row['USIA_0_4'].",".$row['USIA_5_9'].",".$row['USIA_10_14'].",".$row['USIA_15_19'].",".$row['USIA_20_24'].",".$row['USIA_25_29'].",".$row['USIA_30_34'].",".$row['USIA_35_39'].",".$row['USIA_40_44'].",".$row['USIA_45_49'].",".$row['USIA_50_54'].",".$row['USIA_55_59'].",".$row['USIA_60_64'].",".$row['USIA_65_69'].",".$row['USIA_70_74'].",".$row['USIA_75'].",".$row['UP_3_4'].",".$row['UP_5'].",".$row['UP_6_11'].",".$row['UP_12_14'].",".$row['UP_15_17'].",".$row['UP_18_22'].",".$row['JUMLAH_PENDUDUK'].",".$row['JUMLAH_KK'].",".$row['KEPADATAN_PENDUDUK'].",".$row['PERPINDAHAN_PENDUDUK'].",".$row['JUMLAH_MENINGGAL'].",".$row['WAJIB_KTP'].",".$row['KELAHIRAN'];
				array_push($data_desa,array(
				"data"=>"true",
				"id"=>$row['ID_DESA'],
				"id_data"=>$row['ID_DATA_DESA'],
				"tahun"=>$row['KET_TAHUN'],
				"ket"=>$row['KET_KECAMATAN'].",".$row['KET_DESA'].",".$row['LUAS_WILAYAH_DESA'],
				"data_detail"=>$detail,
				));
				$data=true;
			}
			if (!$data) {
				$array_data=$a_desa[0];
				array_push($data_desa,array(
				"data"=>"false",
				"id"=>$array_data['id'],
				"ket"=>$array_data['ket'].",".$array_data['luas_wilayah'].",".$array_data['kecamatan'],
				"data_detail"=>"",
				));
			}
			$i++;
		}
		echo json_encode(array('result'=>$data_desa));
		
		mysqli_close($con);
	}
?>