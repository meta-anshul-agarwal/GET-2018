var queue = new Array(100);
var front = -1;
var rear = -1;
function enqueue() {
  var data = document.getElementById('data').value;
  if(data != "" && rear <= 100) {
    if(front == -1 && rear == -1) {
      front = 0;
      rear = 0;
    }
    else {
      rear++;
    }
    queue[rear] = data;
  }
  else {
    alert("Element can't be enqueued either because of data is empty or queue is full");
  }
}
function dequeue() {
  if(front == rear+1) {
    alert("queue is empty");
  }
  else {
    data = queue[front++];
    document.getElementById('show').innerHTML = data;
  }
}
