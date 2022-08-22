package com.example;

import java.util.List;
import java.util.stream.Collectors;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")
public class MyStringController
{
	private final MyStringDAO myStringDAO = new MyStringDAO();

	@Get
	public List<String> getAllMyString()
	{
		return this.myStringDAO.getMyStrings().stream().map(s -> s + " old string???").collect(Collectors.toList());
	}

	@Get("/{myString}")
	public String getMyString(@QueryValue final String myString)
	{
		return this.myStringDAO.getMyString(myString);
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
