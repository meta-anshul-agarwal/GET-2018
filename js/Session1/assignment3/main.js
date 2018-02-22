var displayedImage = document.querySelector('.displayed-img');
var thumbBar = document.querySelector('.thumb-bar');

btn = document.querySelector('button');
var overlay = document.querySelector('.overlay');

/* Looping through images */
for(var i = 1; i <= 5; i++) {
  var newImage = document.createElement('img');
  newImage.setAttribute('src', "images/pic"+ i +".jpg");
  newImage.setAttribute("onclick","setSRC(\""+newImage.getAttribute("src")+"\")");
  thumbBar.appendChild(newImage);
}
function setSRC(src){
 displayedImage.setAttribute('src',src);
}

/* Wiring up the Darken/Lighten button */
btn.onclick = function() {
  var btnclass = btn.getAttribute("class");
  if(btnclass === "dark") {
    btn.setAttribute("class" ,"lighten");
    btn.textContent = "lighten";
    overlay.style.backgroundColor = "rgba(0,0,0,0.5)";
  }
  else{
    btn.setAttribute("class" ,"dark");
    btn.textContent = "darken";
    overlay.style.backgroundColor = "rgba(0,0,0,0)";
  }
};
