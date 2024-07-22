<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$user=$_POST['username'];
		$passBaru=$_POST['passwordbaru'];
		
		//Import File Koneksi database
		require_once('koneksi.php');

		$gantiPassAdmin="UPDATE ADMIN SET PASSWORD='$passBaru' WHERE USERNAME='$user'";
		if(mysqli_query($con,$gantiPassAdmin)){
			echo 'true';
		}
		else{
			echo 'false';
		}
		mysqli_close($con);
	}
?>