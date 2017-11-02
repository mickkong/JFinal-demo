<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${CONTEXT_PATH}/css/manage.css" />
<title>列表</title>
</head>
<body>
	<h1>
		Blog管理&nbsp;&nbsp; <a href="${CONTEXT_PATH}/blog/add">创建Blog</a>
	</h1>
	<div class="table_box">
		<table class="list">
			<tbody>
				<tr>
					<th width="4%">id</th>
					<th width="35%">标题</th>
					<th width="12%">操作</th>
				</tr>
				<c:forEach items="${blogPage }" var="blog">
					<tr>
						<td style="text-align: left;">${blog.id }</td>
						<td style="text-align: left;">${blog.title }</td>
						<td style="text-align: left;">&nbsp;&nbsp;<a
							href="/blog/delete/${blog.id }">删除</a> &nbsp;&nbsp;<a
							href="/blog/edit/${blog.id }">修改</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>