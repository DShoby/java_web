<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <jsp:include page="header.jsp"/>
    <title>Liste des catalogues</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="alert ${resultMessage.getAlertType()} alert-dismissable">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times</a>
        <c:out value="${resultMessage}"/>
    </div>
    <h2 id="entryMessage">${entryMessage}</h2>
    <table data-toggle="table" data-query-params="queryParams"
           data-pagination="true" data-search="true" id="tableCatalogues" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th data-sortable="true">Numéro Identifiant</th>
            <th data-sortable="true">Nom</th>
            <th data-sortable="true">Date de création</th>
            <th data-sortable="true">Date de dernière modification</th>
            <th data-sortable="true">Nombre d'articles</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="catalogue" items="${listeCatalogues}">
            <tr>
                <td><c:out value="${catalogue.id}"/></td>
                <td><c:out value="${catalogue.label}"/></td>
                <td><c:out value="${catalogue.creationDate}"/></td>
                <td><c:out value="${catalogue.lastModificationDate}"/></td>
                <td><c:out value="${catalogue.products.size()}"/></td>
                <td><button class="btn btn-success" onclick="location.href='/showArticles/${catalogue.id}'">Consulter ses articles</button>
                    <button class="btn btn-info" onclick="location.href='/showArticles/linkArticle/${catalogue.id}'">Ajouter des articles</button>
                    <button class="btn btn-primary" onclick="location.href='/updateCatalogue/${catalogue.id}'">Modifier</button>
                    <button class="btn btn-danger" onclick="location.href='/deleteCatalogue/${catalogue.id}'">Supprimer</button>
                    <c:if test="${link == true}">
                        <c:set value="hidden" var="visibility"/>
                    </c:if>
                    <button class="btn btn-warning" onclick="location.href='/linkArticleToCat/${catalogue.id}/<c:out value="${idArticle}"/>'" style="visibility:${btnVisible}">Lier Article</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="col-md-6 col-md-offset-3" style="margin-top:30px;">
        <a href="home" class="btn-info btn center-block text-center">Retour à l'accueil</a>
    </div></div>
<jsp:include page="footer.jsp"/>
<script language="JavaScript">
    if(${resultMessage != null}){
        $('.alert').show();
    }
    else{
        $('.alert').hide();
    }
    if(${hideLink == null}){
        $('.btn-warning').hide();
        document.getElementById("entryMessage").innerHTML = "Liste des Catalogues";
    }
    else if(${hideLink == false}){
        $('.btn-warning').show();
        document.getElementById("entryMessage").innerHTML = "Veuillez sélectionner un catalogue auquel l'ajouter !";
    }
    if(${listeCatalogues.size() == 0}){
        document.getElementById("entryMessage").innerHTML = "La base de données ne contient aucun catalogue.";
        $('#tableCatalogues').hide();
    }
</script>
</body>
</html>
