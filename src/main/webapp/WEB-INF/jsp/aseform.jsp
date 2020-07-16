<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar nueva Asesoria</title>
</head>
<body>

        <h1>Agregar nueva Asesoria</h1>  
       <form:form method="post" action="asesave">    
        <table > 
        <tr>
        	<td>Cliente:</td>
        	<td>
        		<form:select path="clienteid" items="${listaclientes}" itemLabel="nombre" itemValue="id"> </form:select>
        	</td>
        </tr>   
         <tr>    
          <td>Detalle : </td>   
          <td><form:input path="detalle"  /></td>  
         </tr>    
         <tr>    
          <td>Gestión :</td>    
          <td><form:input path="gestion" /></td>  
         </tr>   
         <tr>    
          <td>Propuestas :</td>
         <td><textarea name="propuestas" rows="10" cols="30">
           Describa propuestas....</textarea></td>     
         </tr>   
         <tr>    
          <td>Fecha : </td>   
          <td><form:input path="fecha"  /></td>  
         </tr>    
         <tr>    
          <td>Especial : </td>   
          <td><form:input path="especial"  /></td>  
         </tr>    
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Agregar" /></td>    
         </tr>    
        </table>    
       </form:form>   

</body>
</html>