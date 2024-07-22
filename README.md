# Perancangan-Sistem-Informasi-Geografis-Bangkalan-Berbasis-Android-untuk-Meningkatkan-Pengetahuan-Masyarakat-Terhadap-Perkembangan-Penduduk-dan-Geografis-di-Bangkalan
&emsp;&emsp;Proyek ini bertujuan untuk merancang dan mengembangkan Aplikasi Sitem Informasi Geografis (SIG) berbasis Android yang bertujuan untuk meningkatkan pengetahuan masyarakat tentang perkembangan penduduk dan geografis di Bangkalan, Jawa timur. Aplikasi ini akan menyediakan informasi yang mudah diakses dan dipahami tentang aspek-aspek demografis dan geografis Bangkalan, termasuk data statistik, visualisasi peta, dan grafik data.<br/><br/>
***Environment***<br/>
Program ini dijalankan menggunakan:<br/>
* Bahasa Pemrograman : Java (untuk pengembangan aplikasi Android) dan PHP (untuk pengembangan backend (operasi CRUD pada data)).<br/>
* Pustaka Peta : Google Maps API untuk menampilkan peta interaktif.<br/>
* Basis Data : MySQL untuk menyimpan data backend.<br/>
* Alat Pengembang : Android Studio untuk pengembangan aplikasi Android dan editor PHP seperti Sublime untuk pengembangan backend (operasi CRUD pada data).<br/>

**<h2 align="center">Rancangan Basis Data</h2>**
<div align="center"><img src="/Images/RancanganBasisData.png" width="450" height="450"/></div>
&emsp;&emsp;Pada Rancangan Basis Data diatas menjelaskan bahwa terdapat 17 tabel yang ada dalam Sistem Informasi Geografis Bangkalan, diantaranya table admin, desa, kecamatan, kabupaten, provinsi, data kependudukan desa, data kependudukan kecamatan, data kependudukan, data agama, data golongan darah, data jenis kelamin, data pekerjaan, data riwayat sekolah, data status pernikahan, data usia, data usia pendidikan, dan tahun.<br/>

**<h2 align="center">Implementasi Aplikasi</h2>**
1.	Tampilan Halaman Awal<br/>
<div align="center"><img src="/Images/HalamanAwal.png" width="150"/></div>
&emsp;&emsp;Pada halaman awal sistem terdapat 4 menu awal yang bisa dipilih yaitu admin, user, tentang kami, dan kontak kami.<br/><br/>
2.	Tampilan Halaman Login Admin<br/>
<div align="center"><img src="/Images/HalamanLoginAdmin.png" width="150"/></div>
&emsp;&emsp;Melakukan login agar dapat masuk ke dalam sistem, serta memilih remember me jika ingin tetap login dan tidak perlu melakukan login lagi saat keluar dari sistem.<br/><br/>
3.	Tampilan Halaman Ganti Kata Sandi<br/>
<div align="center"><img src="/Images/HalamanGantiKataSandi.png" width="150"/></div>
&emsp;&emsp;Pada halaman ganti kata sandi ini dapat mengganti kata sandi yang kita punya menjadi kata sandi yang baru.<br/><br/>
4.	Tampilan Navigation Bar<br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Navigation Bar pada Admin</td>
    <td>Tampilan Navigation Bar pada User</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/TampilanNavigationBarpadaAdmin.png" width="150"/></td>
    <td><img src="/Images/TampilanNavigationBarpadaUser.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada Tampilan Navigation Bar menampilkan menu-menu yang dimiliki dan juga dapat dipilih.<br/><br/>
