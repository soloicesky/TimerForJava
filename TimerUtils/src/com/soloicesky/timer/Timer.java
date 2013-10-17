package com.soloicesky.timer;

public class Timer {
	private long timeOutMs = 0;
	private boolean bTimeOut = false;

	public Timer() {
		this.timeOutMs = 0;
		this.bTimeOut = false;
	}

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

	public boolean timeOut() {
		return bTimeOut;
	}

}
