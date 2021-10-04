package com.pascualbravo.citadel.models;


public class Trolley {
    private int trolleyId;
    private int bookId;
    private String bookName;
    private String author;
    private String editorialName;
    private String bookbindingName;
    private int units;
    private double price;

    /**
     * @return the trolleyId
     */
    public int getTrolleyId() {
        return trolleyId;
    }

    /**
     * @param trolleyId the trolleyId to set
     */
    public void setTrolleyId(int trolleyId) {
        this.trolleyId = trolleyId;
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
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
     * @return the editorialName
     */
    public String getEditorialName() {
        return editorialName;
    }

    /**
     * @param editorialName the editorialName to set
     */
    public void setEditorialName(String editorialName) {
        this.editorialName = editorialName;
    }

    /**
     * @return the bookbindingName
     */
    public String getBookbindingName() {
        return bookbindingName;
    }

    /**
     * @param bookbindingName the bookbindingName to set
     */
    public void setBookbindingName(String bookbindingName) {
        this.bookbindingName = bookbindingName;
    }

    /**
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
