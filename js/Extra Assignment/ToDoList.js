var addButton = document.getElementById('add');
var taskName = document.getElementById('content');
var date = document.getElementById('date');
var currentTaskDiv = document.getElementById('showtask');
var currentTaskHeading= document.getElementById('currentTaskHeading');
var completeTaskDiv = document.getElementById('showcompletedtask');
var completeTaskHeading = document.getElementById('text');
var priorityButton = document.getElementById('priority');
var sortButton = document.getElementById('sortButton');
var objects =  JSON.parse(localStorage.getItem("ToDo"));
//Create new task
addButton.onclick = function(){
	if(taskName.value != ""){
	  if (typeof(Storage) !== "undefined") {
		// Storing different values of to do task in an object
		var obj = {
		  "taskName" : taskName.value,
		  "priorityValue" : priorityButton.innerHTML,
		  "status" : 0,
		  "completeDate" : null,
			"assignDate" : date.value
		};
		objects.push(obj);
		//Storing values in local storage with key value pairs
		localStorage.setItem("ToDo", JSON.stringify(objects));
		addToCurrentDiv(taskName.value, priorityButton.innerHTML , date.value);
	  }
	  else {
		  document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	  }
	}
	else{
		alert("Please assign some task");
	}
}

//update the value of drop down priority button
function changePriority(priorityValue) {
  priorityButton.innerHTML = priorityValue;
}

function makeStructure(taskvalue , privalue , datevalue){
	var div = document.createElement("Div");
  var deleteButton = document.createElement("BUTTON");
	deleteButton.classList.add("dltButton");
  deleteButton.onclick = function(e){
    deletetask(e.target, taskvalue);
  }
  div.appendChild(deleteButton);
  var taskButton = document.createElement("button");
  taskButton.innerHTML = taskvalue;
	taskButton.classList.add("taskButton");
  taskButton.setAttribute("title","Click to move to completed task");
  taskButton.onclick = function(e){
    moveAndUpdateTask(e.target , taskButton.innerHTML);
  }
  div.appendChild(taskButton);
  var priorityElement = document.createElement("p")
  priorityElement.innerHTML = "[ " + privalue + " ] ";
  priorityElement.style.display = "inline";
  div.appendChild(priorityElement);
  var dateElement = document.createElement("p")
  dateElement.innerHTML = " { " + datevalue + " }";
  dateElement.style.display = "inline";
  div.appendChild(dateElement);
	return div;
}
//Adding tasks to the current div
function addToCurrentDiv(taskvalue , privalue , datevalue) {
	var div = makeStructure(taskvalue , privalue , datevalue);
  insertAfter(div,currentTaskHeading);
}
//Add elements in the complete list
function addToCompleteDiv(taskvalue , privalue, completeDate) {
	var div = makeStructure(taskvalue , privalue , completeDate);
  insertAfter(div , completeTaskHeading);
}

