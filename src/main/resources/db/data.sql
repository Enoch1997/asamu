insert into t_user(id,username,password,realName,unit,tel,email,create_time,update_time,role_id,status,remarks) 
	values(1,'admin','123456','小明','教育部','110','34@qq.com',null,null,1,1,null);

insert into t_role(id,name,description,create_time,update_time,remarks)
	values(1,'管理员',null,null,null,null);

insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(1,'项目','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(2,'我的项目','/welcome',null,1,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(3,'通知','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(4,'我的消息','/message',null,3,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(5,'用户管理','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(6,'用户列表','/user',null,5,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(7,'申报管理','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(8,'规则设置','/declare/rule',null,7,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(9,'申报入口','/declare/entry',null,7,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(10,'系统设置','',null,0,1,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(11,'角色管理','/role',null,10,2,null,null);
insert into t_menu(id,name,uri,description,pid,menu_level,create_time,update_time) 
			values(12,'菜单管理','/menu',null,10,2,null,null);

insert into t_role_menu(id,role_id,menu_id) values(1,1,1);
insert into t_role_menu(id,role_id,menu_id) values(2,1,2);
insert into t_role_menu(id,role_id,menu_id) values(3,1,3);
insert into t_role_menu(id,role_id,menu_id) values(4,1,4);
insert into t_role_menu(id,role_id,menu_id) values(5,1,5);
insert into t_role_menu(id,role_id,menu_id) values(6,1,6);
insert into t_role_menu(id,role_id,menu_id) values(7,1,7);
insert into t_role_menu(id,role_id,menu_id) values(8,1,9);
insert into t_role_menu(id,role_id,menu_id) values(9,1,9);
insert into t_role_menu(id,role_id,menu_id) values(10,1,10);
insert into t_role_menu(id,role_id,menu_id) values(11,1,11);
insert into t_role_menu(id,role_id,menu_id) values(12,1,12);

insert into t_declaration_rule(id,rule_content,deadline) values(1,'申报规则1231321',null);