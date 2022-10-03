package com.techelevator.services;

import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public interface BreweryService {

    List<String> searchBreweries(@RequestParam String search) throws IOException, InterruptedException;
}
