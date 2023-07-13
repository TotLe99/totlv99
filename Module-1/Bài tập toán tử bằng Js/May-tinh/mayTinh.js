function Addition() {
    let n1 = document.getElementById("num1").value;
    let n2 = document.getElementById("num2").value;
    let Result1 ="Result Addition: " + (Number(n1) + Number(n2));
    document.getElementById("Result").innerHTML = Result1;
}
function Subtraction() {
    let n1 = document.getElementById("num1").value;
    let n2 = document.getElementById("num2").value;
    let Result2 ="Result Subtraction: " + (Number(n1) - Number(n2));
    // let Result2 = Number(n1) - Number(n2);
    document.getElementById("Result").innerHTML = Result2;
}
function Multiplication() {
    let n1 = document.getElementById("num1").value;
    let n2 = document.getElementById("num2").value;
    let Result3 ="Result Multiplication: " + Number(n1) * Number(n2);
    document.getElementById("Result").innerHTML = Result3;
}

function Division() {
    let n1 = document.getElementById("num1").value;
    let n2 = document.getElementById("num2").value;
    let Result4 ="Result Division: " + Number(n1) / Number(n2);
    document.getElementById("Result").innerHTML = Result4;
}