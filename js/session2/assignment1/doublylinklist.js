var first=null;
var last = null;

function new_node() {
  var data = document.getElementById('data').value;
  if(data != "") {
    var node = new Object();
    node.data = data;
    document.getElementById('data').value = "";
    node.next =  null;
    node.previous = last;
    if(first == null) {
      first = node;
    }
    else {
    last.next = node;
    }
    last = node;
  }
  else {
    alert("data cant be empty");
  }
}
function printforward() {
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
  var br = document.createElement("BR");
  div.appendChild(br);
}
  function printbackward() {

    var temp = last;
    while(temp!=null){
      var div = document.createElement("div");
      div.style.border = "solid 1px black";
      div.style.display = "inline-block";
      div.style.margin = "10px";
      div.style.padding = "10px";
      var t = document.createTextNode(temp.data);
      div.appendChild(t);
      document.body.appendChild(div);
      temp = temp.previous;
    }

}