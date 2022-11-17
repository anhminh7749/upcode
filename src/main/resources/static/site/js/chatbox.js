'use strict';

var nameInput = sessionStorage.getItem("UserName");
var usernamePage = document.querySelector('#chat-circle');
var chatPage = document.querySelector('#chat-box');
var btnChat = document.querySelector('#btn-chat');
var messageInput = document.querySelector('#chat-input');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var roomIdDisplay = document.querySelector('#room-id-display');
var messageForm = document.querySelector('#messageForm');

var stompClient = null;
var currentSubscription;
var usernamechat= null;
var roomId = null;
var topic = null;
var InputRoom = null;
    

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
  
  if(nameInput == null){
nameInput = "client_"+ (Math.random() + 1).toString(36).substring(5);
 
  }
 
 usernamechat = nameInput;  
 roomToken();
 InputRoom =  Cookies.get('roomId');
  if (usernamechat) {
    // usernamePage.classList.add('hidden');
    // chatPage.classList.remove('hidden');

    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
  }
  event.preventDefault();
  $("#chat-circle").toggle('scale');
  $(".chat-box").toggle('scale');
}

// Leave the current room and enter a new one.
function enterRoom(newRoomId) {
  
  roomId = newRoomId;
   roomIdDisplay.textContent = usernamechat;
  topic = `/app/chat/${newRoomId}`;

  if (currentSubscription) {
    currentSubscription.unsubscribe();
  }
  currentSubscription = stompClient.subscribe(`/channel/${roomId}`, onMessageReceived);

  stompClient.send(`${topic}/addUser`,
    {},
    JSON.stringify({sender: usernamechat, type: 'JOIN'})
  );
}

function onConnected() {
  enterRoom( InputRoom );
   connectingElement.classList.add('hidden');
}

function onError(error) {
  connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
  connectingElement.style.color = 'red';
}

function sendMessage(event) {
  var messageContent = messageInput.value.trim();
  if (messageContent.startsWith('/join ')) {
    var newRoomId = messageContent.substring('/join '.length);
    enterRoom(newRoomId);
    while (messageArea.firstChild) {
      messageArea.removeChild(messageArea.firstChild);
    }
  } else if (messageContent && stompClient) {
    var chatMessage = {
      sender: usernamechat,
      content: messageInput.value,
      type: 'CHAT'
    };
    stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(chatMessage));
  }
  messageInput.value = '';
  event.preventDefault();
}

function onMessageReceived(payload) {
  var message = JSON.parse(payload.body);

  var messageElement = document.createElement('li');
  var divElement = document.createElement('div');
  if (message.type == 'JOIN') {
    messageElement.classList.add('event-message');
    message.content = message.sender + ' joined!';
  } else if (message.type == 'LEAVE') {
    messageElement.classList.add('event-message');
    message.content = message.sender + ' left!';
  } else {
    messageElement.classList.add('chat-message');

    var avatarElement = document.createElement('i');
    var avatarText = document.createTextNode(message.sender[0]);
    avatarElement.appendChild(avatarText);
    avatarElement.style['background-color'] = getAvatarColor(message.sender);
    messageElement.appendChild(avatarElement);

    var usernameElement = document.createElement('span');
    var usernameText = document.createTextNode(message.sender);
    usernameElement.appendChild(usernameText);
    divElement.appendChild(usernameElement);

    var timeElement = document.createElement('strong');
    var timeText = document.createTextNode(getCurrentTime());
    timeElement.appendChild(timeText);
    divElement.appendChild(usernameElement);
  }
  var divText = document.createTextNode(getCurrentTime());
    divElement.appendChild(divText);
    messageElement.appendChild(divElement);

  var textElement = document.createElement('p');
  var messageText = document.createTextNode(message.content);
  textElement.appendChild(messageText);
  divElement.appendChild(textElement);

  messageArea.appendChild(messageElement);
  messageArea.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(messageSender) {
  var hash = 0;
  for (var i = 0; i < messageSender.length; i++) {
      hash = 31 * hash + messageSender.charCodeAt(i);
  }
  var index = Math.abs(hash % colors.length);
  return colors[index];
}

$(document).ready(function() {

  btnChat.addEventListener('click', connect, true);
  messageForm.addEventListener('submit', sendMessage, true);
});

function getCurrentTime() {
  return new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3");
}

function base64EncodeUrl(str){
  return window.btoa(str).replace(/\+/g, '-').replace(/\//g, '_').replace(/\=+$/, '');
}

function roomToken() { 
  // JWT body 
  var token = {
          sub: usernamechat,
          aud: "https://AAAS_PLATFORM/idp/YOUR_TENANT/authn/token",
          nbf: Math.floor(Date.now() / 1000) - 30,
          iss: usernamechat,
          exp: Math.floor(Date.now() / 1000) + (60 * 60),
          iat: Math.floor(Date.now() / 1000) - 30
      };
  Cookies.set(  'roomId',base64EncodeUrl( JSON.stringify( token ) ));
}
$(".chat-box-toggle").click(function() {
  $("#chat-circle").toggle('scale');
  $(".chat-box").toggle('scale');
})