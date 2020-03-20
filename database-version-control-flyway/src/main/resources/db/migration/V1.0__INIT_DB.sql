--迁移脚本要遵循文件命名格式，
--Prefix 前缀：V 为版本迁移，U 为回滚迁移，R 为可重复迁移。
--Version 版本号：每一个迁移脚本，都需要一个对应一个唯一的版本号。而脚本的执行顺序，按照版本号的顺序。一般情况下，我们使用数字自增即可。
--Separator 分隔符：两个 _ ，即 __ 。可配置，不过一般不配置。
--Description 描述：描述脚本的用途。在我们的示例中，我们使用 INIT_DB

-- 创建用户表
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 插入一条数据
INSERT INTO `users`(username, password, create_time) VALUES('yudaoyuanma', 'password', now());