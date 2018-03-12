function validation() {
  var name = document.contact.name;
  var ck_name = /^[A-Za-z ]{3,20}$/;
  if(ck_name.test(name.value) == false) {
    alert("Name is invalid");
    return false;
  }
  var email = document.contact.email;
  var ck_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
  if(ck_email.test(email.value) == false) {
    alert("Invalid Email");
    return false;
  }
  var organizationName = document.contact.organization;
  var ck_organizationName = /^[A-Za-z]+$/;
  if(ck_organizationName.test(organizationName.value) == false) {
    alert("Organization Name is invalid");
    return false;
  }
  var pnNumber = document.contact.number;
  var ck_number = /^[0-9]{10}$/;
  if(ck_number.test(pnNumber.value) == false) {
    alert("Phone Number is invalid");
    return false;
  }
  var textarea = document.contact.textarea;
  var ck_length = /^.{0,50}$/;
  if(ck_length.test(textarea.value) == false) {
    alert("Message should be less than 250 words");
    return false;
  }
  return true;
}
function showcity() {
  var city = document.contact.city.value;
  var citybox = document.getElementById("citybox");
  citybox.style.display = "table-row";
  document.contact.citytext.value = "you have selected : "+city;
}
