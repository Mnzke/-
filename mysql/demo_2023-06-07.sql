# ************************************************************
# Sequel Ace SQL dump
# 版本号： 20046
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# 主机: localhost (MySQL 8.0.30)
# 数据库: demo
# 生成时间: 2023-06-07 14:07:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# 转储表 activity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `user_id` int DEFAULT NULL COMMENT '记录所有者',
  `outpatient` int DEFAULT '0' COMMENT '完成门诊随访次数',
  `extension` int DEFAULT '0' COMMENT '参加扩展活动次数',
  `science` int DEFAULT '0' COMMENT '参加科研招募次数',
  `create_time` varchar(32) DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;

INSERT INTO `activity` (`id`, `user_id`, `outpatient`, `extension`, `science`, `create_time`)
VALUES
	(2,1,6,5,4,'2023/6/6 10:19:06'),
	(3,37,0,0,0,'2023/6/6 10:22:15'),
	(4,38,0,0,0,'2023/6/7 20:28:30');

/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 estimate
# ------------------------------------------------------------

DROP TABLE IF EXISTS `estimate`;

CREATE TABLE `estimate` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '所有者id',
  `symptom_description` varchar(64) DEFAULT NULL COMMENT '症状描述',
  `symptom_situation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '症状情况',
  `update_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `estimate` WRITE;
/*!40000 ALTER TABLE `estimate` DISABLE KEYS */;

INSERT INTO `estimate` (`id`, `user_id`, `symptom_description`, `symptom_situation`, `update_time`)
VALUES
	(1,1,'5.2','1','2023/6/5 08:17:23'),
	(3,1,'5.1','1','2023/6/5 08:18:37'),
	(42,1,'5.0','1','2023/6/6 09:15:05'),
	(45,1,'a s d','3','2023/6/6 09:21:26'),
	(46,1,'a s d','3','2022/6/6 09:21:37'),
	(47,1,'5','2','2023/6/6 09:27:17'),
	(48,1,'4','2','2023/6/6 09:27:27'),
	(49,1,'3','2','2023/2/6 09:27:47'),
	(50,1,'3','2','2023/6/6 09:29:13'),
	(51,1,'4','2','2023/6/6 09:31:52'),
	(52,1,'3','2','2023/6/6 09:32:00'),
	(53,1,'5','2','2023/6/6 09:32:03'),
	(54,1,'5','2','2023/6/6 09:32:05'),
	(55,1,'23','2','2023/2/6 09:32:35'),
	(62,1,'3','2','2023/6/6 10:07:07'),
	(67,1,'sa','3','2023/6/6 10:09:29'),
	(68,36,'5','1','2023/6/7 21:56:01'),
	(69,36,'4','1','2023/6/7 21:56:05'),
	(70,36,'4','1','2023/6/7 21:56:07'),
	(71,36,'无并发症近一年','3','2023/6/7 21:56:39'),
	(72,36,'近一年','3','2023/6/7 21:56:53'),
	(73,36,'12','2','2023/6/7 21:57:15'),
	(74,36,'13','2','2023/1/7 21:57:22'),
	(75,36,'12','2','2023/6/7 21:58:06');

/*!40000 ALTER TABLE `estimate` ENABLE KEYS */;
UNLOCK TABLES;


# 转储表 user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录名',
  `user_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `sex` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '性别',
  `growth_points` int DEFAULT '0' COMMENT '成长积分',
  `redeemable_points` int DEFAULT '0' COMMENT '可兑积分',
  `registration_time` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '个人信息更新时间',
  `first_log` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '本日首次登陆',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `login_name`, `user_name`, `password`, `sex`, `growth_points`, `redeemable_points`, `registration_time`, `first_log`)
VALUES
	(1,'zhangsan','张三','123','男',20,75,'2023/6/5 13:16:22','2023/6/7 14:14:01'),
	(2,'lisi','李四','123','',1,0,NULL,'2023/6/7 20:19:30'),
	(3,'lisi1','李四1','123','',0,0,NULL,NULL),
	(5,'lisi3','李四3','123','',0,0,NULL,NULL),
	(6,'lisi4','李四4','123','',0,0,NULL,NULL),
	(7,'lisi5','李四5','123','',0,0,NULL,NULL),
	(8,'lisi6','李四6','123','',0,0,NULL,NULL),
	(9,'lisi7','李四6','123','',0,0,NULL,NULL),
	(10,'lisi8','李四8','123','',0,0,NULL,NULL),
	(11,'lisi9','李四9','123','',0,0,NULL,NULL),
	(17,'zhangsan1','张三1','123','',0,0,NULL,NULL),
	(18,'zhangsan2','张三2','123','',0,0,NULL,NULL),
	(19,'zhangsan3','张三3','123','',0,0,NULL,NULL),
	(20,'zhangsan4','张三4','123','',0,0,NULL,NULL),
	(21,'zhangsan5','张三5','123','',0,0,NULL,NULL),
	(22,'zhangsan6','张三6','123','',0,0,NULL,NULL),
	(23,'zhangsan7','张三7','123','',0,0,NULL,NULL),
	(36,'zhangsan123','张三','123','男',11,16,'2023/6/4 19:01:48','2023/6/4 19:01:33'),
	(38,'zhangsan12','张三','123','男',1,0,'2023/6/7 20:28:52','2023/6/7 20:28:48'),
	(39,'张三','zhangsan123','123','',0,0,NULL,NULL);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
