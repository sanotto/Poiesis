package com.nixartech.poiesis.subcommands;

import picocli.CommandLine.Command;

@Command(
		  name = "gencde",
		  description = "Generate code from definitions."
		)
public class GenCde implements Runnable {

    @Override
    public void run() {
	System.out.println("Generate code from def...");
	
    }

}
