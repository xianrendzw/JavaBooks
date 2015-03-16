package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.decorator;

public class PacketBodyCreator implements IPacketCreator {
	@Override
	public String handleContent() {
		return "Content of Packet";
	}
}
