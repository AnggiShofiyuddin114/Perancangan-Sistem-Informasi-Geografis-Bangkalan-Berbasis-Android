<?php 

	if($_SERVER['REQUEST_METHOD']=='POST'){
		require_once('koneksi.php');
		$id = $_POST['id'];
		$kec = "SELECT * FROM KECAMATAN WHERE ID_KECAMATAN='$id'";
		$r1 = mysqli_query($con,$kec);
		$data_kec=array();
		
		$a_kecamatan = array();
		
		$row1 = mysqli_fetch_array($r1);
		array_push($a_kecamatan,array(
			"ket"=>$row1['KET_KECAMATAN'],
		));
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
		while ($row = mysqli_fetch_array($r)) {
			$detail=$row['BELUM_KAWIN'].",".$row['KAWIN'].",".$row['CERAI_MATI'].",".$row['CERAI_HIDUP'];
			array_push($data_kec,array(
			"data"=>"true",
			"tahun"=>$row['KET_TAHUN'],
			"ket"=>$row['KET_KECAMATAN'],
			"data_detail"=>$detail,
			));
			$data=true;
		}	
		if (!$data) {
			$array_data=$a_kecamatan[0];
			array_push($data_kec,array(
			"data"=>"false",
			"ket"=>$array_data['ket'],
			"data_detail"=>"",
			));
		}
		echo json_encode(array('result'=>$data_kec));
		
		mysqli_close($con);
	}
?>
