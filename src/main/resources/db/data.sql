insert into t_user(id,username,password,real_name,unit,tel,email,create_time,update_time,role_id,status,remarks) 
	values(1,'admin','123456','管理员张三','管理部','12482389299','zhangsan@qq.com',null,null,1,1,'系统管理员nb');
insert into t_user(id,username,password,real_name,unit,tel,email,create_time,update_time,role_id,status,remarks) 
	values(2,'lisi','123456','李老师','教育部','15899654878','lisi@qq.com',null,null,2,1,'我是教职工,我可以申报项目');
insert into t_user(id,username,password,real_name,unit,tel,email,create_time,update_time,role_id,status,remarks) 
	values(3,'wangwu','123456','专家王某','专家部','13365985689','wangwu@qq.com',null,null,3,1,'我是专家,我来评审');
insert into t_user(id,username,password,real_name,unit,tel,email,create_time,update_time,role_id,status,remarks) 
	values(4,'zhaoliu','123456','专家赵某','专家部','13565985689','zhaoliu@qq.com',null,null,3,1,'我是专家,我来评审');

insert into t_role(id,name,description,create_time,update_time,remarks)
	values(1,'管理员',null,null,null,null);
insert into t_role(id,name,description,create_time,update_time,remarks)
	values(2,'教职工',null,null,null,null);
