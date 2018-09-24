package com.thread;

public class MyThreadExtend {
	public static void main(String[] args) {
		MyThreadEx m=new MyThreadEx();
		m.start();
				
	}

}

class MyThreadEx extends Thread{
	public void run() {
		System.out.println("extended thread class");
	}
}
