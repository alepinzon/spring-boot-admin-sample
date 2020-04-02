CREATE DATABASE mydb;

CREATE TABLE mydb.`transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


INSERT INTO mydb.`transaction` (description,created_at) VALUES
('description 1','2020-04-01 17:05:31.0')
,('description 2','2020-04-01 17:05:32.0')
,('description 3','2020-04-01 17:05:33.0')
,('description 4','2020-04-01 17:05:34.0')
,('description 5','2020-04-01 17:05:35.0')
;