import java.io.BufferedInputStream;
import java.io.File;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;

import java.util.zip.ZipFile;


public class Unzip  {
    
    public Unzip(String filename) throws IOException
    {
        ArrayList<String> names=new ArrayList<>();
        unzipFile(filename,names);
        unZipNested(names);
    }
    public static void unzipFile(String filename, ArrayList<String> names) throws IOException{
    String fileZip = filename;
    File destDir = new File("src");

    try (ZipFile file = new ZipFile(fileZip))
    {
      Enumeration<? extends ZipEntry> zipEntries = file.entries();
      while (zipEntries.hasMoreElements())
      {
        ZipEntry zipEntry = zipEntries.nextElement();
        File newFile = new File(destDir, zipEntry.getName());
        names.add("src\\"+zipEntry.getName());
        //create sub directories
        newFile.getParentFile().mkdirs();

        if (!zipEntry.isDirectory())
        {
          try (FileOutputStream outputStream = new FileOutputStream(newFile))
          {
            BufferedInputStream inputStream = new BufferedInputStream(file.getInputStream(zipEntry));
            while (inputStream.available() > 0)
            {
        
outputStream.write(inputStream.read());
            }
            inputStream.close();
          }
        }

      }
    }
    
}
public static void unZipNested(ArrayList<String> names) throws IOException{
    Iterator<String> iter  = names.iterator(); 
    while (iter.hasNext()) { 
             String fileZip = iter.next();
    File destDir = new File("src");

    try (ZipFile file = new ZipFile(fileZip))
    {
      Enumeration<? extends ZipEntry> zipEntries = file.entries();
      while (zipEntries.hasMoreElements())
      {
        ZipEntry zipEntry = zipEntries.nextElement();
        File newFile = new File(destDir, zipEntry.getName());
       
        //create sub directories
        newFile.getParentFile().mkdirs();

        if (!zipEntry.isDirectory())
        {
          try (FileOutputStream outputStream = new FileOutputStream(newFile))
          {
            BufferedInputStream inputStream = new BufferedInputStream(file.getInputStream(zipEntry));
            while (inputStream.available() > 0)
            {
        
outputStream.write(inputStream.read());
            }
            inputStream.close();
          }
        }

      }
    }
        } 
}
}
