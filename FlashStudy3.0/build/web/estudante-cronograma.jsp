<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Cronograma de Estudos</title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="shortcut icon" href="images/icon.ico" type="image/ico">        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="css/estudante-padrao.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="javascript/acoes.js"></script>
    </head>
    
    <body>
        
        <%
            Usuario us = (Usuario) session.getAttribute("Usuario");
        %>
        
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand h1 mb-0 icon icon-group" href="estudante-inicial.jsp"> FlashStudy</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link icon icon-calendar"     href="estudante-cronograma.jsp" style="color: #383838"> Cronograma</a>
                    <a class="nav-item nav-link icon icon-refresh link"      href="estudante-ciclo.jsp" style="color: #383838"> Ciclo de estudos</a>
                    <a class="nav-item nav-link icon icon-pushpin"      href="estudante-flashcards.jsp" style="color: #383838"> Flashcards</a>  
                    <a class="nav-item nav-link icon icon-book"         href="estudante-anotacoes.jsp" style="color: #383838"> Anotações</a>
                    <a class="nav-item nav-link icon icon-user"         href="estudante-perfil.jsp" style="color: #383838"> Perfil</a>
                    <a class="nav-item nav-link icon icon-question-sign" href="estudante-ajuda.jsp" style="color: #383838"> Ajuda</a>
                    <a class="nav-item nav-link icon icon-signout"      href="index.html" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>
    
        <div class="title">
            <h2 class="icon icon-calendar"> Cronograma</h2>
            <span class="byline">Calendário com todos os seus planejamentos</span>
        </div>
    </body>
</html>