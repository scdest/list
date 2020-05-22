package com.simple.list.services;

import com.simple.list.entity.ItemEntity;
import com.simple.list.entity.ListEntity;
import com.simple.list.exceptions.AccessForbiddenException;
import com.simple.list.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ListService listService;


    public void saveOrUpdate(ItemEntity listItem, Integer ownerId) {
        if(!Objects.equals(ownerId, listService.findByIdOrElseNull(listItem.getListId()).getOwnerId())) {
            throw new AccessForbiddenException("Owner of this list doesn't match with the requester");
        }
        itemRepository.save(listItem);
    }

    public List<ItemEntity> getItemsByListIds(List<Integer> listIds) {
        return itemRepository.findAllByListIds(listIds);
    }
}
