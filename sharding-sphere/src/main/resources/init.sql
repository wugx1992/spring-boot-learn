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

