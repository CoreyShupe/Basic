# Java Projects
Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.
<br />
Java was made to be OS independent so it can run on most, if not, all operating systems.
<br />
Java code is written in files with the extension `.java`, compiled into `.class` files, and multi-class programs are compiled into `.jar` files.
<br />
The latest LTS (long term support) version for java is Java 8, however will be Java 11 soon. Due to this the guide will be covering Java 8 installation.
<br />
In Java there are LTS and STS versions, long term support, and short term support. 
Java has beta versions so they can test beta features such as `var` in java 10. 
This gives them a chance to fix any big issues before releasing a long term support version.

## Table Of Contents
- [Resources](#resources)
- [Installation](#installation)
  - [JRE](#jre)
  - [JDK](#jdk)
- [Building / Compilation](#building-and-compilation)
  - [Java Compiler](#java-compiler)
    - [Single File Compilation](#single-file-compilation)
    - [Multiple File Compilation](#multi-file-compilation)
  - [Build Tools](#build-tools)
- [Execution](#execution)
  - [Class File Execution](#single-file-execution)
  - [Jar File Execution](#archive-file-execution)

## Resources
Java Documentation: https://docs.oracle.com/javase/
<br />
[JDK 10](https://docs.oracle.com/javase/10/), [JDK 9](https://docs.oracle.com/javase/9/), [JDK 8](https://docs.oracle.com/javase/8/)
<br />
[Codecademy.com](https://www.codecademy.com/learn/learn-java)
<br />
[LearnJava.org](http://www.learnjavaonline.org/)
<br />
[Tutorial](https://docs.oracle.com/javase/tutorial/)
<br />
[Design Patterns](https://github.com/iluwatar/java-design-patterns)

## Installation
Before installing Java it's good to be familiar with the JRE, the JDK, and the differences of each.

### JRE
The JRE is the Java Runtime Environment. This is used to host the JVM for java code execution. The JRE is imperative to running java apps.
<br />
Installing this will allow you to run java code on your machine.

#### Windows
You can install the JRE [here](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html).
<br />
Just select your bit architechture of your windows machine (32 bit -> x86) (64 bit -> x64) and run the executable file it downloads.
<br />
It's important to know when installing the JRE for Windows that if you're planning on getting the JDK, the JDK installs the JRE for you.

#### MacOS
For Mac there are .dmg files located [here](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) which allow you to install the JRE.
<br />
Similar to Windows, installing the JDK will install the JRE for you if you're planning on installing the JDK.

#### Ubuntu / Debian
For Ubuntu and Debian the JRE is hosted in the apt packages.
<br />
Running this command will install the JRE for you:
```
sudo apt-get install openjdk-8-jre
```

#### Arch
Arch linux hosts java in their package manager (pacman) so installing the JRE can be done with this command:
```
sudo pacman -Syu jre8-openjdk
```

### JDK
The JDK is the java development kit. This is the SDK required for developing java applications.
<br />
Installing this will give you all of the packages you need for developing in Java.

#### Windows
You can install the JDK [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
<br />
Just select your bit architechture of your windows machine (32 bit -> x86) (64 bit -> x64) and run the executable file it downloads.
<br />
Installing the JDK will install the JRE for you during the download process.

#### MacOS
For Mac there are .dmg files located [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) which allow you to install the JDK.
<br />
Similar to windows installing the JDK will install the JRE for you during the download process.

#### Ubuntu / Debian
For Ubuntu and Debian the JDK is hosted in the apt packages.
<br />
Running this command will install the JDK For you:
```
sudo apt-get install openjdk-8-jdk
```

#### Arch
Arch linux hosts the JDK in their package manager (pacman).
<br />
You can run this to install the JDK:
```
sudo pacman -Syu jdk8-openjdk
```

## Building and Compilation
In Java there are a few ways to approach building and compilation.
<br />
You can use the built in java compiler (javac) or use a build tool to compile the code for you.

### Java Compiler
`javac` is a built in java compiler for java, this allows full command-line based compilation.
<br />
There's multiple ways to compile class files with `javac` including single file compilation and multi-file compilation into jars.

#### Single File Compilation
To compile a single file it's very simple with javac, you just need to run this command:
```
$ javac "path/to/java/File.java"
```
This will create `File.class` in the directory `./path/to/java`.

#### Multi File Compilation
To compile multiple files at once you just need to add more args, for example:
```
$ javac "path/to/java/File.java" "path/to/java/File2.java"
```
or rather you can just do
```
$ javac "path/to/java/*.java"
```
This will compile all of the files into class files.
<br />
If you have mutliple packages you need to run through all directories, which is done differently with different shells.
<br />
With batch (windows based) you can run this command:
```batch
C:\ > for /r %%a in (*.java) do ( javac "%%a" )
```
In bash it's slightly different, using this command:
```bash
$ javac $(find -name *.java -print)
```

#### Jar
`jar` is a tool in java which allows you to jar your class files into a single archive file. This archive can be used as a library or as an executable file.
<br />
A jar file is an archived file similar to a zip file which contains all the .class files of the selected program/library.
<br />
If it is executable it will generally also contain the manifest.txt, the META-INF properties, and all the resources used alongside it.
<br />
This archive is created so the JVM and compile can understand what is inside of it easily. This also allows for a single archive to contain an entire program which can be depended on or executed.
<br />
<br />
If you have a [manifest](https://docs.oracle.com/javase/tutorial/deployment/jar/manifestindex.html) written up you can run the command:
```
jar cfm Example.jar manifest.txt <class files>
```
Otherwise you'll need to run this command, defining your entry point:
```
jar cfe Example.jar path/to/Main <class files>
```
If you multiple packages you can run this:
```
Batch:
C:\path\to\src > setlocal enabledelayedexpansion enableextensions & SET LOCAL=& for /F %F in ('dir *.class /b/s') do set LOCAL=%LOCAL%%F& jar cfe Example.jar path/to/Main %LOCAL%
Bash:
$ jar cfe Example.jar $(find -name *.class -print)
```
And if you have resources you'll need to append their directories to the command as such:
```
$ jar cfe Example.jar "path/to/Main" <class files> "dir/to/resources/"
```
A jar with mutliple packages + a manifest + resources should look like this:
```
Batch:
C:\path\to\src > setlocal enabledelayedexpansion enableextensions & SET LOCAL=& for /F %F in ('dir *.class /b/s') do set LOCAL=%LOCAL%%F& jar cfm Example.jar manifest.txt %LOCAL% path/to/resources/
Bash:
$ jar cfm Example.jar manifest.txt $(find -name *.class -print) path/to/resources/
```
And a jar with multiple packages + no manifest + resources should look like this:
```
Batch:
C:\path\to\src > setlocal enabledelayedexpansion enableextensions & SET LOCAL=& for /F %F in ('dir *.class /b/s') do set LOCAL=%LOCAL%%F& jar cfe Example.jar path/to/Main %LOCAL% path/to/resources/
Bash:
$ jar cfe Example.jar path/to/Main $(find -name *.class -print) path/to/resources
```

### Build Tools
Build tools are using in java to simplify the building of the program. They also help with running unit tests and verification steps along with plugins to help with production.
<br />
Build tools are also useful for implementing dependencies in an open-source environment, so each person doesn't have to manually download and implement each dependency.
<br />
There are quite a few build tools however the most popular for java are Maven and Gradle.
<br />
These build tool guides are currently in development and will be linked to when created.

## Execution
Execution of java can be done with single-file execution and archive(jar)-file execution.

### Single File Execution
When using single file execution it's important to note that the class being run must have the main method in it.
<br />
This is denoted with the static method:
```java
public static void main(String[] args) {
}
```
Once you have your class compile you need to go into your source directory.
<br />
If your project is laid out as such:
```
ProjectName
|--/src
|  |--/pack
|  |  |--JavaClass.class
```
Then you'll need to be in the `ProjectName/src` directory and run the following command:
```
$ java -cp . pack/JavaClass
```

### Archive File Execution
Running an archive file or jar file is much simpler however has a requirement.
<br />
The archive file must contain a manifest.txt, if you ran `jar cfe` or generated it with a build tool it should contain it already.
<br />
Once you're certain of this you can run the following command to run the archive file:
```
$ java -jar path/to/Program.jar
```

