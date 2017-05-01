package com.framework.system.common;

import java.util.ArrayList;
import java.util.List;

import com.framework.system.code.generate.CodeGenerate;
import com.framework.system.code.generate.ReadTable;
import com.framework.system.code.po.Columnt;
import com.framework.system.code.po.EntityInfo;
import com.framework.system.code.po.RelationInfo;

public class CreateEntity {
	public static void main(String[] sage) {
		// -----S_DEPARTMENT-----
		if (true) {
			ReadTable r = new ReadTable();
			String tableName = "s_order";
			String databaseName = "physical_examination_sys";
			String bussiPackage = "test";
			String tableInfo = "医院体检项目关系表";
			String entityName = "order";
			CodeGenerate c = new CodeGenerate();

			// 1.字段信息
			List<Columnt> columntList = r.readColumntByTableName(tableName,
					databaseName);

			// 2.实体相关信息
			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
					tableName, entityName);

			// 3.映射关系
			List<RelationInfo> relationList = new ArrayList<RelationInfo>();
			// if (true) {
			// RelationInfo relation = RelationInfo.addParentToOne();
			// relationList.add(relation);
			// }
			if (true) {
				String joinTableName = "s_medical_report";
				String joinEntityName = "medicalReport";
				String joinColumn = "medicalReport";
				RelationInfo relation = RelationInfo.addManyToOne(
						joinTableName, joinEntityName, joinColumn,
						databaseName, r);
				relationList.add(relation);
			}
			if (true) {
				String joinTableName = "s_service_person";	// 服务人员
				String joinEntityName = "servicePerson";
				String joinColumn = "servicePerson";
				RelationInfo relation = RelationInfo.addManyToOne(
						joinTableName, joinEntityName, joinColumn,
						databaseName, r);
				relationList.add(relation);
			}
//			if (true) {
//				String joinTableName = "s_medical_item";
//				String joinEntityName = "medicalItem";
//				String joinColumn = "medicalItem";
//				RelationInfo relation = RelationInfo.addOneToMany(
//						joinTableName, joinEntityName, databaseName, r);
//				relationList.add(relation);
//			}

			// 4，生成代码
			c.generatorCodeMessage(columntList, entityInfo, relationList);
		}
		// //----S_PERSON_INFO----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "s_medical_item";
		// String databaseName="physical_examination_sys";
		// String bussiPackage="test";
		// String tableInfo="体检项目";
		// String entityName="medicalItem";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_USER_GROUP----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_USER_GROUP";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="用户组";
		// String entityName="userGroup";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// RelationInfo relation = RelationInfo.addParentToOne();
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String manyToManyTableName="R_USER_GROUP_USER";
		// String joinTableName="S_USER";
		// String joinEntityName="user";
		// String jionFirst="Y";
		// RelationInfo relation =
		// RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----R_USER_GROUP_USER----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "R_USER_GROUP_USER";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="用户组用户关联表";
		// String entityName="userGroupUser";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----R_USER_GROUP_ROLE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "R_USER_GROUP_ROLE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="用户组角色关联表";
		// String entityName="userGroupRole";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----R_USER_ROLE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "R_USER_ROLE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="用户角色关联表";
		// String entityName="userRole";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "user";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_ROLE";
		// String joinEntityName = "role";
		// String joinColumn = "role";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_USER----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_USER";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="系统账号";
		// String entityName="user";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_DEPARTMENT";
		// String joinEntityName = "department";
		// String joinColumn = "department";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_PERSON_INFO";
		// String joinEntityName = "personInfo";
		// String joinColumn = "personinfo";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String manyToManyTableName="R_USER_GROUP_USER";
		// String joinTableName="S_USER_GROUP";
		// String joinEntityName="userGroup";
		// String jionFirst="N";
		// RelationInfo relation =
		// RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_ROLE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_ROLE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="系统角色";
		// String entityName="role";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// RelationInfo relation = RelationInfo.addParentToOne();
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_MODULE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_MODULE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="页面模块(父菜单、子菜单、页面元素)";
		// String entityName="module";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// RelationInfo relation = RelationInfo.addParentToOne();
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_OPERATOR----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_OPERATOR";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="操作功能";
		// String entityName="operator";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_DATA_RULE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_DATA_RULE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="数据规则功能";
		// String entityName="dataRule";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //----S_PRIVILEGE----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_PRIVILEGE";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="系统权限";
		// String entityName="privilege";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// String joinTableName="S_ROLE";
		// String joinEntityName = "role";
		// String joinColumn = "role";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_MODULE";
		// String joinEntityName = "module";
		// String joinColumn = "module";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
		// //-----S_DATA_DIC-----
		// if(true){
		// ReadTable r = new ReadTable();
		// String tableName = "S_DATA_DIC";
		// String databaseName="WHF-2016-04-18";
		// String bussiPackage="catfly";
		// String tableInfo="数据字典";
		// String entityName="dataDic";
		// CodeGenerate c= new CodeGenerate();
		//
		// //1.字段信息
		// List<Columnt> columntList =
		// r.readColumntByTableName(tableName,databaseName);
		//
		// //2.实体相关信息
		// EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo,
		// tableName, entityName);
		//
		// //3.映射关系
		// List<RelationInfo> relationList = new ArrayList<RelationInfo>();
		// if(true){
		// RelationInfo relation = RelationInfo.addParentToOne();
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "createUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		// if(true){
		// String joinTableName="S_USER";
		// String joinEntityName = "user";
		// String joinColumn = "updateUser";
		// RelationInfo relation =
		// RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);
		// relationList.add(relation);
		// }
		//
		// //4，生成代码
		// c.generatorCodeMessage(columntList, entityInfo,relationList);
		// }
	}
}
