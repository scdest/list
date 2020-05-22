package com.simple.list.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer itemId;
    private Instant createdOn;
    @NotBlank
    @Length(max = 100)
    private String itemName;
    @Min(value = 0)
    private Double quantity;
    private Boolean done;
}
