package com.example;

import io.micronaut.http.annotation.Controller;
import one.microstream.cluster.nodelibrary.micronaut.StorageClusterController;

@Controller("/micro")
public class MicrostreamController extends StorageClusterController
{
}
