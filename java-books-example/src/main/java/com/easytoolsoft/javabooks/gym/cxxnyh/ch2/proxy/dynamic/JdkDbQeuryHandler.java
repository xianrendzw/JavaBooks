package com.easytoolsoft.javabooks.gym.cxxnyh.ch2.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.easytoolsoft.javabooks.gym.cxxnyh.ch2.proxy.IDBQuery;

public class JdkDbQeuryHandler implements InvocationHandler {
	IDBQuery real = null;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (real == null)
			real = new DBQuery();
		return real.request();
	}
}
