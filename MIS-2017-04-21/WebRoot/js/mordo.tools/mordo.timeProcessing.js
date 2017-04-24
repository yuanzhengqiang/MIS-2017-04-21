/**
 * 获取当前时间return yymmddhhmmss
 * 
 * @method getCurrentTime
 * @return yymmddhhmmss
 */
function getCurrentTime() {
	var date = new Date();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var strHour = date.getHours();
	var strMinutes = date.getMinutes();
	var strSeconds = date.getSeconds();

	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	if (strHour >= 0 && strHour <= 9) {
		strHour = "0" + strHour;
	}
	if (strMinutes >= 0 && strMinutes <= 9) {
		strMinutes = "0" + strMinutes;
	}
	if (strSeconds >= 0 && strSeconds <= 9) {
		strSeconds = "0" + strSeconds;
	}
	var currentdate = date.getFullYear() + "" + month + "" + strDate + ""
			+ strHour + "" + strMinutes + "" + strSeconds;
	return currentdate;
}

/**
 * 获取一周前时间return yymmddhhmmss
 * 
 * @method lastweekTime
 * @return yymmddhhmmss
 */
function lastweekTime(){
	var now = new Date();
	var date = new Date(now.getTime() - 7 * 24 * 3600 * 1000);
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var strHour = date.getHours();
	var strMinutes = date.getMinutes();
	var strSeconds = date.getSeconds();
	
	if (month >= 1 && month <= 9) {
	    month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
	    strDate = "0" + strDate;
	}
	if (strHour >= 0 && strHour <= 9) {
	    strHour = "0" + strHour;
	}
	if (strMinutes >= 0 && strMinutes <= 9) {
	    strMinutes = "0" + strMinutes;
	}
	if (strSeconds >= 0 && strSeconds <= 9) {
	    strSeconds = "0" + strSeconds;
	}
	var currentdate = date.getFullYear() + "" + month + "" + strDate + "" + strHour + "" + strMinutes + "" + strSeconds;
	return currentdate;
}

/**
 * 获取一月前时间return yymmddhhmmss
 * 
 * @method lastmonthTime
 * @return yymmddhhmmss
 */
function lastmonthTime(){
	var now = new Date();
	var date = new Date(now.getTime() - 30 * 24 * 3600 * 1000);
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var strHour = date.getHours();
	var strMinutes = date.getMinutes();
	var strSeconds = date.getSeconds();
	
	if (month >= 1 && month <= 9) {
	    month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
	    strDate = "0" + strDate;
	}
	if (strHour >= 0 && strHour <= 9) {
	    strHour = "0" + strHour;
	}
	if (strMinutes >= 0 && strMinutes <= 9) {
	    strMinutes = "0" + strMinutes;
	}
	if (strSeconds >= 0 && strSeconds <= 9) {
	    strSeconds = "0" + strSeconds;
	}
	var currentdate = date.getFullYear() + "" + month + "" + strDate + "" + strHour + "" + strMinutes + "" + strSeconds;
	return currentdate;
}

/**
 * 根据出生年月日计算年龄yyyymmdd 转成年龄数字
 * 
 * @method calculationAgeByBirthday
 * @param {String}
 *            strBirthday 格式(yyyymmdd)
 * @return 格式化的时间(aa)
 */
function calculationAgeByBirthday(strBirthday) {
	var age = "";
	if (strBirthday != null && strBirthday != "") {
		if (strBirthday.length == 8) {
			var birthYear = strBirthday.substr(0, 4);
			var d = new Date();
			var nowYear = d.getFullYear();
			age = nowYear - birthYear;
		}
	}
	return age;
}

/**
 * 格式化时间
 * 
 * @method formateTime
 * @param {String}
 *            time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(YYYY-MM-DD HH:mm:SS)
 */
function formateTime(time) {
	var timeFormate = "未知";
	if (time != null && time.length == 14) {
		timeFormate = time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
				+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				+ time.substring(10, 12) + ":" + time.substring(12, 14);
	}
	return timeFormate;
}

/**
 * 格式化时间
 * 
 * @method formateTime2
 * @param {String}
 *            time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(YYYY-MM-DD)
 */
function formateTime2(time) {
	var timeFormate = "未知";
	if (time != null && time.length == 14) {
		timeFormate = time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8);
	}
	return timeFormate;
}

/**
 * 格式化时间
 * 
 * @method formateTime3
 * @param {String}
 *            time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(YYYY-MM-DD HH:mm)
 */
function formateTime3(time) {
	var timeFormate = "未知";
	if (time != null && time.length == 14) {
		timeFormate = time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
				+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				+ time.substring(10, 12);
	}
	return timeFormate;
}

/**
 * 格式化时间
 * 
 * @method formateTime4
 * @param {String}
 *            time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(YYYY/MM/DD HH:mm:SS)
 */
function formateTime4(time) {
	var timeFormate = "未知";
	if (time != null && time.length == 14) {
		timeFormate = time.substring(0, 4) + "/" + time.substring(4, 6) + "/"
				+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				+ time.substring(10, 12) + ":" + time.substring(12, 14);
	}
	return timeFormate;
}

/**
 * 格式化时间
 * 
 * @method formateTime5
 * @param {String}
 *            time 时间信息(YYYYMMDD)
 * @return 格式化的时间(YYYY年MM月DD日)
 */
function formateTime5(time) {
	var timeFormate = "";
	if (time != null && time.length == 8) {
		timeFormate = time.substring(0, 4) + "年" + time.substring(4, 6) + "月" + time.substring(6, 8) + "日";
	}
	return timeFormate;
}

/**
 * 时间转化成时间戳
 * 
 * @method yyyy-mm-dd hh:mm:ss  例:2014/07/10 10:21:12
 * @param {String}
 *            time 时间信息(YYYYMMDDHHmmSS)
 * @return 格式化的时间(例:1404958872000)
 */
function changeTimeToTimeStamp(time){
 	var timestamp = Date.parse(new Date(time));
	return timestamp + 28800000;
} 
