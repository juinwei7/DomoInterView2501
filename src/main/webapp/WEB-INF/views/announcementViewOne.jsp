<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>新增公告</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5">
	<h2>新增公告</h2>

	<!-- 顯示錯誤或成功訊息 -->
	<c:if test="${not empty msg}">
		<div class="alert alert-warning" role="alert">
				${msg}
		</div>
	</c:if>

	<form action="" method="post">
		<div class="mb-3">
			<label for="title" class="form-label">標題：</label>
			<input type="text" class="form-control" id="title" name="title" value="${announcement.title}" readonly>
		</div>

		<div class="mb-3">
			<label class="form-label">發布時間：</label>
			<input type="datetime-local" class="form-control" id="submitDate" name="submitDate" value="${announcement.publishDate}" readonly>
		</div>

		<div class="mb-3">
			<label for="expireDate" class="form-label">截止日期：</label>
			<input type="datetime-local" class="form-control" id="expireDate" name="expireDate" value="${announcement.expireDate}" readonly>
		</div>

		<div class="mb-3">
			<label for="author" class="form-label">公佈者：</label>
			<input type="text" class="form-control" id="author" name="author" value="${announcement.author}" readonly>
		</div>

		<div class="mb-3">
			<label for="content" class="form-label">公告內容：</label>
			<textarea class="form-control" id="content" name="content" rows="6" readonly>${announcement.content}</textarea>
		</div>

	</form>

	<button type="submit" class="btn btn-primary">返回</button>
</div>

<script>
    window.onload = function() {
        var currentDate = new Date().toISOString().slice(0, 16); // 取得當前時間並格式化為 yyyy-MM-ddTHH:mm
        document.getElementById('submitDate').value = currentDate;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
	document.querySelector('button').addEventListener('click', function() {
		window.location.href = '/announcement/view';
	});
</script>
</body>
</html>
