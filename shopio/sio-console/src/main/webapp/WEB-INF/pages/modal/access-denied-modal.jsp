<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="accessDeniedModal" title="Alert">
	<div class="alert alert-danger">You don't have permission to access this page</div>
	<c:url var="loginUrl" value="/login" />
	<a href="${loginUrl}">Click here to login again</a>
</div>