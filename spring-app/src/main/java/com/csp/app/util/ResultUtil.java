package com.csp.app.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: csp52872
 * @date: 2021/07/09
 */
public class ResultUtil {

    private ResultUtil() {
    }

    public static <T> ResponseEntity<Result<T>> success(T data) {
        Result<T> result = new Result<>();
        result.setStatus(HttpStatus.OK.getReasonPhrase());
        result.setData(data);
        return ResponseEntity.ok(result);
    }

    @Data
    public static class Result<T> {
        private String status;
        private T data;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2};
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.compute(nums[i], (k,v) -> v != null ? v + 1 : 1);
        }
        System.out.println(count);
    }

}
