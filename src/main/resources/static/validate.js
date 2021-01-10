function validate() {

    var login = document.getElementById("login").value;
    var pass = document.getElementById("pass").value;
    var pass2 = document.getElementById("pass2").value;

    var flag = true;

    if(pass != pass2) {
        document.getElementById("pass").style.backgroundColor = 'RED';
        document.getElementById("pass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        if(flag) {
            document.getElementById("pass").style.backgroundColor = 'WHITE';
            document.getElementById("pass2").style.backgroundColor = 'WHITE';
        }
    }

    return flag;
}