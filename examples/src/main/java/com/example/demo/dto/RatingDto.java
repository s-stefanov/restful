package com.example.demo.dto;

import lombok.Data;

@Data
public class RatingDto {
    private Rate rating;

    public enum Rate {
        ONE, TWO, THREE, FOUR, FIVE
    }
}
