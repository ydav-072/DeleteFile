package ru.forwork.first;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

public class DeleteFile {
    public static void main(String[] args) {
        //createDirectory();
        final String PATH = "D:/BackUp/MSPlus-18";
        File dir = new File(PATH);

        File[] listOfFile = dir.listFiles();
        //sort dir on time_to_create
        Arrays.sort(listOfFile, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.valueOf(o1.lastModified()).compareTo(o2.lastModified());
            }
        });

        for (int i = 0; i < listOfFile.length; i++){
            System.out.println(listOfFile[i]);
        }
        //delete 30
        for (int i = 0; i < 30; i++){
            System.out.println(listOfFile[i].toString());
            recursiveDelete(listOfFile[i]);
        }

    }
    //create 40 dir for test
//    public static void createDirectory(){
//        final String PATH = "D:/INSTALL/BackUp/MSPlus-18";
//        List list = new ArrayList();
//        for (int i = 0; i < 40; i++){
//            list.add(i);
//        }
//        for (int i = 0; i < list.size(); i++){
//            new File(PATH+"/"+list.get(i)).mkdir();
//        }
//    }

    //recursive delete
    public static void recursiveDelete(File file) {
        // до конца рекурсивного цикла
        if (!file.exists())
            return;

        //если это папка, то идем внутрь этой папки и вызываем рекурсивное удаление всего, что там есть
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                // рекурсивный вызов
                recursiveDelete(f);
            }
        }
        // вызываем метод delete() для удаления файлов и пустых(!) папок
        file.delete();
        System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
    }
}
