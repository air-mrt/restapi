package com.airmart.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
    private int currentPage;
    private int perPage;
    private int pageCount;
    private long totalCount;
}
