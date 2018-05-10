<!DOCTYPE html>

<html lang="pt-BR">
    <head>
        <title>Flashstudy: Login</title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="shortcut icon" href="images/icon.ico" type="image/ico">        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link href="css/padrao.css" rel="stylesheet" type="text/css" media="all" />
        <link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        <section class="header">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="icon icon-group" href="index.html"><spam> FlashStudy</spam></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">    
                    <a class="nav-item nav-link" href="login.jsp">Login</a>
                    <a class="nav-item nav-link" href="registrar.jsp">Registrar-se</a>
                    <a class="nav-item nav-link" href="info.jsp">Sobre nós/Fale conosco</a>  
                </div>
            </div>
            </nav>
        </section>
        
        <div id="page-wrapper" class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xsm-12">
                    <div class="jumbotron">
                        <div class="title">
                            <h2>Bem vindo ao FlashStudy!</h2>
                            <span class="byline">Uma mãozinha para o seu estudo!</span>
                        </div>    
                    </div>
                </div>
                <div class="col-lg-4 col-md-7 col-sm-12 col-xsm-12">
                    <div class="jumbotron">
                        <div class="container">
                            <div id="login">
                                <h2>Login:</h2>
                                <form action="UsuarioServlet" method="POST">
                                    <div class="form-group">
                                        <label for="email">Email:</label>
                                        <input type="email" class="form-control" id="email" placeholder="Entre com email" name="email" required="required">
                                    </div>
                                    <div class="form-group">
                                        <label for="pwd">Senha:</label>
                                        <input type="password" class="form-control" id="pwd" placeholder="Entre com a senha" name="senha" required="required">
                                        <input type="hidden" name="acao" value="login"/>
                                    </div>
                                    <a style="color: black" href="registrar.jsp"><span>Ainda não é registrado? Clique aqui!</span></a><br>
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </form>
                            </div>  
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-8 col-md-5 col-sm-12 col-xsm-12">
                    <div class="jumbotron">
                        <div class="container">
                            <div class="title">
                                <h3>Faça o seu login e continue na caminhada ao seu sonho!</h3>
                            </div>
                        </div>
                        <div class="container">
                            <br>
                            <div class="image"><img src="images/pic06.jpeg"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="copyright" class="container">
	       <p>&copy; IINF31B. Todos os direitos reservados.</p>
        </div>  
    </body>
</html>