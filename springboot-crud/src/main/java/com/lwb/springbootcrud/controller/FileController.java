package com.lwb.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-11 18:17
 **/
@Controller
public class FileController {

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        String destPath = "D:/20200412";

        File dest = new File(destPath + "/" + fileName);
        if (file.isEmpty()) {
            System.out.println("该文件无内容");
        }
        file.transferTo(dest);
        return destPath + "/" + fileName;
    }


    @PostMapping("upload2")
    @ResponseBody
    public String upload2(MultipartFile file) throws IOException {

        InputStream is = file.getInputStream();

        File uploadFile = new File("d:/20200412" + "/" + "test.txt");
        FileOutputStream fos = new FileOutputStream(uploadFile);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.flush();
        fos.close();
        is.close();
        return uploadFile.toString();
    }


    @PostMapping("/download")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getParameter("file");

        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");

        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        ServletOutputStream outputStream = response.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        fis.close();
        outputStream.flush();
        outputStream.close();


    }


    public static void main(String[] args) throws IOException {

        String path = "D:/20200412/1.png";

        String out = "D:/20200412/2.png";
        FileInputStream fis = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(out);

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }


    }

}
