package com.sp.std.beans;

public class Book {
    private String bookName;
    private String author;

    public Book() {
        System.out.println("Book 被创建..........");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void myInit(){
        System.out.println("..........myInit.............");
    }

    public void myDestroy(){
        System.out.println("..........myDestroy.............");
    }
}
