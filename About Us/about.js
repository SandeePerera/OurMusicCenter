//function that controls ths shrinking of the navigation bar when scrolling
function Scroll(){

		var top = document.getElementById('header');
		var top1 = document.getElementById('header');
		var nav= document.getElementById('nav');
		var ypos = window.pageYOffset;
    
    
    
		//when the y position exceeds 500 the properties that concern the navigation bar chages
		if(ypos > 500) {
			top.style.height = "100px";
			top1.style.opacity="0.9";
			nav.style.padding= "20px";
			
		}
    
    
    
		//when it is less than 500 the normal values are implemented again
		else{
			top.style.height = "125px";
			top1.style.opacity="0.8";
			nav.style.padding= "40px";
		}
	}



	window.addEventListener("scroll",Scroll);//this fires whrn scrolling he page


