inputbanKinh = prompt("Nhập bán kính");
const Pi = 3.1415;

let r = parseFloat(inputbanKinh);

let S = r*r * Pi;
let C = r * 2 * Pi;

document.write("Diện tích hình tròn: " + S);
document.write("Chu vi hình tròn: " + C);