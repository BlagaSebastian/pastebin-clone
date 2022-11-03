package com.pastebin.models;

import javax.persistence.*;

@Entity
@Table(name="paste")
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="paste_id")
    private Integer pasteId;

    private String title;
    private String author;
    @Lob
    private String content;


    public Paste(Integer pasteId, String title, String author, String content) {
        this.pasteId = pasteId;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Paste() {

    }

    public Integer getPasteId() {
        return pasteId;
    }

    public void setPasteId(Integer pasteId) {
        this.pasteId = pasteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Paste{" +
                "pasteId=" + pasteId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", context='" + content + '\'' +
                '}';
    }
}
