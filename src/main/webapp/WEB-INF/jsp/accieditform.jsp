<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar datos Accidente</title>
</head>
<body>

        <h1>Editar Accidente</h1>
       <form:form method="post" action="/modulo5dia5/editsaveacci">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden path="idaccidente" /></td>  
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
          <td><form:input path="suceso" /></td>  
         </tr>   
         <tr>    
          <td>Lugar : </td>   
          <td><form:input path="lugar"  /></td>  
         </tr>
          <tr>    
          <td>Clienteid : </td>   
          <td><form:input path="clienteid"  /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Editar y Guardar" /></td>    
         </tr>
        </table>
       </form:form>   
</body>

</html>