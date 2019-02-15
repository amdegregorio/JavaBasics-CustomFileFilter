package com.amydegregorio.javabasics.customfilefilter;

import java.io.File;

import com.amydegregorio.javabasics.customfilefilter.filter.MonthlyFileFilter;

public class FileFilterExample {

   public static void main(String[] args) {
      MonthlyFileFilter monthlyFileFilter = new MonthlyFileFilter("2019", "02");
      File inputDir = new File("input");
      
      for (File filteredFile : inputDir.listFiles(monthlyFileFilter)) {
         System.out.printf("Filtered out file %s\n", filteredFile.getName());
      }

   }

}
