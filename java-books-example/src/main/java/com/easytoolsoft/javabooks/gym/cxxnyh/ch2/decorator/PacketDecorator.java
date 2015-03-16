package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.decorator;

public abstract class PacketDecorator implements IPacketCreator {
	IPacketCreator componet;

	public PacketDecorator(IPacketCreator c) {
		componet = c;
	}
}
