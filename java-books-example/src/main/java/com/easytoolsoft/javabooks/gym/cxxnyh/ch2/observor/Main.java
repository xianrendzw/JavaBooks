package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.observor;

public class Main {
	public static void main(String[] args) {
		ConcreteSubject sub = new ConcreteSubject();
		sub.attach(new ConcreteObserver());
		sub.inform();
	}
}
