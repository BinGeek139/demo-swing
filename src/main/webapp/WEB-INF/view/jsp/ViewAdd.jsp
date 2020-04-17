<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>
	<form:form method="post" action="addStudent">
		<table>
			<tr>
				<td>Tên 				 :
				</td>
				<td><form:input path="fullName" /></td>
			</tr>
			<tr>
				<td>Ngày sinh(dd/mm/yyyy) :</td>
				<td><form:input path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Địa chỉ 				  :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Tên trường 			   :</td>
				<td><form:input path="school" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>