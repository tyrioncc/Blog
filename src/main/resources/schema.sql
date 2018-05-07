-- Host: localhost    Database: blogdb
-- ------------------------------------------------------

drop table if exists `articles`;
create table `article`(
  `id` int(11) not null auto_increment,
  `category_id` int(11) not null comment '分类Id',
  `title` varchar(40) not null comment '标题',
  `content` longtext not null comment '内容',
  `description` varchar(500) not null comment '文章简介',
  `status` int(11) not null default '0' comment '状态 0：正常  1：不可用',
  `author` varchar(15) not null default 'author' comment '作者',
  `create_time` datetime not null comment '发表时间',
  `update_time` datetime default null comment '发表时间',
  `show_count` int(11) not null DEFAULT '0' comment '浏览量',
  primary key(`id`)
)engine=Innodb, Auto_increment = 100, default charset=utf8 comment '文章表';

insert into `article` values
(1, 0, '女神异闻录5 动画版',
'高二的春天，雨宫莲转学到了东京的「秀尽学园」。因某事为契机而觉醒为“Persona”使用者的莲，与新认识的伙伴们组建了「心之怪盗团」。怪盗团员们去盗走陷进了罪恶欲望之中的成年人们的“扭曲的欲望”，让成年人们洗心革面。同时，难以让人理解的精神暴走事件在城市中的各个角落接连发生……。以大都市“东京”为舞台，一边是身为享受日常生活的高中生、一边是放学后身为「心之怪盗团」的暗地活跃——。壮大的恶汉罗曼故事，就此一触即发！',
'高二的春天，雨宫莲转学到了东京的「秀尽学园」。因某事为契...', 1 , 'Yui_tycc', '2018-04-08 00:00:00', null, 0),
(2, 0, '我的英雄学院',
'拥有名为“个性”的超常能力的人类的存在变得理所当然的世界。与No.1英雄·欧尔麦特相遇了的“无个性”少年·绿谷出久，小出他的隐藏的英雄资质被发现，并继承了欧尔麦特的“个性”——ONE FOR ALL。而后小出成功地进入了英雄辈出的名门校·雄英高校，与同学们过着互相比试切磋琢磨的每一天。雄英高校的学生们激烈比试的大活动「雄英体育祭」、在职业英雄手下磨练技艺的「职场体验」、与“英雄杀手”斯坦因的死斗、期末考试中与欧尔麦特的战斗，然后是与敌联合的死柄木吊的邂逅…。在一个个试炼面前，目标着成为职业英雄而果敢的站了出来的出久。...',
 '拥有名为“个性”的超常能力的人类的存在变得理所当然的世界。与...', 1, 'Yui_tycc', '2018-04-07 00:00:00', null, 0);

/*
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `tag_id` int(11) NOT NULL COMMENT '标签Id',
  `tag_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签表';

INSERT INTO `article_tag` VALUES (0, 'test'),(1, 'java');
*/

drop table if exists `category`;
create table `category` (
  `id` int(11) not null auto_increment,
  `category_name` varchar(20) not null comment '分类名称  唯一',
  `sort` int(11)  not null default '0' comment '排序 （0-10）',
  primary key (`id`),
  unique key(`category_name`)
) engine =InnoDB auto_increment=10 default charset=utf8 comment='分类表';


insert into `category` values (0,'test',10), (1, 'default', 0);


drop table if exists `user`;
create table `user`(
  `id` int(11) not null,
  `user_name` varchar(20) not null,
  `password` varchar(20) not null,
  primary key(`id`),
  unique key(`user_name`)
)engine=Innodb default charset=utf8 comment='登录用户';

insert into `user` values (1, 'admin', 'password');




