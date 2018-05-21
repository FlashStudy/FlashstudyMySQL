<%@page import="model.Usuario"%>
<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Aluno</title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="shortcut icon" href="images/icon.ico" type="image/ico">        
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="css/estudante-padrao.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="javascript/acoes.js"></script>
    <a href="../src/java/controler/FlashcardServlet.java"></a>
        <style>
            .carousel-inner img {
                width: 100%;
                height: 100%;
            }
            
            .bloco{
                border-style: solid;
                margin-top: 30px;
                margin-bottom: 0px;
            }
        </style>
    </head>
    
    <body>
        <% 
           String status = session.getAttribute("status") != null ?
                   session.getAttribute("status").toString() : ""; 
           
           if(status.equals("")){
               status = session.getAttribute("status")!= null 
                   ? request.getAttribute("status").toString() : "";
           }
           
           Usuario us = new Usuario();
           
           if(!status.equals("logado")){
               us = (Usuario)request.getAttribute("Usuario");
               session.setAttribute("Usuario", us);
               session.setAttribute("status", "logado");
           }else{
               us = (Usuario) session.getAttribute("Usuario");
           }
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
                    <a class="nav-item nav-link icon icon-user"         href="estudante-perfil.jsp" style="color: #383838"> Perfil</a>
                    <a class="nav-item nav-link icon icon-question-sign" href="estudante-ajuda.jsp" style="color: #383838"> Ajuda</a>
                    <a class="nav-item nav-link icon icon-signout"      href="index.html" style="color: #383838"> Sair</a>
                </div>
            </div>
        </nav>
             
        <div class="title">
            <h2 class="icon icon-home"> Bem-vindo!</h2>
        </div>
             
        
        <div class="container">
            <div id="carouselSite" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselSite" data-slide-to="0" class="active"></li>
                <li data-target="#carouselSite" data-slide-to="1"></li>
            </ol>
            
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/carrousel1.jpg">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Uma infinidade de opções!</h1>
                        <p class="lead">Tenha acesso a diversos materiais</p>
                    </div>
                </div>
                
                <div class="carousel-item">
                    <img src="images/carrousel2.jpg">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Diminua o espaço!</h1>
                        <p class="lead">Tenha tudo em um só lugar</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
                <span class="sr-only"> anterior</span>
            </a>
            <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">
                <span class="carousel-control-next-icon"></span>
                <span class="sr-only"> avançar</span>
            </a>
            
         </div>
    </body>
</html>