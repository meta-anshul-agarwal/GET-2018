var inputDiv = document.getElementById("input");
var addButton = document.getElementById("add");
var outputDiv = document.getElementById("output");
var okButton = document.getElementById("ok");
var backButton = document.getElementById("back");
var outputTable = document.getElementById("output-table");

// adds header to input div
function addHeader(){
  var div = document.createElement("DIV");
  var name = document.createElement("input");
  var min = document.createElement("input");
  var max = document.createElement("input");
  name.value = "NAME";
  name.style.border = "none";
  name.style.textAlign = "center";
  div.appendChild(name);
  min.value = "MINIMUM";
  min.style.border = "none";
  min.style.textAlign = "center";
  div.appendChild(min);
  max.value = "MAXIMUM";
  max.style.border = "none";
  max.style.textAlign = "center";
  div.appendChild(max);
  inputDiv.insertBefore(div,okButton);
  var obj = [];
  sessionStorage.setItem("table",JSON.stringify(obj));
}

// adds input element to input div
function addInputElement(){
  var div = document.createElement("DIV");
  var name = document.createElement("input");
  var min = document.createElement("input");
  var max = document.createElement("input");
  name.type = "text";
  min.type = "number";
  min.min = "1";
  min.max = "10";
  max.min = "1";
  min.max = "10";
  max.type = "number";
  div.appendChild(name);
  div.appendChild(min);
  div.appendChild(max);
  inputDiv.insertBefore(div,okButton);
}

// add button adds element in UI
addButton.onclick = function(e){
  storeDetails();
  addInputElement();
}

// stores details of input in session storage
function storeDetails() {
  var innerDivs = inputDiv.getElementsByTagName('DIV');
  var inputTag = innerDivs[innerDivs.length - 1].getElementsByTagName('input');
  if(inputTag[2].value > inputTag[1].value){
    var obj = {
      "name" : inputTag[0].value ,
      "min" : inputTag[1].value ,
      "max" : inputTag[2].value
    };
    var objects = JSON.parse(sessionStorage.getItem("table"));

    objects.push(obj);
    sessionStorage.setItem("table",JSON.stringify(objects));
    return true;
  }
  alert("maximum value should be greater than minimum");
  return false;
}

// ok button hides input div and shows output table
okButton.onclick = function(e){
  if(storeDetails()){
    showResult();
    inputDiv.style.display = "none";
    outputDiv.style.display = "inline";
    addButton.style.display = "none";
  }
}

// ok button hides output table and shows input div, refreshes the site
backButton.onclick = function(e){
  clearOutputTable();
  clearInputDivs();
  sessionStorage.clear();
  addHeader();
  addInputElement();
  inputDiv.style.display = "inline";
  outputDiv.style.display = "none";
  addButton.style.display = "inline";
}

// clears all input divs
function clearInputDivs(){
  var innerDivs = inputDiv.getElementsByTagName('DIV');
  var length = innerDivs.length ;
  for( i = 0 ; i < length ; i++){
    innerDivs[0].remove();
  }
}

//clears output table
function clearOutputTable(){
  var objects = JSON.parse(sessionStorage.getItem("table"));
  for( i = 0 ; i < objects.length ; i++){
    outputTable.deleteRow(i);
  }
}

// make cells of table
function makeCells(i , name , min , max){
  var row = outputTable.insertRow(i);
  row.style.borderBottom = "solid 1px black";
  var cells = [];
  for( j = 0 ; j < 11 ; j++){
    var cell = row.insertCell(j);
    cells.push(cell);
    cell.style.width = "60px";
    cell.style.height = "40px";
    if(j == 0){
      cells[j].innerHTML = name;
      cells[j].style.borderRight = "solid 2px black";
      cells[j].style.borderTop = "solid 1px black";
      cells[j].style.cellspacing = "0";
    }
    if(j >= min && j <= max){
      cells[j].style.background = "red";
    }
  }
}

// shows output table
function showResult(){
    var objects = JSON.parse(sessionStorage.getItem("table"));
    var length = objects.length;
    for( i = 0 ; i < length ; i++){
      makeCells(i , objects[i].name , objects[i].min , objects[i].max);
    }
}
