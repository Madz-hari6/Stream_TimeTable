let cookies=null;
function checkCookieSession(cookiename){
	cookieData=document.cookie.split(";");
	if(cookieData.length==0){
		return false;
	}
	else{
		for(let i=0;i<cookieData.length;i++){
			const [name, value] = cookie[i].split('=');
			if(name==cookiename){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
}
function cookieVerification(){
	if(checkCookieSession("name")){
		window.locate.href="index.html(link)";
	}
}
