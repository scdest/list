package com.simple.list.repositories;

import com.simple.list.entity.ListEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListRepository extends CrudRepository<ListEntity, Integer> {
/*
    @Query(value = "SELECT DISTINCT l FROM ListEntity l LEFT JOIN l.items WHERE l.ownerId = :ownerId")
    List<ListEntity> findByOwnerIdJoin(Integer ownerId); */

    List<ListEntity> findByOwnerId(Integer ownerId);
}
