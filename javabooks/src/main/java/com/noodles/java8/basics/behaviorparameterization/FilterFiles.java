package com.noodles.java8.basics.behaviorparameterization;

import java.io.File;
import java.io.FileFilter;

public class FilterFiles {
    public static void main(String[] args) {

        //java7 筛选隐藏文件
        File[] hiddenFiles = new File(".").listFiles(new FileFilter(){

            @Override
            public boolean accept(File file){
                return file.isHidden();
            }
        });

        // java8
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
    }
}
