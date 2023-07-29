package com.example.qualitycontrolsystem.view;

import org.springframework.stereotype.Component;

@Component("menuBar")
public class MenuBar {

    public void shutDown () {
        System.out.print("Shutting down");
       System.exit(0);
    }
}