5.	Tampilan Option Menu<br/>
<div align="center"><img src="/Images/TampilanOptionMenu.png" width="150"/></div>
&emsp;&emsp;Pada tampilan option menu ini hanya terdapat 2 pilihan yang bisa dipilih yaitu ganti kata sandi dan keluar. Dan option menu ini hanya dimiliki oleh admin.<br/><br/>
6.	Tampilan Halaman Beranda<br/>
<div align="center"><img src="/Images/TampilanHalamanBeranda.png" width="150"/></div>
&emsp;&emsp;Ketika masuk ke sistem, sistem akan menampilkan halaman utama atau bisa disebut dengan beranda. Beranda admin dan user hampir sama yang menbedakan yaitu pada user tidak ada option menu.<br/><br/>
7.	Tampilan Halaman Data Wilayah<br/>
<div align="center"><img src="/Images/TampilanHalamanDataWilayah.png" width="150"/></div>
&emsp;&emsp;Pada halaman data wilayah ini menampilkan list daftar kecamatan yang ada di Bangkalan yang bisa dipilih. Halaman data wilayah ini hanya bisa diakses oleh admin saja.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Data Wilayah Bagian Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/TampilanHalamanDataWilayahBagianDesa.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman data wilayah bagian desa ini menampilkan list daftar desa yang ada di kecamatan yang dipilih.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Tambah Data Kecamatan</td>
    <td>Tampilan Halaman Tambah Data Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/TampilanHalamanTambahDataKecamatan.png" width="150"/></td>
    <td><img src="/Images/TampilanHalamanTambahDataDesa.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman tambah data untuk desa dan kecamatan ini hampir sama. Di halaman ini untuk manambahkan data dengan menginputkan tahun dan semua inputan data dari data penduduk, agama, golongan darah, jenis kelamin, pekerjaan, riwayat sekolah, status pernikahan, usia, dan usia pendidikan yang ada di Bangkalan.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Lihat Data Kecamatan</td>
    <td>Tampilan Halaman Lihat Data Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/TampilanHalamanLihatDataKecamatan.png" width="150"/></td>
    <td><img src="/Images/TampilanHalamanLihatDataDesa.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman lihat data untuk desa dan kecamatan ini hampir sama. Di halaman lihat data ini akan menampilkan informasi-informasi data desa atau kecamatan yang dipilih. Di halaman ini juga dapat melakukan edit data dan hapus data.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Edit Data Kecamatan</td>
    <td>Tampilan Halaman Edit Data Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/TampilanHalamanEditDataKecamatan.png" width="150"/></td>
    <td><img src="/Images/TampilanHalamanEditDataDesa.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman edit data untuk desa dan kecamatan ini hampir sama. Di halaman edit data ini akan menampilkan inputan-inputan yang berisi informasi-informasi data desa atau kecamatan yang dipilih, serta isi data tersebut dapat diubah sesuai keinginan admin.<br/><br/>
8.	Tampilan Halaman Lihat Wilayah
<div align="center"><img src="/Images/TampilanHalamanLihatWilayah.png" width="150"/></div>
&emsp;&emsp;Pada halaman lihat wilayah ini menampilkan 3 menu yang dapat dipilih yaitu tampilkan desa/kecamatan, tampilkan semua desa, dan tampilkan semua kecamatan. Halaman lihat wilayah admin dan user hampir sama yang menbedakan yaitu pada user tidak ada option menu.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Lihat Wilayah Desa/Kecamatan</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanLihatWilayahDesaKecamatan.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman lihat wilayah bagian tampilkan desa/kecamatan ini memiliki dua pilihan yaitu ingin menampilkan desa atau kecamatan tertentu yang kita inginkan.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Gambar 1 Tampilan Halaman Lihat Wilayah Semua Kecamatan</td>
    <td>Gambar 2 Tampilan Halaman Lihat Wilayah Semua Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanLihatWilayahSemuaKecamatan.png" width="150"/></td>
    <td><img src="/Images/HalamanLihatWilayahSemuaDesa.png" width="150"/></td>
  </tr>
  <tr align="center">
    <td>Gambar 3 Tampilan Halaman Lihat Wilayah Satu Kecamatan</td>
    <td>Gambar 4 Tampilan Halaman Lihat Wilayah Satu Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanLihatWilayahSatuKecamatan.png" width="150"/></td>
    <td><img src="/Images/HalamanLihatWilayahSatuDesa.png" width="150"/></td>
  </tr>
  <tr align="center">
    <td>Gambar 5 Tampilan Halaman Lihat Wilayah Semua Desa Pada Satu Kecamatan</td>
    <td>Gambar 6 Tampilan Halaman Lihat Wilayah Bagian Lihat Data</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanLihatWilayahSemuaDesaPadaSatuKecamatan.png" width="150"/></td>
    <td><img src="/Images/HalamanLihatWilayahBagianLihatData.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada Gambar 1 sampai Gambar 4 ini merupakan tampilan-tampilan yang dapat dipilih yaitu menampilkan semua wilayah kecamatan, semua wilayah desa, satu wilayah kecamatan, dan satu wilayah desa. dan menampilkan satu desa atau kecamatan. Dan pada Gambar 5 ini adalah menampilkan semua desa pada satu kecamatan, serta pada Gambar 6 adalah tampilan data dari wilayah desa atau kecamatan yang dipilih.<br/><br/>
