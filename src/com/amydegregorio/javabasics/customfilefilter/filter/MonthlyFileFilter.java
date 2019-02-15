package com.amydegregorio.javabasics.customfilefilter.filter;

import java.io.File;
import java.io.FileFilter;

public class MonthlyFileFilter implements FileFilter {
   private static final String ALLOWED_EXTENSION = "txt";
   
   private String fileNameRegex;
   
   public MonthlyFileFilter(String year, String month) {
      if (!year.matches("^(19|20)\\d\\d$")) {
         throw new IllegalArgumentException(String.format("Invalid year %s. Years must be in format yyyy", year));
      }
      
      if (!month.matches("1[0-2]|0[1-9]")) {
         throw new IllegalArgumentException(String.format("Invalid month %s. Months must be in format MM", month));
      }
      
      fileNameRegex = String.format("%s\\-%s\\.%s", year, month, ALLOWED_EXTENSION);
   }

   @Override
   public boolean accept(File pathname) {
      boolean accept = false;
      if (!pathname.isFile()) {
         return accept;
      }
      
      if (pathname.getName().toLowerCase().matches(fileNameRegex)) {
         accept = true;
      }
      
      return accept;
   }

}
