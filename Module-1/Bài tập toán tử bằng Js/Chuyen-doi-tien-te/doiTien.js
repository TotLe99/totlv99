function changeMonney() {
    let Amount = document.getElementById("amount").value;
    let From = document.getElementById("fromTien").value;
    let To = document.getElementById("toTien").value;
    let Result;

    if (From == "VietNam" && To == "USD") {
        Result = "Result: " + (Amount / 23000) + " $";
    }
    else if (From == "USD" && To == "VietNam") {
        Result = "Result: " + (Amount * 23000) + " VNĐ";
    }
    else if (From == "VietNam") {
        Result = "Result: " + Amount + " VNĐ";
    } else {
        Result = "Result: " + Amount + " $";
    }

    document.getElementById("Result").innerHTML = Result;
}