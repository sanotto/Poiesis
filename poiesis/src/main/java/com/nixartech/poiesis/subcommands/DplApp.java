package com.nixartech.poiesis.subcommands;

import picocli.CommandLine.Command;

@Command(
		  name = "dplapp",
		  description = "Deploy this application."
		)
public class DplApp implements Runnable {

    @Override
    public void run() {
	System.out.println("Deploy app ...");
	
    }

}
