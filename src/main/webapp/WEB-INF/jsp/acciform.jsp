<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar nuevo Accidente</title>
</head>
<body>
        <h1>Agregar nuevo Accidente</h1>  
       <form:form  method="post" action="accisave">    
        <table > 
        <tr>
        	<td>Cliente:</td>
        	<td>
        		<form:select path="clienteid" items="${listaclientes}" itemLabel="nombre" itemValue="id"> </form:select>
        	</td>
        </tr>      
         <tr>    
          <td>Fecha : </td>   
          <td><form:input path="fecha"  /></td>  
         </tr>    
         <tr>    
          <td>Hora :</td>    
          <td><form:input path="hora" /></td>  
         </tr>   
         <tr>
         <td>Suceso :</td>
         <td><textarea name="suceso" rows="10" cols="30">
           Describa el accidente....</textarea></td>     
         </tr>  
         <tr>    
          <td>Lugar : </td>   
          <td><form:input path="lugar"  /></td>  
         </tr>    
          <tr>        
          <td><input type="submit" value="Agregar" /></td>   
         </tr>    
        </table>    
       </form:form>   
</body>
</html>