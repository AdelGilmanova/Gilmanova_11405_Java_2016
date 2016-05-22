package ru.kpfu.itis.Gilmanova.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.Gilmanova.model.Comment;
import ru.kpfu.itis.Gilmanova.model.User;

/**
 * Created by Adel on 18.05.2016.
 */

public class CommentModel {
    private ObservableList<Comment> comments = FXCollections.observableArrayList();
    private RestTemplate restTemplate;

    public ObservableList<Comment> getComments() {
        return comments;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public void loadData() {
        Comment[] comments = restTemplate.getForObject("http://localhost:7000/comments", Comment[].class);
        this.comments.setAll(comments);
    }

    public Comment addComment(String userName, String comment) {
        Comment commentEntity = new Comment();
        commentEntity.setUserName(userName);
        commentEntity.setContent(comment);
        Integer id = restTemplate.postForObject("http://localhost:7000/comments", commentEntity, Integer.class);
        commentEntity.setId(id);
        comments.add(commentEntity);
        return commentEntity;
    }

    public User getUser(String username) {
        return restTemplate.getForObject("http://localhost:7000/user/" + username, User.class);
    }

}
