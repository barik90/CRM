<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Car workshop</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/main/header.jsp"%>
	<h1>Klienci</h1>
	<table border="1">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Imie</th>
			<th scope="col">Nazwisko</th>
			<th scope="col">Data Urodzenia</th>
			<th scope="col">Akcje</th>
		</tr>

		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.surname}</td>
				<td>${customer.dateOfBirth}</td>
				<td><a href="customer/edit?id=${customer.id}">Edytuj</a> <a
					href="customer/delete?id=${customer.id}">Usuń</a></td>

			</tr>
		</c:forEach>


	</table>
	<%@	include file="/WEB-INF/views/main/footer.jsp"%>
</body>
</html>