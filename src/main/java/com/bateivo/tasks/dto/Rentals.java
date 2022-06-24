package com.bateivo.tasks.dto;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

@MappedEntity
public class Rentals {
    @Id
    private Long id;

    private String name;

    private String type;

    private String description;

    private Integer sleeps;

    private Long price_per_day;

    private String home_city;

    private String home_state;

    private String home_zip;

    private String home_county;

    private String home_country;

    private String vehicle_make;

    private String vehicle_model;

    private Integer vehicle_year;

    private BigDecimal vehicle_length;

    private Timestamp created;

    private Timestamp updated;

    private Double lat;

    private Double lng;

    private String primary_image_url;

    private String owner_name;

    private String owner_avatar_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSleeps() {
        return sleeps;
    }

    public void setSleeps(Integer sleeps) {
        this.sleeps = sleeps;
    }

    public Long getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(Long price_per_day) {
        this.price_per_day = price_per_day;
    }

    public String getHome_city() {
        return home_city;
    }

    public void setHome_city(String home_city) {
        this.home_city = home_city;
    }

    public String getHome_state() {
        return home_state;
    }

    public void setHome_state(String home_state) {
        this.home_state = home_state;
    }

    public String getHome_zip() {
        return home_zip;
    }

    public void setHome_zip(String home_zip) {
        this.home_zip = home_zip;
    }

    public String getHome_county() {
        return home_county;
    }

    public void setHome_county(String home_county) {
        this.home_county = home_county;
    }

    public String getHome_country() {
        return home_country;
    }

    public void setHome_country(String home_country) {
        this.home_country = home_country;
    }

    public String getVehicle_make() {
        return vehicle_make;
    }

    public void setVehicle_make(String vehicle_make) {
        this.vehicle_make = vehicle_make;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public Integer getVehicle_year() {
        return vehicle_year;
    }

    public void setVehicle_year(Integer vehicle_year) {
        this.vehicle_year = vehicle_year;
    }

    public BigDecimal getVehicle_length() {
        return vehicle_length;
    }

    public void setVehicle_length(BigDecimal vehicle_length) {
        this.vehicle_length = vehicle_length;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPrimary_image_url() {
        return primary_image_url;
    }

    public void setPrimary_image_url(String primary_image_url) {
        this.primary_image_url = primary_image_url;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_avatar_url() {
        return owner_avatar_url;
    }

    public void setOwner_avatar_url(String owner_avatar_url) {
        this.owner_avatar_url = owner_avatar_url;
    }

    @Override
    public String toString(){
        return "Rental { id = " + id + ", name = '" + name + '\'' +
                "type = " + type + "price per day = " + price_per_day + " }";
    }
}
