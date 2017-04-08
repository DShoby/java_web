<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <jsp:include page="header.jsp"/>
    <title>Modification d'un article</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <h3> Modification de l'article ${articleToUpdate.techId} :</h3>
    <form method="post" action="/updateArticle/${articleToUpdate.id}/result" class="well">
        <label for="label"  style="margin-top:15px;font-size:medium;">Nom :</label>
        <input type="text" name="label" id="label" class="form-control" value="${articleToUpdate.label}" required style="margin-top:15px;"/>
        <label for="type"  style="margin-top:15px;font-size:medium;">Type :</label>
        <select id="type" name="type" class="form-control" style="margin-top:15px;">
            <c:forEach var="type" items="${typeEnums}">
                <c:set var="attribute" value="none"/>
                <c:choose>
                    <c:when test="${type eq articleToUpdate.typeEnum}">
                        <option value="${type}" selected>${type.label}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${type}">${type.label}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <label for="color" style="margin-top:15px;font-size:medium;">Couleur :</label>
        <select id="color" name="color" class="form-control" style="margin-top:15px;">
            <c:forEach var="color" items="${colorEnums}">
                <c:choose>
                    <c:when test="${color eq articleToUpdate.colorEnum}">
                        <option value="${color}" selected>${color.label}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${color}">${color.label}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <label for="size"  style="margin-top:15px;font-size: medium;">Taille :</label>
        <input type="text" name="size" id="size" class="form-control" value="${articleToUpdate.size}" required style="margin-top:15px;"/>
        <input type="submit" value="Valider" class="btn-primary btn center-block" style="margin-top:15px;"/>
    </form>
    <div class="col-md-6 col-md-offset-3" style="margin-top:50px;">
        <a href="/home" class="btn btn-info center-block text-center">Retour à l'accueil</a>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
