<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${CONTEXT_PATH}/css/manage.css" />
<title>创建Blog</title>
</head>
<body>
	<h1><a href="/blog">Blog管理</a> ---&gt; 创建Blog</h1>
	<div class="form_box">
		<form action="/blog/save" method="post">
			<div>
				<label>标题</label> <input type="text" name="blog.title"
					value="" />
			</div>
			<div>
				<label>内容</label>
				<textarea name="blog.content" cols="80" rows="10"></textarea>
			</div>
			<div>
				<label>&nbsp;</label> <input value="提交" type="submit">
			</div>
		</form>
	</div>
</body>
</html>