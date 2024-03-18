<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/icon/favicon.ico">
    <title>회원관리: IYF 영업관리시스템</title>
    
     <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

    <!-- NiceAdmin: Vendor CSS Files -->
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/bootstrap/css/bootstrap.min.css"
        rel="stylesheet">
    <link
        href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/bootstrap-icons/bootstrap-icons.css"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/boxicons/css/boxicons.min.css"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/quill/quill.snow.css"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/quill/quill.bubble.css"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/remixicon/remixicon.css"
        rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/simple-datatables/style.css"
        rel="stylesheet">

    <!-- NiceAdmin: Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/resources/NiceAdmin/assets/css/style.css" rel="stylesheet">

    <!-- toast-grid -->
    <link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
    
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>

    <!-- ======= Header ======= -->
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    <!-- End Header -->

    <!-- ======= Sidebar ======= -->
    <jsp:include page="/WEB-INF/views/sidebar.jsp"></jsp:include>
    <!-- End Sidebar-->
    
    <main id="main" class="main" style="width: 80vw;">
    
<!--     	<section> -->
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">회원목록</h5>
							<p>
								<select name="rowAmountPerPage" id="rowAmountPerPage">
									<option value="10">10개</option>
									<option value="20">20개</option>
									<option value="50">50개</option>
									<option value="100">100개</option>
								</select>
							</p>
							<select name="scope" id="scope">
								<option value="I">아이디</option>
								<option value="N">이름</option>
								<option value="C">회사명</option>
								<option value="E">가입승인</option>
							</select>
							<input type="text" name="keyword" id="keyword" placeholder="키워드 입력">
							<button type="button" id="btnKeywordSearch">검색</button>
							<table class="table mt-3">
								<colgroup>
									<col style="width: 5%;"/>
									<col style="width: 15%;"/>
									<col style="width: 15%;"/>
									<col style="width: 15%;"/>
									<col style="width: auto%;"/>
									<col style="width: 15%;"/>
								</colgroup>
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">아이디</th>
										<th scope="col">이름</th>
										<th scope="col">회사명</th>
										<th scope="col">권한</th>
										<th scope="col">가입승인</th>
									</tr>
								</thead>
		
								<tbody id="memberTbody">
									<c:forEach var="member" varStatus="memberStatus" items="${memberList}">
		
										<tr>
											<th scope="row">
												<c:out value="${(param.pageNum - 1) * param.rowAmountPerPage + memberStatus.index+1}" />
											</th>
											<td class="username">
												<c:out value="${member.username}" />
											</td>
											<td class="name">
												<c:out value="${member.name}" />
											</td>
											<td class="company">
												<c:out value="${member.company}" />
											</td>
											<td class="auth">
												<c:out value="${member.authorities}" />
											</td>
											<td class="enabled">
												<c:choose>
													<c:when test="${member.enabled == '0'}">
														미승인
													</c:when>
													<c:when test="${member.enabled == '1'}">
														승인완료
													</c:when>
												</c:choose>
											</td>
										</tr>
	
									</c:forEach>	
								</tbody>	
							</table>
						</div>
					</div>
		
		
		
				</div>
			</div>
			<nav aria-label="Page navigation example">
			  <ul class="pagination" style="justify-content:center;">
			    <c:if test="${pagingCreator.prev }">
					<li class="page-item">
						<a class="page-link" href="?pageNum=1&rowAmountPerPage=${param.rowAmountPerPage ne null ? param.rowAmountPerPage : 10}${param.scope eq null ? '' : '&scope='.concat(param.scope)}${param.keyword eq null ? '' : '&keyword='.concat(param.keyword)}">처음</a>
					</li>
				</c:if>
				<c:if test="${pagingCreator.prev }">
					<li class="page-item">
						<a class="page-link" href="?pageNum=${pagingCreator.startPagingNum - 1}&rowAmountPerPage=${param.rowAmountPerPage ne null ? param.rowAmountPerPage : 10}${param.scope eq null ? '' : '&scope='.concat(param.scope)}${param.keyword eq null ? '' : '&keyword='.concat(param.keyword)}">이전</a>
					</li>
				</c:if>
				
				<c:forEach var="pageNum" begin="${pagingCreator.startPagingNum }" end="${pagingCreator.endPagingNum }">
					<li class="page-item">
						<a class="page-link" href="?pageNum=${pageNum}&rowAmountPerPage=${param.rowAmountPerPage ne null ? param.rowAmountPerPage : 10}${param.scope eq null ? '' : '&scope='.concat(param.scope)}${param.keyword eq null ? '' : '&keyword='.concat(param.keyword)}">${pageNum}</a>
					</li>
				</c:forEach>
				
				<c:if test="${pagingCreator.next }">
					<li class="page-item">
						<a class="page-link" href="?pageNum=${pagingCreator.endPagingNum + 1}&rowAmountPerPage=${param.rowAmountPerPage ne null ? param.rowAmountPerPage : 10}${param.scope eq null ? '' : '&scope='.concat(param.scope)}${param.keyword eq null ? '' : '&keyword='.concat(param.keyword)}">다음</a>
					</li>
				</c:if>
				
				<c:if test="${pagingCreator.next }">
					<li class="page-item">
						<a class="page-link" href="?pageNum=${pagingCreator.lastPageNum}&rowAmountPerPage=${param.rowAmountPerPage ne null ? param.rowAmountPerPage : 10}${param.scope eq null ? '' : '&scope='.concat(param.scope)}${param.keyword eq null ? '' : '&keyword='.concat(param.keyword)}">끝</a>
					</li>
				</c:if>
			  </ul>
			</nav>
			
			
	
	
