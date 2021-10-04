package com.pascualbravo.citadel.models;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private int editorialId;
    private String editorialName;
    private int bookbindingId;
    private String bookbindingName;
    private int bookYear;
    private int numPages;
    private String edition;
    private int categoryId;
    private String categoryName;
    private int units;
    private double price;
    private boolean enabled;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the editorialId
     */
    public int getEditorialId() {
        return editorialId;
    }

    /**
     * @param editorialId the editorialId to set
     */
    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
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
     * @return the bookbindingId
     */
    public int getBookbindingId() {
        return bookbindingId;
    }

    /**
     * @param bookbindingId the bookbindingId to set
     */
    public void setBookbindingId(int bookbindingId) {
        this.bookbindingId = bookbindingId;
    }

    /**
     * @return the bokkbindingName
     */
    public String getBookbindingName() {
        return bookbindingName;
    }

    /**
     * @param bokkbindingName the bokkbindingName to set
     */
    public void setBookbindingName(String bookbindingName) {
        this.bookbindingName = bookbindingName;
    }

    /**
     * @return the bookYear
     */
    public int getBookYear() {
        return bookYear;
    }

    /**
     * @param bookYear the bookYear to set
     */
    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    /**
     * @return the numPages
     */
    public int getNumPages() {
        return numPages;
    }

    /**
     * @param numPages the numPages to set
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public boolean getEnabled(){
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled){
        this.enabled=enabled;
    }
}
