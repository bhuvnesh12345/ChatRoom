console.log("inside script file");
let stompClient=null;


$(document).ready(function(){
	console.log("jquery");
	$("#chatroom").hide();
	
	$("#login-btn").click(()=>{
		if($("#name").val()=="")
		{
			alert("Please Enter Your Name First !")
		}
		else{
			$("#login").hide();
		$("#chatroom").show();
		localStorage.setItem("name",$("#name").val());
		}
		 
	});
	
	connect();
	
	$("#send").click(()=>{
		
		sendMessage();
	})
})

function connect(){
	let socket=new SockJS("/server1")
	stompClient=Stomp.over(socket);
	stompClient.connect({}, function(frame){
		console.log("connected to server"+ frame);
		console.log("inside connect method of stomp")
		
	    stompClient.subscribe("/topic/return-to", function(response){
		    showMessage(JSON.parse(response.body))
	        console.log(response);
	        console.log("inside subscribe method of stomp")
		
	})
	    
	})
}
	
function sendMessage()
{
	  console.log("inside send method of stomp")
	let jsonOb={
        name:localStorage.getItem("name"),
        content:$("#msg").val()
    }
    
    stompClient.send("/app/message",{},JSON.stringify(jsonOb));
    
}


function showMessage(message)
 {
      console.log("inside showmessage method")
      $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.content}</td></tr>`)

 }

	
	

