/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     5/4/2019 5:38:08 PM                          */
/*==============================================================*/

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
create table ADMIN 
(
   USERNAME             varchar(30)                    not null,
   PASSWORD             varchar(30)                    null,
   constraint PK_ADMIN primary key (USERNAME)
);

/*==============================================================*/
/* Index: ADMIN_PK                                              */
/*==============================================================*/
create unique index ADMIN_PK on ADMIN (
USERNAME ASC
);

/*==============================================================*/
/* Table: DATA_AGAMA                                            */
/*==============================================================*/
create table DATA_AGAMA 
(
   ID_AGAMA             varchar(13)                    not null,
   ISLAM                integer                        null,
   KRISTEN              integer                        null,
   KATHOLIK             integer                        null,
   HINDU                integer                        null,
   BUDHA                integer                        null,
   KONGHUCU             integer                        null,
   KEPERCAYAAN          integer                        null,
   constraint PK_DATA_AGAMA primary key (ID_AGAMA)
);

/*==============================================================*/
/* Index: DATA_AGAMA_PK                                         */
/*==============================================================*/
create unique index DATA_AGAMA_PK on DATA_AGAMA (
ID_AGAMA ASC
);

/*==============================================================*/
/* Table: DATA_GOLONGAN_DARAH                                   */
/*==============================================================*/
create table DATA_GOLONGAN_DARAH 
(
   ID_GOLDAR            varchar(13)                    not null,
   A                    integer                        null,
   B                    integer                        null,
   AB                   integer                        null,
   O                    integer                        null,
   A_PLUS               integer                        null,
   A_MIN                integer                        null,
   B_PLUS               integer                        null,
   B_MIN                integer                        null,
   AB_PLUS              integer                        null,
   AB_MIN               integer                        null,
   O_PLUS               integer                        null,
   O_MIN                integer                        null,
   TIDAK_DIKETAHUI      integer                        null,
   constraint PK_DATA_GOLONGAN_DARAH primary key (ID_GOLDAR)
);

/*==============================================================*/
/* Index: DATA_GOLONGAN_DARAH_PK                                */
/*==============================================================*/
create unique index DATA_GOLONGAN_DARAH_PK on DATA_GOLONGAN_DARAH (
ID_GOLDAR ASC
);

/*==============================================================*/
/* Table: DATA_KEPENDUDUKAN                                     */
/*==============================================================*/
create table DATA_KEPENDUDUKAN 
(
   ID_KEPENDUDUKAN      varchar(13)                    not null,
   ID_AGAMA             varchar(13)                    null,
   ID_STATUS_PERNIKAHAN varchar(13)                    null,
   ID_JK                varchar(13)                    null,
   ID_USIA              varchar(13)                    null,
   ID_GOLDAR            varchar(13)                    null,
   ID_RIWAYAT_SEKOLAH   varchar(13)                    null,
   ID_TAHUN             integer                     null,
   ID_USIA_PENDIDIKAN   varchar(13)                    null,
   ID_PEKERJAAN         varchar(13)                    null,
   JUMLAH_PENDUDUK      integer                        null,
   JUMLAH_KK            integer                        null,
   KEPADATAN_PENDUDUK   integer                        null,
   PERPINDAHAN_PENDUDUK integer                        null,
   JUMLAH_MENINGGAL     integer                        null,
   WAJIB_KTP            integer                        null,
   KELAHIRAN            integer                        null,
   constraint PK_DATA_KEPENDUDUKAN primary key (ID_KEPENDUDUKAN)
);

