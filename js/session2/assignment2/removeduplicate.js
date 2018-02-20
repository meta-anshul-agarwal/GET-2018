function removeDuplicate() {
  var string = document.getElementById('string').value;
  var output = remove(string);
  console.log(output);
}
function remove(string) {
  var l = string.length;
  var count = 0;
  for(i = 0;i < l; i++) {
    if(string[i] == string[i+1]) {
      count++;
      continue;
    }
    if(count > 0) {
      string = string.slice(0 ,i - count) + string.slice(i + 1 , l);
      count = 0;
      string = remove(string);
    }
  }
  return string;
}
