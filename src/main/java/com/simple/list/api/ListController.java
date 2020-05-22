package com.simple.list.api;

import com.simple.list.dto.ItemDto;
import com.simple.list.dto.ListDto;
import com.simple.list.entity.ItemEntity;
import com.simple.list.entity.ListEntity;
import com.simple.list.services.ItemService;
import com.simple.list.services.ListService;
import com.simple.list.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ListController {
    private final ListService service;
    private final UserService userService;
    private final ItemService itemService;

    @PostMapping(value = Api.LISTS)
    public ResponseEntity<Integer> addList(@Valid @RequestBody ListDto listDto) {
        log.info("add list request received {}", listDto);
        ListEntity listEntity = ListEntity.builder()
                .createdOn(Instant.now(Clock.systemUTC()))
                .listName(listDto.getListName())
                .ownerId(geUserIdFromToken())
                .build();
        service.saveOrUpdate(listEntity);
        return ResponseEntity.ok(listEntity.getListId());
    }
/*
    @GetMapping(value = Api.LISTS)
    public List<ListDto> getLists() {
        return service.findByOwnerId(geUserIdFromToken()).stream().map(listEntity -> ListDto.builder()
                .createdOn(listEntity.getCreatedOn())
                .listId(listEntity.getListId())
                .ownerId(listEntity.getOwnerId())
                .listName(listEntity.getListName())
                .items(listEntity.getItems().stream().map(i -> ItemDto.builder()
                        .createdOn(i.getCreatedOn())
                        .itemId(i.getItemId())
                        .itemName(i.getItemName())
                        .quantity(i.getQuantity())
                        .done(i.getDone())
                        .build()
                        ).collect(Collectors.toList())
                )
                .build()).collect(Collectors.toList());
    } */

    @GetMapping(value = Api.LISTS)
    public List<ListDto> getLists() {
        List<ListEntity> listEntities = service.findByOwnerId(geUserIdFromToken());
        List<ItemEntity> itemEntities = itemService.getItemsByListIds(listEntities.stream().map(ListEntity::getListId).collect(Collectors.toList()));
        return listEntities.stream().map(listEntity -> ListDto.builder()
                .createdOn(listEntity.getCreatedOn())
                .listId(listEntity.getListId())
                .ownerId(listEntity.getOwnerId())
                .listName(listEntity.getListName())
                .items(itemEntities.stream()
                        .filter(i -> i.getListId().equals(listEntity.getListId()))
                        .map(i -> ItemDto.builder()
                                .createdOn(i.getCreatedOn())
                                .itemId(i.getItemId())
                                .itemName(i.getItemName())
                                .quantity(i.getQuantity())
                                .done(i.getDone())
                                .build())
                        .collect(Collectors.toList())
                )
                .build()).collect(Collectors.toList());
    }

    private Integer geUserIdFromToken() {
        return 13;
    }
}
