package com.easytoolsoft.javabooks.gym.cxxnyh.ch5.memory;

import java.util.Vector;

/**
 * -Xmx11M -Xms4M -verbose:gc
 * -Xmx11M -Xms11M -Xmn8M -verbose:gc
 * 
 * @author Administrator
 *
 */
public class TestXms {
	public static void main(String args[]) {
		Vector v = new Vector();
		for (int i = 1; i <= 10; i++) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 3)
				v.clear();
		}
	}
}
