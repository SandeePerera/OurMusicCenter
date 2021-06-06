window.onload = timechecker;



var totalSeconds = 120;
var minutes= parseInt(totalSeconds/60);
var seconds = parseInt(totalSeconds%60);
var myTimer;

function timechecker(){
document.getElementById("timer_heading2").innerHTML = minutes + ' min : ' + seconds + ' sec ' ;

if(totalSeconds <=0){
setTimeout('getScore()',1);
alert("Times up");
window.location.reload();
document.getElementById("timer_heading2").innerHTML = "Time Up" ;
} 


else {
totalSeconds = totalSeconds -1;
minutes = parseInt(totalSeconds/60);
seconds = parseInt(totalSeconds%60);
myTimer=setTimeout("timechecker()",1000);


}

	
}






var Questions= 10;
var Selections = 4;

<!-- answers-->

var answers = new Array(10);
answers[0] = "'Telecaster'";
answers[1] = "10";
answers[2] = "1st";
answers[3] = "A B C D E F";
answers[4] = "Gibson";
answers[5] = "Trussrod";
answers[6] = "Bbm";
answers[7] = "Headstock";
answers[8] = "C";
answers[9] = "Pickups ";

function getScore(form) {
  var marks = 0;
  var currentEliment;
  var currentSelection;
  var wrongAns = 0;
  var correctAns = 0;
  var ansString = "";
  
  
  for (i=0; i< Questions ; i++) {
    currentEliment = i*Selections;
    for (j=0; j<Selections; j++) {
      currentSelection = form.elements[currentEliment + j];
      if (currentSelection.checked) {
        if (currentSelection.value == answers[i]) {
		      
           correctAns++;
		   ansString +="Your answer" +"  " +  "  "  + currentSelection.value +"  "+" is Correct" + "<br>"+ "<br>" ;
          break;}

        else{
			wrongAns++;
			ansString += "Your answer" +"  " +  "  "  + currentSelection.value +"  "+" is Wrong" + "<br>"+ "<br>" ;   
        }
        
      }
    }
  }
    
<!--every correct answers have 2 marks and wrong answer -1 -->
    
  marks = (correctAns*2)-(wrongAns*1);
 


    if (marks < 10) {
        document.body.style.backgroundColor = "red";

        
    }else {
    document.body.style.backgroundColor = "green";
}


  var correctAnswers = "";
  for (i=1; i<=Questions; i++) {
    correctAnswers += i + ". " + answers[i-1] + "\r\n" + "<br/>" + "<br/>";
  }
  
 document.getElementById("results").innerHTML +="Results:" + "<br>" + "<br>" + ansString+ "<br>" + "<br>" ;
  document.getElementById("results").innerHTML +="Correct Answers:" + "<br><br>" + correctAnswers + "<br>" + "<br>";
  document.getElementById("results").innerHTML += "Your Marks" + "<br>" +  marks;
  
   
 } 



     