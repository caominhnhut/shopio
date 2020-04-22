<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value="/css/bootstrap-4.4.1/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap-4.4.1/bootstrap-glyphicons.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/js/jquery.min.js" />"></script>
<script src="<c:url value="/css/bootstrap-4.4.1/bootstrap.min.js" />"></script>
</head>

<body>
	<div class="web-container">
		<div class="row">
			<div class="col-md-2 left-side">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-md-10 right-side">
				<div class="header">
					<tiles:insertAttribute name="header" />
				</div>
				<div class="content">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>