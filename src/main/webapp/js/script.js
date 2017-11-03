
function clickCtrlEnter(idForm) {
	
	if ((event.keyCode == 10 || event.keyCode == 13) && event.ctrlKey) {
		document.getElementById(idForm).submit();
	}
	
}

function confirmDeletion() {

	if (confirm('Вы уверены?')) {
		return true;
	} else {
		return false;
	}

}

function addLike(idpost) {

	event.preventDefault();
	
	$.ajax({
		url: "addlike.html",
		data: ({postid : idpost}),
		success: function(data) {
			$("#likes").text(data);
		}
	});
	
}

function getLike(idpost) {

	$.ajax({
		url: "getlike.html",
		data: ({postid : idpost}),
		success: function(data) {
			$("#likes").text(data);
		}
	});
	
}
