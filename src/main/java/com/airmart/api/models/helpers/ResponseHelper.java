package com.airmart.api.models.helpers;

import com.airmart.api.models.Pagination;
import org.springframework.data.domain.Page;

import java.util.HashMap;

public class ResponseHelper {
    public static <T> CustomResponse<T> convertFromPage(Page<T> list, int pageNumber, int size) {
        CustomResponse<T> result = new CustomResponse<T>(list.getContent());
        HashMap<String, Pagination> meta = new HashMap<>();
        Pagination pagination = new Pagination(pageNumber, size, list.getTotalPages(), list.getTotalElements());
        meta.put("pagination", pagination);
        result.setMeta(meta);
        return result;
    }
}