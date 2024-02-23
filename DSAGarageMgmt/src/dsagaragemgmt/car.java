/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsagaragemgmt;

import java.util.Objects;

/**
 *
 * @author Ganindudesh
 */
public class car {
    char action;
    String numberPlate;
    int moveCount;

    public car(String numberPlate) {
        this.action = action;
        this.numberPlate = numberPlate;
        this.moveCount = 0;
    }

    public char getAction() {
        return action;
    }

    public String getNumberPlate() {
        return numberPlate;
    }
    
    
    public void moveIncrementer(int incrementNum){
        this.moveCount = moveCount+incrementNum;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
    

}
