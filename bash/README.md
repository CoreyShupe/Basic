# Bash Projects
Bash is a Unix Shell and is used as the default shell for most linux distributions along with MacOS, with support in windows.
<br />
It was designed as a replacement for Bourne Shell by Brian Fox.
<br />
With this in mind it can also be used as a scripting language with the extension `.sh`.

## Resources
https://ss64.com/bash/
<br />
http://tldp.org/LDP/abs/html/refcards.html
<br />
https://tiswww.case.edu/php/chet/bash/bashref.html

## Installation
Most installation occurs at setup by default for MacOS and most linux distributions.

### Windows
With windows it however does not come default with the operating system, there are some steps to installing it.
<br />
You need to open PowerShell as administrator and run the following command:
```powershell
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux
```
After this command it should prompt you to restart, do so.
<br />
Once this is all done you need to install a distribution from the webstore.
<br />
The options are:
- [Ubuntu](https://www.microsoft.com/store/p/ubuntu/9nblggh4msv6)
- [OpenSUSE](https://www.microsoft.com/store/apps/9njvjts82tjx)
- [SLES](https://www.microsoft.com/store/apps/9p32mwbh6cns)
- [Kali Linux](https://www.microsoft.com/store/apps/9PKR34TNCV07)
- [Debian GNU/Linux](https://www.microsoft.com/store/apps/9MSVKQC78PK6)
<br />
Each of these should describe how to open their terminal in their Description.
<br />
<a href="https://docs.microsoft.com/en-us/windows/wsl/install-win10">source</a>

## Building/Compilation
This language has no build or compilation process.

## Execution
Executing in most terminals is as easy as running `bash /path/to/file.sh`.
<br />
When executing it should look a little like this:
<br />
```
# cat is not apart of the building process, it simply prints the contents of the file.
$ cat ./bash/hello_world/hello_world.sh
echo "Hello World!"
$ bash ./bash/hello_world/hello_world.sh
Hello World!
```
