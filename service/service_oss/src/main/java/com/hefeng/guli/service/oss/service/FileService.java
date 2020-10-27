package com.hefeng.guli.service.oss.service;

import java.io.InputStream;

public interface FileService {

    /**
     * 阿里云oss文件上传
     * @param inputStream 输入流
     * @param module 文件夹名称
     * @param originalFilename 原始文件名
     * @return 文件在oss服务器上的url地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    /**
     * 阿里云oss 文件删除
     * @param url 文件的url地址
     */
    void removeFile(String url);
}
