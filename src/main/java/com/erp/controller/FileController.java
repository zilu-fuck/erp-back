package com.erp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
public class FileController {

    /*处理文件商品请求，file参数绑定了上传文件*/
    @PostMapping("/uploadImg")
    public String uploadImg(MultipartFile file){
        System.out.println("file---"+file);

        //通过file对象获得上传的文件的名字  xxxx.png
        String name = file.getOriginalFilename();
        //上传图片文件重新命名
        String uuid = UUID.randomUUID().toString();
        String ext = name.substring(name.lastIndexOf("."));
        name=uuid+ext;
        System.out.println("name="+name);
        //获得保存文件的目录
        String path = FileController.class.getResource("/static/imgs").getPath();
        //创建File对象，封装指定目录下的空文件
        File target=new File(path,name);
        try {
            //将上传的文件拷贝到指定的文件
            FileUtils.copyInputStreamToFile(file.getInputStream(),target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "http://localhost:8081/imgs/"+name;
    }
}