/*==============================================================*/
/* Index: DATA_KEPENDUDUKAN_PK                                  */
/*==============================================================*/
create unique index DATA_KEPENDUDUKAN_PK on DATA_KEPENDUDUKAN (
ID_KEPENDUDUKAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on DATA_KEPENDUDUKAN (
ID_PEKERJAAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on DATA_KEPENDUDUKAN (
ID_AGAMA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on DATA_KEPENDUDUKAN (
ID_GOLDAR ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on DATA_KEPENDUDUKAN (
ID_TAHUN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_6_FK on DATA_KEPENDUDUKAN (
ID_JK ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on DATA_KEPENDUDUKAN (
ID_USIA_PENDIDIKAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on DATA_KEPENDUDUKAN (
ID_STATUS_PERNIKAHAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on DATA_KEPENDUDUKAN (
ID_RIWAYAT_SEKOLAH ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on DATA_KEPENDUDUKAN (
ID_USIA ASC
);

/*==============================================================*/
/* Table: DATA_KEPENDUDUKAN_DESA                                */
/*==============================================================*/
create table DATA_KEPENDUDUKAN_DESA 
(
   ID_DATA_DESA        varchar(13)                    not null,
   ID_DESA              varchar(10)                    null,
   ID_KEPENDUDUKAN      varchar(13)                    null,
   constraint PK_DATA_KEPENDUDUKAN_DESA primary key (ID_DATA_DESA)
);

/*==============================================================*/
/* Index: DATA_KEPENDUDUKAN_DESA_PK                             */
/*==============================================================*/
create unique index DATA_KEPENDUDUKAN_DESA_PK on DATA_KEPENDUDUKAN_DESA (
ID_DATA_DESA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_13_FK on DATA_KEPENDUDUKAN_DESA (
ID_DESA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_15_FK on DATA_KEPENDUDUKAN_DESA (
ID_KEPENDUDUKAN ASC
);

/*==============================================================*/
/* Table: DATA_KEPENDUDUKAN_KECAMATAN                           */
/*==============================================================*/
create table DATA_KEPENDUDUKAN_KECAMATAN 
(
   ID_DATA_KECAMATAN    varchar(9)                     not null,
   ID_KECAMATAN         varchar(6)                     null,
   ID_KEPENDUDUKAN      varchar(13)                    null,
   constraint PK_DATA_KEPENDUDUKAN_KECAMATAN primary key (ID_DATA_KECAMATAN)
);

/*==============================================================*/
/* Index: DATA_KEPENDUDUKAN_KECAMATAN_PK                        */
/*==============================================================*/
create unique index DATA_KEPENDUDUKAN_KECAMATAN_PK on DATA_KEPENDUDUKAN_KECAMATAN (
ID_DATA_KECAMATAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on DATA_KEPENDUDUKAN_KECAMATAN (
ID_KEPENDUDUKAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_14_FK on DATA_KEPENDUDUKAN_KECAMATAN (
ID_KECAMATAN ASC
);

/*==============================================================*/
/* Table: DATA_PEKERJAAN                                        */
/*==============================================================*/
create table DATA_PEKERJAAN 
(
   ID_PEKERJAAN         varchar(13)                    not null,
   BELUM_BEKERJA        integer                        null,
   APARATUR_PEJABAT_NEGARA integer                        null,
   WIRASWASTA           integer                        null,
   PERTANIAN_DAN_PETERNAKAN integer                        null,
   NELAYAN              integer                        null,
   AGAMA_DAN_KEPERCAYAAN integer                        null,
   PELAJAR_DAN_MAHASISWA integer                        null,
   TENAGA_KESEHATAN     integer                        null,
   PENSIUNAN            integer                        null,
   PEKERJAAN_LAINNYA    integer                        null,
   constraint PK_DATA_PEKERJAAN primary key (ID_PEKERJAAN)
);

/*==============================================================*/
/* Index: DATA_PEKERJAAN_PK                                     */
/*==============================================================*/
create unique index DATA_PEKERJAAN_PK on DATA_PEKERJAAN (
ID_PEKERJAAN ASC
);

/*==============================================================*/
/* Table: DATA_RIWAYAT_SEKOLAH                                  */
/*==============================================================*/
create table DATA_RIWAYAT_SEKOLAH 
(
   ID_RIWAYAT_SEKOLAH   varchar(13)                    not null,
   BELUM_SEKOLAH        integer                        null,
   BELUM_TAMAT_SD       integer                        null,
   TAMAT_SD             integer                        null,
   SLTP                 integer                        null,
   SLTA                 integer                        null,
   D1_DAN_D2            integer                        null,
   D3                   integer                        null,
   S1                   integer                        null,
   S2                   integer                        null,
   S3                   integer                        null,
   constraint PK_DATA_RIWAYAT_SEKOLAH primary key (ID_RIWAYAT_SEKOLAH)
);

/*==============================================================*/
/* Index: DATA_RIWAYAT_SEKOLAH_PK                               */
/*==============================================================*/
create unique index DATA_RIWAYAT_SEKOLAH_PK on DATA_RIWAYAT_SEKOLAH (
ID_RIWAYAT_SEKOLAH ASC
);

/*==============================================================*/
/* Table: DATA_USIA                                             */
/*==============================================================*/
create table DATA_USIA 
(
   ID_USIA              varchar(13)                    not null,
   USIA_0_4             integer                        null,
   USIA_5_9             integer                        null,
   USIA_10_14           integer                        null,
   USIA_15_19           integer                        null,
   USIA_20_24           integer                        null,
   USIA_25_29           integer                        null,
   USIA_30_34           integer                        null,
   USIA_35_39           integer                        null,
   USIA_40_44           integer                        null,
   USIA_45_49           integer                        null,
   USIA_50_54           integer                        null,
   USIA_55_59           integer                        null,
   USIA_60_64           integer                        null,
   USIA_65_69           integer                        null,
   USIA_70_74           integer                        null,
   USIA_75              integer                        null,
   constraint PK_DATA_USIA primary key (ID_USIA)
);

/*==============================================================*/
/* Index: DATA_USIA_PK                                          */
/*==============================================================*/
create unique index DATA_USIA_PK on DATA_USIA (
ID_USIA ASC
);

/*==============================================================*/
/* Table: DESA                                                  */
/*==============================================================*/
create table DESA 
(
   ID_DESA              varchar(10)                    not null,
   ID_KECAMATAN         varchar(6)                     null,
   KET_DESA             varchar(30)                    null,
   LUAS_WILAYAH_DESA    float                          null,
   BATAS_WILAYAH_DESA long varchar                   null,
   KOORDINAT_DESA       long varchar                   null,
   constraint PK_DESA primary key (ID_DESA)
);

/*==============================================================*/
/* Index: DESA_PK                                               */
/*==============================================================*/
create unique index DESA_PK on DESA (
ID_DESA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_12_FK on DESA (
ID_KECAMATAN ASC
);

/*==============================================================*/
/* Table: DATA_JENIS_KELAMIN                                         */
/*==============================================================*/
create table DATA_JENIS_KELAMIN 
(
   ID_JK                varchar(13)                    not null,
   PRIA                 integer                        null,
   WANITA               integer                        null,
   constraint PK_JENIS_KELAMIN primary key (ID_JK)
);

/*==============================================================*/
/* Index: DATA_JENIS_KELAMIN_PK                                      */
/*==============================================================*/
create unique index DATA_JENIS_KELAMIN_PK on DATA_JENIS_KELAMIN (
ID_JK ASC
);

/*==============================================================*/
/* Table: KABUPATEN                                             */
/*==============================================================*/
create table KABUPATEN 
(
   ID_KABUPATEN         varchar(4)                     not null,
   ID_PROVINSI          varchar(2)                     null,
   KET_KABUPATEN        varchar(30)                    null,
   constraint PK_KABUPATEN primary key (ID_KABUPATEN)
);

/*==============================================================*/
/* Index: KABUPATEN_PK                                          */
/*==============================================================*/
create unique index KABUPATEN_PK on KABUPATEN (
ID_KABUPATEN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_17_FK on KABUPATEN (
ID_PROVINSI ASC
);

/*==============================================================*/
/* Table: KECAMATAN                                             */
/*==============================================================*/
create table KECAMATAN 
(
   ID_KECAMATAN         varchar(6)                     not null,
   ID_KABUPATEN         varchar(4)                     null,
   KET_KECAMATAN        varchar(30)                    null,
   LUAS_WILAYAH_KECAMATAN float                          null,
   BATAS_WILAYAH_KECAMATAN long varchar                   null,
   KOORDINAT_KECAMATAN  long varchar                   null,
   JUMLAH_DESA          integer                        null,
   constraint PK_KECAMATAN primary key (ID_KECAMATAN)
);

/*==============================================================*/
/* Index: KECAMATAN_PK                                          */
/*==============================================================*/
create unique index KECAMATAN_PK on KECAMATAN (
ID_KECAMATAN ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_16_FK on KECAMATAN (
ID_KABUPATEN ASC
);

/*==============================================================*/
/* Table: PROVINSI                                              */
/*==============================================================*/
create table PROVINSI 
(
   ID_PROVINSI          varchar(2)                     not null,
   KET_PROVINSI         varchar(30)                    null,
   constraint PK_PROVINSI primary key (ID_PROVINSI)
);

/*==============================================================*/
/* Index: PROVINSI_PK                                           */
/*==============================================================*/
create unique index PROVINSI_PK on PROVINSI (
ID_PROVINSI ASC
);

/*==============================================================*/
/* Table: DATA_STATUS_PERNIKAHAN                                     */
/*==============================================================*/
create table DATA_STATUS_PERNIKAHAN 
(
   ID_STATUS_PERNIKAHAN varchar(13)                    not null,
   BELUM_KAWIN          integer                        null,
   KAWIN                integer                        null,
   CERAI_MATI           integer                        null,
   CERAI_HIDUP          integer                        null,
   constraint PK_STATUS_PERNIKAHAN primary key (ID_STATUS_PERNIKAHAN)
);

/*==============================================================*/
/* Index: DATA_STATUS_PERNIKAHAN_PK                                  */
/*==============================================================*/
create unique index DATA_STATUS_PERNIKAHAN_PK on DATA_STATUS_PERNIKAHAN (
ID_STATUS_PERNIKAHAN ASC
);

/*==============================================================*/
/* Table: TAHUN                                                 */
/*==============================================================*/
create table TAHUN 
(
   ID_TAHUN             integer auto_increment                     not null,
   KET_TAHUN            varchar(4)                     null,
   constraint PK_TAHUN primary key (ID_TAHUN)
);

/*==============================================================*/
/* Index: TAHUN_PK                                              */
/*==============================================================*/
create unique index TAHUN_PK on TAHUN (
ID_TAHUN ASC
);

/*==============================================================*/
/* Table: DATA_USIA_PENDIDIKAN                                       */
/*==============================================================*/
create table DATA_USIA_PENDIDIKAN 
(
   ID_USIA_PENDIDIKAN   varchar(13)                    not null,
   UP_3_4               integer                        null,
   UP_5                 integer                        null,
   UP_6_11              integer                        null,
   UP_12_14             integer                        null,
   UP_15_17             integer                        null,
   UP_18_22             integer                        null,
   constraint PK_USIA_PENDIDIKAN primary key (ID_USIA_PENDIDIKAN)
);

/*==============================================================*/
/* Index: DATA_USIA_PENDIDIKAN_PK                                    */
/*==============================================================*/
create unique index DATA_USIA_PENDIDIKAN_PK on DATA_USIA_PENDIDIKAN (
ID_USIA_PENDIDIKAN ASC
);

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_PEK foreign key (ID_PEKERJAAN)
      references DATA_PEKERJAAN (ID_PEKERJAAN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_USI foreign key (ID_USIA)
      references DATA_USIA (ID_USIA)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_AGA foreign key (ID_AGAMA)
      references DATA_AGAMA (ID_AGAMA)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_GOL foreign key (ID_GOLDAR)
      references DATA_GOLONGAN_DARAH (ID_GOLDAR)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_TAHUN foreign key (ID_TAHUN)
      references TAHUN (ID_TAHUN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_JENIS_KE foreign key (ID_JK)
      references DATA_JENIS_KELAMIN (ID_JK)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_USIA_PEN foreign key (ID_USIA_PENDIDIKAN)
      references DATA_USIA_PENDIDIKAN (ID_USIA_PENDIDIKAN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_STATUS_P foreign key (ID_STATUS_PERNIKAHAN)
      references DATA_STATUS_PERNIKAHAN (ID_STATUS_PERNIKAHAN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_RIW foreign key (ID_RIWAYAT_SEKOLAH)
      references DATA_RIWAYAT_SEKOLAH (ID_RIWAYAT_SEKOLAH)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN_DESA
   add constraint FK_DATA_KEP_RELATIONS_DESA foreign key (ID_DESA)
      references DESA (ID_DESA)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN_DESA
   add constraint FK_DATA_KEP_RELATIONS_DATA_KEP foreign key (ID_KEPENDUDUKAN)
      references DATA_KEPENDUDUKAN (ID_KEPENDUDUKAN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN_KECAMATAN
   add constraint FK_DATA_KEP_RELATIONS_DATA_KE2 foreign key (ID_KEPENDUDUKAN)
      references DATA_KEPENDUDUKAN (ID_KEPENDUDUKAN)
      on update cascade
      on delete restrict;

alter table DATA_KEPENDUDUKAN_KECAMATAN
   add constraint FK_DATA_KEP_RELATIONS_KECAMATA foreign key (ID_KECAMATAN)
      references KECAMATAN (ID_KECAMATAN)
      on update cascade
      on delete restrict;

alter table DESA
   add constraint FK_DESA_RELATIONS_KECAMATA foreign key (ID_KECAMATAN)
      references KECAMATAN (ID_KECAMATAN)
      on update cascade
      on delete restrict;

alter table KABUPATEN
   add constraint FK_KABUPATE_RELATIONS_PROVINSI foreign key (ID_PROVINSI)
      references PROVINSI (ID_PROVINSI)
      on update cascade
      on delete restrict;

alter table KECAMATAN
   add constraint FK_KECAMATA_RELATIONS_KABUPATE foreign key (ID_KABUPATEN)
      references KABUPATEN (ID_KABUPATEN)
      on update cascade
      on delete restrict;

