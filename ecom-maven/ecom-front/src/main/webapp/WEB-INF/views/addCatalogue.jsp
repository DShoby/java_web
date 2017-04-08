<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <jsp:include page="header.jsp"/>
    <title>Ajout d'un catalogue</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="container">
        <h2>Ajout d'un nouveau catalogue</h2>
        <form:form method="post" action="resultForm" cssClass="form-inline well">
            <form:label path="label" cssStyle="font-size: medium">Nom :</form:label>
            <form:input path="label" cssClass="form-control" required="true"/>
            <input type="submit" value="Valider" class="btn btn-primary center-block"/>
        </form:form>
        <div class="col-md-6 col-md-offset-3" style="margin-top:50px;">
            <a href="/home" class="btn btn-info center-block text-center">Retour à l'accueil</a>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
