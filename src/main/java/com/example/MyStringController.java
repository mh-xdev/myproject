package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.Uuid;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

@Controller("/mystrings")
public class MyStringController
{
	private final MyStringDAO myStringDAO = new MyStringDAO();

	@Get
	public List<String> getAllMyString()
	{
		return this.myStringDAO.getMyStrings();
	}

	@Get("/{myString}")
	public HttpResponse<String> getMyString(@QueryValue final String myString)
	{
		// Simulate some calculations and stuff for benchmarking
		final long start = System.currentTimeMillis();
		final var x = this.myStringDAO.getMyStrings().stream().flatMap(s ->
		{
			final var ls = new ArrayList<>();
			ls.add(s);
			return ls.stream();
		}).map(e ->
		{
			System.out.println(
				"This is a heavy oneliner that will degrade performance massively!!!! Look at how many letters!" + Uuid
					.randomUuid()
					.toString()
			);
			return e;
		}).collect(Collectors.toList());
		final var res = HttpResponse.ok(this.myStringDAO.getMyString(myString))
			.header("Chunkyness", Integer.toString(x.size()));
		System.err.println("Took: " + (System.currentTimeMillis() - start) + "ms");
		return res;
	}

	@Put(consumes = MediaType.TEXT_PLAIN)
	public void postMyString(@Body final String myString)
	{
		this.myStringDAO.addMyString(myString);
	}

	@Delete("/{myString}")
	public void deleteMyString(@QueryValue final String myString)
	{
		this.myStringDAO.deleteMyString(myString);
	}
}
