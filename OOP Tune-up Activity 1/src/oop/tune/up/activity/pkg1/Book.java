/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.tune.up.activity.pkg1;

/**
 *
 * @author student-106
 */
public class Book {
    private String title;
    private boolean available;

    public Book(String title){
        this.title = title;
        this.available = true;
    }

    public String getTitle(){
        return title;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
}
