-- ----------------------------
-- Table structure for R_USER_GROUP_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `R_USER_GROUP_ROLE`;
CREATE TABLE `R_USER_GROUP_ROLE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_GROUP_ID` int(10) DEFAULT NULL COMMENT '用户组ID',
  `ROLE_ID` int(10) DEFAULT NULL COMMENT '角色ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组角色关联表';

-- ----------------------------
-- Records of R_USER_GROUP_ROLE
-- ----------------------------

-- ----------------------------
-- Table structure for R_USER_GROUP_USER
-- ----------------------------
DROP TABLE IF EXISTS `R_USER_GROUP_USER`;
CREATE TABLE `R_USER_GROUP_USER` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_GROUP_ID` int(10) DEFAULT NULL COMMENT '用户组ID',
  `USER_ID` int(10) DEFAULT NULL COMMENT '账号ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组用户关联表';

-- ----------------------------
-- Records of R_USER_GROUP_USER
-- ----------------------------

-- ----------------------------
-- Table structure for R_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `R_USER_ROLE`;
CREATE TABLE `R_USER_ROLE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int(10) DEFAULT NULL COMMENT '账号ID',
  `ROLE_ID` int(10) DEFAULT NULL COMMENT '角色ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of R_USER_ROLE
-- ----------------------------
INSERT INTO `R_USER_ROLE` VALUES ('23', '1', '1', null, null);

-- ----------------------------
-- Table structure for S_BUTTON
-- ----------------------------
DROP TABLE IF EXISTS `S_BUTTON`;
CREATE TABLE `S_BUTTON` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '标识',
  `ICON` varchar(100) DEFAULT NULL COMMENT '图标',
  `EVENT_ACTION` varchar(50) DEFAULT NULL COMMENT '事件',
  `SHOW_NUM` int(10) DEFAULT NULL COMMENT '显示顺序',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='按钮基础表';

-- ----------------------------
-- Records of S_BUTTON
-- ----------------------------

-- ----------------------------
-- Table structure for S_DATA_BACKUP
-- ----------------------------
DROP TABLE IF EXISTS `S_DATA_BACKUP`;
CREATE TABLE `S_DATA_BACKUP` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '备份名称',
  `CREATE_TIME` varchar(50) DEFAULT NULL COMMENT '备份时间',
  `PATH` varchar(50) DEFAULT NULL COMMENT '备份路径',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库备份';

-- ----------------------------
-- Records of S_DATA_BACKUP
-- ----------------------------

-- ----------------------------
-- Table structure for S_DATA_DIC
-- ----------------------------
DROP TABLE IF EXISTS `S_DATA_DIC`;
CREATE TABLE `S_DATA_DIC` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CODE` varchar(50) DEFAULT NULL COMMENT '标识',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `VALUE` varchar(50) DEFAULT NULL COMMENT '值',
  `DES` varchar(100) DEFAULT NULL COMMENT '描述',
  `PARENT_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of S_DATA_DIC
-- ----------------------------

-- ----------------------------
-- Table structure for S_DATA_RULE
-- ----------------------------
DROP TABLE IF EXISTS `S_DATA_RULE`;
CREATE TABLE `S_DATA_RULE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `DATA_CONDITION` varchar(500) DEFAULT NULL COMMENT '语法条件',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据规则功能';

-- ----------------------------
-- Records of S_DATA_RULE
-- ----------------------------

-- ----------------------------
-- Table structure for S_DEPARTMENT
-- ----------------------------
DROP TABLE IF EXISTS `S_DEPARTMENT`;
CREATE TABLE `S_DEPARTMENT` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '部门编号',
  `SHOW_INDEX` int(10) DEFAULT NULL COMMENT '显示顺序',
  `PARENT_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of S_DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Table structure for S_MODULE
