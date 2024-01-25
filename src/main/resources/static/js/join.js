function validvalue(){
    if (!document.querySelector('input[name="uId"]').value){
        alert("아이디를 입력하세요.");
        return false;
    }
    if (!document.querySelector('input[name="passwd"]').value){
        alert("비밀번호를 입력하세요.");
        return false;
    }
    if (!document.querySelector('input[name="name"]').value){
        alert("이름을 입력하세요.");
        return false;
    }
    if (!document.querySelector('input[name="birthday"]').value){
        alert("생년월일를 입력하세요");
        return false;
    }
    return true;
}

function Join(){

    const formdata = document.querySelector('form');

    //데이터 유효성 검사
    if(!validvalue()){
        return;
    }

    const params = {};
    new FormData(formdata).forEach((value, key) => params[key] = value.trim()); //공백제거

    console.log(params);
    $.ajax({
        url: "/user/joinin",
        contentType : 'application/json; charset=utf-8',
        method: "POST",
        data:  JSON.stringify(params),
        success: function(result){
            console.log(result);
            alert('가입을 축하드립니다!\n로그인 후 서비스를 이용해 주세요.');
            window.location.href="/";
        },
        error: function(result, status, error){
            console.log(error);
            alert('아이디가 이미 존재합니다. 다른 아이디를 사용해주세요.');
        }
    })

}