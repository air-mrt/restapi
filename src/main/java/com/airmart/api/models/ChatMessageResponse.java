package com.airmart.api.models;

import com.airmart.api.domains.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ChatMessageResponse {
    private Long id;
    private Long chat_id;
    private String message;
    private String username;
    private String avatar;
    private String postedDate;

    public static ChatMessageResponse convertToChatMessageResponse(ChatMessage chatMessage){
        return new ChatMessageResponse(chatMessage.getId(),chatMessage.getChat().getId(),chatMessage.getMessage(),chatMessage.getUser().getUsername(),chatMessage.getUser().getProfilePicture(),chatMessage.getPostedDate().toString());
    }
    public static List<ChatMessageResponse> convertToChatMessageResponse(List<ChatMessage> messages){
        List<ChatMessageResponse> result = new ArrayList<>();
        for (ChatMessage message:
             messages) {
            result.add(convertToChatMessageResponse(message));
        }
        return result;
    }
}
