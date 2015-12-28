package com.diyiliu.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Description: FtpClient
 * Author: DIYILIU
 * Update: 2015-12-28 11:10
 */
public class FtpClient {

    private String path;
    private String destination;

    public FtpClient(String path, String destination) {
        this.path = path;
        this.destination = destination;
    }

    public void connect(String ip, int port, String username, String password) {

        FTPClient client = new FTPClient();

        try {
            client.connect(ip, port);

            if (client.login(username, password)) {


                int replyCode = client.getReplyCode();
                //System.out.println("replyCode:" + replyCode);

                if (!FTPReply.isPositiveCompletion(replyCode)) {

                    System.err.println("FTP登录失败!");

                    client.disconnect();

                    return;
                }

                // 切换目录
                // client.changeWorkingDirectory(path);

                FTPFile[] ftpFiles = client.listFiles(path);

                // System.out.println(client.listFiles("hello").length);
                for (FTPFile ftpFile : ftpFiles) {

                    //  FTP协议里面，规定文件名编码为iso-8859-1，所以目录名或文件名需要转码。
                    String fileName = new String(ftpFile.getName().getBytes("ISO-8859-1"), "GBK");

                    copyFile(client, path, ftpFile, destination + File.separator + path);
                }

                client.disconnect();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void copyFile(FTPClient ftpClient, String parent, FTPFile ftpFile, String path) throws Exception {

        //  FTP协议里面，规定文件名编码为iso-8859-1，所以目录名或文件名需要转码。
        String fileName = new String(ftpFile.getName().getBytes("ISO-8859-1"), "GBK");

        if (ftpFile.isFile()) {
            File file = new File(path + File.separator + fileName);
            /**
            OutputStream os = new FileOutputStream(file);
            ftpClient.retrieveFile(fileName, os);
            os.close();*/

            System.out.println("文件：" + file.getAbsolutePath());

        } else if (ftpFile.isDirectory()) {
            File dir = new File(path + File.separator + fileName);
            //dir.mkdir();

            System.out.println("目录：" + dir.getAbsolutePath());

            parent += File.separator + fileName;
            path += File.separator + fileName;

            FTPFile[] ftpFiles = ftpClient.listFiles(new String(parent.getBytes("GBK"), "ISO-8859-1"));

            for (FTPFile file : ftpFiles) {
                copyFile(ftpClient, parent, file, path);
            }
        }
    }

    public void deleteFile(String path) {

        File file = new File(path);

        if (file.isFile()) {
            //System.out.println(file.getAbsolutePath());
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(path + File.separator + f.getName());
            }
            //System.out.println(file.getAbsolutePath());
            file.delete();
        }
    }
}
