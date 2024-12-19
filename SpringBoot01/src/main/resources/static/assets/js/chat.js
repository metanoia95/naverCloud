

// 1. 필요한 변수 미리 준비하기
const einput = document.getElementById("email");
const tinput = document.getElementById("text");
const btn = document.getElementById("btn");
const div = document.getElementById("result");


// 2. WebSocket과 연결
let room ="test";
let url = "ws://localhost:8088/chat/"+room // 전체 경로로만 연결가능. 
// 채팅방 >> path variable로 방 id 보내기.

// web socket 객체 생성 == 서버와 연결
let websocket = new WebSocket(url);

// 3. 서버로 메세지 보내기

let sendMessage = function(){
	// 보내줄 데이터를 담을 객체
	chat = {
		"email" : einput.value,
		"text" : tinput.value
	}
	// javascript object --> json
	var json = JSON.stringify(chat) // json 변환
	
	
	// .send("text") : 서버로 메시지 전송이 일어남. 
	websocket.send(json);
	
	print("me",chat);
}


btn.addEventListener("click", sendMessage)

//4. websocket 콜백함수 지정
function onOpen(){
	
	
}
function onClose(){
	
	
}
function onMessage(msg){
	// 받은 메세지가 매개변수에 자동으로 담김. 
	
	console.log(msg.data);
	
	//json String --> javascript object
	var json = JSON.parse(msg.data); 
	
	print("other",json);
}

// WebSocket과 연결됐을 때
websocket.onopen = onOpen; 

// WebSocket이 닫혔을 때
websocket.onclose = onClose;

// 메시지를 받았을 때.
websocket.onmessage = onMessage;

// 5. 출력
function print(who, json){
	
	div.innerHTML+=`
		<p class="${who}">
		 ${json.email} : ${json.text}
		
		</p>
	`;
	
}