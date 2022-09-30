package com.techelevator.services;

import com.techelevator.model.Brewery;

import java.io.IOException;
import java.util.List;

public interface BreweryService {

    List<String> getAllBreweries() throws IOException, InterruptedException;
}
