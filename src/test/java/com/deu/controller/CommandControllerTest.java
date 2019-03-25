package com.deu.controller;

import com.deu.model.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CommandControllerTest {

    @Test
    public void controlCreateCanvasCommand() throws Exception {
        //given
        CanvasController canvasController = Mockito.mock(CanvasController.class);
        CommandController commandController = new CommandController(canvasController);
        System.setIn(new ByteArrayInputStream("C 20 5 \n Q".getBytes()));
        //when
        commandController.controlCommand();
        //then
        Mockito.verify(canvasController, Mockito.times(1)).createCanvas(20, 5);
    }

    @Test
    public void controlCreateLineCommand() throws Exception {
        //given
        CanvasController canvasController = Mockito.mock(CanvasController.class);
        CommandController commandController = new CommandController(canvasController);
        Mockito.when(canvasController.getCanvas()).thenReturn(new Canvas(20, 5));
        System.setIn(new ByteArrayInputStream("C 20 5\nL 1 3 7 3\nQ".getBytes()));
        //when
        commandController.controlCommand();
        //then
        Mockito.verify(canvasController, Mockito.times(1)).createLine(1, 3, 7, 3);
    }

    @Test
    public void controlCreateRectangleCommand() throws Exception {
        //given
        CanvasController canvasController = Mockito.mock(CanvasController.class);
        CommandController commandController = new CommandController(canvasController);
        Mockito.when(canvasController.getCanvas()).thenReturn(new Canvas(20, 5));
        System.setIn(new ByteArrayInputStream("C 20 5 \nR 15 2 20 5\n Q".getBytes()));
        //when
        commandController.controlCommand();
        //then
        Mockito.verify(canvasController, Mockito.times(1)).createRectangle(15, 2, 20, 5);
    }

}