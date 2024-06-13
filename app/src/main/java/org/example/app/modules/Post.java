package org.example.app.modules;

import org.example.app.enums.PostStatusSelection;


//Post object for all the Post data
public class Post {

    String title;
    String content;

    private PostStatusSelection postStatusSelection;

    boolean published = false;

    String publisher;

    public PostStatusSelection getPostStatusSelection() {
        return postStatusSelection;
    }

    public PostStatusSelection setPostStatusSelection(PostStatusSelection postStatusSelection) {
        return this.postStatusSelection = postStatusSelection;
    }

    public Post(String title, String content, PostStatusSelection postStatusSelection, boolean published, String publisher) {
        this.title = title;
        this.content = content;
        this.postStatusSelection = postStatusSelection;
        this.published = published;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
