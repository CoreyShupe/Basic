# C++ Projects
C++ is a general purpose language, generally written using OOP concepts, however, also inherits a functional flow. 
This language can be used for many purposes: memory manipulation; simple execution programs; large games; and anything in between.
<br />
It can be used in any operating system provided you have the correct libraries to support it.
<br />
C++ files are compiled into native code down from `.cpp` files.

## Resources
https://en.cppreference.com/w/
<br />
http://devdocs.io/cpp/
<br />
https://isocpp.org/get-started
<br />
http://www.learncpp.com/
<br />
http://www.cplusplus.com/doc/tutorial/
<br />
https://isocpp.org/std/the-standard

## Installation
Since C++ is compiled down to native code you'll need g++ (works on any OS) to compile your code.

### Windows
To install g++ on windows follow <a href="http://www1.cmc.edu/pages/faculty/alee/g++/g++.html">this</a> guide for installation. Afterwards g++ should be a valid command.

### MacOS
To install g++ on MacOS there's a few steps.
<br />
Running the command `g++` in the terminal to start should pop up an alert box leading you to an installation, which will install it for you.
<br />
Once it has finished installing and assert that when you run `g++` in terminal again it prints out `clang: error: no input files`
<br />
Once it has been installed correctly, set your finder to show file extensions.

### Ubuntu / Debian
To install g++ on a system with `apt` you'll need to run this command:
```
sudo apt-get install g++
```

### Arch
To install g++ on arch all you need to do is run this command from pacman:
```
sudo pacman -Syu g++
```

## Building / Compilation
With g++ installed you have a few options for building/compilation.

### Compile a single file.
To compile a single file it's as simple as running this command:
```
$ g++ -o <output file> <input file>
```
The output file should be `something.out` and the input file should be a cpp file, like this:
```
$ g++ -o hello_world.out hello_world.cpp
```
This will generate an executable `.out` file.

### Compile multiple files.
To compile multiple files there's a few steps involved.

#### Compile cpp files (1a)
To compile the cpp files into object files you need to run the `g++` command with the `-c` flag, as such:
```
$ g++ -o hello_world.o -c hello_world.cpp
```
and
```
$ g++ -o helper.o -c helper.cpp
```
Once you do this to each file you can move onto the second step.

#### Compile object files (1b)
Next we need to link all the object files into one program.
<br />
To do this we need to run the `g++` command with all with all of the object files, as such:
```
$ g++ -o hello_world hello_world.o helper.o
```
This will generate an executable file named `hello_world`.

#### Alternate compilation (2a)
An alternate approach to generating each object file at once is generating the program directly by linking the cpp files.
<br />
Doing this eliminates the need to do all object files.
<br />
Running this command should link all the files together:
```
$ g++ -o hello_world hello_world.cpp helper.cpp
```
This will generate an executable file named `hello_world`
<br />
You can also use wildcards as such to accomplish the same goal:
```
g++ -o hello_world *.cpp
```

## Execution
To execute g++ generated files all you need to do is run this in the terminal:
```
./path/to/file
```
or alternatively
```
./path/to/file.out
```
Both should execute in the same way.
