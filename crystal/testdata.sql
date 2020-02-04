CREATE TABLE `testdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_computer` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `version` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `os` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `iterations` int NOT NULL,
  `interval` int NOT NULL,
  `date` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


CREATE TABLE `test_row` (
  `id` int NOT NULL AUTO_INCREMENT,
  `test_type` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `mood_type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `q` int NOT NULL,
  `t` int NOT NULL,
  `mbs` decimal(20,0) NOT NULL,
  `iops` decimal(20,0) NOT NULL,
  `us` decimal(20,0) NOT NULL,
  `id_testdata` int NOT NULL,
  `test_rowcol` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci