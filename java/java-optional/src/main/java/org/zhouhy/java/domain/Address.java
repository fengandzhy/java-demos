package org.zhouhy.java.domain;

import java.util.Optional;

public class Address {
    
    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
