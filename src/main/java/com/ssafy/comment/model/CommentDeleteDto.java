package com.ssafy.comment.model;

public class CommentDeleteDto {
    private int commentId;
    private int contentId;
    private int commentNum;
    private int commentDepth;

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

    public int getComment_num() {
        return commentNum;
    }

    public void setComment_num(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getCommentDepth() {
        return commentDepth;
    }

    public void setCommentDepth(int commentDepth) {
        this.commentDepth = commentDepth;
    }
}
