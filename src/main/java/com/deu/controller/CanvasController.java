package com.deu.controller;

import com.deu.model.Canvas;

public class CanvasController {

    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void createCanvas(Integer w, Integer h) {
        canvas = new Canvas(w, h);
        setCanvasBorder();
    }

    private void setCanvasBorder() {
        for(int row = 1 ; row < canvas.getCanvas().length - 1; row++) {
            for(int column = 1 ; column < canvas.getCanvas()[0].length - 1; column++) {
                canvas.getCanvas()[row][column] = ' ';
            }
        }
        for (int column = 0; column < canvas.getCanvas()[0].length; column++) {
            canvas.getCanvas()[0][column] = '-';
            canvas.getCanvas()[canvas.getCanvas().length-1][column] = '-';
        }
        for (int column = 1; column < canvas.getCanvas().length-1; column++) {
            canvas.getCanvas()[column][0] = '|';
            canvas.getCanvas()[column][canvas.getCanvas()[0].length-1] = '|';
        }
    }

    public void printCanvas() {
        for(int row =0 ; row < canvas.getCanvas().length; row++) {
            System.out.println();
            for (int column = 0; column < canvas.getCanvas()[row].length; column++) {
                System.out.print(canvas.getCanvas()[row][column]);
            }
        }
    }

    public void createLine(Integer x1, Integer y1, Integer x2, Integer y2) {
        if( x1 == x2) {
            if(y1 < y2) {
                for (int i=y1; i <=y2; i++) {
                    canvas.getCanvas()[i][x1] = 'X';
                }
            } else {
                for (int i=y1; i >=y2; i--) {
                    canvas.getCanvas()[i][x1] = 'X';
                }
            }
        }
        if( y1 == y2) {
            if(x1 < x2) {
                for (int i=x1; i <=x2; i++) {
                    canvas.getCanvas()[y1][i] = 'X';
                }
            } else {
                for (int i=x1; i >=x2; i--) {
                    canvas.getCanvas()[y1][i] = 'X';
                }
            }
        }
    }

    public void createRectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
        createLine(x1, y1, x2, y1);
        createLine(x1, y2, x2, y2);
        createLine(x1, y1, x1, y2);
        createLine(x2, y1, x2, y2);

    }


}