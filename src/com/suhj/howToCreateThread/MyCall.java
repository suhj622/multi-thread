/**
 * 
 */
package com.suhj.howToCreateThread;

import java.util.concurrent.Callable;

/**
 * @author Haojie
 * 
 */
public class MyCall implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("Hello MyCall");
		return "success";
	}

}
