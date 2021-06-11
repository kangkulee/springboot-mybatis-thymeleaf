$(document).ready(function() {
	$('#new_radio').click(function () {
          $("#pre_addr").hide();
          $("#new_addr").show();
        });
    $('#pre_radio').click(function () {
          $("#new_addr").hide();
          $("#pre_addr").show();
        });
    if($('input[id="pre_radio"]:checked').val()) {
		$("#new_addr").hide();
	}
	
	$("#quantity").on('change keyup', function() {
        var productPrice = $("#product_price").text().replace(/,/gi,"");
		var quantity = $("#quantity").val(); 
		var totalPrice = productPrice*quantity;
		
		$("#totalPrice").text(numberWithCommas(totalPrice));
    });
});

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
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
			//document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
			document.getElementById('sample4_roadAddress').value = fullRoadAddr;
			document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
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
};

function order(userNo, productNo) {
	let data = {
		user_no: userNo,
		product_no: productNo,
		order_quantity: $("#quantity").val(),
		order_totalPrice: $("#totalPrice").text()
	}
	
	$.ajax({
		type: "POST",
		url: "/auth/orderProc",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON"
	}).done(function(resp){
		if(resp.success != -1) {
			alert("주문이 완료 되었습니다.");
			location.href="/";
		} else {
			alert("주문에 실패 하였습니다.");
		}
	}).fail(function(err){
		alert(JSON.stringify(err));
	});
};