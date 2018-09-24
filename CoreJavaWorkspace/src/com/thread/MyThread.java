package com.thread;

public class MyThread  {
	
	public static void main(String[] args) {
		Thread t1=new Thread(new MainThread());
		t1.start();
		
	}
}

class MainThread implements Runnable{
	@Override
	public void run() {
		System.out.println("my first thread");
		
	}
}
