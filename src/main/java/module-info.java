module myClusterApp
{
	exports com.example;

	requires io.micronaut.context;
	requires io.micronaut.core;
	requires io.micronaut.http;
	requires io.micronaut.inject;
	requires jakarta.inject;
	requires microstream.afs;
	requires microstream.base;
	requires microstream.enterprise.cluster.nodelibrary;
}
