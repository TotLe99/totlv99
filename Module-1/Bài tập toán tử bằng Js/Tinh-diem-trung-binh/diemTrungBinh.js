inputPhysics = prompt("Nhập điểm Vật Lý");
inputChemistry = prompt("Nhập điểm Hoá Học");
inputBiology = prompt("Nhập điểm Sinh Học");

let phy = parseFloat(inputPhysics);
let che = parseFloat(inputChemistry);
let bio = parseFloat(inputBiology);
let average = (phy + che + bio) / 3;

// document.write("Điểm Vật Lý : " + phy);
// document.write("Điểm Hoá Học : " + che);
// document.write("Điểm Sinh Học : " + bio);
document.write("Điểm trung bình = " + average);