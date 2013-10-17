package com.soloicesky.timer;

/**
 * 
 * @filname Timer.java
 * @description A Usefull timer lib for java.
 * @author soloicesky
 * @data 2013-10-17		@time ÏÂÎç2:54:50
 */

public class Timer {
	private long timeOutMs = 0;
	private boolean bTimeOut = false;

	/**
	 * default constructor
	 */
	public Timer() {
		this.timeOutMs = 0;
		this.bTimeOut = false;
	}

	/**
	 * 
	 * @param timeOutMs initial the time out millisecond time
	 */
	public Timer(long timeOutMs) {
		this.timeOutMs = timeOutMs;
		this.bTimeOut = false;
	}

	public void setTimeOutMs(long ms) {
		this.timeOutMs = ms;
	}

	public long getTimeOutMs() {
		return this.timeOutMs;
	}
	
	public void setTimOut() {
		bTimeOut = true;
	}

	/**
	 * start the timer
	 */
	public void start() {
		final Timer tm = this;

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long startTime = System.currentTimeMillis();

				while (!tm.timeOut()) {
					if (System.currentTimeMillis() - startTime >= tm
							.getTimeOutMs()) {
						tm.setTimOut();
						break;
					}
				}
			}
		});
		
		thread.start();
	}
	
	/**
	 * to check if the timer is out of time
	 * @return true - already time out false- not time out yet
	 */
	public boolean timeOut() {
		return bTimeOut;
	}

}
