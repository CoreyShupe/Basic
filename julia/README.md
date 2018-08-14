# Julia Projects
Julia was designed for high performance and was made to be compiled into efficient native code.
<br />
This language allows for using libraries from many languages, such as Java, C++, Python, Fortran, and R.
<br />
This language can be compiled down or used for scripting purposes with the extension `.jl`.

## Resources
https://docs.julialang.org/
<br />
https://julialang.org/

## Installation
Insallation differs throughout operating systems.
<br />
Downloads are available <a href="https://julialang.org/downloads/">here</a>

### Windows
Julia has a exe file which installs the language for you. Visit the downloads page linked above and download your version.

### MacOS
Julia has a dmg file which installs is used to install the language. Visit the download page linked above and download your version.
<br />
An alternative to the dmg file is running this command in your terminal:
```
$ brew cask install julia
```

### Ubuntu / Debian
Julia has a tar.gz which can be used to install the language using your package manager. 
Visit the download page linked above and download your version.
<br />
The download is also available with `apt` by running these commands in your terminal:
```
sudo add-apt-repository ppa:staticfloat/juliareleases
sudo apt-get update
sudo apt-cache show julia
sudo apt-get install julia julia-doc -y
```

### Arch
Julia is installed in the main Package-Manager. To install it run this in your terminal:
```
$ sudo pacman -Syu julia
```

## Building/Compilation
> Currently an issue opened in the PackageCompiler due to permission issues.
> Compilation guide currently not available.

## Execution
Executing in terminals have a few options.

### Running code from scripts.
If you want to execute scripts you can use the command `julia` as such:
```
$ cat ./julia/hello_world/HelloWorld.jl
println("Hello World!")
$ julia ./julia/hello_world/HelloWorld.jl
"Hello World!"
```

### Running base code from commandline
If you just want to execute julia code from commandline you have a few options

#### Running code from base terminal
The `julia` command has use to run julia code with the `-E` switch.
<br />
You can run this code as such:
```
$ julia -E 'println("Hello World!")'
Hello World!
nothing
```
The appending nothing is not apart of the run code.

#### Running code from julia terminal
The easiest way to run julia code is from its terminal.
<br />
You can open the terminal and run code as such:
```
$ julia
               _
   _       _ _(_)_     |  A fresh approach to technical computing
  (_)     | (_) (_)    |  Documentation: https://docs.julialang.org
   _ _   _| |_  __ _   |  Type "?help" for help.
  | | | | | | |/ _` |  |
  | | |_| | | | (_| |  |  Version 0.6.4 (2018-07-09 19:09 UTC)
 _/ |\__'_|_|_|\__'_|  |  
|__/                   |  x86_64-pc-linux-gnu

julia> println("Hello World!")
Hello World!
```
