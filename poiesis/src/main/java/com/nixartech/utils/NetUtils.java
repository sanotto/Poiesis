package com.nixartech.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.LinkedList;

public class NetUtils {

	/**
	 * Get the MAC address associated with localhost.
	 * 
	 * @return
	 * @throws UnknownHostException
	 * @throws SocketException
	 */
	public static String getLocalhostMacAddress() throws UnknownHostException, SocketException {

		InetAddress localHost = InetAddress.getLocalHost();
		NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
		byte[] hardwareAddress = ni.getHardwareAddress();
		
		//As NetworkInterface#getHardwareAddress returns an array of bytes, we can format the result:
		return formatMAC(hardwareAddress);
	}

	private static String formatMAC(byte[] hardwareAddress) {
		String[] hexadecimal = new String[hardwareAddress.length];
		for (int i = 0; i < hardwareAddress.length; i++) {
		    hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
		}
		String macAddress = String.join("-", hexadecimal);
		return macAddress;
	}
	
	public static String getLocalIPMacAddress(String address) throws UnknownHostException, SocketException {
		InetAddress localIP = InetAddress.getByName(address);
		NetworkInterface ni = NetworkInterface.getByInetAddress(localIP);
		byte[] hardwareAddress = ni.getHardwareAddress();	
		return formatMAC(hardwareAddress);
	}
	
	public static LinkedList<String> getAllMACs() throws SocketException {
		LinkedList<String> macs = new LinkedList<String>();
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		while (networkInterfaces.hasMoreElements()) {
		    NetworkInterface ni = networkInterfaces.nextElement();
		    byte[] hardwareAddress = ni.getHardwareAddress();
		    if (hardwareAddress != null) {
		    	macs.add(formatMAC(hardwareAddress));
		    }
		}
		return macs;
	}
	
	
	public static void main(String[] args) throws UnknownHostException, SocketException {
		System.out.println("Localhost MAC:"+getLocalhostMacAddress());
		System.out.println("\n\nAll MACs:");
		for(String aMAC: getAllMACs()) {
			System.out.println(aMAC);
		}
	}
	
	
}
