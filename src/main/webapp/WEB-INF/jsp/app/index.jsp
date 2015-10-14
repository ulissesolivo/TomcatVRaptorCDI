<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tomcat, VRaptor 4, CDI, Project</title>
  </head>
  <body>
    <h1>Bem vindo: ${mensagem}</h1>
    <a href="<c:url value='/pessoa/listar' />">Pessoas</a>        
  </body>
</html>