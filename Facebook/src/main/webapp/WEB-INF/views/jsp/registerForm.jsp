<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp"%>
<%@ page session="false"%>

<link rel="stylesheet" href="css/registerForm.css">
	<spring:message code="label.firstName" var="userFirstName" />
	<spring:message code="label.lastName" var="userLastName" />
	<spring:message code="label.email" var="userEmail" />
	<spring:message code="label.login" var="userLogin" />
	<spring:message code="label.logout" var="userLogout" />
	<spring:message code="label.register" var="userRegister" />
	<spring:message code="label.password" var="userPassword" />
	<spring:message code="label.confirmPass" var="passConfirm" />

	<form:form action="login" id="loginForm" commandName="userLogin"
	method="post" style="display: block;">
	<div class="form-group">
		<form:input type="email" path="email" id="email" class="form-control" placeholder="${userEmail}" />
	</div>



	<div class="form-group">
		<form:input type="password" path="password" id="loginPassword"
			class="form-control" placeholder="${userPassword}" />
	</div>

	<c:if test="${not empty loginError}">
		<div class="form-error">
			<c:out value="${loginError}"></c:out>
		</div>
	</c:if>

	<div class="form-group">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<input type="submit" name="login-submit" id="login-submit"
					class="form-control btn btn-login" value="${userLogin}">
			</div>
		</div>
	</div>


</form:form>

<form:form action="register" id="registerForm" commandName="user"
	method="post" style="display:none;">
	<div class="row form-group">
		<div class="col-md-6" style="padding-right: 2px">
			<input type="text" name="firstName" id="firstName"
				placeholder="${userFirstName}" class="form-control input-md" required>
		</div>
		<div class="col-md-6" style="padding-left: 2px">
			<input type="text" name="lastName" id="lastName"
				placeholder="${userLastName}" class="form-control input-md" required>
		</div>
	</div>
	<div class="form-group">
		<input type="email" name="email" id="email" required
			class="form-control" placeholder="${userEmail}" value="">
	</div>

	<c:if test="${not empty regError}">
		<div class="form-error">
			<c:out value="${regError}"></c:out>
		</div>
	</c:if>

	<div class="form-group">
		<input type="password" name="password" id="password"
			class="form-control" placeholder="${userPassword}">
	</div>

	<div class="form-group">
		<input type="password" name="passwordConfirm" id="passwordConfirm"
			class="form-control" placeholder="${passConfirm}">
	</div>

	<div class="form-group">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<input type="submit" name="register-submit" id="register-submit"
					class="form-control btn btn-register" value="${userRegister}">
			</div>
		</div>
	</div>
</form:form>

<form id="recoverForm" action="Recover" method="post"
	style="display: none;" role="form" autocomplete="off">
	<div class="form-group">
		<p style="font-size: 20px; font-weight: bold;" class="text-center">
			Password Recovery</p>
		<p style="font-size: 20px" class="text-center">Please enter your
			email address.</p>
		<input type="email" name="email" id="email" class="form-control"
			placeholder="Email Address" value="" autocomplete="off" required>
	</div>
	<div class="form-group">
		<div class="row">
			<div
				class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
				<input type="submit" name="recover-submit" id="recover-submit"
					class="form-control btn btn-warning" value="Recover Account">
			</div>
		</div>
	</div>
</form>

