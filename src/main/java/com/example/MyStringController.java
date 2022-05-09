package com.example;

import java.util.List;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import one.microstream.cluster.nodelibrary.StorageClusterController;

@Controller("/")
public class MyStringController extends StorageClusterController
{
	private final MyStringDAO myStringDAO = new MyStringDAO();

	public MyStringController()
	{
		super(DB.get().storage());
	}

	@Get
	public List<String> getAllMyString()
	{
		return this.myStringDAO.getMyStrings();
	}

	@Get("/{myString}")
	public String getMyString(@QueryValue final String myString)
	{
		return this.myStringDAO.getMyString(myString);
	}

	@Post(consumes = MediaType.TEXT_PLAIN)
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
