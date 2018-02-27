var addButton = document.getElementById('add');
var taskName = document.getElementById('content');
var date = document.getElementById('date');
var currentTaskDiv = document.getElementById('showtask');
var currentTaskHeading= document.getElementById('currentTaskHeading');
var completeTaskDiv = document.getElementById('showcompletedtask');
var completeTaskHeading = document.getElementById('text');
var priorityButton = document.getElementById('priority');
var sortButton = document.getElementById('sortButton');
var objects =  null;

// to show tasks on UI after reloading , traversing localStorage
function onload(){
	var key;
	document.getElementById("date").value = todayDate();
	if(localStorage.getItem("ToDo") && localStorage.getItem("ToDo") != "null"){
		objects = JSON.parse(localStorage.getItem("ToDo"));
		for(var i = 0 ; i < objects.length ; i++){
			key = objects[i];
			if(key.status == 0) {
			addToCurrentDiv(key.taskName,key.priorityValue,key.assignDate);
			}
			else {
			addToCompleteDiv(key.taskName,key.priorityValue,key.assignDate);
			}
		}
		sorts('Sort' , 4);
	}
	else{
		var obj = [];
		localStorage.setItem("ToDo" , JSON.stringify(obj));
		objects = JSON.parse(localStorage.getItem("ToDo"));
	}
}
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

// make structure of tasks
function makeStructure(taskvalue , privalue , datevalue){
	var div = document.createElement("Div");
  var deleteButton = document.createElement("BUTTON");
	deleteButton.classList.add("dltButton");
  deleteButton.onclick = function(e){
    deletetask(e.target, taskvalue);
  }
  div.appendChild(deleteButton);
  var priorityElement = document.createElement("p")
  priorityElement.innerHTML = "[ " + privalue + " ] ";
	priorityElement.classList.add("priButton");
  div.appendChild(priorityElement);
	var taskButton = document.createElement("button");
	taskButton.innerHTML = taskvalue;
	taskButton.classList.add("taskButton");
	taskButton.setAttribute("title","Click to move to completed task");
	taskButton.onclick = function(e){
		moveAndUpdateTask(e.target , taskButton.innerHTML);
	}
	div.appendChild(taskButton);
  var dateElement = document.createElement("span")
  dateElement.innerHTML = " { " + datevalue + " }";
	dateElement.classList.add("assign-date");
  div.appendChild(dateElement);
	var completeDateElement = document.createElement("span")
  completeDateElement.innerHTML = " { " + todayDate() + " }";
	completeDateElement.classList.add("complete-date");
  div.appendChild(completeDateElement);
	return div;
}
//Adding tasks to the current div
function addToCurrentDiv(taskvalue , privalue , datevalue) {
	var div = makeStructure(taskvalue , privalue , datevalue);
	div.style.textDecoration = "none";
	var span = div.getElementsByTagName("span");
	span[0].style.display = "inline";
	span[1].style.display = "none";
  insertAfter(div,currentTaskHeading);
}
function divCurrentList(div){
	div.style.textDecoration = "none";
	var span = div.getElementsByTagName("span");
	span[0].style.display = "inline";
	span[1].style.display = "none";
	insertAfter(div , currentTaskHeading);
}
//Add elements in the complete list
function addToCompleteDiv(taskvalue , privalue, completeDate) {
	var div = makeStructure(taskvalue , privalue , completeDate);
	div.style.textDecoration = "line-through";
	var span = div.getElementsByTagName("span");
	span[0].style.display = "none";
	span[1].style.display = "inline";
  insertAfter(div , completeTaskHeading);
}
function divCompleteList(div){
	div.style.textDecoration = "line-through";
	var span = div.getElementsByTagName("span");
	span[0].style.display = "none";
	span[1].style.display = "inline";
	insertAfter(div , completeTaskHeading);
}

//Using to insert after a element
function insertAfter(newNode, referenceNode) {
  referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}

//Used to change status and moving task to complete and vice-versa
function moveAndUpdateTask(btn, name) {
	for(j=0;j<objects.length ; j++) {
		if(objects[j].taskName == name) {
			if(objects[j].status == 0) {
				var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
				for(var i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(name == tempbtn[1].innerHTML) {
						objects[j].status = 1;
						objects[j].completeDate = todayDate();
						localStorage.setItem("ToDo" , JSON.stringify(objects));
						divCompleteList(innerDivs[i]);
						break;
					}
				}
			}
			else {
				var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
				for(var i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(name == tempbtn[1].innerHTML) {
						objects[j].status = 0;
						objects[j].completeDate = null;
						localStorage.setItem("ToDo" , JSON.stringify(objects));
						divCurrentList(innerDivs[i]);
						break;
					}
				}
				break;
			}
		}
	}
}

//sorting in descending order
function sorts(sortName , type){
	clearall();
	sortButton.innerHTML = sortName;
	var length = objects.length;
	if(type == 1){
	objects.sort((a,b) => a.taskName < b.taskName);
	}
	else if(type == 2){
	objects.sort((a,b) => a.taskName > b.taskName);
	}
	else if(type == 3){
		objects.sort((a,b) => a.priorityValue < b.priorityValue);
	}
	else{
		objects.sort((a,b) => a.assignDate > b.assignDate);
	}
	for(i = 0 ; i < length ; i++){
		if(objects[i].status == 0) {
			addToCurrentDiv(objects[i].taskName, objects[i].priorityValue, objects[i].assignDate);
		}
		else {
			addToCompleteDiv(objects[i].taskName, objects[i].priorityValue, objects[i].assignDate);
		}
	}
}

//remove all task from UI
function clearall() {
  var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
  var innerDivs1 = completeTaskDiv.getElementsByTagName("DIV");
  var mainlength = innerDivs.length;
  var completedlength = innerDivs1.length;
  for(var i = 0 ; i < mainlength ; i++) {
  	innerDivs[0].remove();
  }
  for(var i = 0 ; i < completedlength ; i++) {
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
      dd = '0'+dd;
  }
  if(mm<10) {
      mm = '0'+mm;
  }
  today = yyyy+"-"+mm+"-"+dd;
  return today;
}

//removes repesctive task
function deletetask(btn,taskvalue){
	if(confirm("want's to delete task : "+taskvalue)){
	for(j=0;j<objects.length ; j++){
		if(objects[j].taskName === taskvalue){
				if(objects[j].status == 0){
				var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
				}
				else {
				var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
				}
				for(i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(btn == tempbtn[0]){
					innerDivs[i].remove();
					objects.splice(j,1);
					localStorage.setItem("ToDo" , JSON.stringify(objects));
					}
				}
			}
		}
	}
}
