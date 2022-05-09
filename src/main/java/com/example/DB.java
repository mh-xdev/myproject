package com.example;

import one.microstream.cluster.nodelibrary.ClusterStorageManager;

public class DB
{
	private static final DB INSTANCE = new DB();
	
	public static DB get()
	{
		return INSTANCE;
	}
	
	private final DataRoot root;
	private final ClusterStorageManager storage = new ClusterStorageManager(new DataRoot());

	private DB()
	{
		this.root = (DataRoot)this.storage.getRoot();
	}
	
	public ClusterStorageManager storage()
	{
		return this.storage;
	}

	public DataRoot root()
	{
		return this.root;
	}
}
