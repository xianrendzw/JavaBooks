package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.proxy.dynamic;

import com.easytoolsoft.javabooks.gym.cxxnyh.ch2.proxy.IDBQuery;

public class DBQuery implements IDBQuery {
	public DBQuery() {
		// Ϊ�˲��Դ���ĵ������ܣ�ȥ���������ʱ����
	}

	@Override
	public String request() {
		return "request string";
	}
}
