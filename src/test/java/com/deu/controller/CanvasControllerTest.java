package com.deu.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CanvasControllerTest {

    CanvasController canvasController;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void verifyCreateCanvas() throws Exception {
        //given
        canvasController = new CanvasController();
        //when
        canvasController.createCanvas(20, 5);
        //then
        Assert.assertEquals(22, canvasController.getCanvas().getCanvas()[0].length);
        Assert.assertEquals(7, canvasController.getCanvas().getCanvas().length);
        Assert.assertEquals("-", canvasController.getCanvas().getCanvas()[0][0].toString());
        Assert.assertEquals("-", canvasController.getCanvas().getCanvas()[0][21].toString());
        Assert.assertEquals("|", canvasController.getCanvas().getCanvas()[1][0].toString());
        Assert.assertEquals("|", canvasController.getCanvas().getCanvas()[1][21].toString());

    }

    @Test
    public void verifyCreateLine() throws Exception {
        //given
        canvasController = new CanvasController();
        canvasController.createCanvas(20, 5);
        //when
        canvasController.createLine(1, 3, 7, 3);
        //then
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][1].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][2].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][3].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][4].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][5].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][6].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[3][7].toString());

    }

    @Test
    public void verifyCreateRectangle() throws Exception {
        //given
        canvasController = new CanvasController();
        canvasController.createCanvas(20, 5);
        //when
        canvasController.createRectangle(15, 2, 20, 5);
        //then
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[2][15].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[5][20].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[5][15].toString());
        Assert.assertEquals("X", canvasController.getCanvas().getCanvas()[2][20].toString());

    }
}