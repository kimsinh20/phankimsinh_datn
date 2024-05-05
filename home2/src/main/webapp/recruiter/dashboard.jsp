<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 	<!-- ======= Hero Slider Section ======= -->
 	<jsp:include page="header.jsp" flush="true"></jsp:include> 
	<!-- End Hero Slider Section -->
	<!-- End Header -->
	<!-- ======= Sidebar ======= -->
	<jsp:include page="sidebar.jsp" flush="true"></jsp:include> 
	<div class="toast-container position-fixed top-1 end-0 ps-3 pe-5 mb-3">
		<div id="liveToast" class="toast fade hide" role="alert"
			aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
				<strong class="me-auto text-success">Thông báo</strong><small>10
					giây</small>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
			<div class="toast-body">Đăng nhập thành công</div>
		</div>
	</div>
	<script language="javascript">const viewToast = document.getElementById('liveToast');const toast = new bootstrap.Toast(viewToast);toast.show();</script>
	<main id="main" class="main">
		<div class="pagetitle">
			<h1>Dashboard</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/adv/view">Trang chủ</a></li>
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
	</main>
	<!-- End #main -->
	<!-- ======= Footer ======= -->
	<footer id="footer" class="footer">
		<div class="copyright">
			© Copyright <strong><span>JP255</span></strong>. All Rights Reserved
		</div>
		<div class="credits">
			<!-- All the links in the footer should remain intact. -->
			<!-- You can delete the links only if you purchased the pro version. -->
			<!-- Licensing information: https://bootstrapmade.com/license/ -->
			<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
			Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
		</div>
	</footer>
	<!-- End Footer -->
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>
	<!-- Vendor JS Files -->
	<script src="/adv/adjavascript/apexcharts/apexcharts.min.js"></script>
	<!-- Template Main JS File -->
	<script src="/adv/adjavascript/main.js"></script>
	<script src="/adv/adjavascript/tags.js"></script>
	<script src="/adv/adjavascript/scripts.js"></script>
	<script src="/adv/adjavascript/profilesChangePassword.js"></script>
	<svg id="SvgjsSvg1152" width="2" height="0"
		xmlns="http://www.w3.org/2000/svg" version="1.1"
		xmlns:xlink="http://www.w3.org/1999/xlink"
		xmlns:svgjs="http://svgjs.dev"
		style="overflow: hidden; top: -100%; left: -100%; position: absolute; opacity: 0;">
		<defs id="SvgjsDefs1153"></defs>
		<polyline id="SvgjsPolyline1154" points="0,0"></polyline>
		<path id="SvgjsPath1155"
			d="M-1 270.99999923706054L-1 270.99999923706054C-1 270.99999923706054 144.38194172198956 270.99999923706054 144.38194172198956 270.99999923706054C144.38194172198956 270.99999923706054 240.6365695366493 270.99999923706054 240.6365695366493 270.99999923706054C240.6365695366493 270.99999923706054 336.891197351309 270.99999923706054 336.891197351309 270.99999923706054C336.891197351309 270.99999923706054 433.1458251659687 270.99999923706054 433.1458251659687 270.99999923706054C433.1458251659687 270.99999923706054 529.4004529806284 270.99999923706054 529.4004529806284 270.99999923706054C529.4004529806284 270.99999923706054 625.6550807952881 270.99999923706054 625.6550807952881 270.99999923706054C625.6550807952881 270.99999923706054 625.6550807952881 270.99999923706054 625.6550807952881 270.99999923706054 "></path></svg>
	<div id="eJOY__extension_root" class="eJOY__extension_root_class"
		style="all: unset;"></div>
</body>
</html>