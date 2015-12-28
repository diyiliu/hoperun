import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Description: FTPClientTest
 * Author: DIYILIU
 * Update: 2015-12-25 11:08
 */
public class FTPClientTest {

    private static String ip = "192.168.1.19";
    private static int port = 21;

    private static String username = "Wang";
    private static String password = "123456";

    private static String path = "test";
    private static String destination = "C:/Users/DIYILIU/Desktop/FTP";

    @Test
    public void testConnect() {

        /**
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /**
    public void copyFile(FTPClient ftpClient, String parent, FTPFile ftpFile, String path) throws Exception {

        //  FTP协议里面，规定文件名编码为iso-8859-1，所以目录名或文件名需要转码。
        String fileName = new String(ftpFile.getName().getBytes("ISO-8859-1"), "GBK");

        if (ftpFile.isFile()) {
            File file = new File(path + File.separator + fileName);
            OutputStream os = new FileOutputStream(file);
            ftpClient.retrieveFile(fileName, os);
            os.close();

            System.out.println("文件：" + file.getAbsolutePath());

        } else if (ftpFile.isDirectory()) {
            File dir = new File(path + File.separator + fileName);
            dir.mkdir();

            System.out.println("目录：" + dir.getAbsolutePath());

            parent += File.separator + fileName;
            path += File.separator + fileName;

            FTPFile[] ftpFiles = ftpClient.listFiles(new String(parent.getBytes("GBK"), "ISO-8859-1"));
            // System.out.println("[" + parent + "]:" + ftpFiles.length);

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
    }*/
}
