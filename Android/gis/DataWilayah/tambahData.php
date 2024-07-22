<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
// 		'$islam','$kristen','$katholik','$hindu','$budha','$konghucu','$kepercayaan'
// '$a','$b','$ab','$o','$a_p','$a_m','$b_p','$b_m','$ab_p','$ab_m','$o_p','$o_m'
// '$pria','$wanita'
// '$belum_bekerja','$aparatur_pejabat_negara','$wiraswasta','$pertanian_dan_peternakan','$nelayan','$agama_dan_kepercayaan','$pelajar_dan_mahasiswa','$tenaga_kesehatan','$pensiunan','$pekerjaan_lainnya'
// '$belum_sekolah','$belum_tamat_sd','$tamat_sd','$sltp','$slta','$d1_dan_d2','$d3','$s1','$s2','$s3'
// '$belum_kawin','$kawin','$cerai_mati','$cerai_hidup'
// '$usia_0_4','$usia_5_9','$usia_10_14','$usia_15_19','$usia_20_24','$usia_25_29','$usia_30_34','$usia_35_39','$usia_40_44','$usia_45_49','$usia_50_54','$usia_55_59','$usia_60_64','$usia_65_69','$usia_70_74','$usia_75'
// '$up_3_4','Hup_5','$up_6_11','$up_12_14','$up_15_17','$up_18_22'
// '$jum_penduduk','$jum_kk','$kepadatan_penduduk','$perpindahan_penduduk','$jum_meninggal','$wajib_ktp','$jum_kelahiran'
		$jenis=$_POST['jenis'];
		$id_data=$_POST['id_data'];
		
		//tahun
		$tahun=$_POST['tahun'];

		//agama
		$islam = $_POST['islam'];
		$kristen = $_POST['kristen'];
		$katholik = $_POST['katholik'];
		$hindu = $_POST['hindu'];
		$budha = $_POST['budha'];
		$konghucu = $_POST['konghucu'];
		$kepercayaan = $_POST['kepercayaan'];

		//golongan darah
		$a = $_POST['a'];
		$b = $_POST['b'];
		$ab = $_POST['ab'];
		$o = $_POST['o'];
		$a_p = $_POST['a_p'];
		$a_m = $_POST['a_m'];
		$b_p = $_POST['b_p'];
		$b_m = $_POST['b_m'];
		$ab_p = $_POST['ab_p'];
		$ab_m = $_POST['ab_m'];
		$o_p = $_POST['o_p'];
		$o_m = $_POST['o_m'];
		$tidak_diketahui = $_POST['tidak_diketahui'];

		//jk
		$pria = $_POST['pria'];
		$wanita = $_POST['wanita'];

		//pekerjaan
		$belum_bekerja = $_POST['belum_bekerja'];
		$aparatur_pejabat_negara = $_POST['aparatur_pejabat_negara'];
		$wiraswasta = $_POST['wiraswasta'];
		$pertanian_dan_peternakan = $_POST['pertanian_dan_peternakan'];
		$nelayan = $_POST['nelayan'];
		$agama_dan_kepercayaan = $_POST['agama_dan_kepercayaan'];
		$pelajar_dan_mahasiswa = $_POST['pelajar_dan_mahasiswa'];
		$tenaga_kesehatan = $_POST['tenaga_kesehatan'];
		$pensiunan = $_POST['pensiunan'];
		$pekerjaan_lainnya = $_POST['pekerjaan_lainnya'];

		//riwayat sekolah
		$belum_sekolah = $_POST['belum_sekolah'];
		$belum_tamat_sd = $_POST['belum_tamat_sd'];
		$tamat_sd = $_POST['tamat_sd'];
		$sltp = $_POST['sltp'];
		$slta = $_POST['slta'];
		$d1_dan_d2 = $_POST['d1_dan_d2'];
		$d3 = $_POST['d3'];
		$s1 = $_POST['s1'];
		$s2 = $_POST['s2'];
		$s3 = $_POST['s3'];

		//status pernikahan
		$belum_kawin = $_POST['belum_kawin'];
		$kawin = $_POST['kawin'];
		$cerai_mati = $_POST['cerai_mati'];
		$cerai_hidup = $_POST['cerai_hidup'];

		//usia
		$usia_0_4 = $_POST['usia_0_4'];
		$usia_5_9 = $_POST['usia_5_9'];
		$usia_10_14 = $_POST['usia_10_14'];
		$usia_15_19 = $_POST['usia_15_19'];
		$usia_20_24 = $_POST['usia_20_24'];
		$usia_25_29 = $_POST['usia_25_29'];
		$usia_30_34 = $_POST['usia_30_34'];
		$usia_35_39 = $_POST['usia_35_39'];
		$usia_40_44 = $_POST['usia_40_44'];
		$usia_45_49 = $_POST['usia_45_49'];
		$usia_50_54 = $_POST['usia_50_54'];
		$usia_55_59 = $_POST['usia_55_59'];
		$usia_60_64 = $_POST['usia_60_64'];
		$usia_65_69 = $_POST['usia_65_69'];
		$usia_70_74 = $_POST['usia_70_74'];
		$usia_75 = $_POST['usia_75'];

		//usia pendidikan
		$up_3_4 = $_POST['up_3_4'];
		$up_5 = $_POST['up_5'];
		$up_6_11 = $_POST['up_6_11'];
		$up_12_14 = $_POST['up_12_14'];
		$up_15_17 = $_POST['up_15_17'];
		$up_18_22 = $_POST['up_18_22'];
		
		//penduduk
		$jum_penduduk = $_POST['jum_penduduk'];
		$jum_kk = $_POST['jum_kk'];
		$kepadatan_penduduk = $_POST['kepadatan_penduduk'];
		$perpindahan_penduduk = $_POST['perpindahan_penduduk'];
		$jum_meninggal = $_POST['jum_meninggal'];
		$wajib_ktp = $_POST['wajib_ktp'];
		$jum_kelahiran = $_POST['jum_kelahiran'];

		//Import File Koneksi database
		require_once('koneksi.php');

		$cekTahun="SELECT COUNT(*) AS count FROM TAHUN WHERE KET_TAHUN='$tahun'";
		$cekT = mysqli_query($con,$cekTahun);
		$rowT = mysqli_fetch_array($cekT);
		$sukses="false";
		if ($rowT['count']==0) {
			$addTahun="INSERT INTO TAHUN VALUES (null,'$tahun')";
			mysqli_query($con,$addTahun);
		}
		$idTahun="SELECT ID_TAHUN FROM TAHUN WHERE KET_TAHUN='$tahun'";
		$cekT = mysqli_query($con,$idTahun);
		$rowT = mysqli_fetch_array($cekT);
		$id_tahun=$rowT["ID_TAHUN"];
		$id=$id_tahun.$id_data;

		$addAgama="INSERT INTO DATA_AGAMA VALUES ('$id','$islam','$kristen','$katholik','$hindu','$budha','$konghucu','$kepercayaan')";
		$addGoldar="INSERT INTO DATA_GOLONGAN_DARAH VALUES ('$id','$a','$b','$ab','$o','$a_p','$a_m','$b_p','$b_m','$ab_p','$ab_m','$o_p','$o_m','$tidak_diketahui')";
		$addJk="INSERT INTO DATA_JENIS_KELAMIN VALUES ('$id','$pria','$wanita')";
		$addPekerjaan="INSERT INTO DATA_PEKERJAAN VALUES ('$id','$belum_bekerja','$aparatur_pejabat_negara','$wiraswasta','$pertanian_dan_peternakan','$nelayan','$agama_dan_kepercayaan','$pelajar_dan_mahasiswa','$tenaga_kesehatan','$pensiunan','$pekerjaan_lainnya')";
		$addRiwayatSekolah="INSERT INTO DATA_RIWAYAT_SEKOLAH VALUES ('$id','$belum_sekolah','$belum_tamat_sd','$tamat_sd','$sltp','$slta','$d1_dan_d2','$d3','$s1','$s2','$s3')";
		$addStatusPernikahan="INSERT INTO DATA_STATUS_PERNIKAHAN VALUES ('$id','$belum_kawin','$kawin','$cerai_mati','$cerai_hidup')";
		$addUsia="INSERT INTO DATA_USIA VALUES ('$id','$usia_0_4','$usia_5_9','$usia_10_14','$usia_15_19','$usia_20_24','$usia_25_29','$usia_30_34','$usia_35_39','$usia_40_44','$usia_45_49','$usia_50_54','$usia_55_59','$usia_60_64','$usia_65_69','$usia_70_74','$usia_75')";
		$addUsiaPendidikan="INSERT INTO DATA_USIA_PENDIDIKAN VALUES ('$id','$up_3_4','$up_5','$up_6_11','$up_12_14','$up_15_17','$up_18_22')";
		$addPenduduk="INSERT INTO DATA_KEPENDUDUKAN VALUES ('$id','$id','$id','$id','$id','$id','$id','$id_tahun','$id','$id','$jum_penduduk','$jum_kk','$kepadatan_penduduk','$perpindahan_penduduk','$jum_meninggal','$wajib_ktp','$jum_kelahiran')";
		$addDataKependudukan="INSERT INTO $jenis VALUES ('$id','$id_data','$id')";
		if(mysqli_query($con,$addAgama) &
		mysqli_query($con,$addGoldar) &
		mysqli_query($con,$addJk) &
		mysqli_query($con,$addPekerjaan) &
		mysqli_query($con,$addRiwayatSekolah) &
		mysqli_query($con,$addStatusPernikahan) &
		mysqli_query($con,$addUsia) &
		mysqli_query($con,$addUsiaPendidikan) &
		mysqli_query($con,$addPenduduk) &
		mysqli_query($con,$addDataKependudukan)){
			echo 'data berhasil ditambah';
		}
		else{
			echo 'data sudah ada';
		}
		mysqli_close($con);
	}
?>