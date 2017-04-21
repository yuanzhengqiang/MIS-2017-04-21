//点击表格中指定th标签后传入本身对象，修改样式兄弟节点样式为初始样式，设置自己为递增或递减,并且返回
function listSortClickEvent(par){
	var classFlag = "";
	if($(par).parent().find("th") != null){
		var selfClass = $(par).attr("class");//先记住本身状态
		var sum = $(par).parent().find("th").size();//一共多少兄弟节点，包括自己
		for(var i = 0; i < sum; i++){//需要被排序的th全部置为初始状态
			var thName = $(par).parent().find("th:eq(" + i + ")").attr("name");
			if(thName == "needSort"){//需要被排序的th
				$(par).parent().find("th:eq(" + i + ")").attr("class","sorting");
			}
		}
		
		if(selfClass == "sorting"){
			$(par).attr("class","sorting_desc");//第一次默认设为递减
			classFlag = "desc";
		}else if(selfClass == "sorting_desc"){
			$(par).attr("class","sorting_asc");//设为递增
			classFlag = "asc";
		}else if(selfClass == "sorting_asc"){
			$(par).attr("class","sorting_desc");//设为递减
			classFlag = "desc";
		}
	}
	return classFlag;
}

//判断查询字段是否是中文，是的话告诉排序规则需要加上标记，让后台根据中文字段类型排序查询
function judgmentChinese(column){
	var type = "";
	if(column != null && column != ""){
		if(column.length > 8){
			if(column.substr(0,8) == "chinese_"){
				type = "chinese_";
			}
		}
	}
	return type;
}