package com.ldb.web.controller;

import com.ldb.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Bobbi
 * @date 2017/11/16
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String folder="C:\\programWorkSpace\\Idea Workspace\\Security\\Security-demo\\src\\main\\java\\com\\ldb\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        String folder="C:\\programWorkSpace\\Idea Workspace\\Security\\Security-demo\\src\\main\\java\\com\\ldb\\web\\controller";
        File localFile=new File(folder,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id,HttpServletRequest request, HttpServletResponse response)throws Exception{
        try(InputStream in=new FileInputStream(new File(folder,id+".txt"));
        OutputStream out=response.getOutputStream()){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(in,out);
            out.flush();
        }

    }
}
