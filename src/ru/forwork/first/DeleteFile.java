package ru.forwork.first;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteFile {
    public static void main(String[] args) {
        createDirectory();
        final String PATH = "D:/testjava";
        File dir = new File(PATH);
        File[] listOfFile = dir.listFiles();
       // Collections.sort(listOfFile);
        for (int i = 0; i < listOfFile.length; i++){
            System.out.println(listOfFile[i]);
        }
//        for (int i = 0; i < 30; i++){
//            System.out.println(listOfFile[i].toString());
//            recursiveDelete(listOfFile[i]);
//        }

    }
    public static void createDirectory(){
        final String PATH = "D:/testjava";
        List list = new ArrayList();
        for (int i = 0; i < 40; i++){
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++){
            new File(PATH+"/"+list.get(i)).mkdir();
        }
    }
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
