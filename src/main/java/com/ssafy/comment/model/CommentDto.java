package com.ssafy.comment.model;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "CommentDto (댓글)", description = "댓글 내용 Class")
public class CommentDto {
    private int commentId;
    private int contentId;
    private String userName;
    private int commentNum;
    private int commentDepth;
    private String commentContent;
    private String commentDate;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getComment_num() {
        return commentNum;
    }

    public void setComment_num(int comment_num) {
        this.commentNum = comment_num;
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
                ", comment_num=" + commentNum +
                ", commentDepth=" + commentDepth +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate='" + commentDate + '\'' +
                '}';
    }
}