-- ----------------------------
DROP TABLE IF EXISTS `S_MODULE`;
CREATE TABLE `S_MODULE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '模块名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '模块code',
  `TYPE` int(10) DEFAULT NULL COMMENT '模块类型',
  `URL` varchar(200) DEFAULT NULL COMMENT '模块地址',
  `ICON` varchar(200) DEFAULT NULL COMMENT '模块图标',
  `PARENT_ID` int(10) DEFAULT NULL COMMENT '父模块ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  `SHOW_INDEX` int(10) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='页面模块(父菜单、子菜单、页面元素)';

-- ----------------------------
-- Records of S_MODULE
-- ----------------------------
INSERT INTO `S_MODULE` VALUES ('1', '系统管理', 'SYSTEM_MENU', '1', 'system.do', '', '0', '1', '20151124150400', '1', '20151230150611', '1');
INSERT INTO `S_MODULE` VALUES ('2', '用户管理', 'SYSTEM_USER', '2', 'systemUser.do?main', '', '1', '1', '20151124150400', '1', '20151230150623', '1');
INSERT INTO `S_MODULE` VALUES ('3', '角色管理', 'SYSTEM_ROLE', '2', 'systemRole.do?main', '', '1', '1', '20151124150400', '1', '20151230150628', '2');
INSERT INTO `S_MODULE` VALUES ('4', '菜单管理', 'SYSTEM_MOUDLE', '2', 'systemModule.do?main', '', '1', '1', '20151124150400', '1', '20151230150633', '3');

-- ----------------------------
-- Table structure for S_OPERATOR
-- ----------------------------
DROP TABLE IF EXISTS `S_OPERATOR`;
CREATE TABLE `S_OPERATOR` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `CODE` varchar(500) DEFAULT NULL COMMENT '操作code',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间2',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='操作功能';

-- ----------------------------
-- Records of S_OPERATOR
-- ----------------------------
INSERT INTO `S_OPERATOR` VALUES ('1', '显示可操作', 'show_do', '1', '20151124094400', null, null);
INSERT INTO `S_OPERATOR` VALUES ('2', '显示不可操作', 'show_undo', '1', '20151124094500', null, null);
INSERT INTO `S_OPERATOR` VALUES ('3', '不显示', 'no_show', '1', '20151124094600', null, null);

-- ----------------------------
-- Table structure for S_OPERATOR_LOG
-- ----------------------------
DROP TABLE IF EXISTS `S_OPERATOR_LOG`;
CREATE TABLE `S_OPERATOR_LOG` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '操作账号',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of S_OPERATOR_LOG
-- ----------------------------

-- ----------------------------
-- Table structure for S_PERSON_INFO
-- ----------------------------
DROP TABLE IF EXISTS `S_PERSON_INFO`;
CREATE TABLE `S_PERSON_INFO` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '姓名',
  `IDNUMBER` varchar(50) DEFAULT NULL COMMENT '身份证',
  `GENDER` varchar(50) DEFAULT NULL COMMENT '性别',
  `BIRTHDATE` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `MOBILE` varchar(50) DEFAULT NULL COMMENT '手机',
  `TEL` varchar(50) DEFAULT NULL COMMENT '座机',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `MARITAL_STATUS` varchar(50) DEFAULT NULL COMMENT '婚姻情况',
  `WORK_ADDRESS` varchar(100) DEFAULT NULL COMMENT '办公地址',
  `WORK_FAX` varchar(50) DEFAULT NULL COMMENT '办公传真',
  `NATION` varchar(50) DEFAULT NULL COMMENT '民族',
  `EDUCATION` varchar(50) DEFAULT NULL COMMENT '学历',
  `SCHOOL` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `QQ_NUM` varchar(50) DEFAULT NULL COMMENT 'qq号码',
  `WECHAT_NUM` varchar(50) DEFAULT NULL COMMENT '微信号码',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户个人信息';

-- ----------------------------
-- Records of S_PERSON_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for S_PRIVILEGE
-- ----------------------------
DROP TABLE IF EXISTS `S_PRIVILEGE`;
CREATE TABLE `S_PRIVILEGE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` int(10) DEFAULT NULL COMMENT '角色ID',
  `MODULE_ID` int(10) DEFAULT NULL COMMENT '模块ID',
  `FUNCITON_TYPE` varchar(50) DEFAULT NULL COMMENT '功能类型(1-操作 2-数据)',
  `FUNCTION_ID` int(10) DEFAULT NULL COMMENT '功能ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统权限';

-- ----------------------------
-- Records of S_PRIVILEGE
-- ----------------------------
INSERT INTO `S_PRIVILEGE` VALUES ('1', '1', '1', '1', '1', '1', '20151124150600');
INSERT INTO `S_PRIVILEGE` VALUES ('2', '1', '2', '1', '1', '1', '20151124150600');
INSERT INTO `S_PRIVILEGE` VALUES ('3', '1', '3', '1', '1', '1', '20151124150600');
INSERT INTO `S_PRIVILEGE` VALUES ('4', '1', '4', '1', '1', '1', '20151124150600');

-- ----------------------------
-- Table structure for S_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `S_ROLE`;
CREATE TABLE `S_ROLE` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `DES` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `PARENT_ID` int(10) DEFAULT '0' COMMENT '父ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of S_ROLE
-- ----------------------------
INSERT INTO `S_ROLE` VALUES ('1', '管理员', '管理员', '0', '1', '20151124093400', null, null);

-- ----------------------------
-- Table structure for S_USER
-- ----------------------------
DROP TABLE IF EXISTS `S_USER`;
CREATE TABLE `S_USER` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `LOGINNAME` varchar(50) DEFAULT NULL COMMENT '账号账号',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '账号密码',
  `NICKNAME` varchar(50) DEFAULT NULL COMMENT '账户昵称',
  `STATUS` tinyint(3) unsigned DEFAULT NULL COMMENT '账号状态',
  `LOGIN_NUM` int(10) DEFAULT NULL COMMENT '本月登录次数',
  `LOGIN_TIME` char(14) DEFAULT NULL COMMENT '本次登录时间',
  `LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '本次登录IP',
  `LAST_LOGIN_TIME` char(14) DEFAULT NULL COMMENT '上次登录时间',
  `LAST_LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '上次登录IP',
  `DEPARTMENT_ID` int(10) DEFAULT NULL COMMENT '部门ID',
  `PERSONINFO_ID` int(10) DEFAULT NULL COMMENT '个人信息ID',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统账号';

-- ----------------------------
-- Records of S_USER
-- ----------------------------
INSERT INTO `S_USER` VALUES ('1', 'admin', 'e5d49d3c11a2f3c537d2f0433992aea7', '管理员', null, null, null, null, null, null, null, null, '1', '20160113172325', null, null);

-- ----------------------------
-- Table structure for S_USER_GROUP
-- ----------------------------
DROP TABLE IF EXISTS `S_USER_GROUP`;
CREATE TABLE `S_USER_GROUP` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '用户组名称',
  `CODE` varchar(50) DEFAULT NULL COMMENT '用户组编号',
  `DES` varchar(200) DEFAULT NULL COMMENT '用户组描述',
  `PARENT_ID` int(10) DEFAULT NULL COMMENT '父ID',
  `SHOW_INDEX` int(10) DEFAULT NULL COMMENT '显示顺序',
  `CREATE_USER_ID` int(10) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` char(14) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER_ID` int(10) DEFAULT NULL COMMENT '更新用户ID',
  `UPDATE_TIME` char(14) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组';

-- ----------------------------
-- Records of S_USER_GROUP
-- ----------------------------
