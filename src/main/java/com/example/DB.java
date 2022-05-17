package com.example;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.cluster.nodelibrary.common.ClusterStorageManagerProvider;

public class DB implements ClusterStorageManagerProvider
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
	
	@Override
	public ClusterStorageManager provideClusterStorageManager()
	{
		return this.storage();
	}
}
