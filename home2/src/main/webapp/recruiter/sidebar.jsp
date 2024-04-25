<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar p-1">
		<ul class="sidebar-nav" id="sidebar-nav">
			<li class="nav-item"><a class="nav-link collapsed"
				href="/home/view"><i class="bi bi-house"></i><span>Dashboard</span></a></li>
			<!-- End Dashboard Nav -->
				<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#job-nav" data-bs-toggle="collapse" href="#"><i
					class="far fa-bookmark"></i><span>Quản lí đăng tuyển</span><i
					class="bi bi-chevron-down ms-auto"></i></a>
			<ul id="job-nav" class="nav-content collapse show"
					data-bs-parent="#job-nav">
					<li><a href="/home/job/list"><i class="fas fa-list"></i><span>Tạo tin tuyển dụng</span></a></li>
					<li><a href="/home/job/list"><i class="fas fa-list"></i><span>Danh sách</span></a></li>
					<li><a href="/home/job/list?trash"><i
							class="fas fa-trash-restore"></i><span>Thùng rác</span></a></li>
				</ul></li>
			<!-- End Components Nav -->
			<li class="nav-item"><a class="nav-link collapsed"
				data-bs-target="#user-nav" data-bs-toggle="collapse" href="#"><i
					class="bi bi-people"></i><span>Quản lí ứng viên</span><i
					class="bi bi-chevron-down ms-auto"></i></a>
				<ul id="user-nav" class="nav-content collapse show "
					data-bs-parent="#user-nav">
					<li><a href="/home/user/list"><i class="fas fa-users-cog"></i><span>Hồ sơ ứng tuyển</span></a></li>
					<li><a href="/home/recruiter/list"><i
							class="fas fa-user-tie"></i><span>Hồ sơ đã lưu</span></a></li>
					<li><a href="/home/client/list"><i class="fas fa-users"></i><span>Tìm kiếm ứng
								viên</span></a></li>
					<li><a href="/home/user/list?trash"><i
							class="fas fa-trash-restore"></i><span>Thùng rác</span></a></li>
				</ul></li>
			<!-- End Components Nav -->
			<!-- End Components Nav -->
			<li class="nav-item"><a class="nav-link  collapsed"
				data-bs-target="#service-nav" data-bs-toggle="collapse" href="#"><i
					class="bi bi-bag-check-fill"></i><span>Quản lí dịch vụ</span><i
					class="bi bi-chevron-down ms-auto"></i></a>
			<ul id="service-nav" class="nav-content collapse show "
					data-bs-parent="#service-nav">
					<li><a href="/home/service/list"><i class="fas fa-list"></i><span>Lịch sử mua hàng</span></a></li>
					<li><a href="/home/service/list"><i class="fas fa-list"></i><span>Dịch vụ đang kích hoạt</span></a></li>
					<li></li>
					<li><a href="/home/service/list"><i class="fas fa-list"></i><span>Dịch vụ đã hết hạn</span></a></li>
					<li></li>
					</ul>
			<!-- End Components Nav -->
			<li class="nav-item"><a class="nav-link collapsed"
				href="/home/user/profiles?id=20"><i class="bi bi-person"></i><span>Profile</span></a></li>
			<!-- End Profile Page Nav -->
		
		
	</aside>
	<!-- End Sidebar-->