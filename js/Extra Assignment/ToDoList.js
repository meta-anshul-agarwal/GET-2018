var addButton = document.getElementById('add');
var taskName = document.getElementById('content');
var date = document.getElementById('date');
var currentTaskDiv = document.getElementById('showtask');
var currentTaskHeading= document.getElementById('currentTaskHeading');
var completeTaskDiv = document.getElementById('showcompletedtask');
var completeTaskHeading = document.getElementById('text');
var priorityButton = document.getElementById('priority');
var sortButton = document.getElementById('sortButton');
var taskList =  null;

// to show tasks on UI after reloading , traversing localStorage
function onload(){
	var key;
	document.getElementById("date").value = todayDate();
	if(localStorage.getItem("ToDo") && localStorage.getItem("ToDo") != "null"){
		taskList = JSON.parse(localStorage.getItem("ToDo"));
		for(var i = 0 ; i < taskList.length ; i++){
			key = taskList[i];
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
		taskList = JSON.parse(localStorage.getItem("ToDo"));
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
			taskList.push(obj);
			//Storing values in local storage with key value pairs
			localStorage.setItem("ToDo", JSON.stringify(taskList));
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

// Div task moves from complete to current
function moveDivFromCompleteToCurrent(div){
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

// Div task moves from current to complete
function moveDivFromCurrentToComplete(div){
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
	for(j=0;j<taskList.length ; j++) {
		if(taskList[j].taskName == name) {
			if(taskList[j].status == 0) {
				var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
				for(var i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(name == tempbtn[1].innerHTML) {
						taskList[j].status = 1;
						taskList[j].completeDate = todayDate();
						localStorage.setItem("ToDo" , JSON.stringify(taskList));
						moveDivFromCurrentToComplete(innerDivs[i]);
						break;
					}
				}
			}
			else {
				var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
				for(var i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(name == tempbtn[1].innerHTML) {
						taskList[j].status = 0;
						taskList[j].completeDate = null;
						localStorage.setItem("ToDo" , JSON.stringify(taskList));
						moveDivFromCompleteToCurrent(innerDivs[i]);
						break;
					}
				}
				break;
			}
		}
	}
}

//sorting
function sorts(sortName , type){
	clearall();
	sortButton.innerHTML = sortName;
	var length = taskList.length;
	if(type == 1){
	taskList.sort((a,b) => a.taskName < b.taskName);
	}
	else if(type == 2){
	taskList.sort((a,b) => a.taskName > b.taskName);
	}
	else if(type == 3){
		taskList.sort((a,b) => a.priorityValue < b.priorityValue);
	}
	else{
		taskList.sort((a,b) => a.assignDate > b.assignDate);
	}
	for(i = 0 ; i < length ; i++){
		if(taskList[i].status == 0) {
			addToCurrentDiv(taskList[i].taskName, taskList[i].priorityValue, taskList[i].assignDate);
		}
		else {
			addToCompleteDiv(taskList[i].taskName, taskList[i].priorityValue, taskList[i].assignDate);
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
	for(j=0;j<taskList.length ; j++){
		if(taskList[j].taskName === taskvalue){
				if(taskList[j].status == 0){
				var innerDivs = currentTaskDiv.getElementsByTagName("DIV");
				}
				else {
				var innerDivs = completeTaskDiv.getElementsByTagName("DIV");
				}
				for(i = 0 ; i < innerDivs.length ; i++) {
					var tempbtn = innerDivs[i].getElementsByTagName("button");
					if(btn == tempbtn[0]){
					innerDivs[i].remove();
					taskList.splice(j,1);
					localStorage.setItem("ToDo" , JSON.stringify(taskList));
					}
				}
			}
		}
	}
}

// converts array object to CSV format
function convertArrayOfObjectsToCSV(args) {
    var result, ctr, keys, columnDelimiter, lineDelimiter, data;

    data = args.data || null;
    if (data == null || !data.length) {
        return null;
    }

    columnDelimiter = args.columnDelimiter || ',';
    lineDelimiter = args.lineDelimiter || '\n';

    keys = Object.keys(data[0]);

    result = '';
    result += keys.join(columnDelimiter);
    result += lineDelimiter;

    data.forEach(function(item) {
        ctr = 0;
        keys.forEach(function(key) {
            if (ctr > 0) result += columnDelimiter;

            result += item[key];
            ctr++;
        });
        result += lineDelimiter;
    });
    return result;
}

// downloads CSV file with task details
function downloadCSV(args) {
    var data, filename, link;

    var csv = convertArrayOfObjectsToCSV({
        data: taskList
    });
    if (csv == null) return;
    filename = args.filename || 'export.csv';

    if (!csv.match(/^data:text\/csv/i)) {
        csv = 'data:text/csv;charset=utf-8,' + csv;
    }
    data = encodeURI(csv);

    link = document.createElement('a');
    link.setAttribute('href', data);
    link.setAttribute('download', filename);
    link.click();
}

// handle file to be imported
function handleFiles(files) {
	// Check for the various File API support.

	if (window.FileReader)  {
		// FileReader are supported.
		document.getElementById("filename").innerHTML = files[0]['name'];
		getAsText(files[0]);
	} else {
		alert('FileReader are not supported in this browser.');
	}
}

// checks if file is in text or not
function getAsText(fileToRead) {
	var reader = new FileReader();
	// Handle errors load
	reader.onload = loadHandler;
	reader.onerror = errorHandler;
	// Read file into memory as UTF-8
	reader.readAsText(fileToRead);
}

// handles success if file is found
function loadHandler(event) {
	var csv = event.target.result;
	processData(csv);
}
// process the data and splits into lines
function processData(csv) {
    var allTextLines = csv.split(/\r\n|\n/);
    var lines = [];
    while (allTextLines.length) {
        lines.push(allTextLines.shift().split(','));
    }
	storeOutput(lines);
}

// handles error
function errorHandler(evt) {
	if(evt.target.error.name == "NotReadableError") {
		alert("Canno't read file !");
	}
}

// stores output in local storage
function storeOutput(lines){
	//Clear previous data
	localStorage.clear();
	onload();
	for (var i = 1; i < lines.length - 1 ; i++) {
		var obj = {
		"taskName" : lines[i][0],
		"priorityValue" : lines[i][1],
		"status" : lines[i][2],
		"completeDate" : lines[i][3],
		"assignDate" : lines[i][4]
		};
		taskList.push(obj);
	}
	localStorage.setItem("ToDo" , JSON.stringify(taskList));
	onload();
}
