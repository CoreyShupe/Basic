# Java Projects
Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.
<br />
Java was made to be OS independent so it can run on most if not all operating systems.

## Resources
Java Documentation: [JDK 10](https://docs.oracle.com/javase/10/), [JDK 9](https://docs.oracle.com/javase/9/), [JDK 8](https://docs.oracle.com/javase/8/)
<br />
[Codecademy.com](https://www.codecademy.com/learn/learn-java)
<br />
[LearnJava.org](http://www.learnjavaonline.org/)

## Installation

Before attempting to install Java, it's important to know the difference between the JRE and the JDK.

### JRE

The Java Runtime Environment. Contains the Java Virtual Machine (JVM) to run Java programs. This can be thought of as the user version of Java.

### JDK

The Java Development Kit. A Software Development Kit for Java including everything someone would need to write their own Java programs. This includes the JRE, JavaDoc, the Java compiler, and the Java Debugger. This can be thought of as the programmer version of Java.

### Downloading

Now that you have an understanding of both the JRE and the JDK, you should download the latest version of the JDK from the [Java Downloads](http://www.oracle.com/technetwork/java/javase/downloads/index.html) page and run the installer for your operating system.

## Building/Compilation

To compile Java source code the command line / terminal, there are several prerequisites.
<br />
**Note**: these steps are not required if you are using an IDE.

### Add Java to path

To access java, first add it to the path so that the necessary commands are visible to the system. If you're unsure how to do this, follow the [official guide](https://www.java.com/en/download/help/path.xml).

### Location

Before compiling, you should make sure that you are in the same directory as the `.java` files that you're trying to compile. You can change directories by using the `cd` command.

### Compiling

Once we've completed all these steps, we're ready to compile our code! To do this, we'll invoke the java compiler with the `javac` command using the file we want to compile. For example
```
javac yourFileName.java
```
This will generate a `.class` file "next to" our original file with the same name. This is the bytecode for your program that can now be run by the JVM.

## Execution

Finally, to run our Java program we simply ask the JVM to execute our new `.class` file using the following command
```
java yourFileName
```
If all these steps worked as intended, you should now see the output of your java program in the console!
