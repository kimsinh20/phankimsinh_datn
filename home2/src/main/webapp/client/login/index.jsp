<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Đăng Nhập</title>
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
       <link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet" />
        <link href="/home/user.css" type="text/css" rel="stylesheet">
        <link href="/home/css/bootstrap.min.css" rel="stylesheet">
        <script language="javascript" src="/home/js/auth.js"></script>
    </head>
    <style>
        body {
            background: linear-gradient(120deg,#3ca7ee, #9b408f) ;
            height: 100vh;
            overflow: hidden;
        }

        #errName {
            border-radius: 5px;
            margin-top: 4px;
            padding: 2px 0px;
        }

        #errPass {
            border-radius: 5px;
            margin-top: 4px;
            padding: 2px 0px;
        }
    </style>
    <body>
        <main>
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                                <div class="d-flex justify-content-center py-2 py-2">
                                    <a href="/home/" class="logo d-flex flex-column align-items-center w-auto">
                                        <img class="rounded-circle" width="100" height="100" src="/home/img/logo.jpg" alt="">
                                        <span class="d-none d-lg-block fs-3 text-dark fw-bold" id="brand">CLIENT JOBNOW</span>
                                    </a>
                                </div>
                                <!-- End Logo -->
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="pt-2 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-5 mb-2">Đăng nhập tài khoản của bạn</h5>
                                        </div>
                                        <form class="row g-3 needs-validation" method="POST" novalidate>
                                            <div class="col-12">
                                                <label for="yourUsername" class="form-label">
                                                  <i class="fa-solid fa-user"></i>
                                                    Tên tài khoản
                                                </label>
                                                <input onKeyup="checkValiLogin()" type="text" class="form-control" name="txtName" id="name">
                                                <div id="errName"></div>
                                            </div>
                                            <div class="col-12">
                                                <label for="yourPassword" class="form-label">
                                                 <i class="fa-solid fa-key"></i>
                                                    Mật Khẩu
                                                </label>
                                                <input onKeyup="checkValiLogin()" type="password" class="form-control" name="txtPass" id="pass">
                                                <div id="errPass"></div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe">
                                                    <label class="form-check-label" for="rememberMe">Ghi nhớ</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100" id="btn-login" type="submit" disabled>
                                                    <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                                                    &nbsp;Đăng Nhập
                                                </button>
                                            </div>
                                            <div class="col-12">
                                                <p class="small mb-0">
                                                    Bạn chưa có tài khoản? <a href="/home/client/register">Tạo tài khoản</a>
                                                </p>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="credits text-white">
                                    <!-- All the links in the footer should remain intact. -->
                                    <!-- You can delete the links only if you purchased the pro version. -->
                                    <!-- Licensing information: https://bootstrapmade.com/license/ -->
                                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                                    Thiết kế bởi <a class='text-white' href="https://bootstrapmade.com/">Phan Kim Sinh</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
        <!-- End #main -->
        <script src="/home/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
