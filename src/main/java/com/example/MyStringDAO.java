package com.example;

import java.util.ArrayList;
import java.util.List;

public class MyStringDAO
{
	public void addMyString(final String myString)
	{
		synchronized (DB.get())
		{
			final List<String> myStrings = DB.get().root().myStrings;
			myStrings.add(myString);
			DB.get().storage().store(myStrings);
		}
	}

	public List<String> getMyStrings()
	{
		return new ArrayList<>(DB.get().root().myStrings);
	}

	public String getMyString(final String myString)
	{
		return this.getMyStrings().stream().filter(s -> s.equals(myString)).findFirst().orElse(null);
	}

	public void deleteMyString(final String myString)
	{
		synchronized (DB.get())
		{
			final List<String> myStrings = DB.get().root().myStrings;
			myStrings.remove(myString);
			DB.get().storage().store(myStrings);
		}
	}
}
