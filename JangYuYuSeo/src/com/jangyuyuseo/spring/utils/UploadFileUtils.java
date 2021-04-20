package com.jangyuyuseo.spring.utils;


import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
  
 
 public static String fileUpload(String uploadPath,
         String fileName,
         byte[] fileData) throws Exception {

  UUID uid = UUID.randomUUID();
  
  String newFileName = uid + "_" + fileName;
  String imgPath = uploadPath;

  File target = new File(imgPath, newFileName);
  FileCopyUtils.copy(fileData, target);
 
  File image = new File(imgPath + File.separator + newFileName);

  return newFileName;
 }


 private static void makeDir(String uploadPath, String... paths) {

  if (new File(paths[paths.length - 1]).exists()) { return; }

  for (String path : paths) {
   File dirPath = new File(uploadPath + path);

   if (!dirPath.exists()) {
    dirPath.mkdir();
   }
  }
 }
}

