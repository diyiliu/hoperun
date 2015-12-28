package com.diyiliu.task;

import com.diyiliu.ftp.FtpClient;
import com.diyiliu.task.base.BaseJob;

import javax.annotation.Resource;

/**
 * Description: FTPJob
 * Author: DIYILIU
 * Update: 2015-12-28 11:09
 */
public class FTPJob extends BaseJob{

    @Resource
    private FtpClient ftpClient;

    private String ip;
    private int port;
    private String username;
    private String password;


    @Override
    public void execute() {

        logger.info("FTPJob execute ...");
        ftpClient.connect(ip, port, username, password);
    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
