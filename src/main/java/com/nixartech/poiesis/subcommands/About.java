package com.nixartech.poiesis.subcommands;

import picocli.CommandLine.Command;

@Command(
		  name = "about",
		  description = "about this app"
		)
public class About implements Runnable {

    @Override
    public void run() {
	System.out.println("About...");
	
    }

}
