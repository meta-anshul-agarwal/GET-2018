var addButton = document.getElementById('add');
var taskName = document.getElementById('content');
var date = document.getElementById('date');
var currentTaskDiv = document.getElementById('showtask');
var currentTaskHeading= document.getElementById('currentTaskHeading');
var completeTaskDiv = document.getElementById('showcompletedtask');
var completeTaskHeading = document.getElementById('text');
var priorityButton = document.getElementById('priority');
var sortButton = document.getElementById('sortButton');

//Create new task
addButton.onclick = function(){
	if(taskName.value != ""){
	  if (typeof(Storage) !== "undefined") {
		var objects =  JSON.parse(localStorage.getItem("ToDo"));
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

//Adding tasks to the current div
function addToCurrentDiv(taskvalue , privalue , datevalue) {
  var div = document.createElement("Div");
  var deleteButton = document.createElement("BUTTON");
  deleteButton.style.height = "16px";
  deleteButton.style.width = "16px";
  deleteButton.style.background = "white";
  deleteButton.style.backgroundImage = "url('https://cdn0.iconfinder.com/data/icons/pixon-1/24/Close_delete_outline_remove-16.png')";
  deleteButton.style.border = "none";
  deleteButton.onclick = function(e){
    deletetask(e.target, taskvalue);
  }
  div.appendChild(deleteButton);
  var taskButton = document.createElement("button");
  taskButton.style.background = "white";
  taskButton.style.border = "none";
  taskButton.style.height = "16px";
  taskButton.style.width = "auto";
  taskButton.innerHTML = taskvalue;
  taskButton.setAttribute("data-toggle","tooltip");
  taskButton.setAttribute("data-placement","bottom");
  taskButton.setAttribute("title","Click to move to completed task");
  taskButton.style.padding = "none";
  taskButton.style.cursor = "pointer";
  taskButton.onclick = function(e){
    moveAndUpdateTask(e.target , taskButton.innerHTML);
  }
  taskButton.style.boder = "none";
  taskButton.style.display = "inline";
  div.appendChild(taskButton);
  var priorityElement = document.createElement("p")
  priorityElement.innerHTML = "[ " + privalue + " ] ";
  priorityElement.style.display = "inline";
  div.appendChild(priorityElement);
  var dateElement = document.createElement("p")
  dateElement.innerHTML = " { " + datevalue + " }";
  dateElement.style.display = "inline";
  div.appendChild(dateElement);
  insertAfter(div,currentTaskHeading);
}

//Add elements in the complete list
function addToCompleteDiv(taskvalue , privalue, completeDate) {
  var div = document.createElement("Div");
  var taskButton = document.createElement("button");
  taskButton.style.background = "white";
  taskButton.style.border = "none";
  taskButton.style.height = "20px";
  taskButton.style.width = "auto";
  taskButton.style.cursor = "pointer";
  var striketag = document.createElement("strike");
  striketag.innerHTML = taskvalue;
  taskButton.appendChild(striketag);
  taskButton.onclick = function(e){
    moveAndUpdateTask(e.target , striketag.innerHTML);
  }
  taskButton.style.boder = "none";
  taskButton.setAttribute("data-toggle","tooltip");
  taskButton.setAttribute("data-placement","bottom");
  taskButton.setAttribute("title","Click to move to current task");
  taskButton.style.display = "inline";
  div.appendChild(taskButton);
  var priorityElement = document.createElement("p")
  priorityElement.innerHTML = "[ " + privalue + " ] ";
  priorityElement.style.display = "inline";
  div.appendChild(priorityElement);
  var dateElement = document.createElement("p")
  dateElement.innerHTML =" { " + completeDate + " }";
  dateElement.style.display = "inline";
  div.appendChild(dateElement);
  insertAfter(div , completeTaskHeading);
}

//Using to insert after a element
function insertAfter(newNode, referenceNode) {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

//Used to change status and moving task to complete and vice-versa
function moveAndUpdateTask(btn, name){
  var obj =  JSON.parse(localStorage.getItem("ToDo"));
  //loop for traversing localStorage
  for(i = 0 ; i < obj.length ; i++){
    //checks if task is current or not
    if(obj[i].status == 0){
      if(obj[i].taskName == name){
        obj[i].status = 1;
        obj[i].completeDate = todayDate();
        addToCompleteDiv(obj[i].taskName, obj[i].priorityValue, obj[i].completeDate);
        removeItemFromCurrent(obj[i].taskName);
        localStorage.setItem("ToDo" , JSON.stringify(obj));
        break;
      }
    }
    else{
      if(obj[i].taskName == name){
        obj[i].status = 0;
				obj[i].completeDate = null;
        addToCurrentDiv(obj[i].taskName, obj[i].priorityValue, obj[i].assignDate);
        removeItemFromCompleted(obj[i].taskName);
        localStorage.setItem("ToDo" , JSON.stringify(obj));
        break;
      }
    }
  }
}
// to show tasks on UI after reloading , traversing localStorage
function onload(){
	var key;
	document.getElementById("date").value = todayDate();
	if(localStorage.getItem("ToDo")){
	  var obj =  JSON.parse(localStorage.getItem("ToDo"));
	  for(var i = 0 ; i < obj.length ; i++){
	    key = obj[i];
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
function sortdescending(sortName){
  clearall();
  sortButton.innerHTML = sortName;
  document.getElementById("date").value = todayDate();
	var obj =  JSON.parse(localStorage.getItem("ToDo"));
	obj.sort(GetSortOrder("taskName"));
  for(var i = 0 ; i < obj.length ; i++){
    if(obj[i].status == 0) {
      addToCurrentDiv(obj[i].taskName, obj[i].priorityValue, obj[i].assignDate);
    }
    else {
      addToCompleteDiv(obj[i].taskName, obj[i].priorityValue, obj[i].completeDate);
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
//sorting tasks in ascending order
function sortAscending(sortName){
  clearall();
  sortButton.innerHTML = sortName;
	var obj =  JSON.parse(localStorage.getItem("ToDo"));
	obj.sort(GetSortOrder("taskName"));
  for(var i = obj.length - 1; i >= 0 ;i--){
    if(obj[i].status == 0) {
      addToCurrentDiv(obj[i].taskName, obj[i].priorityValue, obj[i].assignDate);
    }
    else {
      addToCompleteDiv(obj[i].taskName, obj[i].priorityValue, obj[i].completeDate);
    }
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
  for(var i = 0 ; i < innerDivs.length ; i++)
  {
     var key = innerDivs[i].getElementsByTagName("button");
     if(key[1].innerHTML == taskName){
       innerDivs[i].remove();
     }
  }
}

//removes respective task from completed list
function removeItemFromCompleted(taskName) {
  var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
  for(var i = 0 ; i < innerDivs.length ; i++)
  {
     var key = innerDivs[i].getElementsByTagName("button");
     var striketag = key[0].getElementsByTagName("strike");
     if(striketag[0].innerHTML == taskName){
       innerDivs[i].remove();
     }
  }
}

//removes repesctive task
function deletetask(btn,taskvalue){
	var obj =  JSON.parse(localStorage.getItem("ToDo"));
  if(confirm("want's to delete task : "+taskvalue)){
    var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
    for(var i = 0 ; i < innerDivs.length ; i++)
    {
       var key = innerDivs[i].getElementsByTagName("button");
       var tempbtn = innerDivs[i].getElementsByTagName("button");
       if(btn == tempbtn[0]){
         innerDivs[i].remove();

				 // loop for deleting task from local Storage
				 for(j=0;j<obj.length ; j++){
					 if(obj[j].taskName === key[1].innerHTML)
         		obj.splice(j,1);
						localStorage.setItem("ToDo" , JSON.stringify(obj));
				 }
       }
    }
  }
}
