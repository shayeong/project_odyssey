package com;
import java.io.File;
 
public class UploadMem {
 
    // Windows, VMWare, AWS cloud 절대 경로 설정
    public static synchronized String getUploadDir() {
        String path = "";
        if (File.separator.equals("\\")) {
            path = "D:/2023-java_fullstack/deploy/odyssey/member/storage/";
            System.out.println("Windows 10: " + path);
            
        } else {
            // System.out.println("Linux");
            path = "/home/ubuntu/deploy/member/storage/";
        }
        
        return path;
    }
    
}