<!-- 		</section> -->

    </main><!-- End #main -->

    <!-- ======= Footer ======= -->
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!-- END Footer -->
	
	<script>
	
		function retainSelectedParams() {
			const currentUrl = window.location.search;
			const searchParams = new URLSearchParams(currentUrl);

			const rowAmountPerPage = searchParams.get("rowAmountPerPage");
			const scope = searchParams.get("scope");
			const keyword = searchParams.get("keyword");
			
			if (rowAmountPerPage) {
				$("#rowAmountPerPage").val(rowAmountPerPage);
			} else {
				$("#rowAmountPerPage").val(10);
			}

			if (scope) {
				$("#scope").val(scope);
				if ($('#scope').val() === 'C') {
					const enabledListEl = $('<dataList id="enabled-list">');
					const optEl1 = $('<option value="IYCNC">');
					const optEl2 = $('<option value="IBTS">');
					const optEl3 = $('<option value="IYS">');
					enabledListEl.append(optEl1);
					enabledListEl.append(optEl2);
					enabledListEl.append(optEl3);
					$('#scope').after(enabledListEl);
					$('#keyword').attr("list", "enabled-list");
				} else if ($('#scope').val() === 'E') {
					const enabledListEl = $('<dataList id="enabled-list">');
					const optEl1 = $('<option value="승인완료">');
					const optEl2 = $('<option value="미승인">');
					enabledListEl.append(optEl1);
					enabledListEl.append(optEl2);
					$('#scope').after(enabledListEl);
					$('#keyword').attr("list", "enabled-list");
				}
				
			} else {
				$("#scope").val("I");
			}

			if (keyword) {
				$("#keyword").val(keyword);
			} else {
				$("#keyword").val("");
			}

		}

		$(document).ready(function() {
			retainSelectedParams()
		
			$("a.page-link").filter(function() {
				const pageNum = new URLSearchParams(window.location.search).get("pageNum");
				
				if (!pageNum) {
					return $(this).text() == 1
				} else {
					return $(this).text() == pageNum;
				}
			}).parent("li").addClass("active");
			
			
			$("#memberTbody tr").hover(function() {
				$(this).find('.username').css({ "text-decoration": "underline" });
				$(this).css({ "background-color": "lightgray" })
					   .click(function() {
							const popupUrl = '${pageContext.request.contextPath}/admin/memberDetail?username=' + $(this).children(".username").text();
							const popupName = 'empPoolDetail-popup';
							const popupWidth = 800;
							const popupHeight = 600;
							const left = (screen.width - popupWidth) / 2;
							const top = (screen.height - popupHeight) / 2;

							window.open(popupUrl, popupName, 'width=' + popupWidth + ', height=' + popupHeight + ', left=' + left + ', top=' + top);
					
					   })	
			}, function() {
				$(this).find('.username').css({ "text-decoration": "none" });
				$(this).css({ "background-color": "" });
			});


			$("#rowAmountPerPage").change(function() {
				window.location.href = "?pageNum=1&rowAmountPerPage=" + $(this).val() + "&scope=" +$("#scope").val() + "&keyword=" + $("#keyword").val();
			})

			// 키워드 엔터입력 이벤트
			$('#keyword').keydown(function(e) {
				
		        if (e.keyCode === 13) { // Enter 키의 keyCode는 13입니다.
		            $("#btnKeywordSearch").trigger('click');
		        }
		    });
			
			// 키워드 검색 클릭 이벤트
			$("#btnKeywordSearch").click(function() {
				window.location.href = "?pageNum=1&rowAmountPerPage=" + $("#rowAmountPerPage").val() + "&scope=" +$("#scope").val() + "&keyword=" + $("#keyword").val();
			})
			
			$('#scope').change(function() {
				
				if ($('#scope').val() === 'C') {
					const enabledListEl = $('<dataList id="enabled-list">');
					const optEl1 = $('<option value="IYCNC">');
					const optEl2 = $('<option value="IBTS">');
					const optEl3 = $('<option value="IYS">');
					enabledListEl.append(optEl1);
					enabledListEl.append(optEl2);
					enabledListEl.append(optEl3);
					$('#scope').after(enabledListEl);
					$('#keyword').attr("list", "enabled-list");
				} else if ($('#scope').val() === 'E') {
					const enabledListEl = $('<dataList id="enabled-list">');
					const optEl1 = $('<option value="승인완료">');
					const optEl2 = $('<option value="미승인">');
					enabledListEl.append(optEl1);
					enabledListEl.append(optEl2);
					$('#scope').after(enabledListEl);
					$('#keyword').attr("list", "enabled-list");
				} else {
					$('#keyword').removeAttr("list");
				}
			})
			
       		// 사이드바 접을 때 그리드 리사이징
            $('i.toggle-sidebar-btn').click(function() {
            	if ($('body').attr('class') === 'toggle-sidebar') {
            		$('#main').attr('style', 'width: 93vw;');
            		$('#footer').attr('style', 'width: 93vw;');
            	} else {
            		$('#main').attr('style', 'width: 80vw;');
            		$('#footer').attr('style', 'width: 80vw;');
            	}
            	
            });

		});
	</script>
    
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <!-- Excel Export JS File-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.1/xlsx.full.min.js"></script>


    <!-- toast-grid -->
    <script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>

    <!-- Vendor JS Files -->
    <script
        src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script
        src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/chart.js/chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/echarts/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/quill/quill.min.js"></script>
    <script
        src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/tinymce/tinymce.min.js"></script>
    <script
        src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/vendor/php-email-form/validate.js"></script>

    <!-- NiceAdmin: Template Main JS File -->
    <script src="${pageContext.request.contextPath}/resources/NiceAdmin/assets/js/main.js"></script>
</body>
</html>