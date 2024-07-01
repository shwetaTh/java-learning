package LabWorks.Unit3;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Lab2 {
    public static void main(String[] args) {
        String fileUrl = "https://th.bing.com/th/id/R.bdf7e5ccacdca6284e953142f6aee5ea?rik=775KghDE1psqZg&pid=ImgRaw&r=0";
        String savePath = "downloaded.jpg";

        try {
            URL url = new URL(fileUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);

            byte[] data = new byte[1024];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(data, 0, 1024)) != -1) {
                fileOutputStream.write(data, 0, bytesRead);
            }

            fileOutputStream.close();
            bufferedInputStream.close();

            System.out.println("File downloaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

