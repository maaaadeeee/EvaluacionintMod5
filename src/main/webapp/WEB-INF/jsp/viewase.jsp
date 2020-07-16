<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Asesorias</title>
</head>
<body>

<h1>Lista de Asesorias</h1>  
<table>  
	<tr>
		<th>Id</th><th>Detalle</th><th>Gestión</th><th>Propuestas</th><th>Fecha</th><th>Especial</th><th>Clienteid</th><th>Editar</th><th>Eliminar</th>
	</tr>  
   <c:forEach var="ase" items="${lista}">   
   <tr>  
	   <td>${ase.idasesoria}</td>  
	   <td>${ase.detalle}</td>  
	   <td>${ase.gestion}</td>  
	   <td>${ase.propuestas}</td>
	   <td>${ase.fecha}</td>  
	   <td>${ase.especial}</td>
	   <td>${ase.clienteid}</td> 
	   <td><a href="editase/${ase.idasesoria}">Editar</a></td>  
	   <td><a href="deletease/${ase.idasesoria}">Eliminar</a></td>  
   </tr>
   </c:forEach>  
   </table>  
   <br/>  
   <a href="aseform">Agregar nueva Asesoria</a> 

</body>
</html>