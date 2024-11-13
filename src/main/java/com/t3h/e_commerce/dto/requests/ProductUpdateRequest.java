package com.t3h.e_commerce.dto.requests;

import lombok.Builder;


import java.math.BigDecimal;


@Builder
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
   private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public ProductUpdateRequest() {
    }

    public ProductUpdateRequest(String name, String imageUrl, String description,
                                BigDecimal price, Integer quantity) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
