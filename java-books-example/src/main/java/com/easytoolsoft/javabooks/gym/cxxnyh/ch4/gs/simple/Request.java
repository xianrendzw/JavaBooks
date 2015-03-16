package com.easytoolsoft.javabooks.gym.cxxnyh.ch4.gs.simple;

import com.easytoolsoft.javabooks.gym.cxxnyh.ch4.future.pattern.Data;

public class Request {
	private String name;

	public Request(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "[ Request " + name + " ]";
	}
}
