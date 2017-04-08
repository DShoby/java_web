<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <jsp:include page="header.jsp"/>
        <title>Ajout d'un article</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <h2>Ajout d'un article</h2>
            <form:form method="post" action="resultArticleForm" cssClass="well">
                <form:label path="label" cssStyle="margin-top:15px;font-size: medium;" >Nom de l'article :</form:label>
                <form:input path="label" cssClass="form-control" required="true" cssStyle="margin-top:15px;"/>
                <form:label path="typeEnum"  cssStyle="margin-top:15px;font-size: medium;">Type :</form:label>
                <form:select  path="typeEnum" cssClass="form-control"  cssStyle="margin-top:15px;">
                    <c:forEach var="type" items="${typeEnums}">
                        <c:choose>
                            <c:when test="${type.order eq 5}">
                                <form:option value="${type}" selected="selected">${type.label}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${type}">${type.label}</form:option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <form:label path="colorEnum"  cssStyle="margin-top:15px;font-size: medium;">Couleur :</form:label>
                <form:select  path="colorEnum" cssClass="form-control"  cssStyle="margin-top:15px;">
                    <c:forEach var="color" items="${colorEnums}">
                        <c:choose>
                            <c:when test="${color.order eq 7}">
                                <form:option value="${color}" selected="selected">${color.label}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${color}">${color.label}</form:option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <form:label path="size"  cssStyle="margin-top:15px;font-size: medium;">Taille :</form:label>
                <form:input path="size" cssClass="form-control" required="true"  cssStyle="margin-top:15px;"/>
                <input type="submit" value="Valider" class="btn-primary btn center-block" style="margin-top:15px;"/>
            </form:form>
            <div class="col-md-6 col-md-offset-3" style="margin-top:50px;">
                <a href="/home" class="btn btn-info center-block text-center">Retour à l'accueil</a>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
