package com.bateivo.tasks.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rentals")
public class RentalDto {
    @Id
    private Long id;

    private String name;

    private String type;

    private String description;

    private Integer sleeps;

    @Column(name="price_per_day")
    private Long price;

    @Column(name="home_city")
    private String homeCity;

    @Column(name="home_state")
    private String homeState;

    @Column(name="home_zip")
    private String homeZip;

    @Column(name="home_county")
    private String homeCounty;

    @Column(name="home_country")
    private String homeCountry;

    @Column(name="vehicle_make")
    private String vehicleMake;

    @Column(name="vehicle_model")
    private String vehicleModel;

    @Column(name="vehicle_year")
    private Integer vehicleYear;

    @Column(name="vehicle_length")
    private BigDecimal vehicleLength;

    private Timestamp created;

    private Timestamp updated;

    private Double lat;

    private Double lng;

    @Column(name="primary_image_url")
    private String primaryImageUrl;

    @Column(name="owner_name")
    private String ownerName;

    @Column(name="owner_avatar_url")
    private String ownerAvatarUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "rentalId", fetch = FetchType.EAGER)
    private Set<RentalImageDto> images = new HashSet<>();

    public RentalDto() {}

    public RentalDto(@NotNull Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public BigDecimal getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(BigDecimal vehicleLength) {
        this.vehicleLength = vehicleLength;
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

    public String getPrimaryImageUrl() {
        return primaryImageUrl;
    }

    public void setPrimaryImageUrl(String primaryImageUrl) {
        this.primaryImageUrl = primaryImageUrl;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    public void setOwnerAvatarUrl(String ownerAvatarUrl) {
        this.ownerAvatarUrl = ownerAvatarUrl;
    }

    public Set<RentalImageDto> getImages() {
        return images;
    }

    public void setImages(Set<RentalImageDto> images){
        this.images = images;
    }

    @Override
    public String toString(){
        return "Rental { id = " + id + ", name = '" + name + '\'' +
                "type = " + type + "price per day = " + price + " }";
    }
}
