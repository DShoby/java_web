<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">A&C Manager</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    Gestion Catalogues
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="/addCatalogue">Ajouter</a></li>
                    <li><a href="/showCatalogues">Modifier</a></li>
                    <li><a href="/showCatalogues">Supprimer</a></li>
                    <li class="divider"></li>
                    <li><a href="/showCatalogues">Liste des catalogues</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="" class="dropdown-toggle" data-toggle="dropdown">
                    Gestion Articles
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="/addArticle">Ajouter</a></li>
                    <li><a href="/showArticles">Modifier</a></li>
                    <li><a href="/showArticles">Supprimer</a></li>
                    <li><a href="/showArticles">Lier un article</a></li>
                    <li class="divider"></li>
                    <li><a href="/showArticles">Liste des articles</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<script language="JavaScript">
    var timerIn = 200;
    var timerOut = 200;
    $('ul.nav li.dropdown').hover(function() {
        $(this).find('> .dropdown-menu').stop(true, true).fadeIn(timerIn);
        $(this).addClass('open');
    }, function() {
        $(this).find('> .dropdown-menu').stop(true, true).fadeOut(timerOut);
        $(this).removeClass('open');
    });
</script>
