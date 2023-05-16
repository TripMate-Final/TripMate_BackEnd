package com.ssafy.comment.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto (댓글)", description = "댓글 내용 Class")
public class CommentDto {
    private String commentId;
    private String contentId;
    private String userName;
    private int comment_num;
    private int commentDepth;
    private String commentContent;
    private String commentDate;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getCommentDepth() {
        return commentDepth;
    }

    public void setCommentDepth(int commentDepth) {
        this.commentDepth = commentDepth;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentId='" + commentId + '\'' +
                ", contentId='" + contentId + '\'' +
                ", userName='" + userName + '\'' +
                ", comment_num=" + comment_num +
                ", commentDepth=" + commentDepth +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate='" + commentDate + '\'' +
                '}';
    }
}
