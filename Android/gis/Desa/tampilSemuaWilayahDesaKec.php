<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		
		//Importing database
		require_once('koneksi.php');
		
		//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
		$sql = "SELECT * FROM DESA WHERE ID_KECAMATAN='$id'";
		
		//Mendapatkan Hasil 
		$r = mysqli_query($con,$sql);
		
		//Membuat Array Kosong 
		$result = array();
		
		while($row = mysqli_fetch_array($r)){
			
			//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
			array_push($result,array(
				"id"=>$row['ID_DESA'],
				"ket"=>$row['KET_DESA'],
				"batas_wilayah"=>$row['BATAS_WILAYAH_DESA'],
				"koordinat"=>$row['KOORDINAT_DESA']
			));
		}
		
		//Menampilkan dalam format JSON
		echo json_encode(array('result'=>$result));
		
		mysqli_close($con);
	}
?>