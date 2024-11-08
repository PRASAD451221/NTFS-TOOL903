package com.ni;

/**
 * Hello world!
 */
public class App {
	public int sum(int a,int b)
	{
		return a+b;
	}
    public static void main(String[] args) {
        System.out.println("Hello World!");
        App app = new App();
        System.out.println("Hello World!"+app.sum(10, 30));
    }
}
