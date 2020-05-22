package com.simple.list.api;

import com.simple.list.dto.ItemDto;
import com.simple.list.entity.ItemEntity;
import com.simple.list.services.ItemService;
import com.simple.list.services.ListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ListService listService;

    @PostMapping(value = Api.ITEMS)
    public ResponseEntity<Integer> addItem(@Valid @RequestBody ItemDto itemDto,
                                           @PathVariable("list_id") Integer listId) {
        ItemEntity itemEntity = ItemEntity.builder()
                .itemName(itemDto.getItemName())
                .createdOn(Instant.now())
                .done(itemDto.getDone())
                .quantity(itemDto.getQuantity())
                .listId(listId)
                .build();
        itemService.saveOrUpdate(itemEntity, geUserIdFromToken());
        return ResponseEntity.ok(itemEntity.getItemId());
    }

    @GetMapping(value = Api.ITEMS)
    public ResponseEntity<List<ItemEntity>> getItems() {
        return ResponseEntity.ok(itemService.getItemsByListIds(new ArrayList<Integer>(Arrays.asList(3000, 30001, 3002))));
    }

    private Integer geUserIdFromToken() {
        return 13;
    }
}
