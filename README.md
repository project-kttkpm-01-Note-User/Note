# Note

NOTE:

getAll:

	GET: http://localhost:8081/notes

addNote :

	POST: http://localhost:8081/notes
  
	data:{
       		"title":"test3",
      		"content":"Dương Diễm Phước",
      		"userId":2
	 }

getByUserId: (ĐÃ SORT (THEO NGÀY CHỈNH SỬA VS PHÂN TRANG) 

	GET:http://localhost:8081/notes/userId/ID?page=PAGE&limit=LIMIT
	
	ID: idUser,
	PAGE: page tương ứng,
	LIMIT: số đối tượng trong 1 page


updateNote:

	POST: http://localhost:8081/notes/update
  
	data: {
		 "id":1,
       		"title":"test3",
      		 "content":"Dương Diễm Phước",
       		"userId":2
	}


getByid: 

	GET: http://localhost:8081/notes/3


deleteNote:

	DELETE: http://localhost:8081/notes/delete/3
