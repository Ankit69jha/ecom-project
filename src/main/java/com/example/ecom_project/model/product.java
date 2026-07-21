package com.example.ecom_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String brand;
    private String category;

    private BigDecimal price;

    private Date releaseDate;

    private boolean productAvailable;

    private int stockQuantity;

    private String imageName;
    private String imageType;

    @JdbcTypeCode(SqlTypes.VARBINARY)
    @Column(name = "image_data")
    private byte[] imageData;
}