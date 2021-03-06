package sbtj.entity;

import java.util.ArrayList;
import java.util.List;

import com.framework.system.code.generate.CodeGenerate;
import com.framework.system.code.generate.ReadTable;
import com.framework.system.code.po.Columnt;
import com.framework.system.code.po.EntityInfo;
import com.framework.system.code.po.RelationInfo;

public class CreateEntity {
	
	public static void main(String[] sage) {
		CreateEntity c = new CreateEntity();
		c.create();
	}
	
	public static void create() {	
		
//		//-----B_OLDER-----
		if(true){
			ReadTable r = new ReadTable();
	        String tableName = "B_OLDER";
	        String databaseName="WHF-2016-04-18_WECHAT";
	        String bussiPackage="fsk";
	        String tableInfo="老人信息表";
	        String entityName="older";
	        CodeGenerate c= new CodeGenerate();
	        
	        //1.字段信息
			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
			
			//2.实体相关信息
			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
			
			//3.映射关系
			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
			if(true){
				String joinTableName="S_USER";						
				String joinEntityName = "user";
				String joinColumn = "user";					
				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
				relationList.add(relation);
			}		
			if(true){
				String joinTableName="B_EMPLOYEE";						
				String joinEntityName = "employee";
				String joinColumn = "nurseEmployee";					
				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_OLDER_SITE";						
				String joinEntityName = "olderSite";		
				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_OLDER_ADDRESS";						
				String joinEntityName = "olderAddress";		
				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_OLDER_CONTACT";						
				String joinEntityName = "olderContact";		
				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_CASE_RECORD";						
				String joinEntityName = "caseRecord";		
				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_DAILY_LIFE";						
				String joinEntityName = "dailyLife";		
				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
				relationList.add(relation);
			}
			if(true){
				String manyToManyTableName="R_OLDER_PRINCIPAL_EMPLOYEE";
				String joinTableName="B_EMPLOYEE";
				String joinEntityName="employee";
				String jionFirst="Y";						
				RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
				relationList.add(relation);
			}
			
			//4，生成代码
			c.generatorCodeMessage(columntList, entityInfo,relationList);
		}
//				//-----B_EMPLOYEE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_EMPLOYEE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="员工信息表";
//			        String entityName="employee";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="S_USER";						
//						String joinEntityName = "user";
//						String joinColumn = "user";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					
//					if(true){
//						String joinTableName="B_EMPLOYEE";						
//						String joinEntityName = "employee";
//						String joinColumn = "leaderEmployee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					if(true){
//						String joinTableName="B_WECHAT";						
//						String joinEntityName = "wechat";
//						String joinColumn = "wechat";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//				    }
//					if(true){
//						String manyToManyTableName="R_SITE_EMPLOYEE";
//						String joinTableName="B_SITE";
//						String joinEntityName="site";
//						String jionFirst="N";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					if(true){
//						String manyToManyTableName="R_EMPLOYEE_POSITIONAL_TITLE";
//						String joinTableName="S_DATA_DIC";
//						String joinEntityName="dataDic";
//						String jionFirst="Y";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "firstDepartment";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "secondDepartment";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				
//				//-----B_SITE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SITE";
//			        String databaseName="WHF-2016-04-18_WECHAT";
//			        String bussiPackage="fsk";
//			        String tableInfo="站点信息表";
//			        String entityName="site";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_EMPLOYEE";						
//						String joinEntityName = "employee";
//						String joinColumn = "masterEmployee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "province";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "city";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "area";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "street";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					
//					if(true){
//						String manyToManyTableName="R_SITE_EMPLOYEE";
//						String joinTableName="B_EMPLOYEE";
//						String joinEntityName="employee";
//						String jionFirst="Y";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					if(true){
//						String manyToManyTableName="R_SITE_SERVICE_AREA";
//						String joinTableName="S_DATA_DIC";
//						String joinEntityName="dataDic";
//						String jionFirst="Y";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					if(true){
//					String joinTableName="B_OLDER_SITE";						
//					String joinEntityName = "OlderSite";		
//					RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//					relationList.add(relation);
//				}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				
//				
//				
//				//-----B_OLDER_CONTACT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_OLDER_CONTACT";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="老人联系人表";
//			        String entityName="olderContact";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}					
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_OLDER_CONTACT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_OLDER_ADDRESS";
//			        String databaseName="WHF-2016-04-18_WECHAT";
//			        String bussiPackage="fsk";
//			        String tableInfo="老人地址表";
//			        String entityName="olderAddress";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}					
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_CASE_RECORD-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_CASE_RECORD";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="病例记录";
//			        String entityName="caseRecord";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_MEDICAL_HISTORY";						
//						String joinEntityName = "medicalHistory";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----R_OLDER_PRINCIPAL_EMPLOYEE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "R_OLDER_PRINCIPAL_EMPLOYEE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="老人医师员工关联表";
//			        String entityName="olderPrincipalEmployee";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_EMPLOYE";						
//						String joinEntityName = "employee";
//						String joinColumn = "principalEmployee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				
//				//-----R_SITE_EMPLOYEE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "R_SITE_EMPLOYEE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="站点员工关联表";
//			        String entityName="siteEmployee";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SITE";						
//						String joinEntityName = "site";
//						String joinColumn = "site";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_EMPLOYE";						
//						String joinEntityName = "employee";
//						String joinColumn = "employee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----R_SITE_SERVICE_AREA-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "R_SITE_SERVICE_AREA";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="站点服务区域关联表";
//			        String entityName="siteServiceArea";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SITE";						
//						String joinEntityName = "site";
//						String joinColumn = "site";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "serviceStreet";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----R_EMPLOYEE_POSITIONAL_TITLE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "R_EMPLOYEE_POSITIONAL_TITLE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="员工职称关联表";
//			        String entityName="employeePositionalTitle";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_EMPLOYE";						
//						String joinEntityName = "employee";
//						String joinColumn = "employee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "positionalTitle";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_ADL-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_ADL";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="ADL量表";
//			        String entityName="adl";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_NUTRITION-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_NUTRITION";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="营养风险评估量表";
//			        String entityName="nutrition";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_FALL-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_FALL";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="跌倒风险评估";
//			        String entityName="fall";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_MMSE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_MMSE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="MMSE量表";
//			        String entityName="mmse";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_SORE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SORE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="压疮风险评估";
//			        String entityName="sore";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_RECOVERY-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_RECOVERY";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="康复评估";
//			        String entityName="recovery";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();	
//					if(true){
//						String joinTableName="B_SKIN_LESIONS";						
//						String joinEntityName = "skinLesions";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_HEALTH_REPORT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_HEALTH_REPORT";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="健康评估报告";
//			        String entityName="healthReport";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();	
//					if(true){
//						String joinTableName="B_EMPLOYE";						
//						String joinEntityName = "employee";
//						String joinColumn = "employee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					if(true){
//						String joinTableName="B_HEALTH_REPORT_PHOTO";						
//						String joinEntityName = "healthReportPhoto";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}			
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				
//		//-----B_FCA-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_FCA";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="功能综合评定";
//	        String entityName="fca";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//				//-----B_HEALTH_ASSESSMENT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_HEALTH_ASSESSMENT";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="健康评估";
//			        String entityName="healthAssessment";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();	
//					if(true){
//						String joinTableName="B_EMPLOYE";						
//						String joinEntityName = "employee";
//						String joinColumn = "employee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_HEALTH_REPORT";						
//						String joinEntityName = "healthReport";
//						String joinColumn = "healthReport";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_RECOVERY";						
//						String joinEntityName = "recovery";
//						String joinColumn = "recovery";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_ADL";						
//						String joinEntityName = "adl";
//						String joinColumn = "adl";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_NUTRITION";						
//						String joinEntityName = "nutrition";
//						String joinColumn = "nutrition";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_FALL";						
//						String joinEntityName = "fall";
//						String joinColumn = "fall";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SORE";						
//						String joinEntityName = "sore";
//						String joinColumn = "sore";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_MMSE";						
//						String joinEntityName = "mmse";
//						String joinColumn = "mmse";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_MAS";						
//						String joinEntityName = "mas";
//						String joinColumn = "mas";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_BARTHEL";						
//						String joinEntityName = "barthel";
//						String joinColumn = "barthel";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_FCA";						
//						String joinEntityName = "fca";
//						String joinColumn = "fca";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_PHYSIOLOGICAL_PARAMETERS_CURRENT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_PHYSIOLOGICAL_PARAMETERS_CURRENT";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="生理参数当前表";
//			        String entityName="physiologicalParametersCurrent";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_PHYSIOLOGICAL_PARAMETERS_CURRENT-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_PHYSIOLOGICAL_PARAMETERS_HISTORY";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="生理参数历史表";
//			        String entityName="physiologicalParametersHistory";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_DAILY_LIFE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_DAILY_LIFE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="日常生活记录";
//			        String entityName="dailyLife";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_HEALTH_REPORT_PHOTO-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_HEALTH_REPORT_PHOTO";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="健康报告图片";
//			        String entityName="healthReportPhoto";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_HEALTH_REPORT";						
//						String joinEntityName = "healthReport";
//						String joinColumn = "healthReport";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//				    }			
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_SKIN_LESIONS-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SKIN_LESIONS";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="压疮列表";
//			        String entityName="skinLesions";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_RECOVERY";						
//						String joinEntityName = "recovery";
//						String joinColumn = "recovery";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}		
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_MAS-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_MAS";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="运动功能评定MAS";
//			        String entityName="mas";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				//-----B_BARTHEL-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_BARTHEL";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="日常生活评定";
//			        String entityName="barthel";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//				}
//				
//				//-----B_ASSESSMENT_LOG-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_ASSESSMENT_LOG";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="评估操作日志";
//			        String entityName="assessmentLog";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_ASSESSMENT_TASK";						
//						String joinEntityName = "assessmentTask";
//						String joinColumn = "assessmentTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				
//				//-----B_ASSESSMENT_TASK-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_ASSESSMENT_TASK";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="评估任务";
//			        String entityName="assessmentTask";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_HEALTH_ASSESSMENT";						
//						String joinEntityName = "healthAssessment";
//						String joinColumn = "healthAssessment";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_EMPLOYEE";						
//						String joinEntityName = "employee";
//						String joinColumn = "distributeEmployee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_EMPLOYEE";						
//						String joinEntityName = "employee";
//						String joinColumn = "assessmentEmployee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_ASSESSMENT_LOG";						
//						String joinEntityName = "assessmentLog";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_MEDICAL_HISTORY-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_MEDICAL_HISTORY";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="既往病史";
//			        String entityName="medicalHistory";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_CASE_RECORD";						
//						String joinEntityName = "caseRecord";
//						String joinColumn = "caseRecord";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}				
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE";
//			        String databaseName="WHF-2016-04-18_WECHAT";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务项目";
//			        String entityName="service";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "type";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_SERVICE_CHILD";						
//						String joinEntityName = "serviceChild";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SERVICE_PHOTO";						
//						String joinEntityName = "servicePhoto";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_CHILD-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_CHILD";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务子项";
//			        String entityName="serviceChild";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE";						
//						String joinEntityName = "service";
//						String joinColumn = "service";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_PHOTO-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_PHOTO";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务项目图片";
//			        String entityName="servicePhoto";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE";						
//						String joinEntityName = "service";
//						String joinColumn = "service";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_TASK_PHOTO-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_TASK_PHOTO";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务照片";
//			        String entityName="serviceTaskPhoto";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_EDEMA_CONDITION-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_EDEMA_CONDITION";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="水肿情况";
//			        String entityName="edemaCondition";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SITUATION_OBSERVATION-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SITUATION_OBSERVATION";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="全身情况观察";
//			        String entityName="situationObservation";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_EMPLOYEE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_EMPLOYEE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务人员";
//			        String entityName="serviceEmployee";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					if(true){
//						String joinTableName="B_EMPLOYEE";						
//						String joinEntityName = "employee";
//						String joinColumn = "employee";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_LOG-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_LOG";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务日志";
//			        String entityName="serviceLog";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}			
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_TASK_SERVICE-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_TASK_SERVICE";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务工单和服务项中间表";
//			        String entityName="serviceTaskService";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SERVICE";						
//						String joinEntityName = "service";
//						String joinColumn = "service";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_TASK_PHYSIOLOGICAL_PARAMETERS_HISTORY-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_TASK_PHYSIOLOGICAL_PARAMETERS_HISTORY";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务工单生理参数历史关联表";
//			        String entityName="serviceTaskPhysiologicalParametersHistory";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_SERVICE_TASK";						
//						String joinEntityName = "serviceTask";
//						String joinColumn = "serviceTask";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_PHYSIOLOGICAL_PARAMETERS_HISTORY";						
//						String joinEntityName = "physiologicalParametersHistory";
//						String joinColumn = "physiologicalParametersHistory";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SERVICE_TASK-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SERVICE_TASK";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="服务工单";
//			        String entityName="serviceTask";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//					if(true){
//						String joinTableName="B_OLDER";						
//						String joinEntityName = "older";
//						String joinColumn = "older";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_WECHAT";						
//						String joinEntityName = "wechat";
//						String joinColumn = "addPersonWechat";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SITE";						
//						String joinEntityName = "site";
//						String joinColumn = "site";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "serviceArea";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="S_DATA_DIC";						
//						String joinEntityName = "dataDic";
//						String joinColumn = "serviceStreet";					
//						RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//						relationList.add(relation);
//					}	
//					if(true){
//						String joinTableName="B_SERVICE_TASK_PHOTO";						
//						String joinEntityName = "serviceTaskPhoto";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_EDEMA_CONDITION";						
//						String joinEntityName = "edemaCondition";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SITUATION_OBSERVATION";						
//						String joinEntityName = "situationObservation";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SERVICE_LOG";						
//						String joinEntityName = "serviceLog";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_DAILY_LIFE_ASK";						
//						String joinEntityName = "dailyLifeAsk";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String joinTableName="B_SERVICE_EMPLOYEE";						
//						String joinEntityName = "serviceEmployee";		
//						RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//						relationList.add(relation);
//					}
//					if(true){
//						String manyToManyTableName="B_SERVICE_TASK_SERVICE";
//						String joinTableName="B_SERVICE";
//						String joinEntityName="service";
//						String jionFirst="Y";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					if(true){
//						String manyToManyTableName="B_SERVICE_TASK_PHYSIOLOGICAL_PARAMETERS_HISTORY";
//						String joinTableName="B_PHYSIOLOGICAL_PARAMETERS_HISTORY";
//						String joinEntityName="physiologicalParametersHistory";
//						String jionFirst="Y";						
//						RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//						relationList.add(relation);
//					}
//					
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//				//-----B_SOFT_INFO-----
//				if(true){
//					ReadTable r = new ReadTable();
//			        String tableName = "B_SOFT_INFO";
//			        String databaseName="WHF-2016-04-18";
//			        String bussiPackage="fsk";
//			        String tableInfo="软件版本管理";
//			        String entityName="softInfo";
//			        CodeGenerate c= new CodeGenerate();
//			        
//			        //1.字段信息
//					List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//					
//					//2.实体相关信息
//					EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//					
//					//3.映射关系
//					List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//				
//					//4，生成代码
//					c.generatorCodeMessage(columntList, entityInfo,relationList);
//					
//				}
//                
//		
		//-----B_EMPLOYEE_DISTRIBUTION-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EMPLOYEE_DISTRIBUTION";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="护工分配列表";
//	        String entityName="employeeDistribution";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "chargeEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_NURSING_PLAN_SERVICE";						
//				String joinEntityName = "nursingPlanService";
//				String joinColumn = "nursingPlanService";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}
		//-----B_NURSING_PLAN_SERVICE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_NURSING_PLAN_SERVICE";
//	        String databaseName="WHF-2016-04-18_WECHAT";
//	        String bussiPackage="fsk";
//	        String tableInfo="护理计划服务项目";
//	        String entityName="nursingPlanService";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_NURSING_PLAN";						
//				String joinEntityName = "nursingPlan";
//				String joinColumn = "nursingPlan";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_SERVICE";						
//				String joinEntityName = "service";
//				String joinColumn = "service";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_EMPLOYEE_DISTRIBUTION";						
//				String joinEntityName = "employeeDistribution";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}
//		//-----B_NURSING_PLAN-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_NURSING_PLAN";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="护理计划";
//	        String entityName="nursingPlan";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "addEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_NURSING_PLAN_SERVICE";						
//				String joinEntityName = "nursingPlanService";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}
//		//-----B_DAILY_LIFE_ASK-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_DAILY_LIFE_ASK";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="日常生活问询";
//	        String entityName="dailyLifeAsk";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_SERVICE_TASK";						
//				String joinEntityName = "serviceTask";
//				String joinColumn = "serviceTask";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}	
//		//-----B_WECHAT-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_WECHAT";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="微信信息表";
//	        String entityName="wechat";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String manyToManyTableName="R_OLDER_WECHAT";
//				String joinTableName="B_OLDER";
//				String joinEntityName="older";
//				String jionFirst="N";						
//				RelationInfo relation = RelationInfo.addManyToMany(manyToManyTableName,joinTableName,joinEntityName,jionFirst,databaseName,r);													
//				relationList.add(relation);
//			}
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----R_OLDER_WECHAT-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "R_OLDER_WECHAT";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="老人微信关联表";
//	        String entityName="olderWechat";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_WECHAT";						
//				String joinEntityName = "wechat";
//				String joinColumn = "wechat";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}	
//		//-----B_DEV-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_DEV";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="设备信息表";
//	        String entityName="dev";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_DEV_ALARM-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_DEV_ALARM";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="设备报警信息表";
//	        String entityName="devAlarm";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_DEV";						
//				String joinEntityName = "dev";
//				String joinColumn = "dev";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_DEV_POS-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_DEV_POS";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="设备位置历史信息表";
//	        String entityName="devPos";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_DEV";						
//				String joinEntityName = "dev";
//				String joinColumn = "dev";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_DATA-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_DATA";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检数据信息表";
//	        String entityName="examinationData";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EXAMINATION_RECORD";						
//				String joinEntityName = "examinationRecord";
//				String joinColumn = "examinationRecord";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="S_DATA_DIC";						
//				String joinEntityName = "dataDic";
//				String joinColumn = "type1DataDic";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="S_DATA_DIC";						
//				String joinEntityName = "dataDic";
//				String joinColumn = "type2DataDic";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EXAMINATION_DATA_FILE";						
//				String joinEntityName = "examinationDataFile";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			if(true){
//				String joinTableName="B_EXAMINATION_DATA_PHOTO";						
//				String joinEntityName = "examinationDataPhoto";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_DATA_FILE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_DATA_FILE";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检数据文件信息表";
//	        String entityName="examinationDataFile";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EXAMINATION_DATA";						
//				String joinEntityName = "examinationData";
//				String joinColumn = "examinationData";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_DATA_PHOTO-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_DATA_PHOTO";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检数据图片信息表";
//	        String entityName="examinationDataPhoto";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EXAMINATION_DATA";						
//				String joinEntityName = "examinationData";
//				String joinColumn = "examinationData";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_RECORD-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_RECORD";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检记录信息表";
//	        String entityName="examinationRecord";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "createEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}			
//			if(true){
//				String joinTableName="B_EXAMINATION_RECORD_FILE";						
//				String joinEntityName = "examinationRecordFile";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			if(true){
//				String joinTableName="B_EXAMINATION_RECORD_PHOTO";						
//				String joinEntityName = "examinationRecordPhoto";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			if(true){
//				String joinTableName="B_EXAMINATION_DATA";						
//				String joinEntityName = "examinationData";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_RECORD_FILE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_RECORD_FILE";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检记录文件信息表";
//	        String entityName="examinationRecordFile";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EXAMINATION_RECORD";						
//				String joinEntityName = "examinationRecord";
//				String joinColumn = "examinationRecord";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_EXAMINATION_RECORD_PHOTO-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_EXAMINATION_RECORD_PHOTO";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="体检记录图片信息表";
//	        String entityName="examinationRecordPhoto";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			if(true){
//				String joinTableName="B_EXAMINATION_RECORD";						
//				String joinEntityName = "examinationRecord";
//				String joinColumn = "examinationRecord";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_SEND_RECEIVE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_SEND_RECEIVE";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="交接班记录";
//	        String entityName="sendReceive";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_SITE";						
//				String joinEntityName = "site";
//				String joinColumn = "serviceSite";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "sendEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "receiveEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "superviseEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}						
//			if(true){
//				String joinTableName="B_SEND_RECEIVE_PHOTO";						
//				String joinEntityName = "sendReceivePhoto";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }
//			if(true){
//				String joinTableName="B_SEND_RECEIVE_CAREFUL";						
//				String joinEntityName = "sendReceiveCareful";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_SEND_RECEIVE_PHOTO-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_SEND_RECEIVE_PHOTO";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="交接班图片";
//	        String entityName="sendReceivePhoto";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_SEND_RECEIVE";						
//				String joinEntityName = "sendReceive";
//				String joinColumn = "sendReceive";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}						
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_SEND_RECEIVE_CAREFUL-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_SEND_RECEIVE_CAREFUL";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="交接班注意事项";
//	        String entityName="sendReceiveCareful";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_SEND_RECEIVE";						
//				String joinEntityName = "sendReceive";
//				String joinColumn = "sendReceive";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_SEND_RECEIVE_CAREFUL_PHOTO";						
//				String joinEntityName = "sendReceiveCarefulPhoto";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }	
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_SEND_RECEIVE_CAREFUL_PHOTO-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_SEND_RECEIVE_CAREFUL_PHOTO";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="交接班图片";
//	        String entityName="sendReceiveCarefulPhoto";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_SEND_RECEIVE_CAREFUL";						
//				String joinEntityName = "sendReceiveCareful";
//				String joinColumn = "sendReceiveCareful";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}						
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_MED_PLAN-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_MED_PLAN";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="服药计划";
//	        String entityName="medPlan";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_MED_NOTICE";						
//				String joinEntityName = "medNotice";		
//				RelationInfo relation = RelationInfo.addOneToMany(joinTableName, joinEntityName, databaseName, r);						
//				relationList.add(relation);
//		    }	
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_MED_NOTICE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_MED_NOTICE";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="服药提醒";
//	        String entityName="medNotice";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_MED_PLAN";						
//				String joinEntityName = "medPlan";
//				String joinColumn = "medPlan";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}						
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_RECHARGE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_RECHARGE";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="充值记录";
//	        String entityName="recharge";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_SERVICE";						
//				String joinEntityName = "service";
//				String joinColumn = "service";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}	
//			if(true){
//				String joinTableName="B_SITE";						
//				String joinEntityName = "site";
//				String joinColumn = "serviceSite";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			if(true){
//				String joinTableName="B_EMPLOYEE";						
//				String joinEntityName = "employee";
//				String joinColumn = "rechargeEmployee";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
//		//-----B_CHAT-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_CHAT";
//	        String databaseName="WHF-2016-04-18";
//	        String bussiPackage="fsk";
//	        String tableInfo="聊天记录";
//	        String entityName="chat";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			if(true){
//				String joinTableName="B_OLDER";						
//				String joinEntityName = "older";
//				String joinColumn = "older";					
//				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
//				relationList.add(relation);
//			}		
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//		}
		//-----B_REVIEW-----
/*		if(true){
			ReadTable r = new ReadTable();
	        String tableName = "B_REVIEW";
	        String databaseName="WHF-2016-04-18";
	        String bussiPackage="fsk";
	        String tableInfo="回访记录";
	        String entityName="review";
	        CodeGenerate c= new CodeGenerate();
	        
	        //1.字段信息
			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
			
			//2.实体相关信息
			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
			
			//3.映射关系
			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
			
			if(true){
				String joinTableName="B_OLDER";						
				String joinEntityName = "older";
				String joinColumn = "older";					
				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_SITE";						
				String joinEntityName = "site";
				String joinColumn = "site";					
				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
				relationList.add(relation);
			}
			if(true){
				String joinTableName="B_EMPLOYEE";						
				String joinEntityName = "employee";
				String joinColumn = "employee";					
				RelationInfo relation = RelationInfo.addManyToOne(joinTableName,joinEntityName,joinColumn,databaseName,r);						
				relationList.add(relation);
			}
			//4，生成代码
			c.generatorCodeMessage(columntList, entityInfo,relationList);
		}*/
//		//-----B_OLDER_SITE-----
//		if(true){
//			ReadTable r = new ReadTable();
//	        String tableName = "B_OLDER_SITE";
//	        String databaseName="WHF-2016-04-18_WECHAT";
//	        String bussiPackage="fsk";
//	        String tableInfo="老人站点关联表";
//	        String entityName="olderSite";
//	        CodeGenerate c= new CodeGenerate();
//	        
//	        //1.字段信息
//			List<Columnt> columntList = r.readColumntByTableName(tableName,databaseName);					
//			
//			//2.实体相关信息
//			EntityInfo entityInfo = EntityInfo.add(bussiPackage, tableInfo, tableName, entityName);										
//			
//			//3.映射关系
//			List<RelationInfo> relationList = new ArrayList<RelationInfo>();				
//			
//			//4，生成代码
//			c.generatorCodeMessage(columntList, entityInfo,relationList);
//			
//		}		
	}
}
