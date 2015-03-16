package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.singleton;

public class LazySingleton {
	private LazySingleton() {
		// ���������Ĺ��̿��ܻ�Ƚ���
		System.out.println("LazySingleton is create");
	}

	private static LazySingleton instance = null;

	public static synchronized LazySingleton getInstance() {
		if (instance == null)
			instance = new LazySingleton();
		return instance;
	}
}