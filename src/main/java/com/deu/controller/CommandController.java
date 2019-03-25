package com.deu.controller;

import java.util.Scanner;

public class CommandController {

    private CanvasController canvasController;

    public CommandController(CanvasController canvasController) {
        this.canvasController = canvasController;
    }

    public void controlCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nEnter command : ");
        String command = scanner.nextLine();
        while(command != null && !command.contains("Q")) {
            processCommand(command);
            System.out.print("\n\nEnter command : ");
            command = scanner.nextLine();
        }
    }

    private void processCommand(String cammand) {
        Integer h, w, x1, y1, x2, y2;
        if(cammand  != null && cammand.length() > 0) {
            String[] cammands = cammand.split(" ");
            if(cammands != null && cammands.length == 3 || cammands.length == 5) {
                switch (cammands[0]) {
                    case "C" :
                        processCanvanCommand(cammands);
                        break;
                    case "L" :
                        if(canvasController.getCanvas() != null && canvasController.getCanvas().getCanvas() != null && canvasController.getCanvas().getCanvas().length > 0) {
                            processLineCommand(cammands);
                        } else {
                            System.out.println("Please create canvas first.");
                        }
                        break;
                    case "R" :
                        if(canvasController.getCanvas() != null && canvasController.getCanvas().getCanvas() != null && canvasController.getCanvas().getCanvas().length > 0) {
                            processRectangleCommand(cammands);
                        } else {
                            System.out.println("Please create canvas first.");
                        }
                        break;
                }
            } else {
                System.out.println("Please enter valid command.");
            }

        }

    }

    private void processRectangleCommand(String[] cammands) {
        Integer x1;
        Integer y1;
        Integer x2;
        Integer y2;
        try {
            x1 = Integer.parseInt(cammands[1]);
            y1 = Integer.parseInt(cammands[2]);
            x2 = Integer.parseInt(cammands[3]);
            y2 = Integer.parseInt(cammands[4]);
            if(x1 > 0 && y1> 0 && x2 > 0 && y2 > 0 ) {
                canvasController.createRectangle(x1, y1, x2, y2);
                canvasController.printCanvas();
            } else {
                System.out.println("Please enter positive co-ordinates for rectangle.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers for co-ordinates.");
        }
    }

    private void processLineCommand(String[] cammands) {
        Integer x1;
        Integer y1;
        Integer x2;
        Integer y2;
        try {
            x1 = Integer.parseInt(cammands[1]);
            y1 = Integer.parseInt(cammands[2]);
            x2 = Integer.parseInt(cammands[3]);
            y2 = Integer.parseInt(cammands[4]);
            if(x1 > 0 && y1> 0 && x2 > 0 && y2 > 0 ) {
                if( x1.equals(x2) || y1.equals(y2) ) {
                    canvasController.createLine(x1, y1, x2, y2);
                    canvasController.printCanvas();
                } else {
                    System.out.println("Please enter valid co-ordinates for line.");
                }
            } else {
                System.out.println("Please enter positive co-ordinates for line.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers for co-ordinates.");
        }
    }

    private void processCanvanCommand(String[] cammands) {
        Integer w;
        Integer h;
        try {
            w = Integer.parseInt(cammands[1]);
            h = Integer.parseInt(cammands[2]);
            if(w > 0 && h > 0) {
                canvasController.createCanvas(w, h);
                canvasController.printCanvas();
            } else {
                System.out.println("Please enter positive co-ordinates for canvas.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers for co-ordinates.");
        }
    }

    public CanvasController getCanvasController() {
        return canvasController;
    }
}
