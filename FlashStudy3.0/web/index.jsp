<%-- 
    Document   : index
    Created on : May 16, 2018, 2:42:37 PM
    Author     : Igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>FlashStudy: Página inicial</title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link rel="shortcut icon" href="img/icon.png" type="image/ico">        

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- Plugin CSS -->
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/freelancer.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <%
            HttpSession sessao = request.getSession();

            if (sessao.getAttribute("usuario_logado") == null) {
                sessao.setAttribute("usuario_logado", "false");
            }
        %>

        <script type="text/javascript">
            function validaReg() {
                var nome = document.getElementById("nomer").value;
                var email = document.getElementById("emailr").value;
                var senha1 = document.getElementById("senhar").value;
                var senha2 = document.getElementById("csenha").value;

                if ((senha1 === "") || (senha2 === "") || (nome === "") || (email === "")) {
                    window.alert("Algum campo está em branco!");
                } else {
                    if (validaEmail(email)) {
                        window.alert("Endereço de email inválido!");
                    } else {
                        if (senha1 !== senha2) {
                            window.alert("As senhas diferem!");
                        } else {
                            document.getElementById("formReg").submit();
                        }
                    }
                }
            }

            function validaLogin() {
                var email = document.getElementById("email").value;
                var senha = document.getElementById("pwd").value;

                if ((senha === "") || (email === "")) {
                    window.alert("Algum campo está em branco!");
                } else {
                    if (validaEmail(email)) {
                        window.alert("Endereço de email inválido!");
                    } else {
                        document.getElementById("formLogin").submit();
                    }
                }
            }

            function validaEmail(email) {
                var atpos = email.indexOf("@");
                var dotpos = email.lastIndexOf(".");
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
                    return true;
                }
            }
        </script>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">FlashStudy</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fa fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Como Funciona?</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Entrar</a>
                        </li>
                        <li class="nav-item mx-0 mx-lg-1">
                            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Header -->
        <header class="masthead bg-primary text-white text-center">
            <div class="container">
                <img class="img-fluid mb-5 d-block mx-auto" src="img/icon.png" alt="">
                <h1 class="text-uppercase mb-0">FlashStudy</h1>
                <hr class="star-light">
                <h2 class="font-weight-light mb-0">Uma mãozinha para os seus estudos ;)</h2>
            </div>
        </header>

        <!-- Portfolio Grid Section -->
        <section class="portfolio" id="portfolio">
            <div class="container">
                <h2 class="text-center text-uppercase text-secondary mb-0">Como Funciona?</h2>
                <hr class="star-dark mb-5">
                <div class="row">
                    <div class="col-md-6 col-lg-4">
                        <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
                            <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                    <i class="fa fa-search-plus fa-3x"></i>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/portfolio/flahcards.png" alt="">
                        </a>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
                            <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                    <i class="fa fa-search-plus fa-3x"></i>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/portfolio/cronograma.png" alt="">
                        </a>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
                            <div class="portfolio-item-caption d-flex position-absolute h-100 w-100">
                                <div class="portfolio-item-caption-content my-auto w-100 text-center text-white">
                                    <i class="fa fa-search-plus fa-3x"></i>
                                </div>
                            </div>
                            <img class="img-fluid" src="img/portfolio/CiclodeEstudos.png" alt="">
                        </a>
                    </div>

                </div>
            </div>
        </section>

        <!-- About Section -->
        <section class="bg-primary text-white mb-0" id="about">
            <div class="container">
                <h2 class="text-center text-uppercase text-white">Entrar</h2>
                <hr class="star-light mb-5">
                <div class="row">
                    <div class="col-lg-4 ml-auto">
                        <p class="lead">Esqueceu todo aquele assunto que estudou semana passada? Deixou a matéria acumular ou ta estudando pra prova um dia antes?</p>
                    </div>
                    <div class="col-lg-4 mr-auto">
                        <p class="lead">Chega de desespero! O FlashStudy está aqui pra te ajudar por meio de nossas ferramentas. Junte-se a nós.</p>
                    </div>
                </div>
                <div class="text-center mt-4">
                    <!-- <a class="btn btn-xl btn-outline-light" href="#">
                       <i class="mr-2"></i>
                       Download Now!
                     </a>-->
                    <button type="button" class="btn btn-primary" id="btnCiclo" data-toggle="modal" data-target="#myModalLogin">
                        <spam > LOGIN</spam>
                    </button>
                </div>
            </div>
        </section>
        <!-- Modal Login -->
        <div class="modal fade" id="myModalLogin">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal cabeçalho -->
                    <div class="modal-header">
                        <center><h4 class="modal-title">LOGIN </h4></center>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal corpo -->
                    <div class="modal-body" id="mBody">
                        <div id="login">
                            <form name="formLogin" id="formLogin" action="executar_login" method="POST">
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" placeholder="Entre com email" name="email" required="required">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Senha:</label>
                                    <input type="password" class="form-control" id="pwd" placeholder="Entre com a senha" name="senha" required="required">
                                    <input type="hidden" name="acao" value="login"/>
                                </div>
                            </form>
                        </div>  
                    </div>

                    <!-- Modal rodapé -->
                    <div class="modal-footer">
                        <button type="button" onclick="validaLogin()" class="btn btn-primary">Login</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" data-toggle="modal" data-target="#myModalRegistra">Registre-se</button>

                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModalRegistra">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal cabeçalhor -->
                    <div class="modal-header">
                        <center><h4 class="modal-title"> REGISTRAR </h4></center>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal corpo -->
                    <div class="modal-body" id="mBody">
                        <div id="registrar">
                            <form name = "formReg" id="formReg" action="executar_login" method="POST">
                                <div class="form-group">
                                    <label for="nome">Nome:</label>
                                    <input type="text" class="form-control" id="nomer" placeholder="Nome completo" name="nome">
                                </div><div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="emailr" placeholder="Entre com email" name="email">
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Senha:</label>
                                    <input type="password" class="form-control" id="senhar" placeholder="Entre com a senha" name="senha">
                                </div>
                                <div class="form-group">
                                    <label for="pwd2">Confirme a senha:</label>
                                    <input type="password" class="form-control" id="csenha" placeholder="Entre com a senha nvamente" name="csenha">
                                    <input type="hidden" name="acao" value="cadastro"/>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Modal rodapé -->
                    <div class="modal-footer">
                        <button type="button" onclick="validaReg(this.value)" class="btn btn-primary">Registrar-se</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                    </div>

                </div>
            </div>
        </div>


        <!-- Contact Section -->
        <section id="contact">
            <div class="container">
                <h2 class="text-center text-uppercase text-secondary mb-0"> Fale Conosco </h2>
                <hr class="star-dark mb-5">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                        <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                        <form name="sentMessage" id="contactForm" novalidate="novalidate">
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                    <label>Nome</label>
                                    <input class="form-control" id="name" type="text" placeholder="Nome" required="required" data-validation-required-message="Por favor, entre com o seu nome.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                    <label>Email </label>
                                    <input class="form-control" id="email" type="email" placeholder="Email" required="required" data-validation-required-message="Por favor, entre com o seu e-mail.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                    <label>Número de Celular</label>
                                    <input class="form-control" id="phone" type="tel" placeholder="Celular" required="required" data-validation-required-message="Por favor, entre com o seu número de celular.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                    <label>Mensagem</label>
                                    <textarea class="form-control" id="message" rows="5" placeholder="Mensagem" required="required" data-validation-required-message="Por favor, entre com a mensagem."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-xl" id="sendMessageButton">Enviar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Local</h4>
                        <p class="lead mb-0">IFAM - CAMPUS MANAUS CENTRO</p>
                    </div>
                    <div class="col-md-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Nos siga nas redes sociais</h4>
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-facebook"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-google-plus"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-twitter"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-pinterest"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-instagram"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4">
                        <h4 class="text-uppercase mb-4">FlashStudy</h4>
                        <p class="lead mb-0">Clique aqui para abrir os
                            <a href="#">Termos de Uso</a>.</p>
                    </div>
                </div>
            </div>
        </footer>

        <div class="copyright py-4 text-center text-white">
            <div class="container">
                <small>Copyright &copy; FlashStudy </small>
            </div>
        </div>

        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
        <div class="scroll-to-top d-lg-none position-fixed ">
            <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
                <i class="fa fa-chevron-up"></i>
            </a>
        </div>

        <!-- Portfolio Modals -->

        <!-- Portfolio Modal 1 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Flashcards</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/flahcards.png" alt="">
                            <p class="mb-5"> Os flashcards oferecem um método mais eficiente de revisão de conteúdos. Crie agora os seus! </p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 2 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Cronograma</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/cronograma.png" alt="">
                            <p class="mb-5"> Organize seus estudos!</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 3 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Ciclo de Estudos</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/CiclodeEstudos.png" alt="">
                            <p class="mb-5">Acompanhe seu desempenho ao decorrer dos meses!</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="js/jqBootstrapValidation.js"></script>
        <script src="js/contact_me.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/freelancer.min.js"></script>

    </body>

</html>
