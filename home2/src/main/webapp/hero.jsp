
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.lang" />
<!-- Start Hero -->
<section class="relative  md:py-56 py-36 container" data-aos="fade-up">
	<div class="absolute inset-0 bg-hero"></div>
	<div class="container z-1">
		<div class="grid grid-cols-1 text-center mt-10 relative">
			<h4
				class="lg:leading-normal leading-normal text-4xl lg:text-5xl mb-5 font-bold">
				<fmt:message key="menu.join" />
				& <span class="text-emerald-600 font-bold"><fmt:message
						key="menu.explore" /></span> <br> <span
					class="text-emerald-600 font-bold"><fmt:message
						key="menu.thousands" /></span>
				<fmt:message key="menu.ofjob" />
			</h4>
			<p class="text-slate-400 text-lg max-w-xl mx-auto">
				<fmt:message key="menu.des" />
			</p>

			<div class="d-flex" id="reserve-form">
				<div class="md:w-5/6 mx-auto">
					<div class="lg:col-span-10 mt-8">
						<div
							class="bg-white dark:bg-slate-900 border-0 shadow rounded-md p-3">
							<form action="/home/jobs" autocomplete="off" class=""
								method="get">
								<div class="registration-form text-dark text-start">
									<div id="filter_box"
										class="grid lg:grid-cols-12 md:grid-cols-6 relative items-center grid-cols-1 lg:gap-0 gap-6">
										<div
											class="filter-search-form lg:col-span-5 md:col-span-3 relative items-center flex filter-border">
											<i class="fa-solid fa-magnifying-glass"></i> <input
												type="text" onkeyup="displayResultSearch(this)"
												id="job-keyword" name="key"
												class="outline-none ps-4 lg:w-[260px] md:w-[120px]  form-control"
												placeholder="Nhập từ khóa">
										</div>
										<ul id="result_search"
											class="absolute hidden md:block bg-white w-[280px] z-5 rounded shadow top-12 left-0 ">

										</ul>


										<div
											class="filter-search-form flex items-center lg:col-span-3 md:col-span-2  filter-border">
											<i class="fa-solid fa-location-dot"></i> <select
												class="form-select outline-none w-full" name="lc" data-trigger
												name="choices-location" id="choices-location"
												aria-label="Default select example">
												<option value="">Tất cả thành phố</option>
												<option value="Hà Nội">Hà Nội</option>
												<option value="Hà Nam">Hà Nam</option>
												<option value="Hải Phòng">Hải Phòng</option>
												<option value="Thái Nguyên">Thái Nguyên</option>
												<option value="Nam Định">Nam Định</option>
												<option value="Thanh Hóa">Thanh Hóa</option>
												<option value="Nghệ An">Nghệ An</option>
												<option value="Hồ Chí Minh">Hồ Chí Minh</option>
												<option value="Thái Bình">Thái Bình</option>
												<option value="Khánh hòa">Khánh hòa</option>
												<option value="Cao Bằng">Cao Bằng</option>
											</select>
										</div>

										<div
											class="filter-search-form flex items-center lg:col-span-3 md:col-span-2  filter-border">
											<i class="fa-solid fa-users"></i> <select
												class="form-select outline-none w-full" name="cr" data-trigger
												name="choices-type" id="choices-type"
												aria-label="Default select example">
												<option value="0">Tất cả ngành nghề</option>
												<option value="215">Bác Sĩ/Điều Trị Đa Khoa/Điều Trị Nội Trú</option><option value="129">Bán Hàng Kỹ Thuật</option><option value="151">Bán Hàng Qua Điện Thoại</option><option value="152">Bán Hàng/Phát Triển Kinh Doanh</option><option value="61">Bảo Hiểm</option><option value="62">Bao Tiêu/Bảo Lãnh</option><option value="153">Bảo trì/Bảo Dưỡng</option><option value="106">Bảo Vệ</option><option value="66">Bất Động Sản/Cho Thuê</option><option value="105">Biên Phiên Dịch</option><option value="169">Bộ Phận Tiền Sảnh &amp; Dịch Vụ Khách Hàng</option><option value="63">Bồi Thường Bảo Hiểm</option><option value="75">Chính Phủ/Phi Lợi Nhuận(Chính sách, Quy hoạch &amp; Quy định</option><option value="197">Chỉnh Sửa Video</option><option value="67">Cho Thuê &amp; Quản Lý Căn Hộ</option><option value="78">Chuyển Đổi Số</option><option value="122">Cơ Khí &amp; Điện Lạnh</option><option value="154">Cơ Khí Tự Động Hoá</option><option value="120">Công Nghệ Sinh Học</option><option value="121">Công Nghệ Thực Phẩm</option><option value="170">Công Ty Kinh Doanh Lữ Hành</option><option value="79">Data Engineer/Data Analyst/AI</option><option value="211">Dịch Vụ Hàng Không</option><option value="160">Dịch Vụ Hỗ Trợ Khách Hàng</option><option value="100">Dịch Vụ Sinh Viên/Hỗ Trợ Học Viên</option><option value="212">Dịch Vụ Vận Tải Công Cộng</option><option value="216">Dược Sĩ</option><option value="91">Dược(Phân Phối Dược Phẩm)</option><option value="175">Gắn Kết Nhân Viên</option><option value="101">Giảng Dạy/Đào Tạo</option><option value="107">Hành Chính</option><option value="191">Hoạch Định &amp; Quản Lý Sản Xuất</option><option value="171">Hướng Dẫn Viên Du Lịch</option><option value="155">In Ấn</option><option value="80">IT Support/Help Desk</option><option value="149">Kế hoạch/Tư Vấn Doanh Nghiệp</option><option value="141">Kế Toán Chi Phí</option><option value="142">Kế Toán Công Nợ</option><option value="143">Kế Toán Doanh Thu</option><option value="144">Kế Toán Quản Trị</option><option value="147">Kế Toán Tài Chính</option><option value="145">Kế Toán Thanh Toán</option><option value="146">Kế Toán Thuế</option><option value="148">Kế Toán Tổng Hợp</option><option value="139">Kế Toán/Kiểm Toán(Kiểm Soát Viên Tài Chính</option><option value="123">Khai Thác Mỏ</option><option value="140">Kiểm Toán</option><option value="132">Kiến Trúc/Xây Dựng(An Toàn Lao Động</option><option value="68">Kinh Doanh Thương Mại, Cho Thuê &amp; Quản Lý Tài Sản</option><option value="156">Kỹ Thuật CNC</option><option value="124">Kỹ Thuật Hóa Học</option><option value="125">Kỹ Thuật Môi Trường</option><option value="126">Kỹ Thuật Ô Tô</option><option value="217">Kỹ Thuật Viên Y Tế</option><option value="127">Kỹ Thuật Điện/Điện Tử</option><option value="108">Lễ Tân/Tiếp Tân</option><option value="182">Luật Lao động/Hưu Trí</option><option value="183">Luật Sở Hữu Trí Tuệ</option><option value="185">Luật Tài Chính Ngân Hàng Thương mại</option><option value="184">Luật Thuế</option><option value="186">Luật Xây Dựng</option><option value="161">Môi Giới &amp; Giao Dịch Chứng Khoán</option><option value="157">Nghệ thuật, Truyền thông/In ấn/Xuất bản(In Ấn &amp; Xuất Bản</option><option value="201">Nghiên Cứu &amp; Phân Tích Thị Trường</option><option value="192">Nghiên Cứu &amp; Phát Triển</option><option value="102">Nghiên Cứu Học Thuật</option><option value="76">NGO/Phi Lợi Nhuận)</option><option value="177">Nhân Sự Tổng Hợp</option><option value="181">Nông/Lâm/Ngư Nghiệp</option><option value="82">Phần Cứng Máy Tính</option><option value="83">Phần Mềm Máy Tính</option><option value="162">Phân Tích &amp; Báo Cáo Tài Chính</option><option value="70">Phân Tích Dự Án Bất Động Sản</option><option value="81">Phân Tích Kinh Doanh/Phân Tích Hệ Thống</option><option value="193">Phân Tích Sản Xuất</option><option value="69">Phát Triển Bất Động Sản</option><option value="133">Phát Triển Dự Án/Đấu Thầu</option><option value="92">Phát Triển Sản Phẩm May Mặc</option><option value="84">QA/QC/Software Testing</option><option value="223">Quản lí chuỗi cung ứng</option><option value="202">Quan Hệ Công Chúng</option><option value="203">Quản Lý &amp; Phát Triển Sản Phẩm</option><option value="114">Quản Lý Chuỗi Cung Ứng</option><option value="71">Quản Lý Cơ Sở Vật Chất</option><option value="85">Quản Lý Công Nghệ Thông Tin</option><option value="57">Quản Lý Cửa Hàng</option><option value="134">Quản Lý Dự Án</option><option value="86">Quản Lý Dự Án Công Nghệ</option><option value="97">Quản Lý F&amp;B</option><option value="103">Quản Lý Giáo Dục</option><option value="115">Quản Lý Kho &amp; Phân Phối</option><option value="58">Quản Lý Khu Vực</option><option value="163">Quản Lý Quan Hệ Khách Hàng</option><option value="164">Quản Lý Quỹ</option><option value="204">Quản Lý Sự Kiện</option><option value="206">Quản Lý Tài Khoản Khách Hàng</option><option value="187">Quản Lý Thi Hành Pháp Luật</option><option value="205">Quản Lý Thương Hiệu</option><option value="109">Quản Lý Văn Phòng</option><option value="116">Quản Lý Đội Xe</option><option value="93">Quản Lý Đơn Hàng</option><option value="87">Quản Trị Cơ Sở Dữ Liệu</option><option value="178">Quản Trị Hiệu Suất &amp; Sự Nghiệp</option><option value="98">Quầy Bar/Đồ Uống/Phục vụ</option><option value="194">Quy Trình &amp; Lắp Ráp</option><option value="158">Sản Xuất Chương Trình</option><option value="88">System/Cloud/DevOps Engineer</option><option value="135">Thiết Kế &amp; Quy Hoạch Đô Thị</option><option value="198">Thiết Kế Công Nghiệp/Kỹ Thuật</option><option value="136">Thiết Kế Kiến Trúc/Họa Viên Kiến Trúc</option><option value="137">Thiết Kế Nội Thất</option><option value="199">Thiết Kế Thời Trang/Trang Sức</option><option value="200">Thiết Kế Đồ Họa)</option><option value="165">Thu Hồi Nợ</option><option value="111">Thư Ký</option><option value="188">Thư Ký Luật &amp; Trợ Lý Luật</option><option value="189">Thư Ký Pháp Lý</option><option value="59">Thu Mua</option><option value="117">Thu Mua &amp; Quản Trị Hàng Tồn Kho</option><option value="207">Tiếp Thị</option><option value="208">Tiếp Thị Nội Dung</option><option value="209">Tiếp Thị Thương Mại</option><option value="210">Tiếp Thị Trực Tuyến</option><option value="167">Tín Dụng</option><option value="60">Trợ Lý Bán Lẻ</option><option value="112">Trợ Lý Kinh Doanh</option><option value="104">Tư Vấn Giáo Dục</option><option value="190">Tư Vấn Pháp Lý</option><option value="64">Tư Vấn Rủi Ro</option><option value="218">Tư Vấn Tâm Lý &amp; Công Tác Xã Hội</option><option value="166">Tuân Thủ &amp; Kiểm Soát Rủi Ro</option><option value="179">Tuyển Dụng</option><option value="89">UX/UI Design</option><option value="195">Vận Hành Máy Móc</option><option value="213">Vận Tải Đường Bộ</option><option value="214">Vận Tải Đường Sắt &amp; Hàng Hải</option><option value="118">Vận Tải/Giao Nhận Hàng Hóa</option><option value="172">Vệ Sinh Buồng Phòng</option><option value="90">Viễn Thông</option><option value="138">Xây Dựng</option><option value="119">Xuất Nhập Khẩu &amp; Thủ Tục Hải Quan</option><option value="219">Y Tá</option><option value="173">Đại Lý Du Lịch</option><option value="159">Đạo Diễn Nghệ Thuật/Nhiếp Ảnh</option><option value="180">Đào Tạo Và Phát Triển</option><option value="174">Đặt Phòng Khách Sạn</option><option value="99">Đầu Bếp</option><option value="168">Đầu Tư Tài Chính</option><option value="128">Điện/Nước/Chất Thải</option><option value="113">Điều Phối</option><option value="72">Định Giá</option><option value="65">Định Phí Bảo Hiểm</option>
											</select>
										</div>

										<button type="submit" id="search" style=""
											class="btn rounded lg:col-span-1 md:col-span-2 bg-emerald-600 hover:bg-emerald-700 border-emerald-600 hover:border-emerald-700 text-white searchbtn submit-btn px-2 py-1">
											Lọc<i class="fa-solid fa-filter ms-1"></i>
										</button>
									</div>
									<!--end grid-->

								</div>
								<!--end container-->
							</form>
						</div>
					</div>
					<!--ed col-->
				</div>
			</div>
			<!--end grid-->

			<div class="mt-4">
				<span class="text-slate-400"><span class="text-dark">Popular
						Searches :</span> Designer, Developer, Web, IOS, PHP Senior Engineer</span>
			</div>

			<div
				class="absolute -top-20 hidden md:block  start-1/2 -translate-x-1/2">
				<div
					class="w-10 h-10 animate-[bounce_2s_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/facebook-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-[20%] hidden md:block  start-10">
				<div
					class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/google-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-[20%] hidden md:block end-1">
				<div
					class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/android.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-3/4 hidden md:block start-1">
				<div
					class="w-10 h-10 bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/lenovo-logo.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div class="absolute top-3/4 hidden md:block  end-10">
				<div
					class="w-10 h-10 animate-[spin_5s_linear_infinite] bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/skype.png" class="h-6 w-6" alt="">
				</div>
			</div>

			<div
				class="absolute -bottom-32 hidden md:block  start-1/2 -translate-x-1/2">
				<div
					class="w-10 h-10 animate-pulse bg-white dark:bg-slate-900 flex items-center justify-center shadow dark:shadow-gray-700 rounded-md">
					<img src="/home/img/snapchat.png" class="h-6 w-6" alt="">
				</div>
			</div>
		</div>
		<!--end grid-->
	</div>
	<!--end container-->
</section>
<!--end section-->
<!-- End Hero -->