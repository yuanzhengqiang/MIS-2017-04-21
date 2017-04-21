/**
 * 根据单选框name名称，获取被选中值的value
 * 
 * @method getValueByRadioName
 * @param {String}
 *            name
 * @return value
 */
function getValueByRadioName(name) {
	var a = "";
	var boxes = document.getElementsByName(name);
	for (i = 0; i < boxes.length; i++) {
		if (boxes[i].checked == true) {
			a = boxes[i].value;
		}
	}
	return a;
}

/**
 * 根据单选框name名称，去除选中
 * 
 * @method setNullByRadioName
 * @param {String}
 *            name
 */
function setNullByRadioName(name) {
	$("input[name=" + name + "]").iCheck('uncheck');
}

/**
 * 根据单选框name名称，勾选指定value值的那一个单选框
 * 
 * @method checkRadioByNameAndValue
 * @param {String}
 *            value_,name
 */
function checkRadioByNameAndValue(value_, name) {
	var boxes = document.getElementsByName(name);
	for (i = 0; i < boxes.length; i++) {
		if (boxes[i].value == value_) {
			boxes[i].checked = true;
			break;
		}
	}
}

/**
 * 根据多选框name名称，去除选中
 * 
 * @method setNullByCheckBoxName
 * @param {String}
 *            name
 */
function setNullByCheckBoxName(name) {
	$("input[name=" + name + "]").iCheck('uncheck');
}

/**
 * 根据复选框name名称，获取被勾选的value值集合
 * 
 * @method getCheckboxValuesByName
 * @param {String}
 *            name
 * @return value
 */
function getCheckboxValuesByName(name) {
	var a = "";
	var boxes = document.getElementsByName(name);
	for (i = 0; i < boxes.length; i++) {
		if (boxes[i].checked == true) {
			a = a + boxes[i].value + ",";
		}
	}
	if (a != "") {
		a = a.substr(0, a.length - 1);
	}
	return a;
}

/**
 * 勾选指定id的复选框
 * 
 * @param {String}
 *            id
 * @method checkCheckboxById
 */
function checkCheckboxById(id) {
	document.getElementById(id).checked = true;
}

/**
 * 批量勾选指定name和需要被批量勾选的value值集合的复选框
 * 
 * @param {String}
 *            value_
 * @param {String}
 *            name
 * @method checkCheckboxByNameAndValues
 */
function checkCheckboxByNameAndValues(value_, name) {
	var a = value_.split(",");
	if (a.length > 0) {
		var boxes = document.getElementsByName(name);
		for (i = 0; i < boxes.length; i++) {
			for (j = 0; j < a.length; j++) {
				if (boxes[i].value == a[j]) {
					boxes[i].checked = true;
					break;
				}
			}
		}
	} else {
		var boxes = document.getElementsByName(name);
		for (i = 0; i < boxes.length; i++) {
			if (boxes[i].value == value_) {
				boxes[i].checked = true;
				break;
			}
		}
	}
}