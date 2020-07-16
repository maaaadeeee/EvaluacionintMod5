<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizar Actividades</title>
</head>
<body>
        <h1>Visualizar Actividades</h1>
        <table >
        <tr>
        	<td>Cliente:</td>
        	<td>
        		
        		<select name="slccliente">
        			<option>Seleccione una opcion</option>
        		<c:forEach items="${listcliente}" var="cli">
        			<option value="${cli.getId()}"> ${cli.getNombre()} </option>
        		</c:forEach>
        		</select>
        	</td>
        </tr>
        </table>
        <br/>
    <h2>Propuesta de Actividades</h2>
	<table>
		<tr>
			<th>Asesorías</th>
			<th>Soluciones</th>
			<th>Capacitaciones</th>
		</tr>
		<tr>
			<td>Legal</td>
		    <td>Tecnológicas</td>
		    <td>Prevensión de Riesgos</td>
		<tr>
		    <td>Psicológica</td>
			<td>Administrativa</td>
			<td>Medio Ambientales</td>
		</tr>
     </table>		
	    
</body>
</html>