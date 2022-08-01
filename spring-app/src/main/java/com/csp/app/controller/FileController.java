package com.csp.app.controller;

import com.alibaba.excel.EasyExcel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/5/21
 */
@Controller
@RequestMapping("file")
public class FileController {

    @PostMapping("download")
    public ResponseEntity<?> download(HttpServletResponse response, String key) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String date = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
            String fileName = URLEncoder.encode(key + "_" + date + ".xlsx", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName);
            EasyExcel.write(response.getOutputStream())
                    .sheet("策略参数模板")
                    .doWrite(Collections.emptyList());

            return ResponseEntity.ok("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