insert into t_role(id,name,description,create_time,update_time,remarks)
	values(3,'评审专家',null,null,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(1,'项目','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(2,'我的项目','/project',null,1,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(3,'项目列表','/project/list',null,1,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(4,'申报管理','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(5,'规则设置','/declare/rule',null,4,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(6,'申报入口','/declare/entry',null,4,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(7,'项目初审','/declare/check',null,4,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(8,'专家分配','/declare/expertAllot',null,4,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(9,'项目评审','/declare/expertReview',null,4,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(10,'项目立项','/declare/projectSet',null,4,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(11,'中期检查','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(12,'要求设定','/mid/set',null,11,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(13,'上传材料','/mid/material',null,11,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(14,'材料评审','/mid/review',null,11,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(15,'结题验收','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(16,'要求设定','/end/set',null,15,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(17,'上传材料','/end/material',null,15,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(18,'材料评审','/end/review',null,15,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(19,'通知','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(20,'我的消息','/message',null,19,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(21,'用户管理','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(22,'用户列表','/user/list',null,21,2,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(23,'系统设置','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(24,'角色管理','/role',null,23,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(25,'菜单管理','/menu',null,23,2,null,null);

insert into t_role_menu(id,role_id,menu_id) values(1,1,1);
insert into t_role_menu(id,role_id,menu_id) values(3,1,3);
insert into t_role_menu(id,role_id,menu_id) values(4,1,4);
insert into t_role_menu(id,role_id,menu_id) values(5,1,5);
insert into t_role_menu(id,role_id,menu_id) values(7,1,7);
insert into t_role_menu(id,role_id,menu_id) values(8,1,8);
insert into t_role_menu(id,role_id,menu_id) values(10,1,10);
insert into t_role_menu(id,role_id,menu_id) values(11,1,11);
insert into t_role_menu(id,role_id,menu_id) values(12,1,12);
insert into t_role_menu(id,role_id,menu_id) values(14,1,14);
insert into t_role_menu(id,role_id,menu_id) values(15,1,15);
insert into t_role_menu(id,role_id,menu_id) values(16,1,16);
insert into t_role_menu(id,role_id,menu_id) values(18,1,18);
insert into t_role_menu(id,role_id,menu_id) values(19,1,19);
insert into t_role_menu(id,role_id,menu_id) values(20,1,20);
insert into t_role_menu(id,role_id,menu_id) values(21,1,21);
insert into t_role_menu(id,role_id,menu_id) values(22,1,22);
insert into t_role_menu(id,role_id,menu_id) values(23,1,23);
insert into t_role_menu(id,role_id,menu_id) values(24,1,24);
insert into t_role_menu(id,role_id,menu_id) values(25,1,25);

insert into t_role_menu(id,role_id,menu_id) values(26,2,1);
insert into t_role_menu(id,role_id,menu_id) values(27,2,2);
insert into t_role_menu(id,role_id,menu_id) values(28,2,4);
insert into t_role_menu(id,role_id,menu_id) values(29,2,6);
insert into t_role_menu(id,role_id,menu_id) values(30,2,11);
insert into t_role_menu(id,role_id,menu_id) values(31,2,13);
insert into t_role_menu(id,role_id,menu_id) values(32,2,15);
insert into t_role_menu(id,role_id,menu_id) values(33,2,17);
insert into t_role_menu(id,role_id,menu_id) values(34,2,19);
insert into t_role_menu(id,role_id,menu_id) values(35,2,20);

insert into t_role_menu(id,role_id,menu_id) values(36,3,4);
insert into t_role_menu(id,role_id,menu_id) values(37,3,8);
insert into t_role_menu(id,role_id,menu_id) values(38,3,19);
insert into t_role_menu(id,role_id,menu_id) values(39,3,20);


insert into t_declaration_rule(id,type,rule_content,deadline) values(1,0,'第一章  校级“三创”项目

　　第一条 校内外在读本科生均可申报，但项目最终完成时间与结项时间应早于标准学制内最早毕业的团队成员毕业时间2个月以上，并还须满足以下条件：

　　（一）项目负责人与项目成员均无尚在实施中的校级以上“三创项目”或学生科研项目。

　　（二）项目负责人应为我校学生且项目成员应全部为我校在读本科生或以我校在读本科生为主，鼓励跨专业、跨学科申报，但每位学生（包含项目负责人和项目成员）只能参与申报一个“三创”项目。

　　允许吸纳外校在读本科生加入申报团队，但外校在读本科生的占比不得超过三分之一；外校在读本科生参与申报时，应提供在读高校教务处或其他校级主管机构开具的证明，证明内容包括学籍信息（包括姓名、所在院系、所学专业、年级、学号、标准学制毕业时间等）和该生无尚在实施中的校级以上“三创项目”或学生科研项目（主持和参与均包括在内），且其参与的申报项目一旦在我校获准立项，本年度将不再允许该生申报“三创”项目或学生科研项目。

　　（三）创业训练项目和创业实践项目的负责人应是最主要、最核心的创始人（其余成员应以项目创始人身份或原始股东身份参与）。

　　已完成工商注册的申报项目，申报项目负责人应是所注册企业（公司）的法人代表，且工商注册的时间应为在我校就读期间，其余成员也应是所注册企业（公司）的股东。

　　（四）既可以学生团队（或项目小组）的形式申报，也可以学生团队加指导老师的形式申报。其中包括项目负责人在内的学生成员人数应为3-5人。加指导老师的，应获得指导老师的签字同意，且指导老师一般为1人，最多不得超过2人；当指导老师为2人时，排名第二的指导老师应由排名第一的指导老师推荐。

　　一个指导老师每年度最多只能参与申报4个“三创”项目（包括以排名第二的身份参与指导在内），指导老师参与申报的项目数超过限额的，取消其当年指导资格。

　　在校内申报阶段若无合适的指导老师，可暂不填写申报书的相关栏目，后续可由创新创业学院为其选配指导老师。','2019-01-05');

insert into t_declaration_rule(id,type,rule_content,deadline) values(2,1,'中期检查材料说明

　　第一条 校内外在读本科生均可申报，但项目最终完成时间与结项时间应早于标准学制内最早毕业的团队成员毕业时间2个月以上，并还须满足以下条件：

　　（一）项目负责人与项目成员均无尚在实施中的校级以上“三创项目”或学生科研项目。

　　（二）项目负责人应为我校学生且项目成员应全部为我校在读本科生或以我校在读本科生为主，鼓励跨专业、跨学科申报，但每位学生（包含项目负责人和项目成员）只能参与申报一个“三创”项目。

　　允许吸纳外校在读本科生加入申报团队，但外校在读本科生的占比不得超过三分之一；外校在读本科生参与申报时，应提供在读高校教务处或其他校级主管机构开具的证明，证明内容包括学籍信息（包括姓名、所在院系、所学专业、年级、学号、标准学制毕业时间等）和该生无尚在实施中的校级以上“三创项目”或学生科研项目（主持和参与均包括在内），且其参与的申报项目一旦在我校获准立项，本年度将不再允许该生申报“三创”项目或学生科研项目。

　　（三）创业训练项目和创业实践项目的负责人应是最主要、最核心的创始人（其余成员应以项目创始人身份或原始股东身份参与）。

　　已完成工商注册的申报项目，申报项目负责人应是所注册企业（公司）的法人代表，且工商注册的时间应为在我校就读期间，其余成员也应是所注册企业（公司）的股东。

　　（四）既可以学生团队（或项目小组）的形式申报，也可以学生团队加指导老师的形式申报。其中包括项目负责人在内的学生成员人数应为3-5人。加指导老师的，应获得指导老师的签字同意，且指导老师一般为1人，最多不得超过2人；当指导老师为2人时，排名第二的指导老师应由排名第一的指导老师推荐。

　　一个指导老师每年度最多只能参与申报4个“三创”项目（包括以排名第二的身份参与指导在内），指导老师参与申报的项目数超过限额的，取消其当年指导资格。

　　在校内申报阶段若无合适的指导老师，可暂不填写申报书的相关栏目，后续可由创新创业学院为其选配指导老师。','2019-02-04');

insert into t_declaration_rule(id,type,rule_content,deadline) values(3,2,'结题验收材料说明

　　第一条 校内外在读本科生均可申报，但项目最终完成时间与结项时间应早于标准学制内最早毕业的团队成员毕业时间2个月以上，并还须满足以下条件：

　　（一）项目负责人与项目成员均无尚在实施中的校级以上“三创项目”或学生科研项目。

　　（二）项目负责人应为我校学生且项目成员应全部为我校在读本科生或以我校在读本科生为主，鼓励跨专业、跨学科申报，但每位学生（包含项目负责人和项目成员）只能参与申报一个“三创”项目。

　　允许吸纳外校在读本科生加入申报团队，但外校在读本科生的占比不得超过三分之一；外校在读本科生参与申报时，应提供在读高校教务处或其他校级主管机构开具的证明，证明内容包括学籍信息（包括姓名、所在院系、所学专业、年级、学号、标准学制毕业时间等）和该生无尚在实施中的校级以上“三创项目”或学生科研项目（主持和参与均包括在内），且其参与的申报项目一旦在我校获准立项，本年度将不再允许该生申报“三创”项目或学生科研项目。

　　（三）创业训练项目和创业实践项目的负责人应是最主要、最核心的创始人（其余成员应以项目创始人身份或原始股东身份参与）。

　　已完成工商注册的申报项目，申报项目负责人应是所注册企业（公司）的法人代表，且工商注册的时间应为在我校就读期间，其余成员也应是所注册企业（公司）的股东。

　　（四）既可以学生团队（或项目小组）的形式申报，也可以学生团队加指导老师的形式申报。其中包括项目负责人在内的学生成员人数应为3-5人。加指导老师的，应获得指导老师的签字同意，且指导老师一般为1人，最多不得超过2人；当指导老师为2人时，排名第二的指导老师应由排名第一的指导老师推荐。

　　一个指导老师每年度最多只能参与申报4个“三创”项目（包括以排名第二的身份参与指导在内），指导老师参与申报的项目数超过限额的，取消其当年指导资格。

　　在校内申报阶段若无合适的指导老师，可暂不填写申报书的相关栏目，后续可由创新创业学院为其选配指导老师。','2019-02-04');

insert into t_projectinfo(id,name,apply_level,field,members,promise,director_user_id,status,declaration_material_id)
	values(1,"基于深度学习的遗传算法",1,"深度学习","胡喜乐,胡喜乐,胡喜乐","我承诺...",2,0,1);