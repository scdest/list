package com.simple.list.services;

import com.simple.list.entity.ItemEntity;
import com.simple.list.entity.ListEntity;
import com.simple.list.repositories.ItemRepository;
import com.simple.list.repositories.ListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListService {
    private final ListRepository repository;
    private final ItemRepository itemRepository;

    public void saveOrUpdate(ListEntity listEntity) {
        log.info("list entity {}", listEntity);
        repository.save(listEntity);
    }

    public ListEntity findByIdOrElseNull(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<ListEntity> findByOwnerId(Integer id) {
        return repository.findByOwnerId(id);
    }

    /*public void generateListsAndItems() {
        String listNameTemplate = "List %d";
        for(int i = 0; i < 5000; i++) {
            ListEntity listEntity = ListEntity.builder()
                    .ownerId(getRandomUserId())
                    .createdOn(Instant.now())
                    .listName(String.format(listNameTemplate, i))
                    .build();
            repository.save(listEntity);
            for(int j = 0; j < 20; j++) {
                ItemEntity itemEntity = ItemEntity.builder()
                        .createdOn(Instant.now())
                        .quantity(1d)
                        .done(false)
                        .itemName(getRandomItemName())
                        .listEntity(listEntity)
                        .build();
                itemRepository.save(itemEntity);
            }
        }
    } */

    private Integer getRandomUserId() {
        int[] userIds = new int[]{1, 3, 4, 9, 10, 11, 12, 13};
        return userIds[new Random().nextInt(userIds.length)];
    }

    private String getRandomItemName() {
        String[] itemNames = new String[]{"Колбаса", "Сосиски", "Конфеты",
                "Цикорий", "Картошка", "Морковка", "Лук", "Голубика", "Хлопья Гречневые",
                "Хлопья Кукурузные", "Макароны", "Гречка", "Авокадо", "Киноа"};
        return itemNames[new Random().nextInt(itemNames.length)];
    }

}
