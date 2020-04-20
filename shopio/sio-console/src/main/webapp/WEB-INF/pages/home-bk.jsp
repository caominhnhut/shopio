<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShopIO Console</title>
<link href="<c:url value="/css/bootstrap-4.4.1/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/js/jquery.min.js" />"></script>
<script src="<c:url value="/css/bootstrap-4.4.1/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="web-container">
		<div class="row">
			<div class="col-md-2 left-side">left
			</div>
			<div class="col-md-10 right-side">
				<div class="cl1">${greeting}</div>
				<div class="cl1">${greeting}</div>
				<div class="cl1">${greeting}</div>
				<div class="cl1">${greeting}</div>
				<div class="cl1">${greeting}</div>
			</div>
		</div>
	</div>
</body>
</html>