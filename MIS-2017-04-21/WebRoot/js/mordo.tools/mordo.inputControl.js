/**
 * 只能输入数字0-9
 * 
 * @method keyPress
 */
function keyPress() {
	var theEvent = window.event || arguments.callee.caller.arguments[0];
	var keyCode = theEvent.keyCode || theEvent.which;
	if ((keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 37
			&& keyCode != 39) {
		theEvent.preventDefault();
	}
}

/**
 * 只能输入数字0-9和小数点
 * 
 * @method keyPress2
 */
function keyPress2() {
    var theEvent = window.event || arguments.callee.caller.arguments[0];
	var keyCode = theEvent.keyCode || theEvent.which;
	if ((keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 46 && keyCode != 37 && keyCode != 39) {
       theEvent.preventDefault();
    }
} 
/**
 * 只能输入数字0-9，小数点，负号
 * 
 * @method keyPress3
 */

function keyPress3() {
    var theEvent = window.event || arguments.callee.caller.arguments[0];
		var keyCode = theEvent.keyCode || theEvent.which;
		if ((keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 45 && keyCode != 46 && keyCode != 37 && keyCode != 39) {
        theEvent.preventDefault();
    };
}