<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Accidentes</title>
</head>
<body>

<h1>Lista de Accidentes</h1>  
<table>
	<tr>
		<th>Id</th><th>Fecha</th><th>Hora</th><th>Suceso</th><th>Lugar</th><th>Cliente</th><th>Editar</th><th>Eliminar</th>
</tr>  
   <c:forEach var="acci" items="${listado}">   
   <tr>  
	   <td>${acci.idaccidente}</td>  
	   <td>${acci.fecha}</td>  
	   <td>${acci.hora}</td>  
	   <td>${acci.suceso}</td>
	   <td>${acci.lugar}</td>  
	   <td>${acci.clienteid}</td> 
	  
	  <td><a href="editacci/${acci.idaccidente}">Editar</a></td>  
	   <td><a href="deleteacci/${acci.idaccidente}">Eliminar</a></td>  
   </tr>
   </c:forEach>  
   </table>  
   <br/>  
   <a href="acciform">Agregar nuevo Accidente</a> 

</body>
   
</html>