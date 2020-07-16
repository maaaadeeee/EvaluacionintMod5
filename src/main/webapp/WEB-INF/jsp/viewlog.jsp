<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registro de log</h1>
<table>
	<tr>
		<th>Info</th><th>Clase</th><th>Fecha</th><th>Mensaje</th>
	</tr>
   <c:forEach var="bit" items="${list}">
   <tr>
	   <td>${bit.tipo}</td>
	   <td>${bit.clase}</td>
	   <td>${bit.fecha}</td>
	   <td>${bit.mensaje}</td>
   </tr>
   </c:forEach>
   </table>

</body>
</html>