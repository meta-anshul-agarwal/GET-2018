var stack1 = new Array(100);
var top1 = -1;
function push() {
  document.getElementById('show').innerHTML = "";
  if(top1 < 100){
    var data = document.getElementById('data').value;
    top1 = top1 + 1;
    stack1[top1] = data;
    console.log(stack1);
  }
  else{
    alert("stack is full");
  }
  document.getElementById('data').value = "";
}
function pop(){
  document.getElementById('show').innerHTML = "";
  if(top1 > -1){
    var data = stack1[top1];
    top1 = top1 - 1;
    console.log(top1);
    document.getElementById('show').innerHTML = data;
  }
  else{
    document.getElementById('show').innerHTML = "";
    alert("no element in stack");
  }
}
