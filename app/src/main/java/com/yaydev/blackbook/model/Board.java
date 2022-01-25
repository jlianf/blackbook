package com.yaydev.blackbook.model;

public class Board {

    private int image;
    private String title;
    private String message;
    private String permission;

    public Board(int image, String title, String message, String permission) {
        this.image = image;
        this.title = title;
        this.message = message;
        this.permission = permission;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
