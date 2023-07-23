package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Comment;
import com.Interface.CommentRepository;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> cmFindByProductID(Integer productID) {
        return commentRepository.cmFindByProductID(productID);
    }

    public void deleteCommentByProductID(List<Comment> comments) {
        commentRepository.deleteAll(comments);
    }
}
