<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <jsp:include page="header.jsp"/>
    <title>Modification du catalogue ${catalogueToUpdate.label}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
    <div class="container">
        <h2>Modification du catalogue ${catalogueToUpdate.label}</h2>
        <form method="post" action="/updateCatalogue/${catalogueToUpdate.id}/result" class="well form-inline">
            <label for="label">Nom :</label>
            <input type="text" name="label" id="label" value="${catalogueToUpdate.label}" class="form-control" required/>
            <input type="submit" name="submit" value="Valider" class="btn-primary btn center-block"/>
        </form>
        <div class="col-md-6 col-md-offset-3" style="margin-top:50px;">
            <a href="/home" class="btn btn-info center-block text-center">Retour à l'accueil</a>
        </div>
    </div>
<jsp:include page="footer.jsp"/>
</body>
</html>
