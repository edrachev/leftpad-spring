$(document ).ready(function() {
  var socket = new WebSocket("ws://localhost:8080/lastpadded");
  socket.onopen = function() {
    socket.onmessage = function(message) {
      var data = JSON.parse(message.data);
      $("#tbody").append(
          "<tr><td>" + data.input + "</td><td>" + data.output + "</td></tr>");
    };
  };
})