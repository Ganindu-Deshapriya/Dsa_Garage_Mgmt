/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsagaragemgmt;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ganindudesh
 */
public class garageActions {

    Queue<car> garageLine = new LinkedList<>(); // Queue to represent the garage
    Queue<car> waitingList = new LinkedList<>();// List to maintain cars waiting for parking
    Queue<car> Templine = new LinkedList<>();// Temporary storage for cars during depart process
    private final int garage_Size = 10;// Maximum capacity of the garage
    boolean foundFlag = false;
    Queue<String> test = new LinkedList<>(); //remove!!!!!!!!!!!!!!

    public void arrival(String numberplate) {
        if (alreadyExists(numberplate)) {
            System.out.println("Car with license plate " + numberplate + " Already exists, try again.");
        } else {

            if (garageLine.size() < garage_Size) {
                car car = new car(numberplate);
                garageLine.add(car);
                System.out.println("Car with license plate " + numberplate + " arrived. Garage has space.");
            } else {
                car car = new car(numberplate);
                waitingList.add(car);
                System.out.println("Car with license plate " + numberplate + " arrived. No space. Waiting");

            }
        }
    }

    public void departure(String numberplate) {
        int dCarCounter = 1;
        
        if (!alreadyExists(numberplate)){
            System.out.println("Car with license plate " + numberplate + " does not exist, try again!");
        }
        for (car carInWaiting : waitingList) {
            if (carInWaiting.numberPlate.equals(numberplate)) {
                System.out.println("Car with license plate " + numberplate + " departed from the waiting queue. Moved " + 0 + " times.");
                waitingList.remove(carInWaiting);
                foundFlag = true;
                break; // Exit loop after removing the car
            }
        }
        if (!foundFlag) {
            for (car obj : garageLine) {
                if (obj.numberPlate.equals(numberplate)) {
                    obj.moveIncrementer(dCarCounter - 1);
                    System.out.println("Car with license plate " + numberplate + " departed. Moved " + dCarCounter + " times.");
                    continue; // Exit loop after processing the car
                } else {
                    Templine.add(obj);
                    dCarCounter++;
                }
            }
            garageLine.clear();
            garageLine.addAll(Templine); // Update garageLine
            Templine.clear();

            while (!waitingList.isEmpty() && garageLine.size() < 10) {
                garageLine.add(waitingList.poll());
            }

        }
    }

    public boolean alreadyExists(String numberplate) {
        for (car obj : garageLine) {
            if (obj.numberPlate.equals(numberplate)) {
                return true;
            }
        }

        for (car obj : waitingList) {
            if (obj.numberPlate.equals(numberplate)) {
                return true;
            }
        }
        return false;
    }

    public Queue<String> printgarage() {
        test.clear();
        for (car obj : garageLine) {
            test.add(obj.getNumberPlate());
        }
        return test;
    }
    
        public Queue<String> printWaitingLine() {
        test.clear();
        for (car obj : waitingList) {
            test.add(obj.getNumberPlate());
        }
        return test;
    }
}
