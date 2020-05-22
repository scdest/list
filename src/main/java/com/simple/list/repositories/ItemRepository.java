package com.simple.list.repositories;

import com.simple.list.entity.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
    @Query("SELECT i FROM ItemEntity i WHERE i.listId IN (:listIds)")
    List<ItemEntity> findAllByListIds(List<Integer> listIds);
}
