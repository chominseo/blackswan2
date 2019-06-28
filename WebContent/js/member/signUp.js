window.addEventListener("load", function(){
    
    var signUp = document.querySelector(".signUp");
    
    signUp.onclick = function(){
    
    var email = document.getElementsByName("email").value;
    
    var name = document.getElementsByName("name").value;
    var pw = document.getElementsByName("pw").value;
    var pwc = document.getElementsByName("pwc").value;
    var phone = document.getElementsByName("phone").value;
     
 /*   if (!email){
        alert("이메일을 입력하세요.")
        return;
    }
    if (!name){
        alert("이름을 입력하세요.")
        return;
    }
    if (!pw){
        alert("비밀번호를 입력하세요.")
        return;
    }
    if (!pwc){
        alert("비밀번호를 입력하세요.")
        return;
    }
    if (!phone){
        alert("전화번호를 입력하세요.")
        return;
    }*/
    
    };
});