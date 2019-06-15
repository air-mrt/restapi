package com.airmart.api.models;

import com.airmart.api.domains.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CommentResponse {
    private Long _id;
    private Long _productId;
    private String username;
    private String content;

    public static  List<CommentResponse> convertToCommentResponse(List<Comment> comments){
        List<CommentResponse> commentResponses = new ArrayList<CommentResponse>();
        for(Comment comment:comments){
            commentResponses.add(new CommentResponse(comment.getId(),comment.getProduct().getId(),comment.getUser().getUsername(),comment.getContent()));
        }
        return commentResponses;
    }
    public static  CommentResponse convertToCommentResponse(Comment comment){
            return new CommentResponse(comment.getId(),comment.getProduct().getId(),comment.getUser().getUsername(),comment.getContent());
    }
}

