
CREATE TABLE `t_category` (
                              `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类id',
                              `name` varchar(60) NOT NULL DEFAULT '' COMMENT '分类名称',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                              `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位：0：未删除 1：已删除',
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE KEY `uk_name` (`name`) USING BTREE,
                              KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章分类表';

CREATE TABLE `t_tag` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签id',
                         `name` varchar(60) NOT NULL DEFAULT '' COMMENT '标签名称',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                         `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位：0：未删除 1：已删除',
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE KEY `uk_name` (`name`) USING BTREE,
                         KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章标签表';

CREATE TABLE `t_blog_settings` (
                                   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                   `logo` varchar(120) NOT NULL DEFAULT '' COMMENT '博客Logo',
                                   `name` varchar(60) NOT NULL DEFAULT '' COMMENT '博客名称',
                                   `author` varchar(20) NOT NULL DEFAULT '' COMMENT '作者名',
                                   `introduction` varchar(120) NOT NULL DEFAULT '' COMMENT '介绍语',
                                   `avatar` varchar(120) NOT NULL DEFAULT '' COMMENT '作者头像',
                                   `github_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'GitHub 主页访问地址',
                                   `csdn_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'CSDN 主页访问地址',
                                   `gitee_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT 'Gitee 主页访问地址',
                                   `zhihu_homepage` varchar(60) NOT NULL DEFAULT '' COMMENT '知乎主页访问地址',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='博客设置表';

# 初始化博客设置信息记录
insert into t_blog_settings values (1, 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', '犬小哈的博客', '犬小哈', '平安喜乐', 'https://img.quanxiaoha.com/quanxiaoha/f97361c0429d4bb1bc276ab835843065.jpg', '', '', '', '')

CREATE TABLE `t_article` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
                             `title` varchar(120) NOT NULL DEFAULT '' COMMENT '文章标题',
                             `cover` varchar(120) NOT NULL DEFAULT '' COMMENT '文章封面',
                             `summary` varchar(160) DEFAULT '' COMMENT '文章摘要',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
                             `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志位：0：未删除 1：已删除',
                             `read_num` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '被阅读次数',
                             PRIMARY KEY (`id`) USING BTREE,
                             KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章表';

CREATE TABLE `t_article_content` (
                                     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章内容id',
                                     `article_id` bigint(20) NOT NULL COMMENT '文章id',
                                     `content` text COMMENT '教程正文',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     KEY `idx_article_id` (`article_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章内容表';

CREATE TABLE `t_article_tag_rel` (
                                     `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
                                     `article_id` bigint(20) unsigned NOT NULL COMMENT '文章id',
                                     `tag_id` bigint(20) unsigned NOT NULL COMMENT '标签id',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     KEY `idx_article_id` (`article_id`) USING BTREE,
                                     KEY `idx_tag_id` (`tag_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='文章对应标签关联表';

