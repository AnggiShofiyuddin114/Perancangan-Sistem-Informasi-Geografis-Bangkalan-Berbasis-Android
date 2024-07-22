<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$user=$_POST['username'];
		$pass=$_POST['password'];
		
		//Import File Koneksi database
		require_once('koneksi.php');

		$cekAdmin="SELECT * FROM ADMIN WHERE USERNAME='$user' AND PASSWORD='$pass'";
		$sql=mysqli_query($con,$cekAdmin);
		if($sql){
			if (mysqli_num_rows($sql)==1) {
				echo "true";
			}
			else{
				echo 'false';
			}
		}
		else{
			echo 'false';
		}
		mysqli_close($con);
	}
?>