var METHOD = {
  POST: "POST",
  GET: "GET"
};

var API_BASE_URL = "http://localhost:8083/";

function saveTestService(){
  var api = document.getElementById("endpoint").value,
      titel = document.getElementById("testTitel").value,
      test = JSON.stringify({testTitel:titel});
  invoke(api, METHOD.POST, test);
}

function getTestsServer(){
	var endpoint = document.getElementById("endpoint").value;
	return invoke(endpoint, METHOD.GET);
}

function invoke(api, method, data = null){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && [202,200].includes(this.status)) {
      document.getElementById("demo").innerHTML = this.responseText;
    }
  };
  
  xhttp.open(method, API_BASE_URL + api, true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(data);
}