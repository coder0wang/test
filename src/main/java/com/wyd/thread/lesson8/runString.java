package com.wyd.thread.lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class runString {

	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strs = "1+1*2+(10-(2*(5-3)*(2-1))-4)+10/(5-0)";
		try {
			System.out.println(jse.eval(strs));
		} catch (Exception t) {
		}
	}
}
