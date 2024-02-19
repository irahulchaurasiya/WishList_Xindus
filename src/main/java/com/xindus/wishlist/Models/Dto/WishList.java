package com.xindus.wishlist.Models.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class WishList {
    private String name;
    private Integer price;
}