//Using to insert after a element
function insertAfter(newNode, referenceNode) {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

//Used to change status and moving task to complete and vice-versa
function moveAndUpdateTask(btn, name){
  //loop for traversing localStorage
  for(i = 0 ; i < objects.length ; i++){
    //checks if task is current or not
    if(objects[i].status == 0){
      if(objects[i].taskName == name){
        objects[i].status = 1;
        objects[i].completeDate = todayDate();
        addToCompleteDiv(objects[i].taskName, objects[i].priorityValue, objects[i].completeDate);
        removeItemFromCurrent(objects[i].taskName);
        localStorage.setItem("ToDo" , JSON.stringify(objects));
        break;
      }
    }
    else{
      if(objects[i].taskName == name){
        objects[i].status = 0;
				objects[i].completeDate = null;
        addToCurrentDiv(objects[i].taskName, objects[i].priorityValue, objects[i].assignDate);
        removeItemFromCompleted(objects[i].taskName);
        localStorage.setItem("ToDo" , JSON.stringify(objects));
        break;
      }
    }
  }
}
// to show tasks on UI after reloading , traversing localStorage
function onload(){
	var key;
	document.getElementById("date").value = todayDate();
	if(localStorage.getItem("ToDo") && localStorage.getItem("ToDo") != "null"){
	  for(var i = 0 ; i < objects.length ; i++){
	    key = objects[i];
	    if(key.status == 0) {
	      addToCurrentDiv(key.taskName,key.priorityValue,key.assignDate);
	    }
	    else {
	      addToCompleteDiv(key.taskName,key.priorityValue,key.completeDate);
	    }
	  }
	}
	else{
		var obj = [];
		localStorage.setItem("ToDo" , JSON.stringify(obj));
	}
}
//sorting in descending order
function sort(sortName , type){
  clearall();
  sortButton.innerHTML = sortName;
  document.getElementById("date").value = todayDate();
	objects.sort(GetSortOrder("taskName"));
	var length = objects.length;
  for(var i = 0 ; i < length ; i++){
    if(objects[i].status == 0) {
			if(type == 2){
      	addToCurrentDiv(objects[i].taskName, objects[i].priorityValue, objects[i].assignDate);
			}
			else{
				addToCurrentDiv(objects[length - i - 1].taskName, objects[length - i - 1].priorityValue, objects[length - i - 1].assignDate);
			}
    }
    else {
			if(type == 2){
      	addToCompleteDiv(objects[i].taskName, objects[i].priorityValue, objects[i].completeDate);
			}
			else{
				addToCompleteDiv(objects[length - i - 1].taskName, objects[length - i - 1].priorityValue, objects[length - i - 1].assignDate);
			}
    }
  }
}

// gives sorting order
function GetSortOrder(task) {
    return function(a, b) {
        if (a[task] > b[task]) {
            return 1;
        } else if (a[task] < b[task]) {
            return -1;
        }
        return 0;
    }
}

//remove all task from UI
function clearall() {
  var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
  var innerDivs1 = completeTaskDiv.getElementsByTagName("DIV");
  var mainlength = innerDivs.length;
  var completedlength = innerDivs1.length;
  for(var i = 0 ; i < mainlength ; i++)
  {
       innerDivs[0].remove();
  }
  for(var i = 0 ; i < completedlength ; i++)
  {
       innerDivs1[0].remove();
  }
}

//calculate and returns today's date
function todayDate() {
  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();
  if(dd<10) {
      dd = '0'+dd
  }
  if(mm<10) {
      mm = '0'+mm
  }
  today = yyyy+"-"+mm+"-"+dd;
  return today;
}

//removes respective task from current list
function removeItemFromCurrent(taskName) {
  var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
  removeElement(innerDivs , taskName);
}

//removes respective task from completed list
function removeItemFromCompleted(taskName) {
  var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
  removeElement(innerDivs , taskName);
}

//removes element from inner div
function removeElement(innerDivs , taskName){
	for(var i = 0 ; i < innerDivs.length ; i++)
  {
     var key = innerDivs[i].getElementsByTagName("button");
     if(key[1].innerHTML == taskName){
       innerDivs[i].remove();
     }
  }
}
//removes repesctive task
function deletetask(btn,taskvalue){
  if(confirm("want's to delete task : "+taskvalue)){
    var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
    for(var i = 0 ; i < innerDivs.length ; i++) {
       var key = innerDivs[i].getElementsByTagName("button");
       var tempbtn = innerDivs[i].getElementsByTagName("button");
       if(btn == tempbtn[0]){
         innerDivs[i].remove();
				 // loop for deleting task from local Storage
				 for(j=0;j<objects.length ; j++){
					 if(objects[j].taskName === key[1].innerHTML)
         		objects.splice(j,1);
						localStorage.setItem("ToDo" , JSON.stringify(objects));
				 }
       }
    }
  }
}
