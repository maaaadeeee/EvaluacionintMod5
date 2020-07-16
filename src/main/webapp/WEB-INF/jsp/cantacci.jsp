<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>  Cantidad de  Accidentes</h1>  
    
      
       
        	
    
                <select>
                <option>Seleccione una opcion</option> 
         		<c:forEach items="${listclientes}" var="cli">
        			<option value="${cli.getId()}"> ${cli.getNombre()} </option> 
         		</c:forEach>
      		</select>       	
    
        <br/>
<%--       //<c:set var="listcount" value="${accidenteCount}"/> --%>
	<h3>Cantidad de Accidentes del cliente es: <c:out value="${listcount}" /></h3>
<br/>
    <br/>
    
    <br/>
	    		
</body>
</html>