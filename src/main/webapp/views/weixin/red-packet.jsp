<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>我的红包</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/red-packet.css">
</head>
<body>
	<div class="header">
		<span class="backspace"></span>
		<h3>红包</h3>
	</div>

	<div class="container">
		<div class="bg"></div>
		<ul class="red-list">
			<c:forEach items="${packets }" var="packet">

				<li><a href="#">
						<div class="relative">
							<span>${packet.money }元</span> <i>满${packet.lowestMoney }元起用</i>
							<p>有效期至${packet.dueDate }</p>
							<p>
								<span dueDate="${packet.dueDate }" class="diffDay"></span>
							</p>
						</div>
					</a></li>
			</c:forEach>

		</ul>
	</div>
	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>

	<script type="text/javascript" src="${rootPath }/resources/js/common.js"></script>

	<script>
		//两个日期的差值(d1 - d2).
		function DateDiff(d1, d2) {
			var day = 24 * 60 * 60 * 1000;
			try {
				var dateArr = d1.split("-");
				var checkDate = new Date();
				checkDate.setFullYear(dateArr[0], dateArr[1] - 1, dateArr[2]);
				var checkTime = checkDate.getTime();

				var dateArr2 = d2.split("-");
				var checkDate2 = new Date();
				checkDate2.setFullYear(dateArr2[0], dateArr2[1] - 1,
						dateArr2[2]);
				var checkTime2 = checkDate2.getTime();

				var cha = (checkTime - checkTime2) / day;
				return cha;
			} catch (e) {
				return false;
			}
		}//end fun

		//date format
		Date.prototype.format = function(format) {
			var o = {
				"M+" : this.getMonth() + 1, //month
				"d+" : this.getDate(), //day
				"h+" : this.getHours(), //hour
				"m+" : this.getMinutes(), //minute
				"s+" : this.getSeconds(), //second
				"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
				"S" : this.getMilliseconds()
			//millisecond
			}

			if (/(y+)/.test(format)) {
				format = format.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			}

			for ( var k in o) {
				if (new RegExp("(" + k + ")").test(format)) {
					format = format.replace(RegExp.$1,
							RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
									.substr(("" + o[k]).length));
				}
			}
			return format;
		}
		//get current date
		function getCurrentDate() {
			var now = new Date();
			var nowStr = now.format("yyyy-MM-dd");
			return nowStr;
		}
		$.each($(".diffDay"), function(i, e) {
			var days = DateDiff($(e).attr("dueDate"), getCurrentDate());
			if (days < 0)
				$(e).html("已过期");
			else {
				$(e).html("还有"+days+"天过期");
			}
		});
	</script>
</body>
</html>