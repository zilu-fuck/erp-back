package com.erp.controller;

import com.erp.pojo.BuyList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.erp.service.BuyListService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class BuyListController {

    @Autowired
    private BuyListService buyListService;

//    处理采购信息，需要自动带入的数据的请求
    @GetMapping("/buyAutoInfo/{id}")
    public Map<String,Object> buyAutoInfo(@PathVariable Integer id){
        return buyListService.queryAutoDataBuyService(id);
    }

    @PostMapping("/saveBuyList")
    public Map<String,Object> saveBuyList(@RequestBody BuyList buyList){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","保存失败");
        try {
            buyList.setFactBuyNum(0);
            buyList.setBuyTime(new Date());
            buyList.setIsIn("0");
            buyListService.save(buyList);
            result.put("code",200);
            result.put("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

//    处理采购单分页查询请求
    @GetMapping("/queryBuyList")
    public Map<String,Object> queryBuyList(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "3") Integer pageSize)
    {
        return buyListService.queryBuyListService(pageNum,pageSize);
    }

//    更新采购单请求
    @PostMapping("/updateBuyList")
    public Map<String,Object> updateBuyList(@RequestBody BuyList buyList){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","更新失败");
        try {
            buyList.setBuyTime(new Date());
            buyListService.updateById(buyList);
            result.put("code",200);
            result.put("msg","更新成功");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    //处理采购单删除
    @GetMapping("/deleteBuyList/{id}")
    public Map<String,Object> deleteBuyList(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","删除失败");
        try {
            buyListService.removeById(id);
            result.put("code",200);
            result.put("msg","删除成功");
            }catch (Exception e){
            e.printStackTrace();
            }
        return result;
    }
//处理数据导出excel请求,下载excel文件
    @GetMapping("/exportBuyList")
    public ResponseEntity exportExcel(){
        XSSFWorkbook workbook = buyListService.exportExcelService();
        //将workbook文件excel对象，封装到字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            workbook.write(baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //将字节数组封装到responseEntity中
        byte[] bytes = baos.toByteArray();
        //创建文件响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置下载的文件名
        headers.setContentDisposition(
                ContentDisposition.attachment()
                .filename("采购单.xlsx", StandardCharsets.UTF_8)  // 自动处理编码
                .build());
        //
        ResponseEntity<byte[]> result = new ResponseEntity(bytes,headers,HttpStatus.CREATED);
        return result;
    }
}
