// 이메일 중복 체크

const input = document.getElementById("email");

const p = document.getElementById("result");

// change : input 태그의 값이 변했을 때
// -- 입력을 다 하고 커서가 밖으로 나갔을 때 발생
// input : input 태그에 입력이 발생했을 때
// -- 입력을 할 때마다 계속 실행됨. 


let request = function(){
	
	let url = "check";
	
	let email = input.value;
	
	axios.get(url+"?email="+email)
		 .then(function(res){
			
			console.log(res.data)
			
			if(res.data=="t"){ //true, false로 받으면 느슨한 형변환이 됨. 
				p.innerText="사용가능한 이메일 입니다.";
				p.style="color : green";
			}else if(res.data=="f"){
				p.innerText="니 이메일 이미 있음ㅅㄱ";
				p.style="color : red";
			}
			
			
		});
	
}

input.addEventListener("input", request );
