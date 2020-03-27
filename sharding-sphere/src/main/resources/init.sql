CREATE DATABASE IF NOT EXISTS sharding_test_0 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS sharding_test_1 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE `sharding_test_0`.`test_tb`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `sharding_test_1`.`test_tb`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) DEFAULT NULL,
    `create_time` datetime     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`)
VALUES ('1', '张三', '2020-03-24 10:55:38');
INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`)
VALUES ('2', '李四', '2020-03-24 10:55:44');
INSERT INTO `sharding_test_1`.`test_tb` (`id`, `name`, `create_time`)
VALUES ('3', '王五', '2020-03-24 10:55:51');


create table `sharding_test_0`.`t_order0`
(
    order_id bigint not null auto_increment primary key,
    user_id  bigint not null,
    name     varchar(100)
);

create table `sharding_test_0`.t_order1
(
    order_id bigint not null auto_increment primary key,
    user_id  bigint not null,
    name     varchar(100)
);

-- 这是广播表，新建在其中一个节点上就可以
CREATE TABLE `sharding_test_0`.`t_config`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20)   DEFAULT NULL,
    `config`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `sharding_test_0`.`t_order_item0`
(
    `order_id` bigint(20) NOT NULL,
    `item`     varchar(100) DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `sharding_test_0`.`t_order_item1`
(
    `order_id` bigint(20) NOT NULL,
    `item`     varchar(100) DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



create table `sharding_test_1`.`t_order0`
(
    order_id bigint not null auto_increment primary key,
    user_id  bigint not null,
    name     varchar(100)
);

create table `sharding_test_1`.t_order1
(
    order_id bigint not null auto_increment primary key,
    user_id  bigint not null,
    name     varchar(100)
);

-- 这是广播表，新建在其中一个节点上就可以
CREATE TABLE `sharding_test_1`.`t_config`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20)   DEFAULT NULL,
    `config`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE `sharding_test_1`.`t_order_item0`
(
    `order_id` bigint(20) NOT NULL,
    `item`     varchar(100) DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `sharding_test_1`.`t_order_item1`
(
    `order_id` bigint(20) NOT NULL,
    `item`     varchar(100) DEFAULT NULL,
    `user_id`  bigint(20) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO `sharding_test_0`.`t_config` (`id`, `user_id`, `config`) VALUES ('1', '1', 'user 1 config');
INSERT INTO `sharding_test_0`.`t_config` (`id`, `user_id`, `config`) VALUES ('2', '2', 'user 2 config');
INSERT INTO `sharding_test_0`.`t_config` (`id`, `user_id`, `config`) VALUES ('3', '3', 'user 3 config');
INSERT INTO `sharding_test_0`.`t_config` (`id`, `user_id`, `config`) VALUES ('4', '4', 'user 4 config');

INSERT INTO `sharding_test_1`.`t_config` (`id`, `user_id`, `config`) VALUES ('1', '1', 'user 1 config');
INSERT INTO `sharding_test_1`.`t_config` (`id`, `user_id`, `config`) VALUES ('2', '2', 'user 2 config');
INSERT INTO `sharding_test_1`.`t_config` (`id`, `user_id`, `config`) VALUES ('3', '3', 'user 3 config');
INSERT INTO `sharding_test_1`.`t_config` (`id`, `user_id`, `config`) VALUES ('4', '4', 'user 4 config');


-- ----------

CREATE TABLE `sharding_test_0`.`history_log_1`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `sharding_test_0`.`history_log_2`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `sharding_test_0`.`history_log_3`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



CREATE TABLE `sharding_test_1`.`history_log_1`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `sharding_test_1`.`history_log_2`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE `sharding_test_1`.`history_log_3`
(
    `id` bigint(20) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `content`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `sharding_test_0`.`history_log_msg` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `begin_id` int(11) DEFAULT NULL,
     `end_id` int(11) DEFAULT NULL,
     `begin_time` datetime DEFAULT NULL,
     `end_time` datetime DEFAULT NULL,
     `table_suffix` int(11) NOT NULL,
     `create_time` datetime NOT NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `sharding_test_0`.`history_log_msg` VALUES ('1', '1', '10', '2020-03-01 00:00:00', '2020-03-21 23:59:59', '1', '2020-03-25 14:49:31');
INSERT INTO `sharding_test_0`.`history_log_msg` VALUES ('2', '11', '20', '2020-03-22 00:00:58', '2020-03-25 23:59:59', '2', '2020-03-25 14:50:48');
INSERT INTO `sharding_test_0`.`history_log_msg` VALUES ('3', '21', '30', '2020-03-26 00:00:15', null, '3', '2020-03-25 14:51:26');


CREATE TABLE `sharding_test_1`.`history_log_msg` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `begin_id` int(11) DEFAULT NULL,
    `end_id` int(11) DEFAULT NULL,
    `begin_time` datetime DEFAULT NULL,
    `end_time` datetime DEFAULT NULL,
    `table_suffix` int(11) NOT NULL,
    `create_time` datetime NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `sharding_test_1`.`history_log_msg` VALUES ('1', '1', '10', '2020-03-01 00:00:00', '2020-03-21 23:59:59', '1', '2020-03-25 14:49:31');
INSERT INTO `sharding_test_1`.`history_log_msg` VALUES ('2', '11', '20', '2020-03-22 00:00:58', '2020-03-25 23:59:59', '2', '2020-03-25 14:50:48');
INSERT INTO `sharding_test_1`.`history_log_msg` VALUES ('3', '21', '30', '2020-03-26 00:00:15', null, '3', '2020-03-25 14:51:26');
