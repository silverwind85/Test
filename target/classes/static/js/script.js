$(document).ready(function() {
	$('.delete-user').on('click', function() {

		var path = window.location.pathname
		var url = path.substr(0, path.length - 13) + "user/remove";
		var token = $('#_csrf').attr('content');
		var header = $('#_csrf_header').attr('content');
		var id = $(this).attr('id');

		bootbox.confirm({
			message : "Usunąć Użytkownika?",
			buttons : {
				cancel : {

					label : '<i class="fa fa-times"></i> Anuluj'
				},
				confirm : {
					className : 'btn-dark',
					label : '<i class="fa fa-check"></i> Potwierdź'
				}
			},
			callback : function(result) {
				if (result) {
					$.ajax({
						type : "POST",
						url : url,
						data : {
							id : id
						},

						beforeSend : function(xhr) {
							xhr.setRequestHeader(header, token);
						},

						success : function(response) {
							location.reload()

						},
						error : function(e) {
							console.log(e);
						}

					});

				}

			}
		});

	});

	$('.status-user').on('click', function() {
		var path = window.location.pathname
		var url = path.substr(0, path.length - 13) + "user/status";
		
		var token = $('#_csrf').attr('content');
		var header = $('#_csrf_header').attr('content');
		var id = $(this).attr('id');
		var element = $(this);

		$.ajax({
			type : "POST",
			url : url,
			data : {
				id : id
			},

			beforeSend : function(xhr) {
				xhr.setRequestHeader(header, token);
			},

			success : function(response) {

				location.reload();

			},
			error : function(e) {
				console.log(e);
				/* alert('Failed!: ' + e); */
			}

		});
	});

	$('.btn-clear').click(function() {
		window.location.href = window.location.href;
	});

	$('.delete-publication').on('click', function(e) {
		var id = $(this).attr('id');
		e.preventDefault();

		var id = $(this).attr('id');
		var path = window.location.pathname
		var array = path.split("/");

		console.log(array);
		
		var url = (array[1]==="publications") ? '/publications/delete/' + id : "/"+array[1]+'/publications/delete/'+id;
		console.log(url);
		var token = $('#_csrf').attr('content');
		var header = $('#_csrf_header').attr('content');

		bootbox.confirm({
			message : "Czy napewno usunąć element?",
			buttons : {
				cancel : {

					label : '<i class="fa fa-times"></i> Anuluj'
				},
				confirm : {
					className : 'btn-dark',
					label : '<i class="fa fa-check"></i> Potwierdź'
				}
			},
			callback : function(result) {
				if (result) {
					$.ajax({
						type : "GET",
						url : url,

						beforeSend : function(xhr) {
							xhr.setRequestHeader(header, token);
						},

						success : function(response) {
							location.reload()

						},
						error : function(e) {
							console.log(e);
						}

					});

				}

			}
		});

	});

});
