package com.airmart.api.models;

import com.airmart.api.domains.Chat;
import com.airmart.api.domains.ChatMessage;
import com.airmart.api.domains.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class ChatResponse {
    private Long id;
    private String message;
    private String owner;
    private String postedDate;
    private Set<String> users;
    private List<String> messages;

    public static List<ChatResponse> convertToChatResponse(List<Chat> chats){
        List<ChatResponse> chatResponses = new ArrayList<>();
        for (Chat chat:
             chats) {
            chatResponses.add(convertToChatResponse(chat));
        }
        return chatResponses;
    }
    public static ChatResponse convertToChatResponse(Chat chat){
        return new ChatResponse(chat.getId(),chat.getMessage(),chat.getOwner().getUsername(),chat.getPostedDate().toString(),convertToStringSet(chat.getUsers()),convertToStringList(chat.getMessages()));
    }
    private static Set<String> convertToStringSet(List<User> userSet){
        Set<String> stringSet = new HashSet<>(Arrays.asList());
        if(userSet != null){
            for(User user:userSet){
                stringSet.add(user.getUsername());
            }
        }
        return stringSet;
    }
    private static List<String> convertToStringList(List<ChatMessage> messageSet){
        List<String> stringSet = new ArrayList<>();
        if(messageSet != null){
            for(ChatMessage message:messageSet){
                stringSet.add(message.getMessage());
            }
        }
        return stringSet;
    }
}
