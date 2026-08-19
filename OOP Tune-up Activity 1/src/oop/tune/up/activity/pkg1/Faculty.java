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
class Faculty extends Member {

    public Faculty(String name, String username, String password){
        super(name, username, password);
    }

    @Override
    public int getBorrowingLimit(){
        return 5;
    }

}
