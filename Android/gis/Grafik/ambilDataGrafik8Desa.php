<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('koneksi.php');
		$id = $_POST['id'];
		$desa = "SELECT * FROM DESA JOIN KECAMATAN ON DESA.ID_KECAMATAN=KECAMATAN.ID_KECAMATAN WHERE DESA.ID_DESA='$id'";
		$r1 = mysqli_query($con,$desa);
		$data_desa=array();
		
		$a_desa = array();
		
		$row1 = mysqli_fetch_array($r1);
		array_push($a_desa,array(
			"ket"=>$row1['KET_DESA'],
		));
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
			$detail=$row['USIA_0_4'].",".$row['USIA_5_9'].",".$row['USIA_10_14'].",".$row['USIA_15_19'].",".$row['USIA_20_24'].",".$row['USIA_25_29'].",".$row['USIA_30_34'].",".$row['USIA_35_39'].",".$row['USIA_40_44'].",".$row['USIA_45_49'].",".$row['USIA_50_54'].",".$row['USIA_55_59'].",".$row['USIA_60_64'].",".$row['USIA_65_69'].",".$row['USIA_70_74'].",".$row['USIA_75'];
			array_push($data_desa,array(
			"data"=>"true",
			"tahun"=>$row['KET_TAHUN'],
			"ket"=>$row['KET_DESA'],
			"data_detail"=>$detail,
			));
			$data=true;
		}	
		if (!$data) {
			$array_data=$a_desa[0];
			array_push($data_desa,array(
			"data"=>"false",
			"ket"=>$array_data['ket'],
			"data_detail"=>"",
			));
		}
		echo json_encode(array('result'=>$data_desa));
		
		mysqli_close($con);
	}
?>
