<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id_data=$_POST['id_data'];

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

		$editAgama="UPDATE DATA_AGAMA SET ISLAM='$islam',KRISTEN='$kristen',KATHOLIK='$katholik',HINDU='$hindu',BUDHA='$budha',KONGHUCU='$konghucu',KEPERCAYAAN='$kepercayaan' WHERE ID_AGAMA='$id_data'";
		$editGoldar="UPDATE DATA_GOLONGAN_DARAH SET A='$a',B='$b',AB='$ab',O='$o',A_PLUS='$a_p',A_MIN='$a_m',B_PLUS='$b_p',B_MIN='$b_m',AB_PLUS='$ab_p',AB_MIN='$ab_m',O_PLUS='$o_p',O_MIN='$o_m',TIDAK_DIKETAHUI='$tidak_diketahui' WHERE ID_GOLDAR='$id_data'";
		$editJk="UPDATE DATA_JENIS_KELAMIN SET PRIA='$pria',WANITA='$wanita' WHERE ID_JK='$id_data'";
		$editPekerjaan="UPDATE DATA_PEKERJAAN SET BELUM_BEKERJA='$belum_bekerja',APARATUR_PEJABAT_NEGARA='$aparatur_pejabat_negara',WIRASWASTA='$wiraswasta',PERTANIAN_DAN_PETERNAKAN='$pertanian_dan_peternakan',NELAYAN='$nelayan',AGAMA_DAN_KEPERCAYAAN='$agama_dan_kepercayaan',PELAJAR_DAN_MAHASISWA='$pelajar_dan_mahasiswa',TENAGA_KESEHATAN='$tenaga_kesehatan',PENSIUNAN='$pensiunan',PEKERJAAN_LAINNYA='$pekerjaan_lainnya' WHERE ID_PEKERJAAN='$id_data'";
		$editRiwayatSekolah="UPDATE DATA_RIWAYAT_SEKOLAH SET BELUM_SEKOLAH='$belum_sekolah',BELUM_TAMAT_SD='$belum_tamat_sd',TAMAT_SD='$tamat_sd',SLTP='$sltp',SLTA='$slta',D1_DAN_D2='$d1_dan_d2',D3='$d3',S1='$s1',S2='$s2',S3='$s3' WHERE ID_RIWAYAT_SEKOLAH='$id_data'";
		$editStatusPernikahan="UPDATE DATA_STATUS_PERNIKAHAN SET BELUM_KAWIN='$belum_kawin',KAWIN='$kawin',CERAI_MATI='$cerai_mati',CERAI_HIDUP='$cerai_hidup' WHERE ID_STATUS_PERNIKAHAN='$id_data'";
		$editUsia="UPDATE DATA_USIA SET USIA_0_4='$usia_0_4',USIA_5_9='$usia_5_9',USIA_10_14='$usia_10_14',USIA_15_19='$usia_15_19',USIA_20_24='$usia_20_24',USIA_25_29='$usia_25_29',USIA_30_34='$usia_30_34',USIA_35_39='$usia_35_39',USIA_40_44='$usia_40_44',USIA_45_49='$usia_45_49',USIA_50_54='$usia_50_54',USIA_55_59='$usia_55_59',USIA_60_64='$usia_60_64',USIA_65_69='$usia_65_69',USIA_70_74='$usia_70_74',USIA_75='$usia_75' WHERE ID_USIA='$id_data'";
		$editUsiaPendidikan="UPDATE DATA_USIA_PENDIDIKAN SET UP_3_4='$up_3_4',UP_5='$up_5',UP_6_11='$up_6_11',UP_12_14='$up_12_14',UP_15_17='$up_15_17',UP_18_22='$up_18_22' WHERE ID_USIA_PENDIDIKAN='$id_data'";
		$editPenduduk="UPDATE DATA_KEPENDUDUKAN SET JUMLAH_PENDUDUK='$jum_penduduk',JUMLAH_KK='$jum_kk',KEPADATAN_PENDUDUK='$kepadatan_penduduk',PERPINDAHAN_PENDUDUK='$perpindahan_penduduk',JUMLAH_MENINGGAL='$jum_meninggal',WAJIB_KTP='$wajib_ktp',KELAHIRAN='$jum_kelahiran' WHERE ID_KEPENDUDUKAN='$id_data'";
		if(mysqli_query($con,$editAgama) &
		mysqli_query($con,$editGoldar) &
		mysqli_query($con,$editJk) &
		mysqli_query($con,$editPekerjaan) &
		mysqli_query($con,$editRiwayatSekolah) &
		mysqli_query($con,$editStatusPernikahan) &
		mysqli_query($con,$editUsia) &
		mysqli_query($con,$editUsiaPendidikan) &
		mysqli_query($con,$editPenduduk) ){
			echo 'data berhasil diubah';
		}
		else{
			echo 'data gagal diubah';
		}
		mysqli_close($con);
	}
?>