
$(document).ready(function () {
  $(".showLogin").click(function () {
    $("#loginMenu").slideToggle(1400);
    $("#searchFlights").fadeTo(1400, 0);
    $("#searchFlights").hide(1400);
  });
});

$(document).ready(function () {
  $(".hideLogin").click(function () {
    $("#loginMenu").slideToggle(1400);
    $("#searchFlights").show(500);
    $("#searchFlights").fadeTo(1400, 1);
  });
});

function validateLogin() {
  var flag = true;
  var email = document.getElementById("email");
  var emailVal = email.value;
  if (!emailVal || emailVal.length == 0) {
    email.style.boxShadow = "1px 1px 3px red";
    flag = false;
  } else {
    email.style.boxShadow = "none";
  }
  var password = document.getElementById("password");
  var passwordVal = password.value;
  if (!passwordVal || passwordVal.length == 0) {
    password.style.boxShadow = "1px 1px 3px red";
    flag = false;
  } else {
    password.style.boxShadow = "none";
  }
  if (flag) document.getElementById("loginForm").submit();
}
