package com.zeinDev.tryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TryRequest {
    private String title;
    private String content;
    private String writer;
}
