package com.louis.kitty.generator.controller;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.dbms.vo.ConnParam;
import com.louis.kitty.generator.service.GenerateService;
import com.louis.kitty.generator.utils.CompressUtils;
import com.louis.kitty.generator.vo.GenerateModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成控制器
 *
 * @author Louis
 * @date Nov 9, 2018
 */
@RestController
@RequestMapping
public class GenerateController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GenerateService generatorService;

    @GetMapping("/test")
    public HttpResult test() {
        System.out.println("i am test");
        return HttpResult.error("连接失败,请检查数据库及连接。");
    }

    @PostMapping("/testConnection")
    public HttpResult testConnection(@RequestBody ConnParam connParam) {
        try {
            boolean success = generatorService.testConnection(connParam);
            if (success) {
                return HttpResult.ok(generatorService.testConnection(connParam));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.error("连接失败,请检查数据库及连接。");
    }

    @PostMapping("/getTables")
    public HttpResult getTables(@RequestBody ConnParam connParam) {
        return HttpResult.ok(generatorService.getTables(connParam));
    }

    @PostMapping("/getGenerateModel")
    public HttpResult getGenerateModel(@RequestBody GenerateModel generateModel) {
        return HttpResult.ok(generatorService.getGenerateModel(generateModel));
    }

    /**
     * 在kitty基础上，生成文件并由Nginx提供下载
     *
     * @param response
     * @param generateModel
     * @return
     * @throws Exception
     */
    @PostMapping("/generateModels")
    public HttpResult generateModels(HttpServletResponse response, @RequestBody GenerateModel generateModel) throws Exception {
        boolean bool = generatorService.generateModels(generateModel);
        Map<String, String> map = new HashMap<>();
        try {
            if(bool){
               logger.info("输出文件地址:" + generateModel.getOutPutFolderPath());
                // 压缩为rar
                String downloadFilePath = CompressUtils.generateFile(generateModel.getOutPutFolderPath(), "rar");
                logger.info("http://120.79.210.194" + downloadFilePath);
                map.put("path", "http://120.79.210.194" + downloadFilePath);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return HttpResult.ok(map);
    }

    @GetMapping("/download")
    public String download(HttpServletResponse response, @RequestParam("path") String path) {
        // rar 压缩文件位置
        File file = new File(path);
        downloadFile(file, response, false);
        return null;
    }

    public static void downloadFile(File file, HttpServletResponse response, boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if (isDelete) {
                file.delete();        //是否将生成的服务器端文件删除
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
