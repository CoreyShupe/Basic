package com.github.coreyshupe.tree;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
  
  public static void main(String[] args) {
    File file;
    if(args.length > 0) {
      file = new File(args[0]);
      if(!file.exists() || !file.isDirectory()) {
        System.out.printf("Could not find `%s` as a valid directory.", args[0]);
	return;
      }
    } else {
      file = new File(System.getProperty("user.dir"));
    }
    System.out.println(file.getAbsolutePath());
    runDir(file, 0);
  }

  public static void runDir(File dir, int len) {
    Queue<String> hdirs = new ArrayDeque<>();
    Queue<String> execs = new ArrayDeque<>();
    File[] files = dir.listFiles();
    if(files == null) {
      return;
    }
    for(File file : files) {
      if(file.isDirectory()) {
        if(file.isHidden()) {
          hdirs.offer(buildString(file.getName() + " (content hidden)", true, len));
	} else {
          System.out.println(buildString(file.getName(), true ,len));
	  runDir(file, len + 1);
	}
      } else {
        execs.offer(buildString(file.getName(), false, len));
      }
    }
    printQueue(hdirs);
    printQueue(execs);
  }

  public static void printQueue(Queue<String> queue) {
    String next;
    while((next = queue.poll()) != null) {
      System.out.println(next);
    }
  }

  public static String buildString(String name, boolean dir, int len) {
    StringBuilder builder = new StringBuilder("|");
    for(int i = 0; i < len; i++) {
      builder.append("  |");
    }
    builder.append("--");
    if(dir) {
      builder.append("/");
    }
    builder.append(name);
    return builder.toString();
  }
}
