package com.simple.list.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "lists")
@NoArgsConstructor
@AllArgsConstructor
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;
    private Instant createdOn;
    private String listName;
    private Integer ownerId;
/*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listEntity")
    private List<ItemEntity> items; */
}
