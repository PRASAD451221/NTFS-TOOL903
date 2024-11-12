package com.nt.upi;

import java.util.Random;

public class upiPayment {
	public String upipay(String upiid,float amout)
	{
		return "upi payment for the amount" + amout+"this id"+upiid+" as done sss";
	}
	public double checkBalance(String upid)
	{
		return new Random().nextInt(122000);
	}

}
