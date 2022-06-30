package com.bateivo.tasks.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rental_images")
public class RentalImageDto {

    @Id
    private Long id;

    @Column(name="rental_id")
    private Long rentalId;

    private String url;

    public RentalImageDto() {}

    public RentalImageDto(@NotNull Long rentalId, @NotNull String url) {

        this.rentalId = rentalId;
        this.url = url;
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

    public Long getRentalId() { return rentalId; }

    public void setRentalId(Long rentalId) { this.rentalId = rentalId; }

    @Override
    public String toString() {
        return "RentalImage {" + "id = " + id + ", url = " + url + '}';
    }
}
