


const input = document.getElementById("text")
const Btn = document.getElementById("searchBtn")


let search = function(){
	
	
	var url = "search";
	let text = input.value;
	
	axios.get(url+"?text="+text)
		 .then(function(res){
			
			console.log(res.data)
			
			const tbody = document.querySelector("tbody");
			
			tbody.innerHTML = "";
			
			for(let i =0 ; i<res.data.length;i++){
				
				let board = res.data[i];
				
				tbody.innerHTML += `
					<tr>
						<td>${board.idx}</td>
						<td> <a href = "view?idx=${board.idx}"> ${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.indate}</td>
						<td><a href = "delete/${board.idx}" > X </a> </td>
					</tr>`;
				
			}
			
		});
		
	
}

Btn.addEventListener("click",search)


//===========================================================================
	
 let req = "chart";
 
 axios.get(req)
	  .then(function(res){
		
		let writer = [];
		let count = [];
		
		for(let i = 0 ; i<res.data.length;i++){
			writer.push(res.data[i].writer);
			count.push(res.data[i].count);
			
		}
		
		const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: writer,
      datasets: [{
        label: 'count',
        data: count,
        borderWidth: 1,
		backgroundColor: ["red",'yellow'],

      }, {
        label: 'count',
        data: count,
        borderWidth: 1,
		backgroundColor: ['yellow'],

      }
]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
	});
	

  






