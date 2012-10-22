<html>
<head>
<title></title>
</head>

<body>
<form>

<table border="1">
     <g:each in="${allProjects}" status ="i" var="thisProject">
<tr>
 <td>${thisProject.name }</td> 
 <td>${thisProject.description }</td> 
 <td>${thisProject.dueDate }</td>
</tr>
</g:each>
</table>


</form>

</body>

</html>