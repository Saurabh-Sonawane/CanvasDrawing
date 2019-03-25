package com.deu.model;

public class Canvas {

    private Character[][] canvas;

    public Canvas() {
    }

    public Canvas(Integer width, Integer height) {
        this.canvas = new Character[height+2][width+2];
    }

    public Character[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(Character[][] canvas) {
        this.canvas = canvas;
    }

}