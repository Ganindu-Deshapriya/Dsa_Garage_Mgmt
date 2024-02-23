/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsagaragemgmt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Ganindudesh
 */
public class DSAGarageMgmt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        garageActions garageActions = new garageActions();
        Queue<String> garageQueue = new LinkedList<>();
        Queue<String> waitingQueue = new LinkedList<>();
        Queue<String> tempQueue = new LinkedList<>();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        String action, numberplate;

        while (running) {
            System.out.println("----------------------------------------------------");
            System.out.println("            Laughs parking garage System");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Park a vehicle (Ex input : a ABC1234) ");
            System.out.println("2. Depart a vehicle (Ex input : d ABC1234) ");
            System.out.println("3. Type exit to exit the program");

            String entry = scanner.nextLine();
            if (entry.equals("exit")) {
                running = false;
                break;
            }

            if (entry.equals("p")) {
                System.out.println("Garage queue");
                System.out.println(garageActions.printgarage());
                System.out.println("Waiting Queue");
                System.out.println(garageActions.printWaitingLine());
                
            } else {

                String[] elements = entry.split(" ", 2);
                
                if (elements.length < 2) {
                System.out.println("Invalid input. try again");
                continue; 
            }
                action = elements[0];
                numberplate = elements[1];

                switch (action) {
                    case "a":
                        garageActions.arrival(numberplate);
                        break;
                    case "d":
                        garageActions.departure(numberplate);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
    }
}
