package sbtj.util;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

public class CreateReportUtil {
	private static Logger logger = Logger.getLogger(CreateReportUtil.class);
    /**
     * 健康报告自动生成逻辑
     * @param action 返回请求消息体
     * @param adl ADL量表评分
     * @param adlDes ADL量表评分说明
     * @param fall 跌倒风险评分
     * @param fallDes 跌倒风险评分说明
     * @param nutrition 营养风险评分
     * @param nutritionDes 营养风险评分说明
     * @param sore 压疮评分
     * @param soreDes 压疮评分说明
     * @param mmse MMSE评分
     * @param mmseDes MMSE评分说明
     * @param mas 运动功能评定评分
     * @param masDes 运动功能评定评分说明
     * @param barthe 日常生活评定改良Barthel评分
     * @param bartheDes 日常生活评定改良Barthel评分说明
     * @param fca 功能综合评定评分
     * @param fcaDes 功能综合评定评分说明
     * @param upperLimbMuscleStrength 肌力-上肢
     * @param muscleStrengthOfLowerLimb 肌力-下肢
     * @param muscleToneUpperLimb 肌张力（改良Ashworth法）上肢
     * @param muscleToneLowerLimb 肌张力（改良Ashworth法）下肢
     * @param jointMobility 关节活动度
     * @param languageFunction 语言功能
     * @return {"action":"CREATE_REPORT_BY_SCORE_RESPONSE","result":"100","des":"success","content":{"diseaseSummary":"","mainProblem":"","recentRehabilitationGoals":"","rehabilitationLongTermGoal":"","trainingProgram":""}

     */
	public static String createReport(String action,String adl,String adlDes, 
			String fall,String fallDes,
			String nutrition,String nutritionDes,
			String sore, String soreDes,
			String mmse, String mmseDes, 
			String mas,String masDes,
			String barthe, String bartheDes, 
			String fca, String fcaDes, 
			String upperLimbMuscleStrength,String muscleStrengthOfLowerLimb, 
			String muscleToneUpperLimb,String muscleToneLowerLimb, 
			String jointMobility,
			String languageFunction) {
		String result = "";		
		try {
			String enter = "\n";
			String diseaseSummary = "";
			String mainProblem = "";
			String recentRehabilitationGoals = "";
			String rehabilitationLongTermGoal = "";
			String trainingProgram = "";
			
			//1.病情摘要
			int a = 1;
			if(adl!=null&&!"".equals(adl.trim())){
				diseaseSummary+=a+".ADL："+adl+" "+adlDes+enter;
				a++;
			}
			if(fall!=null&&!"".equals(fall.trim())){
				diseaseSummary+=a+".跌倒风险："+fall+" "+fallDes+enter;
				a++;
			}
			if(nutrition!=null&&!"".equals(nutrition.trim())){
				diseaseSummary+=a+".营养风险："+nutrition+" "+nutritionDes+enter;
				a++;
			}
			if(sore!=null&&!"".equals(sore.trim())){
				diseaseSummary+=a+".压疮评定："+sore+" "+soreDes+enter;
				a++;
			}
			if(mmse!=null&&!"".equals(mmse.trim())){
				diseaseSummary+=a+".MMSE："+mmse+" "+mmseDes+enter;
				a++;
			}
			if(mas!=null&&!"".equals(mas.trim())){
				diseaseSummary+=a+".运动功能评定："+mas+" "+masDes+enter;
				a++;
			}
			if(barthe!=null&&!"".equals(barthe.trim())){
				diseaseSummary+=a+".日常生活评定改良Barthel："+barthe+" "+bartheDes+enter;
				a++;
			}
			if(fca!=null&&!"".equals(fca.trim())){
				diseaseSummary+=a+".功能综合评定："+fca+" "+fcaDes+enter;
				a++;
			}
			if((upperLimbMuscleStrength!=null&&!"".equals(upperLimbMuscleStrength.trim()))||(muscleStrengthOfLowerLimb!=null&&!"".equals(muscleStrengthOfLowerLimb.trim()))){
				String upperLimbMuscleStrengthStr = getjili(upperLimbMuscleStrength);
				String muscleStrengthOfLowerLimbStr = getjili(muscleStrengthOfLowerLimb);
				diseaseSummary+=a+".肌力评定：上肢"+upperLimbMuscleStrengthStr+"    下肢"+muscleStrengthOfLowerLimbStr+enter;
				a++;
			}
			if((muscleToneUpperLimb!=null&&!"".equals(muscleToneUpperLimb.trim()))||(muscleToneLowerLimb!=null&&!"".equals(muscleToneLowerLimb.trim()))){
				String muscleToneUpperLimbStr = getjizhangli(muscleToneUpperLimb);
				String muscleToneLowerLimbStr = getjizhangli(muscleToneLowerLimb);
				diseaseSummary+=a+".肌张力评定：上肢"+muscleToneUpperLimbStr+"    下肢"+muscleToneLowerLimbStr+enter;
				a++;
			}
			if(jointMobility!=null&&!"".equals(jointMobility.trim())){
				diseaseSummary+=a+".关节活动度："+jointMobility+enter;
				a++;
			}
			if(languageFunction!=null&&!"".equals(languageFunction.trim())){
				diseaseSummary+=a+".语言功能："+languageFunction+enter;
				a++;
			}
			
			//2.目前存在问题
			int b = 0;
			
			mainProblem="经过评定，存在";
			if(adl!=null&&!"".equals(adl.trim())&&Double.valueOf(adl).doubleValue()<60){
				mainProblem+="日常生活能力、";
				b++;
			}
			if(mmse!=null&&!"".equals(mmse.trim())&&Double.valueOf(mmse).doubleValue()<27){
				mainProblem+="精神状态、";
				b++;
			}
			if(sore!=null&&!"".equals(sore.trim())&&!"0期".equals(sore)){
				mainProblem+="压疮分期、";
				b++;
			}
			if(nutrition!=null&&!"".equals(nutrition.trim())&&Double.valueOf(nutrition).doubleValue()<12){
				mainProblem+="微营养评定、";
				b++;
			}
			if(barthe!=null&&!"".equals(barthe.trim())&&Double.valueOf(barthe).doubleValue()<12){
				mainProblem+="Berg平衡存在、";
				b++;
			}
			if((upperLimbMuscleStrength!=null&&!"".equals(upperLimbMuscleStrength.trim())&&!"5".equals(upperLimbMuscleStrength))||
					(muscleStrengthOfLowerLimb!=null&&!"".equals(muscleStrengthOfLowerLimb.trim())&&!"5".equals(muscleStrengthOfLowerLimb))||
					(muscleToneUpperLimb!=null&&!"".equals(muscleToneUpperLimb.trim())&&!"0".equals(muscleToneUpperLimb))||
					(muscleToneLowerLimb!=null&&!"".equals(muscleToneLowerLimb.trim())&&!"0".equals(muscleToneLowerLimb))){
				mainProblem+="肌力障碍、";
				b++;
			}
			if(languageFunction!=null&&!"".equals(languageFunction.trim())&&languageFunction.indexOf("异常")>-1){
				mainProblem+="语言功能障碍、";
				b++;
			}
			if(b>0){
				mainProblem = mainProblem.substring(0,mainProblem.length()-1);
				mainProblem+="的问题。";
			}else{
				mainProblem+="无问题。";
			}
			
			//3.康复目标-近期目标
			int c = 1;
			if(adl!=null&&!"".equals(adl.trim())&&Double.valueOf(adl).doubleValue()<60){
				recentRehabilitationGoals+=c+".改善日常生活能力"+enter;
				c++;
			}
			if(sore!=null&&!"".equals(sore.trim())&&!"0期".equals(sore)){
				recentRehabilitationGoals+=c+".改善压疮情况"+enter;
				c++;
			}
			if(nutrition!=null&&!"".equals(nutrition.trim())&&Double.valueOf(nutrition).doubleValue()<12){
				recentRehabilitationGoals+=c+".改善营养状况"+enter;
				c++;
			}
			if((upperLimbMuscleStrength!=null&&!"".equals(upperLimbMuscleStrength.trim())&&!"5".equals(upperLimbMuscleStrength))||
					(muscleStrengthOfLowerLimb!=null&&!"".equals(muscleStrengthOfLowerLimb.trim())&&!"5".equals(muscleStrengthOfLowerLimb))){
				recentRehabilitationGoals+=c+".促进各关节的血液循环，防止肌肉的萎缩等"+enter;
				c++;
			}
			if((muscleToneUpperLimb!=null&&!"".equals(muscleToneUpperLimb.trim())&&!"0".equals(muscleToneUpperLimb))||
					(muscleToneLowerLimb!=null&&!"".equals(muscleToneLowerLimb.trim())&&!"0".equals(muscleToneLowerLimb))){
				recentRehabilitationGoals+=c+".训练肢体障碍使其肌力增加，肌张力降低等"+enter;
				c++;
			}
			if(languageFunction!=null&&!"".equals(languageFunction.trim())&&languageFunction.indexOf("异常")>-1){
				recentRehabilitationGoals+=c+".训练口语的表达能力，恢复跟家人的交流能力等"+enter;
				c++;
			}
			
			//4.康复目标-长期目标
			int d=3;
			rehabilitationLongTermGoal += "1.恢复正常生活，能够生活自理"+enter+"2.早日回归工作岗位，回归社会"+enter;
			if(adl!=null&&!"".equals(adl.trim())&&Double.valueOf(adl).doubleValue()<60){
				rehabilitationLongTermGoal+=d+".恢复部分日常生活能力"+enter;
				d++;
			}
			if(sore!=null&&!"".equals(sore.trim())&&!"0期".equals(sore)){
				rehabilitationLongTermGoal+=d+".恢复压疮破损情况"+enter;
				d++;
			}
			if(nutrition!=null&&!"".equals(nutrition.trim())&&Double.valueOf(nutrition).doubleValue()<12){
				rehabilitationLongTermGoal+=d+".恢复到正常营养状况"+enter;
				d++;
			}
			
            //5.训练计划
			int e= 1;
			if(sore!=null&&!"".equals(sore.trim())&&!"0期".equals(sore)){
				if("I期".equals(sore)){
					trainingProgram+=e+".压疮恢复："+enter;
					trainingProgram+="    应用透明薄膜黏贴在发红和容易受到摩擦力的部位，以减轻摩擦力，同时给患者翻身时不要拖拉，避免敷料卷曲；或使用泡沫敷料或水胶体敷料减轻压力。黏贴的透明薄膜敷料或泡沫敷料如无卷边和脱落，通常约1周左右更换，如有渗液流出或卷边，应及时更换。"+enter;
					e++;
				}else if("II期".equals(sore)){
					trainingProgram+=e+".压疮恢复："+enter;
					trainingProgram+="    小水疱（直径小于5mm）未破的小水疱要减少和避免摩擦，防止破裂感染，使其自行吸收。先按伤口消毒标准消毒后，直接黏贴透气性薄膜敷料或泡沫敷料，水疱吸收后才将敷料撕除。 ②大水疱（直径大于5mm）大水疱可在无菌操作下加以处理。首先按照标准消毒水泡周围后，在水疱的边缘用注射器抽出疱内液体或用针头刺破水疱；然后用无菌棉签挤压干净水疱内的液体或用无菌纱布吸干水疱内渗液；贴覆泡沫敷料，待水疱吸收后才将敷料撕除。如水泡直径较大，渗液多，或水泡反复出现，可在发现水泡后初次即完全去除水泡皮，彻底清洁，然后覆盖泡沫敷料。③真皮层破损首先用生理盐水清洗伤口及周围皮肤，以去除残留在伤口上的表皮破损的组织，然后根据伤口的渗液情况及基底情况可选择水胶体敷料或藻酸盐敷料。敷料更换间隔根据伤口的渗液情况确定换药次数。"+enter;
					e++;
				}else{
					trainingProgram+=e+".压疮恢复："+enter;
					trainingProgram+="    进行彻底清创、去除坏死组织，减少感染机会，有助于准确地评估伤口、选择合适的伤口敷料促进愈合。①焦痂（黑痂皮和黄痂皮）有焦痂的伤口在没有去除焦痂时不能直接判断伤口的分期，一定要清除焦痂后才能判断，创面过于干燥或有难以清除的坏死组织时，用水凝胶进行自溶清创。水凝胶清创时在焦痂上用刀片画上V字样痕迹，以便于水凝胶的吸收，有利于焦痂溶解。焦痂开始溶解后，再配合采用外科清创的方法将焦痂和坏死组织清除，如有黑痂且伤口有红肿热痛的感染症状时，必须要进行外壳切开，将脓液引流出来和清除坏死组织。②伤口有黄色腐肉，渗液多的处理创面渗液多时，使用高吸收的敷料，如藻酸盐敷料，间隔换药。③伤口合并感染的处理使用银离子敷料或含碘敷料，但不能长期使用，1-2次炎症控制后就要停止使用，否则影响创面的愈合，碘剂对肝脏有毒性作用，感染的创面应定期采集分泌物作细菌培养及药敏实验。每周一次，结果及时报告医生，按检查结果用药。如合并骨髓炎的伤口，应请骨科医生会诊处理。④对大且深的伤口清创后，基底肉芽好的伤口可请外科医生会诊，确定能否给予皮瓣移植修复术。压疮是全身局部综合因素所引起的变性坏，死病理过程，因此要积极预防采取局部治疗为主，全身治疗为辅的综合防治措施。针对不同病例不同时期采取相应恰当有效的措施，促进伤口愈合，缩短伤口的愈合时间，减少患者的痛苦和经济负担。"+enter;
					e++;
				}				
			}
			
			if((upperLimbMuscleStrength!=null&&!"".equals(upperLimbMuscleStrength.trim())&&!"5".equals(upperLimbMuscleStrength))||
					(muscleStrengthOfLowerLimb!=null&&!"".equals(muscleStrengthOfLowerLimb.trim())&&!"5".equals(muscleStrengthOfLowerLimb))||
					(muscleToneUpperLimb!=null&&!"".equals(muscleToneUpperLimb.trim())&&!"0".equals(muscleToneUpperLimb))||
					(muscleToneLowerLimb!=null&&!"".equals(muscleToneLowerLimb.trim())&&!"0".equals(muscleToneLowerLimb))){
				trainingProgram+=e+".肌力训练："+enter;
				trainingProgram+="    a)治疗者适当增加阻力：肌力强化必须给与一定的阻力，使患者发挥最佳能力，阻力可来自于肌肉的重量，肌肉运动时外加的阻碍力量等。"+enter;
				trainingProgram+="    b)治疗者给与超量负荷：初始一般以最大负荷量进行重复10次，即10RM；康复的进展期，也可以用体重的百分比计算；重复的次数应大于5-6次，可安排3-5组等。"+enter;
				trainingProgram+="    c)渐进抗阻训练：需训练肌和肌群在规定范围能完成10次的最大重量负荷；分三组训练：1.第一组：50%的10RM重量，10-15次每分钟的速度，10次锻炼；2.第二组：75%的10RM重量，10-15次每分钟的速度，10次锻炼；3.第三组：100%的10RM重量，10-15次每分钟的速度，10次锻炼。每组训练间休息1分钟。"+enter;
				e++;
			}
			if(languageFunction!=null&&!"".equals(languageFunction.trim())&&(languageFunction.indexOf("听觉理解异常")>-1||languageFunction.indexOf("口语异常")>-1||languageFunction.indexOf("阅读异常")>-1)){
				int f= 1;
				trainingProgram+=e+".言语功能障碍："+enter;
				if(languageFunction.indexOf("听觉理解异常")>-1){
					trainingProgram+="    "+f+")口语理解训练：以听语刺激促进法为核心。"+enter;
					f++;
				}
				if(languageFunction.indexOf("口语异常")>-1){
					trainingProgram+="    "+f+")口语表达训练：语音练习；自动语；命名练习；复述练习；叙述练习。"+enter;
					f++;
				}
				if(languageFunction.indexOf("阅读异常")>-1){
					trainingProgram+="    "+f+")阅读与朗读训练：单词认知；单词朗读；语句及篇章的阅读与朗读，书写训练。"+enter;
					f++;
				}				
				e++;
				trainingProgram = trainingProgram.replaceAll("1\\)", "a\\)");
				trainingProgram = trainingProgram.replaceAll("2\\)", "b\\)");
				trainingProgram = trainingProgram.replaceAll("3\\)", "c\\)");
			}
	
			
			//拼装返回字段
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("action", action);
			jsonobj.put("result", "100");
			jsonobj.put("des", "success");

			JSONObject contentobj = new JSONObject();			
			contentobj.put("diseaseSummary", diseaseSummary);
			contentobj.put("mainProblem", mainProblem);
			contentobj.put("recentRehabilitationGoals", recentRehabilitationGoals);
			contentobj.put("rehabilitationLongTermGoal", rehabilitationLongTermGoal);
			contentobj.put("trainingProgram", trainingProgram);
			
			jsonobj.put("content", contentobj);
			
			result = jsonobj.toString();
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}
	private static String getjili(String temp) {
		String result="";
		if("1".equals(temp)){
			result="可摸到肌肉收缩，但无关节活动";
		}else if("2-".equals(temp)){
			result="可见到肌肉收缩，除掉重力情况下关节可以轻微活动";
		}else if("2".equals(temp)){
			result="消除重力下关节轻度活动，可达关节活动范围的80%";
		}else if("2+".equals(temp)){
			result="消除重力下关节可全范围活动，但不能做抗重力运动";
		}else if("3-".equals(temp)){
			result="有抗重力运动出现，但运动范围不足50%";
		}else if("3".equals(temp)){
			result="能抗重力运动";
		}else if("3+".equals(temp)){
			result="能灵活抗重力运动，并可重复运动多次或稍抗阻力";
		}else if("4-".equals(temp)){
			result="抗阻力运动出现，但仅能抗较小阻力";
		}else if("4".equals(temp)){
			result="能抗中等阻力活动";
		}else if("4+".equals(temp)){
			result="能抗阻力运动，但阻力为中等或稍强";
		}else if("5-".equals(temp)){
			result="能抗较大阻力运动，但较健侧力量稍弱";
		}else if("5".equals(temp)){
			result="正常";
		}
		return result;
	}
	private static String getjizhangli(String temp) {
		String result="";
		if("0".equals(temp)){
			result="无肌张力增高";
		}else if("1".equals(temp)){
			result="轻高，被动活动有一过性停顿";
		}else if("2".equals(temp)){
			result="较高，活动不受限";
		}else if("3".equals(temp)){
			result="明显高，被动活动困难";
		}else if("4".equals(temp)){
			result="极高，肢僵，不能被动活动";
		}
		return result;
	}

}
