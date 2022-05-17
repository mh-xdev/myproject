package com.example;

import one.microstream.cluster.nodelibrary.common.ClusterStorageManager;
import one.microstream.cluster.nodelibrary.common.ClusterStorageManagerProvider;

public class MyClusterStorageManagerProvider implements ClusterStorageManagerProvider
{
	@Override
	public ClusterStorageManager provideClusterStorageManager()
	{
		return DB.get().storage();
	}
}
