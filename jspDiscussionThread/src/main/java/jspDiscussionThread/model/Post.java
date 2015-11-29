/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jspDiscussionThread.model;

/**
 *
 * @author cswor
 */
public class Post {
    private String author;
    private String date;
    private String content;

    public Post(String author, String date, String content) {
        this.author = author;
        this.date = date;
        this.content = content;
    }

    Post() {
        this.author = "";
        this.date = "";
        this.content = "";
    }
    
    @Override
    public String toString() {
        return "<div class=\"post\"><h1>" + author + " replied on " + date + "</h1><hr><p>" + content + "</p></div>";
    }
    
    public String toFileString() {
        return author + '"' + date + '"' + content;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    void loadFromFileString(String line) {
        String[] parts = line.split("\"");
            author = parts[0];
            date = parts[1];
            content = parts[2];
    }
}
