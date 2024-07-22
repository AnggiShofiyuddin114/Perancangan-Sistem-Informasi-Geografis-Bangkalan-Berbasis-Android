<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id_data=$_POST['id_data'];
		$jenis=$_POST['jenis'];
		$atribut_jenis=$_POST['atribut_jenis'];
		
		//Import File Koneksi database
		require_once('koneksi.php');

		$deleteAgama="DELETE FROM DATA_AGAMA WHERE ID_AGAMA='$id_data'";
		$deleteGoldar="DELETE FROM DATA_GOLONGAN_DARAH WHERE ID_GOLDAR='$id_data'";
		$deleteJk="DELETE FROM DATA_JENIS_KELAMIN WHERE ID_JK='$id_data'";
		$deletePekerjaan="DELETE FROM DATA_PEKERJAAN WHERE ID_PEKERJAAN='$id_data'";
		$deleteRiwayatSekolah="DELETE FROM DATA_RIWAYAT_SEKOLAH WHERE ID_RIWAYAT_SEKOLAH='$id_data'";
		$deleteStatusPernikahan="DELETE FROM DATA_STATUS_PERNIKAHAN WHERE ID_STATUS_PERNIKAHAN='$id_data'";
		$deleteUsia="DELETE FROM DATA_USIA WHERE ID_USIA='$id_data'";
		$deleteUsiaPendidikan="DELETE FROM DATA_USIA_PENDIDIKAN WHERE ID_USIA_PENDIDIKAN='$id_data'";
		$deletePenduduk="DELETE FROM DATA_KEPENDUDUKAN WHERE ID_KEPENDUDUKAN='$id_data'";
		$deleteDataKependudukan="DELETE FROM $jenis WHERE $atribut_jenis='$id_data'";
		if(mysqli_query($con,$deleteDataKependudukan) &
		mysqli_query($con,$deletePenduduk) &
		mysqli_query($con,$deleteAgama) &
		mysqli_query($con,$deleteGoldar) &
		mysqli_query($con,$deleteJk) &
		mysqli_query($con,$deletePekerjaan) &
		mysqli_query($con,$deleteRiwayatSekolah) &
		mysqli_query($con,$deleteStatusPernikahan) &
		mysqli_query($con,$deleteUsia) &
		mysqli_query($con,$deleteUsiaPendidikan)){
			echo 'data berhasil dihapus';
		}
		else{
			echo 'data gagal dihapus';
		}
		mysqli_close($con);
	}
?>