9.	Tampilan Halaman Grafik<br/>
<div align="center"><img src="/Images/HalamanGrafik.png" width="150"/></div>
&emsp;&emsp;Pada halaman grafik ini menampilkan list daftar kecamatan yang ada di Bangkalan yang bisa dipilih. Halaman grafik admin dan user hampir sama yang menbedakan yaitu pada user tidak ada option menu.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Grafik Bagian Desa</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanGrafikBagianDesa.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman grafik bagian desa ini menampilkan list daftar desa yang ada di kecamatan yang dipilih.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Grafik Bagian Lihat Grafik Berdasarkan Jenis Data</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanGrafikBagianLihatGrafikBerdasarkanJenisData.png" width="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman grafik bagian lihat grafik berdasarkan ini terdapat list daftar grafik yang bisa dipilih yaitu grafik penduduk, grafik agama, grafik golongan darah, grafik jenis kelamin, grafik pekerjaan, grafik riwayat sekolah, grafik status pernikahan, grafik usia, dan grafik usia pendidikan.<br/><br/><br/>
<table align="center">
  <tr align="center">
    <td>Tampilan Halaman Grafik Bagian Lihat Grafik</td>
  </tr>
  <tr align="center">
    <td><img src="/Images/HalamanGrafikBagianLihatGrafik.png" height="150"/></td>
  </tr>
</table>
&emsp;&emsp;Pada halaman grafik bagian lihat grafik ini akan menampilkan grafik berdasarkan data yang sudah dipilih, serta juga bisa memilih tahun data grafik yang ada.<br/><br/>
10.	Tampilan Halaman Tentang Kami<br/>
<div align="center"><img src="/Images/HalamanTentangKami.png" width="150"/></div>
&emsp;&emsp;Pada halaman tentang kami ini hanya berisi informasi tentang aplikasi ini. Halaman tentang kami admin dan user hampir sama yang membedakan yaitu pada user tidak ada option menu.<br/><br/>
11.	Tampilan Halaman Kontak Kami<br/>
<div align="center"><img src="/Images/HalamanKontakKami.png" width="150"/></div>
&emsp;&emsp;Pada halaman kontak kami ini berisi informasi untuk menghubungi admin, baik untuk menanyakan prihal yang penting atau memberikan kritik dan saran secara pribadi. User dapat menghubungi admin melalui telepon atau email. Halaman Kontak Kami admin dan user hampir sama yang menbedakan yaitu pada user tidak ada option menu.<br/><br/>
12.	Tampilan Halaman Hilang Koneksi Internet<br/>
<div align="center"><img src="/Images/HalamanHilangKoneksiInternet.png" width="150"/></div>
&emsp;&emsp;Pada halaman ini hanya menampilkan halaman hilang koneksi internet dan admin atau user bisa melakukan aktivitas sistem kembali dengan menekan tombol refresh, serta akan berhasil jika koneksi internetnya telah menyala.
