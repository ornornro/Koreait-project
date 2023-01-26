package com.korit.library.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchNumberListReqDto {
    private String category;
    private String searchValue;
}
