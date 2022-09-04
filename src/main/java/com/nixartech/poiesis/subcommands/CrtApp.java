package com.nixartech.poiesis.subcommands;

import picocli.CommandLine.Command;

@Command(
		  name = "crtapp",
		  description = "Create a new Poiesis application."
		)
public class CrtApp implements Runnable {

    @Override
    public void run() {
	System.out.println("Create a Poiesis App...");
	
    }

}
