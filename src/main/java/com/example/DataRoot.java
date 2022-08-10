package com.example;

import java.util.HashMap;
import java.util.Map;

public class DataRoot
{
	public static class MyClass
	{
		private Map<String, String> map = new HashMap<>();

		public Map<String, String> getMap()
		{
			return this.map;
		}

		public void setMap(final Map<String, String> map)
		{
			this.map = map;
		}

		public MyClass(final Map<String, String> map)
		{
			this.map = map;
		}

		public MyClass()
		{
		}
	}

	public final MyClass myStrings = new MyClass();
}
