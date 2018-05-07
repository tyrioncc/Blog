use blogdb;

drop table if exists articles;
create table articles(
id int unique key auto_increment,
title varchar(30) not null,
head varchar(50) not null,
create_time timestamp not null default current_timestamp(),
edit_time timestamp not null default current_timestamp(),
content text not null
);

insert into articles(title, head, create_time, content) values
('女神异闻录5 动画版', '高二的春天，雨宫莲转学到了东京的「秀尽学园」。因某事为契...', '20180408000000',
'高二的春天，雨宫莲转学到了东京的「秀尽学园」。因某事为契机而觉醒为“Persona”使用者的莲，与新认识的伙伴们组建了「心之怪盗团」。怪盗团员们去盗走陷进了罪恶欲望之中的成年人们的“扭曲的欲望”，让成年人们洗心革面。同时，难以让人理解的精神暴走事件在城市中的各个角落接连发生……。以大都市“东京”为舞台，一边是身为享受日常生活的高中生、一边是放学后身为「心之怪盗团」的暗地活跃——。壮大的恶汉罗曼故事，就此一触即发！'),
('我的英雄学院', '拥有名为“个性”的超常能力的人类的存在变得理所当然的世界。与...','20180407000000',
'拥有名为“个性”的超常能力的人类的存在变得理所当然的世界。与No.1英雄·欧尔麦特相遇了的“无个性”少年·绿谷出久，小出他的隐藏的英雄资质被发现，并继承了欧尔麦特的“个性”——ONE FOR ALL。而后小出成功地进入了英雄辈出的名门校·雄英高校，与同学们过着互相比试切磋琢磨的每一天。雄英高校的学生们激烈比试的大活动「雄英体育祭」、在职业英雄手下磨练技艺的「职场体验」、与“英雄杀手”斯坦因的死斗、期末考试中与欧尔麦特的战斗，然后是与敌联合的死柄木吊的邂逅…。在一个个试炼面前，目标着成为职业英雄而果敢的站了出来的出久。...');