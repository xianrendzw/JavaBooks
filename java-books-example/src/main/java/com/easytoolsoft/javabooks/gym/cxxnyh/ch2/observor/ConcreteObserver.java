package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.observor;

public class ConcreteObserver implements IObserver {
	public void update(Event evt) {
		System.out.println("obserer receives information");
	}
}