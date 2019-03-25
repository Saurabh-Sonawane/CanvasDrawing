package com.deu;

import com.deu.controller.CanvasController;
import com.deu.controller.CommandController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrawingApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(DrawingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DrawingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CommandController commandController = new CommandController(new CanvasController());
        commandController.controlCommand();
    }
}
