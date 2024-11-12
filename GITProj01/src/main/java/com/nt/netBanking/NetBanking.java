package com.nt.netBanking;

import java.util.Random;

public class NetBanking {
	public String OpenAccount(String aadhar,double initailAmount,String type)

	{
		return "acount is open for "+new Random().nextLong(1234567890);
	}
	public String withDraw(long accno,double amount)
	{
		return amount+"is the withdrew from acc no"+accno;
	}
	public String diposited(long accno,double amount)
	{
		return amount+"is the diposte the amount to "+accno;
	}
	// Hi hello every one here HI

	public String closeAcc()
	{
		return " close account";
	}
}
