// 우클릭 > open with > generic editor로 열어야 함. 


// HTML 요소의 자바스크립트 객체를 선택
const btn01 = document.getElementById("btn01")

// HTML 요소에 이벤트 걸어주기
btn01.addEventListener("click" ,request )


function request(){
	
	// 동기 통신 : 요청에 대한 응답으로 전체 HTML을 응답
	
	// 비동기 통신 : 요청이 발생하면 필요한 데이터만 응답
	// 			  페이지 이동(전환) X
	//			  >> 주고 받는 데이터 양이 줄어듦
	// 			  >> 작업을 이어할 수 있다. 
	//			  >> 데이터 처리를 Client에 위임
	// 			  << 무분별한 요청이 발생할 수 있음. -> 로딩바 등으로 막음.
	
	
	// 내부서버(같은 프로젝트 내) 요청 시에는 urlmapping만 작성해도 된다.
	// 외부서버(다른 프로젝트/서버)로 요청 시에는 전체 url 작성해야함.
	// 		>> CORS 에러를 처리해줘야 한다. 
	// react -> spring 갈 때도 동일 출처 처리를 해줘야됨. 
	var url = "axios01"; // 매핑값과 동일하게 설정. 	
	
	// .get(url):GET 방식
	// .post(url): POST방식 요청
	axios.get(url)
		 .then(function(res){
			// 응답이 돌아오면 무슨 일을 할지 정의
			// 응답 데이터는 매개변수에 담김
			console.log(res.data);		
			
			
			
		}
	)
	
}

//=================================================

//Get 방식으로 데이터 전송
const btn02 = document.getElementById("btn02")

let request2 = function(){
	
	let url ="axios02";
	
	const inp01 = document.getElementById("inp01");
	let text = inp01.value; // input text 가져오기
	
	// get 방식으로 데이터 전송 시, 
	// query string, path variable을 작성해서 전송
	axios.get(url+"?text="+text)
		 .then(function(res){
			console.log(res.data)
			
		})
		
}

btn02.addEventListener("click",request2 )



//=========================================================

//POST방식+데이터 응답

const btn03 = document.getElementById("btn03")
const div = document.getElementById("result")
//name은 여러개에 묶여서 나오기 때문에 인덱스 설정 필요
const tinput = document.getElementsByName("title")[0]; 
//css 선택자를 기준으로 사용, 태그명[속성명=속성값]
const winput = document.querySelector("input[name=writer]");

let request03 = function(){
	
	let url = "axios03";
	
	let title = tinput.value;
	let writer = winput.value;
	let data = { // 자바스크립트 객체 양식
		
		"title" : title,
		"writer" : writer 
	};  
	// post 방식으로 전송 시에 데이터를 객체로 묶어서 전송
	// javascript --> json 형식으로 전송
	// JavaScript Object Notation
	axios.post(url, data)
		 .then(function(res){
			console.log(res.data);
			
			for(let i = 0 ; i<res.data.length;i++){
				// div에 게시글 제목들을 출력
				div.innerHTML += "<p>"+res.data[i].title+"</p>";
				
				
			}
			
			})
	
	
}

btn03.addEventListener("click",request03)









