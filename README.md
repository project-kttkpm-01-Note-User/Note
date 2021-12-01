API 

Lưu ý : /auth/** : k cần token

	Còn lại phải add heahers : headers: { Authorization: `Bearer ${token}`}

REGISTER:

Post : http://localhost:9191/auth/register

Truyền vào:	

		data:{
			userName:"",
			password:""
		}
Trả về: 
		
	{
   		 "user": {
      			  "id": 7,
      			  "userName": "test2",
       			 "password": "123456"
   			 },

   		 "token": "eyJhbGciOiJIUzI1NiJ9.eyJQaHVvYyI6eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJJZCI6NywiYXV0aG9yaXRpZXMiOm51bGwsInVzZXJuYW1lIjoidGVzdDIifSwiZXhwIjoxNjM5MjMwOTM1fQ.kPDUcADmssrsYAx0SEYe-66IWTTjyvpfsSglZIm7weY"
	}

LOGIN: 
Post : http://localhost:9191/auth/login

Truyền vào:	

		data:{
			userName:"",
			password:""
		}
Trả về: 
		
	{
   		 "user": {
      			  "id": 7,
      			  "userName": "test2",
       			 "password": "123456"
   			 },

   		 "token": "eyJhbGciOiJIUzI1NiJ9.eyJQaHVvYyI6eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJJZCI6NywiYXV0aG9yaXRpZXMiOm51bGwsInVzZXJuYW1lIjoidGVzdDIifSwiZXhwIjoxNjM5MjMwOTM1fQ.kPDUcADmssrsYAx0SEYe-66IWTTjyvpfsSglZIm7weY"
	}



findById :

	GET : http://localhost:9191/auth/user/1


NOTE:


ADDNOTE:

	POST: http://localhost:9191/notes
  
 TRUYỀN: 

	 data:{
       		"title":"test3",
      		"content":"Dương Diễm Phước",
      		"userId":2
	 }
 Trả về: 


 {
    "id": 7,
    "title": "test3",
    "content": "Dương Diễm Phước",
    "createdAt": "2021-12-01T14:05:46.828+00:00",
    "updateAt": "2021-12-01T14:05:46.828+00:00",
    "userId": 2
}

GETBYUSERID (ĐÃ SORT (THEO NGÀY CHỈNH SỬA VS PHÂN TRANG) 

	GET:http://localhost:9191/notes/userId/ID?page=PAGE&limit=LIMIT
	
	ID: idUser,
	PAGE: page tương ứng,
	LIMIT: số đối tượng trong 1 page


UPDATE NOTE

	POST: http://localhost:9191/notes/update
  
 TRUYỀN:

	data: {
		 "id":1,
       		"title":"test3",
      		 "content":"Dương Diễm Phước",
       		"userId":2
	}

 TRẢ : NOTE mới


GETNOTEBYID

	GET: http://localhost:9191/notes/7

 Trả :
 
{
    "note": {
        "id": 7,
        "title": "test3",
        "content": "Dương Diễmc",
        "createdAt": "2021-12-01T14:05:47.000+00:00",
        "updateAt": "2021-12-01T14:08:20.000+00:00",
        "userId": 2
    },
    "user": {
        "id": 2,
        "userName": "truongphuoc",
        "password": "123456"
    }
}


DELETENOTE

	DELETE: http://localhost:9191/notes/delete/3
