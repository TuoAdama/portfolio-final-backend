package com.portfolio.adama.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    private Date expiryDate;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
}
