drop table if exists t_user;
drop table if exists t_role_menu;
drop table if exists t_role;
drop table if exists t_menu;
drop table if exists t_projectinfo;
drop table if exists t_material;
drop table if exists t_declaration_rule;
drop table if exists t_expert_review;
drop table if exists t_material_review;
drop table if exists t_message;


##########################
##用户表t_user
##########################
create table t_user(
	id				int unsigned auto_increment comment '主键id',
	username		varchar(50) not null comment '用户名',
	password		varchar(50) not null comment '密码',
	realName		varchar(50) comment '真实姓名',
	unit			varchar(50) comment '所属部门',
	tel 			varchar(20) comment '手机号',
	email  			varchar(50) comment '邮箱',
	create_time		datetime comment '创建时间',
	update_time		datetime comment '更新时间',
	role_id			int comment '用户角色',
	status			tinyint unsigned default '1' comment '状态：0表示不可用,1可用',
	remarks			varchar(255) comment '备注',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='用户表';


##########################
##角色表t_role
##########################
create table t_role(
	id				int unsigned auto_increment comment '主键id',
	name			varchar(50) not null comment '角色名称',
	description		varchar(255) comment '描述',
	create_time		datetime comment '创建时间',
	update_time		datetime comment '更新时间',
	remarks			varchar(255) comment '备注',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='角色表';




##########################
##菜单表t_menu
##########################
create table t_menu(
	id				int unsigned auto_increment comment '主键id',
	name			varchar(50) not null comment '菜单名称',
	uri				varchar(255) comment '菜单uri',
	description		varchar(255) comment '描述',
	pid				int unsigned default '0' comment '父菜单id',
	menu_level		tinyint unsigned default '1' comment '菜单层级',
	create_time		datetime comment '创建时间',
	update_time		datetime comment '更新时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='菜单表';


##########################
##角色菜单关系表t_role_menu
##########################
create table t_role_menu(
	id 					int unsigned auto_increment comment '主键id',
	role_id			int unsigned comment '角色id',
	menu_id			int unsigned comment '菜单id',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='角色菜单关系表';




##########################
##项目信息表t_projectinfo
##########################
create table t_projectinfo(
	id 					int unsigned auto_increment comment '主键id',
	name 				varchar(50) not null comment '项目名称',
	apply_level			tinyint unsigned not null comment '申报级别:1校级一类2校级二类',
	field				varchar(50) comment '所属专业或领域',
	members				varchar(255) comment '项目成员：成员用户,(英文逗号)隔开',
	promise 			varchar(1000) comment '立项承诺',
	director_user_id	int unsigned not null comment '负责人id',
	director_tel		varchar(20) comment '负责人联系电话',
	director_email		varchar(50) comment '联系邮箱',
	status				tinyint unsigned comment '项目状态',
	declaration_material_id	int unsigned comment '申报书',
	midterm_material_id	int unsigned comment '中期检查材料',
	end_material_id		int unsigned comment '结题验收材料',
	create_time   		datetime comment '创建时间',
	update_time			datetime comment '更新时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='项目信息表';
##ps::项目状态:0保存1已提交2初审通过3立项评审中4立项评审完成
##			  5立项6不立项7中期检查通过8中期检查待整9已结题10结题验收整改




##########################
##申报规则表t_declaration_rule
##########################
create table t_declaration_rule(
	id				int unsigned auto_increment comment '主键id',
	rule_content	varchar(1000) comment '申报规则内容',
	deadline		date comment '截止期限',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='申报规则表';


##########################
##专家评审表t_expert_review
##########################
create table t_expert_review(
	id				int unsigned auto_increment comment '主键编号',
	project_id 		int unsigned not null comment '项目id',
	score			int unsigned comment '评分',
	comment 		varchar(255) comment '评语',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='专家评审表';



##########################
##材料表t_material
##########################
create table t_material(
	id				int unsigned auto_increment comment '主键编号',
	name			varchar(50)   not null comment '材料名',
	url				varchar(255) comment 'url',
	create_time		datetime comment '上传时间',
	description 	varchar(255) comment '描述',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='材料表';


##########################
##项目材料审查表t_material_review
##########################
create table t_material_review(
	id 						int unsigned auto_increment comment '主键id',
	project_id 				int unsigned not null comment '项目id',
	project_name 			varchar(50) comment '项目名称',
	project_period			tinyint unsigned not null comment '项目阶段:1中期检查2结题答辩',
	finish_time 			datetime comment '完成时间',
	deadline				datetime comment '截止期限',
	material_description	varchar(255) comment '需要上传材料说明',
	review_result			tinyint unsigned comment '审查结果:0未处理1通过2驳回',
	reject_reason			varchar(255) comment '驳回理由',
	primary key(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='项目材料审查表';




##########################
##站内消息表t_message
##########################
create table t_message(
	id					int unsigned auto_increment comment '消息编号',
	title				varchar(50) not null comment '标题',
	receiver_user_id	int unsigned not null comment '接收者id',
	content				varchar(255) comment '消息内容',
	create_time    		datetime comment '创建时间',
	is_read				tinyint comment '是否已读:0未读1已读' default '0',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='站内消息表';





