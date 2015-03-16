package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.proxy;

public class Main {
	public static void main(String args[]) {
		IDBQuery q = new DBQueryProxy(); // ʹ�ô���
		q.request(); // ������ʹ��ʱ�Ŵ�����ʵ����
	}
}
