var first=null;
var last = null;

function new_node() {
  var data = document.getElementById('data').value;
  if(data != "") {
    var node = new Object();
    node.data = data;
    node.next =  null;
    if(first == null) {
      first = node;
    }
    else {
    last.next = node;
    }
    last = node;
    document.getElementById('data').value = "";
  }
  else {
    alert("data cant be empty");
  }
}
function printq() {
  var temp = first;
  while(temp!=null){
    var div = document.createElement("div");
    div.style.border = "solid 1px black";
    div.style.display = "inline-block";
    div.style.margin = "10px";
    div.style.padding = "10px";
    var t = document.createTextNode(temp.data);
    div.appendChild(t);
    document.body.appendChild(div);
    temp = temp.next;
  }
}