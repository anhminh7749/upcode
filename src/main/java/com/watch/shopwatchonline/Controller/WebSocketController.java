package com.watch.shopwatchonline.Controller;

import static java.lang.String.format;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Format;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.watch.shopwatchonline.Domain.ChatMessage;
import com.watch.shopwatchonline.Domain.ChatMessage.MessageType;
import com.watch.shopwatchonline.Model.ChatBox;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.ChatBoxRepository;
import com.watch.shopwatchonline.Repository.UserRepository;


@Controller
public class WebSocketController {

  @Autowired
  private SimpMessageSendingOperations messagingTemplate;
  @Autowired
  private ChatBoxRepository boxRepository;
  @Autowired
  private UserRepository userRepository;
  @MessageMapping("/chat/{roomId}/sendMessage")
  // @SendTo("/topic/publicChatRoom")
  public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
    System.out.println(chatMessage);
    messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
  }

  @MessageMapping("/chat/{roomId}/addUser")
  // @SendTo("/topic/publicChatRoom")
  public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
    SimpMessageHeaderAccessor headerAccessor) {
    String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
    if (currentRoomId != null) {
     
      ChatMessage leaveMessage = new ChatMessage();
      leaveMessage.setType(MessageType.LEAVE);
      leaveMessage.setSender(chatMessage.getSender());
      messagingTemplate.convertAndSend(format("/channel/%s", currentRoomId), leaveMessage);
    }


    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
    saveuser(chatMessage.getSender(), roomId);
  }


  public void saveuser(String username, String room) {
    System.out.println("------------------------------------------------------");
    Optional < User > user = userRepository.findByUsername(username);
    ChatBox chatbox = boxRepository.findByUsername(username);
    ChatBox chat = new ChatBox();
    if (chatbox != null && user.isPresent()) {
      if (chatbox.getUsers().getId() != user.get().getId()) {
        if (username.equals("admin") == false) {
          chat.setUsername(username);
            chat.setUsers(user.get());
            chat.setStatus((short) 1);       
        }
      } else {
        BeanUtils.copyProperties(chatbox, chat);
        chat.setRoom(room);
      }    
    }else{
      chat.setUsername(username);
      chat.setRoom(room);
      chat.setStatus((short) 0);
    }
    boxRepository.save(chat);
  }
}