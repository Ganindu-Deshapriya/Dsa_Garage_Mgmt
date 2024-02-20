/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsagaragemgmt;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ganindudesh
 */
public class DSAGarageMgmt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> garageQueue = new LinkedList<>();
        Queue<String> waitingQueue = new LinkedList<>();

        String input = "a A, a B, a C, a D, a E, a F, a G, a H, a I, a J, a K, a L, a M, a N, d A, d C, d F, d x, d E, d K";
        String[] steps = input.split(", ");

        for (String step : steps) {
            int movecount = 0;
            String numberPlate = step.substring(2);
            char action = step.charAt(0);
            car car = new car(action, numberPlate);

            if (car.action == 'a') {
                if (garageQueue.size() < 10) {
                    garageQueue.add(car.numberPlate);
                    System.out.println("Car with license plate " + car.numberPlate + " arrived. Garage has space.");
                } else {
                    waitingQueue.add(car.numberPlate);
                    System.out.println("Car with license plate " + car.numberPlate + " arrived. No space available. Waiting for space");
                }

            } else if (car.action == 'd') {
                Queue<String> updatedQueue = new LinkedList<>();
                System.out.println(garageQueue);
                if (garageQueue.contains(car.numberPlate)) {
                    String topcar = garageQueue.peek();
                    while (!garageQueue.peek().equals(car.numberPlate)) {
                        updatedQueue.add(garageQueue.poll());
                        movecount++;
                    }
                    garageQueue.poll();
                    movecount++;
                    while (!garageQueue.isEmpty()) {
                        updatedQueue.add(garageQueue.poll());
                    }

                    System.out.println("Car with license plate " + car.numberPlate + " departed. Moved " + movecount + " times.");
                    garageQueue = updatedQueue;
//                    System.out.println(garageQueue);

                    while (!waitingQueue.isEmpty() && garageQueue.size() < 10) {
                        garageQueue.add(waitingQueue.poll());
                    }
                } else if (waitingQueue.contains(car.numberPlate)) {
                    System.out.println("Car with license plate " + car.numberPlate + " departed from the waiting queue. Moved " + movecount + " times.");
                } else {
                    System.out.println("\ncar with numberplate " + car.numberPlate + " does not exist!\n");
                }

            }
        }

    }
    // TODO code application logic here

}
