package com.bateivo.tasks.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rental_images")
public class RentalImage {

    @Id
    private Long id;

    private String url;

    @ManyToOne
    private Rental rental;

    public RentalImage() {}

    public RentalImage(@NotNull String url, Rental rental ) {
        this.url = url;
        this.rental = rental;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "RentalImage {" + "id = " + id + ", url = " + '\'' + "rental= " + rental + '}';
    }
}
