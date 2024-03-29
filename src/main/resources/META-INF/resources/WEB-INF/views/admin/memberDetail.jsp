<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/icon/favicon.ico">
    <title>회원 상세페이지: IYF 영업관리시스템</title>


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

	
    <main id="main" class="main">
        <section>
            <div class="container">
                <h1>회원 상세페이지</h1>
                <div class="form-group mb-3">
                    <label for="username">아이디:</label>
                    <input type="text" class="form-control" id="username" name="username" value="${member.username}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label for="name">이름:</label>
                    <input type="text" class="form-control" id="name" name="name" value="${member.name}">
                </div>
                <div class="form-group mb-3">
                    <label for="name">회사명:</label>
                    <input type="text" class="form-control" id="company" name="company" value="${member.company}">
                </div>
                <div class="row mt-2" id="row-change-password" >
                	<div class="col-4">
                	</div>
					<div class="col-8 text-end" style="display: ;">
						<input type="password" id="password" placeholder="비밀번호">
						<button type="button" id="btnChangePassword">변경</button>
					</div>
				</div>
                <div class="form-group mt-5 mb-5">
                    <span>
                    	<c:set var="isSystemAdmin" value="0"/>
                    	<c:set var="isIycncAdmin" value="0"/>
                    	<c:set var="isIbtsAdmin" value="0"/>
                    	<c:set var="isIysAdmin" value="0"/>
                    	<c:set var="hasNoAuthority" value="0"/>
                    	
                    	<c:forEach var="item" items="${member.authorities}">
                        	<c:choose>
                        		<c:when test="${item.authority == '통합 관리자'}"><c:set var="isSystemAdmin" value="1" /></c:when>
                        		<c:when test="${item.authority == 'IYCNC 관리자'}"><c:set var="isIycncAdmin" value="1" /></c:when>
                        		<c:when test="${item.authority == 'IBTS 관리자'}"><c:set var="isIbtsAdmin" value="1" /></c:when>
                        		<c:when test="${item.authority == 'IYS 관리자'}"><c:set var="isIysAdmin" value="1" /></c:when>
                        	</c:choose>
                        </c:forEach>
                        
                         <span class="btn-group btn-group-sm">
						    <input type="checkbox" class="btn-check" name="auth" id="auth1" value="통합 관리자" <c:if test="${isSystemAdmin == '1'}">checked</c:if>>
						    <label class="btn btn-outline-primary" for="auth1">통합 관리자</label>
							
							<input type="checkbox" class="btn-check" name="auth" id="auth2" value="IYCNC 관리자" <c:if test="${isIycncAdmin == '1'}">checked</c:if>>
							<label class="btn btn-outline-primary" for="auth2">IYCNC 관리자</label>
							
							<input type="checkbox" class="btn-check" name="auth" id="auth3" value="IBTS 관리자" <c:if test="${isIbtsAdmin == '1'}">checked</c:if>>
							<label class="btn btn-outline-primary" for="auth3">IBTS 관리자</label>
							
							<input type="checkbox" class="btn-check" name="auth" id="auth4" value="IYS 관리자" <c:if test="${isIysAdmin == '1'}">checked</c:if>>
							<label class="btn btn-outline-primary" for="auth4">IYS 관리자</label>
						 </span>
                    </span>
	
                    <span class="float-end">
                        <label for="enabled">가입승인:</label>
                        <select name="enabled" id="enabled">
                        <c:choose>
                            <c:when test="${member.enabled == '0'}">
                                <option value="0" selected>미승인</option>
                                <option value="1">승인완료</option>
                            </c:when>
                            <c:when test="${member.enabled == '1'}">
                                <option value="0">미승인</option>
                                <option value="1" selected>승인완료</option>
                            </c:when>
                        </c:choose>
                        </select>
                    </span>
                </div>
                <div class="form-group mt-3">
                    <button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
                    <button type="button" class="btn btn-danger float-end" id="btnDelete">삭제</button>
                </div>
            </div>
        </section>

    </main><!-- End #main -->
    

    <script>
        $(document).ready(function () {
        	
        	
            // 수정 버튼 클릭 시 이벤트
            $('#btnUpdate').click(function() {
                const authList = []; //권한 배열 초기화
                	$("input[name=auth]:checked").each(function(){
                		authList.push($(this).val()); //선택한 권한만 추가
                	});
                		
                const requestMap = { //해당 데이터를 requestMap에 추가
             		username: $('#username').val(),
             		name: $('#name').val(),
             		company: $('#company').val(),
             		authList: authList,
             		enabled: $('#enabled').val()
                };
                
                $.ajax({
                    type: 'PUT',
                    url: '${pageContext.request.contextPath}/admin/member.ajax/',
                    data: JSON.stringify(requestMap),
                    contentType: 'application/json',
                    success: function() {
                    	alert('회원 수정이 완료되었습니다.')
                        opener.parent.location.reload();
                       	window.location.reload();
                        
                    },
                    error: function() {
                        alert('내부 서버 오류')
                    }
                })
            });

            

            // 삭제 버튼 클릭 시 이벤트: 실제 삭제
            $('#btnDelete').click(function () {
                if (!confirm('해당 회원을 정말로 삭제하시겠습니까?')) {
                    return;
                } else {
                    $.ajax({
                        type: 'DELETE',
                        url: '${pageContext.request.contextPath}/admin/member.ajax/username/' + $('#username').val(),
                        success: function () {
                            opener.parent.location.reload();
                            window.close();
                        },
                        error: function () {
                            opener.parent.location.reload();
                            window.close();
                        }
                    });
                }
                    
            })
            
            // 회원 비밀번호 변경
            $('#btnChangePassword').click(function() {
            	if (!$('#password').val()) {
            		alert('변경할 비밀번호를 입력해주세요.');
            		return;
            	}
            	if (!confirm('해당 회원의 비밀번호를 변경하시겠습니까?')) {
                    return;
                } else {

                	const requestMap = {
              			username: $('#username').val(),
              			password: $('#password').val(),
                	};
                	
                	$.ajax({
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/admin/member.ajax/changePassword/',
                        data: JSON.stringify(requestMap),
                        contentType: 'application/json',
                        success: function () {
                        	alert('비밀번호 변경이 완료되었습니다.')
                            opener.parent.location.reload();
                           	window.location.reload();
                        },
                        error: function () {
                        	alert('내부 서버 오류')
                        }
                    });
                }
            });
            

        });

    </script>


    

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