function fillCircle(){
  var c = document.getElementById("fill-circle");
  var ctx = c.getContext("2d");
  ctx.beginPath();
  ctx.arc(50,50,40,0,2*Math.PI);
  ctx.stroke();
  ctx.fillStyle = "blue";
  ctx.fill();
}
function semiCircle(){
  var c = document.getElementById("semi-circle");
  var ctx = c.getContext("2d");
  var ctx1 = c.getContext("2d");
  ctx.beginPath();
  ctx.arc(50,50,40,Math.PI/2 , -Math.PI/2);
  ctx.stroke();
  ctx.fillStyle = "blue";
  ctx.fill();
  ctx1.beginPath();
  ctx1.arc(50,50,38,-Math.PI/2 , Math.PI/2);
  ctx1.strokeStyle = "grey";
  ctx1.lineWidth   = 4;
  ctx1.stroke();
}
function strokeCircle(){
  var c = document.getElementById("stroke-circle");
  var ctx = c.getContext("2d");
  ctx.beginPath();
  ctx.arc(50,50,40,0,2*Math.PI);
  ctx.strokeStyle = "red";
  ctx.lineWidth   = 5;
  ctx.stroke();
}
function plusCircle() {
  var c = document.getElementById("plus-circle");
  var ctx = c.getContext("2d");
  ctx.beginPath();
  ctx.arc(50,50,40,0,2*Math.PI);
  ctx.fillStyle = "orange";
  ctx.fill();
  var vline = c.getContext("2d");
  vline.beginPath();
  vline.moveTo(50,15);
  vline.lineTo(50,85);
  vline.strokeStyle = "white";
  vline.lineWidth   = 15;
  vline.stroke();
  var hline = c.getContext("2d");
  hline.beginPath();
  hline.moveTo(15,50);
  hline.lineTo(85,50);
  hline.strokeStyle = "white";
  hline.lineWidth   = 15;
  hline.stroke();
}
function triangle() {
  var c = document.getElementById("triangle");
  var line1 = c.getContext("2d");
  line1.beginPath();
  line1.moveTo(50,10);
  line1.lineTo(10,80);
  line1.lineTo(90,80);
  line1.lineTo(50,10);
  line1.fillStyle = "blue";
  line1.fill();
  line1.stroke();
}
function rectangle() {
  var c = document.getElementById("rectangle");
  var ctx = c.getContext("2d");
  ctx.beginPath();
  ctx.rect(10, 10, 80, 80);
  ctx.fillStyle = "green";
  ctx.fill();
}
