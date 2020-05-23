<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="loginModal" title="User Login">
	<c:url var="loginUrl" value="/login-process" />
	<form action="${loginUrl}" method="post">
	<input type="text" id="ssoId" name="ssoId" placeholder="Email">
	<input type="password" id="password" name="password" placeholder="Password">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="submit" class="btn btn-primary" value="LOG IN">
	<br/>
	<c:if test="${param.error != null}"><div id="loginErrorMessage" class="alert alert-danger">Invalid email or password</div></c:if>
	</form>
</div>