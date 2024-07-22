<?php 
 
 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
	
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT KECAMATAN.ID_KECAMATAN,KECAMATAN.KET_KECAMATAN,DESA.ID_DESA,DESA.KET_DESA FROM KECAMATAN JOIN DESA on KECAMATAN.ID_KECAMATAN=DESA.ID_KECAMATAN";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"id_kecamatan"=>$row['ID_KECAMATAN'],
			"ket_kecamatan"=>$row['KET_KECAMATAN'],
			"id_desa"=>$row['ID_DESA'],
			"ket_desa"=>$row['KET_DESA']
		));
	}
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>