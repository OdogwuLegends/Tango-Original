package com.tm30.tango.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "role")
public class Role extends BaseEntity{

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permission> permission = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
}
