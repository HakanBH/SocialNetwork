<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="false"%>

<link rel="stylesheet" href="css/registerForm.css">

<form:form action="login" id="loginForm" commandName="userLogin" method="post" style="display: block;" >
	<div class="form-group">
		<spring:message code="user.email" var="userEmail"/>
		<form:input type="email" path="email" id="email"
			class="form-control" placeholder="${userEmail}" />
	</div>

	<div class="form-group">
		<form:input type="password" path="password" id="loginPassword"
			class="form-control" placeholder="Password" />
	</div>

	<c:if test="${not empty loginError}">
		<div class="form-error">
			<c:out value="${loginError}"></c:out>
		</div>
	</c:if>

	<div class="form-group text-center">
		<input type="checkbox" name="remember" id="remember"> <label
			for="remember"> Remember Me </label>
	</div>

	<div class="form-group">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<input type="submit" name="login-submit" id="login-submit"
					class="form-control btn btn-login" value="Log In">
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="row">
			<div class="col-lg-12">
				<div class="text-center">
					<a href="#" id="recover-form-link">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
</form:form>

<form:form action="register" id="registerForm" commandName="user" method="post" style="display:none;">
	<div class="row form-group">
		<div class="col-md-6" style="padding-right: 2px">
			<input type="text" name="firstName" id="firstName"
				placeholder="First Name" class="form-control input-md" required>
		</div>
		<div class="col-md-6" style="padding-left: 2px">
			<input type="text" name="lastName" id="lastName"
				placeholder="Family Name" class="form-control input-md" required>
		</div>
	</div>
	<div class="form-group">
		<input type="email" name="email" id="email" required
			class="form-control" placeholder="Email Address" value="">
	</div>

	<c:if test="${not empty regError}">
		<div class="form-error">
			<c:out value="${regError}"></c:out>
		</div>
	</c:if>

	<div class="form-group">
		<input type="password" name="password" id="password"
			class="form-control" placeholder="Password" >
	</div>

	<div class="form-group">
		<input type="password" name="passwordConfirm" id="passwordConfirm" 
			class="form-control" placeholder="Confirm Password">
	</div>

	<div class="form-group">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<input type="submit" name="register-submit" id="register-submit"
					class="form-control btn btn-register" value="Register Now">
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
					class="form-control btn btn-warning"
					value="Recover Account">
			</div>
		</div>
	</div>
</form>

