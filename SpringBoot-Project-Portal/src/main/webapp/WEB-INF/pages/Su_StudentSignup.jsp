<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/card/card.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/button/button.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/radio/radio.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Interface</title>
</head>

<body>
	<div class="column1" style="background-color: #aaa;">
		<details> <summary>Compulsory Details.</summary> 1. Library
		id is Compulsory.<br />
		2. Student Id is Compulsory.<br />
		3. Full name should be as mentioned on Id.<br />
		4. Current year is Compulsory.<br />
		5. Department is Compulsory.<br />
		</details>

		<details> <summary>Password Rules.</summary> 1. Passwords
		must be 8 characters or longer.<br />
		2. At least three of the following character categories must be
		included in the password:<br />
		a .Case insensitive characters (A-Z)<br />
		<br />
		b. Characters in lowercase (a-z)<br />
		<br />
		c. Digits (0-9)<br />
		<br />
		d. (!@#$ percent &*_-+=’|()[]:;”‘>,.?/) Special characters<br />
		<br />
		3. Password can not be changed after account creation. </details>
	</div>

	<div class="column2" style="background-color: #fff;">
		<form:form
			action="${pageContext.request.contextPath}/student/signup_done"
			method="post" modelAttribute="student">
			<div class="card">
				<div class="card-header">
					<div class="text-header">Signup</div>
				</div>
				<div class="card-body">

					<div class="form-group">
						<label for="username">Library Id:</label>
						<form:input type="text" class="form-control" path="libraryId"
							id="username" required="required" />

					</div>
					<div class="form-group">
						<label for="username">Student Id:</label>
						<form:input type="text" class="form-control" path="studentId"
							id="username" required="required" />

					</div>
					<div class="form-group">
						<label for="username">Full Name:</label>
						<form:input type="text" class="form-control" path="name"
							id="username" required="required" />

					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:input type="email" class="form-control" path="email"
							id="email" required="required" />

					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:input type="text" class="form-control" path="password"
							id="password" required="required" />
					</div>
					<div class="form-group">
						<label for="confirm-password">Confirm Password:</label> <input
							required="true" class="form-control" name="confirm-password"
							id="confirm-password" type="password">
						<input type="checkbox" onclick="toggleVisibility()" />
					</div>

					<div class="form-group">
						<label for="confirm-password">Select Year:</label>
					</div>

					<div class="radio-buttons-container">
						<div class="radio-button">
							<form:radiobutton path="year" id="radio2"
								class="radio-button__input" required="required" value="1" />
							<label for="radio2" class="radio-button__label"> <span
								class="radio-button__custom"></span> 1st
							</label>
						</div>
						<div class="radio-button">
							<form:radiobutton path="year" id="radio1"
								class="radio-button__input" required="required" value="2" />

							<label for="radio1" class="radio-button__label"> <span
								class="radio-button__custom"></span>2nd
							</label>
						</div>
						<div class="radio-button">
							<form:radiobutton path="year" id="radio3"
								class="radio-button__input" required="required" value="3" />

							<label for="radio3" class="radio-button__label"> <span
								class="radio-button__custom"></span>3rd
							</label>
						</div>
						<div class="radio-button">
							<form:radiobutton path="year" id="radio4"
								class="radio-button__input" required="required" value="4" />

							<label for="radio4" class="radio-button__label"> <span
								class="radio-button__custom"></span>4th
							</label>
						</div>
					</div>


					<div class="form-group">
						<label for="cars" style="margin-bottom: 10px;">Select
							departmet:</label>
						<form:select path="department" class="input" id="cars"
							required="required">

							<form:option value="Computer Science Engineering">Computer
								Science Engineering</form:option>
							<form:option value="Mechanical Engineering">Mechanical
								Engineering</form:option>
							<form:option value="Chemical Engineering">Chemical
								Engineering</form:option>
							<form:option
								value="Electronics & Communications
							Engineering">Electronics
								& Communications Engineering</form:option>
							<form:option value="Biotechnology Engineering">Biotechnology
								Engineering</form:option>
							<form:option value="Other">Other</form:option>
						</form:select>
					</div>
					<button class="btn">submit</button>
				</div>
			</div>
		</form:form>
	</div>
	<script>
		function toggleVisibility() {
			var getPasword = document.getElementById("confirm-password");
			if (getPasword.type === "password") {
				getPasword.type = "text";
			} else {
				getPasword.type = "password";
			}
		}
	</script>
</body>
</html>