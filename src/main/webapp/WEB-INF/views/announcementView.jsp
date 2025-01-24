<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>公告列表</title>
	<style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .actions {
            text-align: center;
        }
        .no-data {
            color: red;
            font-weight: bold;
        }
        .pagination {
            margin-top: 20px;
            text-align: center;
        }
        .pagination a {
            margin: 0 5px;
            padding: 8px 12px;
            text-decoration: none;
            border: 1px solid #ddd;
            color: #007bff;
            border-radius: 4px;
        }
        .pagination a.active {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
        .pagination a:hover {
            background-color: #ddd;
        }
	</style>
</head>
<body>
<h2>公告列表</h2>

<table>
	<thead>
	<tr>
		<th>標題</th>
		<th>發布日期</th>
		<th>截止日期</th>
		<th>作者</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:if test="${empty pagination.items}">
		<tr>
			<td colspan="5" class="no-data">無資料</td>
		</tr>
	</c:if>
	<c:forEach var="announcement" items="${pagination.items}">
		<tr>
			<td>${announcement.title}</td>
			<td>
				<fmt:formatDate value="${announcement.publishDate}" pattern="yyyy/MM/dd HH:mm" />
			</td>
			<td>
				<fmt:formatDate value="${announcement.expireDate}" pattern="yyyy/MM/dd HH:mm" />
			</td>
			<td>${announcement.author}</td>
			<td class="actions">
				<a href="/announcement/view/${announcement.id}">查看</a>
				<a href="/announcement/edit/${announcement.id}">編輯</a>
				<a href="/announcement/delete/${announcement.id}">刪除</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<div class="pagination">
	<c:if test="${pagination.currentPage > 1}">
		<a href="?page=${pagination.currentPage - 1}">上一頁</a>
	</c:if>
	<c:forEach begin="1" end="${pagination.totalPages}" var="page">
		<a href="?page=${page}" class="${page == pagination.currentPage ? 'active' : ''}">${page}</a>
	</c:forEach>
	<c:if test="${pagination.currentPage < pagination.totalPages}">
		<a href="?page=${pagination.currentPage + 1}">下一頁</a>
	</c:if>
</div>

<button onclick="location.href='/announcement/create'">新增公告</button>
</body>
</html>
