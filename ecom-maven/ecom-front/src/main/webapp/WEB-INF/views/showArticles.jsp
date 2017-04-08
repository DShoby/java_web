<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <jsp:include page="header.jsp"/>
    <title>Liste des articles</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="content col-md-offset-2 col-md-8">
    <div class="alert ${resultMessage.getAlertType()} alert-dismissable" hidden>
        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times</a>
        <c:out value="${resultMessage}"/>
    </div>
    <h2 id="entryMessage"></h2>
    <table data-toggle="table" data-search="true"  data-query-params="queryParams"
           data-pagination="true" id="tableArticles" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th data-sortable="true">Numéro Identifiant</th>
            <th data-sortable="true">Identifiant Technique</th>
            <th data-sortable="true">Nom</th>
            <th data-sortable="true">Type</th>
            <th data-sortable="true">Couleur</th>
            <th data-sortable="true">Taille</th>
            <th data-sortable="true">Date de création</th>
            <th data-sortable="true">Date de dernière modification</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="article" items="${listeArticles}">
            <tr>
                <td><c:out value="${article.id}"/></td>
                <td><c:out value="${article.techId}"/></td>
                <td><c:out value="${article.label}"/></td>
                <td><c:out value="${article.typeEnum.label}"/></td>
                <td><c:out value="${article.colorEnum.label}"/></td>
                <td><c:out value="${article.size}"/></td>
                <td><c:out value="${article.creationDate}"/></td>
                <td><c:out value="${article.lastModificationDate}"/></td>
                <td>
                    <script>
                            if(${addingPhase == false}){
                                <c:set value="hidden" var="btnVisible"/>
                            }
                            else if(${addingPhase == true}){
                                <c:set value="visible" var="btnVisible"/>
                            }
                    </script>
                    <button id="btnLink" class="btn btn-info" style="visibility:<c:out value="${btnVisible}"/>" onclick="location.href='/linkArticleToCat/<c:out value="${catalogueId}"/>/<c:out value="${article.id}"/>'">Lier au catalogue</button>
                    <button class="btn btn-primary" onclick="location.href='/updateArticle/${article.id}'">Modifier</button>
                    <script>if(${articlesFromCat == true}){
                        document.getElementById("btnSuppr").setAttribute("onclick","location.href='/deleteArticle/catalogue/${article.id}'") ;
                    }</script>
                    <button id="btnSuppr" class="btn btn-danger" onclick="location.href='/deleteArticle/${article.id}'">Supprimer</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="col-md-6 col-md-offset-3" style="margin-top:30px;">
        <a href="/home" class="btn btn-info center-block text-center">Retour à l'accueil</a>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<script>
    if(${resultMessage != null}){
        $('.alert').show();
    }
    else{
        $('.alert').hide();
    }
    if(${listeArticles.size() == 0}){
        if(${articlesFromCat == true}){
            $('#tableArticles').hide();
            document.getElementById("entryMessage").innerHTML = "Ce catalogue ne contient aucun article.";
        }
        else{
            $('#tableArticles').hide();
            document.getElementById("entryMessage").innerHTML = "La base de données ne contient aucun article.";
        }
    }
    else{
        document.getElementById("entryMessage").innerHTML = "Liste des articles";
    }
</script>
</body>
</html>

