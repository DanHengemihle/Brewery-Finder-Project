package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> listAllBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * from breweries";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }



    @Override
    public Brewery getBreweryById(int breweryId) {
        String sql = "SELECT * FROM breweries WHERE brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if (results.next()) {
            return mapRowToBrewery(results);
        } else {
            return null;
        }
    }

    @Override
    public Brewery getBreweryByName(String name) {
        if (name == null){listAllBreweries();}
        for (Brewery brewery: this.listAllBreweries()){
            if (brewery.getName().equalsIgnoreCase(name)){
                return brewery;
            }
        }
        throw new UsernameNotFoundException("Brewery " + name + " was not found.");
        //exception above will need to be changed to BreweryNotFoundException upon creation
    }

    @Override
    public boolean createBrewery(Brewery brewery) {
        String insertBrewerySql = "INSERT INTO breweries (name, street, city, state, phone, website, " +
                "hours_of_operation) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(insertBrewerySql, brewery.getName(), brewery.getStreet(), brewery.getCity(), brewery.getState(),
                brewery.getPhone(), brewery.getWebsiteUrl(), brewery.getHoursOfOperation()) == 1;
    }

    @Override // needs finished
    public void updateBrewery(Brewery brewery) {
        String sql = "UPDATE breweries SET name = ?, street = ?, city = ?, state = ?, phone = ?, " +
                "website = ?, hours_of_operation = ?";
        jdbcTemplate.update(sql, brewery.getName(), brewery.getStreet(), brewery.getCity(),brewery.getState(),
                brewery.getPhone(), brewery.getWebsiteUrl(), brewery.getHoursOfOperation());
    }

    private Brewery mapRowToBrewery(SqlRowSet results) {
        Brewery brewery = new Brewery();
        brewery.setId(results.getInt("brewery_id"));
        brewery.setName(results.getString("name"));
        brewery.setStreet(results.getString("street"));
        brewery.setCity(results.getString("city"));
        brewery.setState(results.getString("state"));
//        brewery.setPostalCode(results.getString("postal_code"));
//        brewery.setCountry(results.getString("country"));
        brewery.setPhone(results.getString("phone"));
        brewery.setWebsiteUrl(results.getString("website"));
        brewery.setHoursOfOperation(results.getString("hours_of_operation"));


        return brewery;
    }
}
