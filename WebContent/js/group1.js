window.addEventListener("load",function(){
    var section = document.querySelector("#join");
    
    var id = section.querySelector("input[name=id]");
    //var checkid = section.querySelector("input[name=check-id]");
    var pwd = section.querySelector("input[name=password]");
    var check = section.querySelector(".check-pwd");
    var pwd2 = section.querySelector("input[name=password1]");
    var pwdcheck = section.querySelector(".check-pwd1");
    var submit = section.querySelector("input[type=submit]");



    pwd.oninput = function(){
        if(pwd.value.includes(" ")){
            //check.innerText = "공백은 포함될 수 없습니다.";
            //check.style.color = "red";
            check.value="not";
            pwd.style.border = "2px solid orangered";
            
        }else{
            //check.innerText = "";
            check.value="ok";
            pwd.style.border = "2px solid green";
        }
    }
    pwd2.oninput = function(){
        if(pwd.value == pwd2.value){
            // pwdcheck.innerText = "일치합니다."
            // pwdcheck.style.color = "green";
            pwd.style.border = "2px solid green";
            pwd2.style.border = "2px solid green";
            pwdcheck.value="ok";
        }else{
            //pwdcheck.innerText = "불일치합니다."
            //pwdcheck.style.color = "red";

            pwd2.style.border = "2px solid orangered";
            pwdcheck.value="not";
        }
    };

    submit.onclick = function(e){
        
        if(exist.value!="ok"){
            alert("아이디 중복확인을 눌러주세요.");
            e.preventDefault();
            return;
        }
        if(check.value!="ok" || pwdcheck.value!="ok"){
            alert("비밀번호를 다시 확인하십시오.");
            e.preventDefault();
            return;
        }
        
    };

    // pwd2.onchange = function(){
        

    //     if(pwd.value == pwd2.value){
    //         pwdcheck.innerText = "일치합니다."
    //         pwdcheck.style.color = "green";
    //     }else{
    //         pwdcheck.innerText = "불일치합니다."
    //         pwdcheck.style.color = "red";
    //     }
    // };
    

    var exist = section.querySelector(".check-id");

    // id.onblur = function(){
    //     alert("onblur");
    //     id.style.border = "2px solid rgba(0, 0, 0, 0.02)";
    //     id.style["background-image"] = 'url("/semi-JCC/images/guest/check-button1.png")';
    // };

    id.onchange = function(){
        var userid = id.value;
        if(userid == "" || userid == null || userid.includes(" ")){
            alert("공백 는(은) 사용할 수 없습니다.");
            // exist.innerText = "사용할 수 없습니다.";
            // exist.style.color = "red";
            id.style.border = "2px solid orangered";
            id.style["background-image"] = 'url("/semi-JCC/images/guest/check-red.png")';
            exist.value="not";
            return;
        }


        var request = new XMLHttpRequest();
        request.open("GET","join-check?id="+userid,false);
        request.send();
        var json = JSON.parse(request.responseText);

        if(json["exist"] != 0){
            alert(userid+"는(은) 사용할 수 없습니다.");
            // exist.innerText = "사용할 수 없습니다.";
            // exist.style.color = "red";
            id.style.border = "2px solid orangered";
            id.style["background-image"] = 'url("/semi-JCC/images/guest/check-red.png")';
            exist.value="not";
            return;
        }else{
            alert(userid+"는(은) 사용 가능 합니다.");
            //exist.innerText = "사용 가능 합니다.";
            //exist.style.color = "green";
            id.style.border = "2px solid green";
            id.style["background-image"] = 'url("/semi-JCC/images/guest/check-green.png")';
            exist.value="ok";
        }
        

    };
});