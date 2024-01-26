package com.project.first_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categoryEntity",cascade =CascadeType.ALL)
    private List<ProductEntity> products;
}
