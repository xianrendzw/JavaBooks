package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.decorator;

public class Main {
	public static void main(String[] args) {
		IPacketCreator pc = new PacketHTTPHeaderCreator(
				new PacketHTMLHeaderCreator(
						new PacketBodyCreator()));
		System.out.println(pc.handleContent());
	}
}
