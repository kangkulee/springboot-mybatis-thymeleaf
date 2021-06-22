function save() {
	var roadAddress = $("#sample4_roadAddress").val();
	var jibunAddress = $("#sample4_jibunAddress").val();
	var user_addr = null;
	
	if(roadAddress != "") {
		user_addr = roadAddress + $("#user_detailAddr").val();
	}
	
	if(roadAddress == "") {
		user_addr = jibunAddress + $("#user_detailAddr").val();
	}
	
	let data = {
		user_id: $("#user_id").val(),
		user_name: $("#user_name").val(),
		user_password: $("#user_password").val(),
		user_addr: user_addr,
		user_phone: $("#user_phone").val(),
		user_email: $("#user_email").val()
	}

	$.ajax({
		// 수행 요청
		type: "POST",
		url: "/auth/joinProc",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON"
	}).done(function(resp) {
		// 요청이 정상
		if (resp.success != -1) {
			alert("회원가입이 완료되었습니다.")
			location.href = "/";
		} else {
			alert("회원가입이 실패하였습니다.");
		};
	}).fail(function(err) {
		// 요청에 실패
		alert(JSON.stringify(err));
	});
};

function DaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 도로명 조합형 주소 변수
			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== ''
				&& /[동|로|가]$/g.test(data.bname)) {
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== ''
				&& data.apartment === 'Y') {
				extraRoadAddr += (extraRoadAddr !== '' ? ', '
					+ data.buildingName : data.buildingName);
			}
			// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraRoadAddr !== '') {
				extraRoadAddr = ' (' + extraRoadAddr + ')';
			}
			// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
			if (fullRoadAddr !== '') {
				fullRoadAddr += extraRoadAddr;
			}
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			//$("#sample4_postcode").val(data.zonecode); //5자리 새우편번호 사용
			$("#sample4_roadAddress").val(fullRoadAddr);	
			$("#sample4_jibunAddress").val(data.jibunAddress);
			$("#old_addr").val("");
			$("#old_addr_form").hide();
			// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
			if (data.autoRoadAddress) {
				//예상되는 도로명 주소에 조합형 주소를 추가한다.
				var expRoadAddr = data.autoRoadAddress
					+ extraRoadAddr;
				document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
					+ expRoadAddr + ')';
			} else if (data.autoJibunAddress) {
				var expJibunAddr = data.autoJibunAddress;
				document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
					+ expJibunAddr + ')';
			} else {
				document.getElementById('guide').innerHTML = '';
			}
		}
	}).open();
}

function updateUser(userNo) {
	var user_password = null;
	var roadAddress = $("#sample4_roadAddress").val();
	var jibunAddress = $("#sample4_jibunAddress").val();
	var user_addr = null;
	
	if(roadAddress != "") {
		user_addr = roadAddress + $("#user_detailAddr").val();
	}
	
	if(roadAddress == "") {
		user_addr = jibunAddress + $("#user_detailAddr").val();
	}
	
	if(user_addr == "") {
		user_addr = $("#old_addr").val();
	}

	if($("#new_user_password").val() != "") {
		user_password = $("#new_user_password").val()
	}
	let data = {
		user_password: user_password,
		user_addr: user_addr,
		user_phone: $("#user_phone").val(),
		user_email: $("#user_email").val()
	};
	
	$.ajax({
		// 수행 요청
		type: "PUT",
		url: "/api/user/" + userNo,
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON"
	}).done(function(resp) {
		// 요청이 정상
		if (resp.success != -1) {
			alert("회원수정이 완료되었습니다.");
		} else {
			alert("회원수정이 실패하였습니다.");
		};
		location.href = "/";
	}).fail(function(err) {
		// 요청에 실패
		alert(JSON.stringify(err));
	});
};