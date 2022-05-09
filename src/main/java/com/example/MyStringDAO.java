package com.example;

import java.util.ArrayList;
import java.util.List;

public class MyStringDAO
{
	public void addMyString(final String myString)
	{
		synchronized (DB.get())
		{
			DB.get().root().myStrings.add(myString);
			DB.get().storage().store(myString);
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
			final DataRoot root = DB.get().root();
			root.myStrings.remove(myString);
			DB.get().storage().store(root);
		}
	}
}
