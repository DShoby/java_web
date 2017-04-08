<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <jsp:include page="header.jsp"/>
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <c:if test="${resultMessage != null}">
            <c:set var="visibility" value="visible"/>
        </c:if>
        <div class="container">
            <div class="alert ${resultMessage.getAlertType()} alert-dismissable">
                <a href="#" class="close" aria-label="close" data-dismiss="alert">&times;</a>
                <p style="font-size: medium"><c:out value="${resultMessage.toString()} ${label}"/></p>
            </div>
            <div class="well-lg">
                <h2 class="text-center">Bienvenue !</h2>
                <table class="table table-bordered">
                    <thead>
                        <th>Nombre d'articles dans la BD</th>
                        <th>Nb de catalogues dans la BD</th>
                    </thead>
                    <tbody>
                        <td><c:out value="${sizeArticles}"/></td>
                    <td><c:out value="${sizeCatalogues}"/></td>

                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
<script>
    if(${resultMessage != null}){
        $('.alert').show();
    }
    else{
        $('.alert').hide();
    }
</script>
</html>
