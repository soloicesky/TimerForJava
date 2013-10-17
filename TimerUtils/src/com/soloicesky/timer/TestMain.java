package com.soloicesky.timer;

public class TestMain {
	public static void main(String[] args) {
		Timer tmTimer = new Timer(10*100);
		
		tmTimer.start();
		System.out.println("timer start!");
		while (!tmTimer.timeOut()) {
			System.out.println("not time out!!!");
			
		}
		
		System.out.println("timeout");
	}
}
