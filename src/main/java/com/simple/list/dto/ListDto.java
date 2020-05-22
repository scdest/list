package com.simple.list.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;
import java.util.List;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListDto {
    private Integer listId;
    private Instant createdOn;
    @NotBlank
    @Length(max = 100)
    private String listName;
    private Integer ownerId;
    private List<ItemDto> items;
}
