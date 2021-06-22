$(document).ready(function(){
	$("#search").keydown(function(key) {
		if(key.keyCode == 13) {
			search();
		}
	});
});

function writeBoard() {
	let data = {
		user_no: $("#user_no").val(),
		freeboard_title: $("#freeboard_title").val(),
		freeboard_content: $("#freeboard_content").val()
	};

	$.ajax({
		// 수행 요청
		type: "POST",
		url: "/api/freeboard",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON"
	}).done(function(resp) {
		// 요청이 정상
		if (resp.success != -1) {
			alert("글쓰기가 완료되었습니다.");
		} else {
			alert("글쓰기가 실패하였습니다.");
		};
		location.href = "/auth/freeboard/1";
	}).fail(function(err) {
		// 요청에 실패
		alert(JSON.stringify(err));
	});
};

function search() {
	var column = $("#column option:selected").val();
	var search = $("#search").val();
	if (search == "") {
		location.href = "/auth/freeboard/1/";
	} else {
		location.href = "/auth/freeboard/1/" + column + "/" + search;
	}
}

function updateBoard(boardNo) {
	let data = {
		freeboard_title: $("#freeboard_title").val(),
		freeboard_content: $("#freeboard_content").val()
	};

	$.ajax({
		type: "PUT",
		url: "/api/freeboard/" + boardNo,
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "JSON"
	}).done(function(resp) {
		if (resp.success != -1) {
			alert("글수정이 완료되었습니다.");
		} else {
			alert("글수정이 실패하였습니다.");
		};
		history.go(-2);
	}).fail(function() {
		alert(JSON.stringify(err));
	});
}

function deleteBoard(boardNo) {
	$.ajax({
		type: "DELETE",
		url: "/api/freeboard/" + boardNo
	}).done(function(resp) {
		if (resp.success != -1) {
			alert("글삭제가 완료되었습니다.");
		} else {
			alert("글삭제가 실패하였습니다.");
		};
		history.back();
	}).fail(function() {
		alert(JSON.stringify(err));
	});
}