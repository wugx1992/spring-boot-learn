
CREATE DATABASE IF NOT EXISTS sharding_test_0 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS sharding_test_1 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE sharding_test_0.`test_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE sharding_test_1.`test_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`) VALUES ('1', '张三', '2020-03-24 10:55:38');
INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`) VALUES ('2', '李四', '2020-03-24 10:55:44');
INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`) VALUES ('3', '王五', '2020-03-24 10:55:51');
