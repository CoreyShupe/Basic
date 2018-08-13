# Contributing To `Basic`
:heart: Welcome to `Basic` and the world of contributors. :heart:

#### How do I contribute?
>|What are you contributing?|Where to go|
>|:---|:---|
>|Found an issue|[Issue Reporting](#issue-reporting)|
>|Contributing code|[Code Contribution](#code-contribution)|
>|Contributing documentation|[Documentation Contribution](#documentation-contribution)|

## Code Of Conduct
We follow the [Basic's Code Of Conduct](CODE_OF_CONDUCT.md) within contributions, issues, and representation.
<br />
These standards are important and if you contribute you are expected to uphold them.
<br />
Please report any unacceptable behavior to coreyshupe101@gmail.com.

## License
We follow the [MIT License](LICENSE) which basically means do whatever you want with the code, 
but we hold no responsibility.

## What should I know?
This github project was created to be a community resource. For developers of all skill level. 
It is meant to be used to learn basic syntax of a language as well as how to install and execute it.
<br />
`Basic` uses a generator to create the [README](README.md) and various other aspects of the codebase for simplicity sake.
<br />
Languages are added in the filespace as `<lang name>/<project_name>/<project_space>`. 
This is used to keep the filespace organized with the languages and their respective projects.

## Python Generation json Breakdown.
The current json format is as such:
```json
{
  "languages":[
    {"name":"Example1","dir":"example1","project_sub":"src/{dir}/{dir}.ext"},
    {"name":"Example2","dir":"example2","project_sub":"src/{adir}/{name}.ext"},
    {"name":"Example3","dir":"example3","project_sub":"{adir}.ext"}
  ],
  "projects":[
    {"name":"Example Project","dir":"example_project"}
  ]
}
```
With this we see 3 in-line variables being used.

|Variable|What it means|
|:---|:---|
|dir|This is the directory which the project points to e.g. (example_project)|
|name|This is the name of a project with spaces removed e.g. (ExampleProject)|
|adir|This is the alphanumeric version of `{dir}` e.g. (exampleproject)|

### In The `Languages`

#### `name`
This is the name of the language. e.g. (`Java`, `Haskell`, etc...)

#### `dir`
This is the base directory of the language. Found as `./dir`, e.g. (`./java`, `./haskell`, etc...)

#### `project_sub`
This is the parsed project main class location.
<br />
In this we parse all of the variables into the string, to find the right directory.
<br />
The source found is generated as such: `./dir/project dir/project_sub` all project subs should link to the exact main file.
<br />
Example: `./example1/example_project/src/example_project/example_project.ext`

### In The `Projects`

#### `name`
This is the name of the project, e.g. (`Echo`, `Tree`, `Hello World`, etc...)

#### `dir`
This is the dir which the project should be located in, e.g. (`echo`, `tree`, `hello_world`, etc...)

## Python README Generation
To generate a new readme it's as running a command in the [generator](_generator) filespce.
<br />
Once you're in the directory run the following command:
```
python generate_readme.py
```
This will generate the new README and spit back the contents it created in the console.

## Issue Reporting
When adding an issue, please remember to look through the labels and use any that apply.
<br />
Found an issue? What is it regarding?
<br />
For any unlisted issue use [this](.github/ISSUE_TEMPLATE/unlisted-issue.md)

***
### Coding Convention Issue (Naming/In-Code)
Please follow the issue template laid out [here](.github/ISSUE_TEMPLATE/coding-convention-issue.md).
<br />
Use this when you notice bad coding conventions, wether that be bad naming or bad in-code conventions.
<br />
Do not use this when you have nothing to cite where you know this from, or why it's better to do it your way.
<br />
Use the `Coding Convention Issue` label for this issue.

***
### Code Execution Issue
Please follow the issue template laid out [here](.github/ISSUE_TEMPLATE/code-execution-issue.md).
<br />
Use this for when something does not execute as expected or prints something wrong.
<br />
Do not use this when you have an issue executing the script. All projects are compiled before allowed in the codebase.
<br />
Use the `Code Execution Issue` label for this issue.

***
### Spelling / Grammatical Issue
Please follow the issue template laid out [here](.github/ISSUE_TEMPLATE/spelling-or-grammar-issue.md)
<br />
Use the `Spelling/Grammar` label for this issue.

***
## Code Contribution
To contribute a new language or project to the codebase you must have `python-3` installed to run the generator scripts.
<br />
So what are you trying to contribute?

***
### A New Language
When implementing a new languages there's a few things to do for it to be properly implemented.

#### Make the README.md
First make the README.md, give it the header `# <lang> Projects` inside of the language directory.

#### Add the language to the generator.
In `Basic` we use a generator for languages for the README and information, so it needs to be implemented into it.
<br />
The language must be added to [the generator json](_generator/readme.template.json).
<br />
With the format provided, the name is the use name of the language, the directory is where the language is held, 
the project\_sub is where the main file is held within the dir/project\_name/ filespace. 
For example with the echo project in Rust it's held in `rust/echo/echo.rs` so in the generator it's defined as `{dir}.rs`. 
All of the references to the project information is defined in the `comments` in the json.

#### Implementing base projects.
You may implement as many of the existing projects as you'd like. 
The `echo` and `Hello World` projects, however, are required in order for the language to be accepted.
<br />
The language also has to have some sort of valid documentation, as well as a way to install it and compile/execute code.

#### Once everything is setup.
After you've done everything previous to this, you'll need to generate a new README.md.
<br />
If you don't already know how to do this, please read [this](#python-readme-generation).
<br />
After all is generated and done, open a pull request and label it with the `New Language` label.

***
### A New Project
When implementing a new project there's a few things to do for it to be properly implemented.

#### Add the project to the generator.
Similar to adding a new language, the [the generator json](_generator/readme.template.json) must be appended.
<br />
The name being the name of the project with format being `upper case splitting words with spaces`. 
The dir being the directory which the project should fall in the format `low case splitting words with _`.
<br />
The project doesn't actually have to be used by any of the current languages to be accepted. 
The only thing needed is the idea.

#### Adding the project README
The project README must be inside of the [project descriptors](_project_descriptors).
<br />
The README must be headed with the name of the project and have a brief description of the program in its execution phase. 
A good example would be the [Tree](_project_descriptors/TREE.md) project's readme.
<br />
The README must be named `{The name uppercase splitting words with _}.md`

#### Once everything is done
After you've done everything previous to this, you'll need to generate a new README.md.
<br />
if you don't already know how to do this, please read [this](#python-readme-generation).
<br />
After all is generated and done, open a pull request and label it with the `New Project` label.

***
### Code Quality Enhancement
With this type of contribution no python generation is needed unless you're changing filenames.

#### If you're changing filenames:
After following the steps after this, make sure to generate a new README and push it along with everything else.
<br />
if you don't already know how to do this, please read [this](#python-readme-generation).

#### Define it's use and cite your sources.
When you optimize code, change filenames, or change filespaces, please cite your sources.
<br />
Changes made to code especially files need to have reason for changing after working already.
<br />
If you have no sourced reasons for why you changed something it will most likely be denied.

#### After everything is cited properly, and generated if needed.
Please make a PR and mark it as `Quality Enhancement`

***
## Documentation Contribution
Which documentation are you trying to contribute to?

***
### Project Explanation/Description
When making a PR to a project explanation, make sure that the new explanation is more descriptive and a net positive.
<br />
If your version gives less information on it, it will most likely be denied.
<br />
If you believe your version is better, please PR it and explain why.
<br />
These contributions are very open to everyone, there's no strict rules or regulations for these.

***
### Language OS Installation
This should all be done in the language's README.md:
<br />
When adding installation guides make sure that everything is under a `##` header for `Installation`. 
It should be defined and written under the `###` header for operating system you plan to implement.
<br />
All operating systems are invited to be represented but 
make sure you provide a full installation guide including any needed dependencies.

***
### Language Compilation/Execution
This should all be done in the language's README.md:
<br />
When adding compilation or execution guides make sure that everything is under a `##` header for `Compilation and Execution`.
<br />
With the compilation and execution they should either be disregarding of operating system, or define separate guides for 
the differences in operating systems.
<br />
With the compilation/execution development give some code examples of how it should compile and run.
For example:
```
$ cat hello_world.cpp
#include <iostream>
int main() {
  std::cout << "Hello World." << std::endl;
}
$ g++ -o hello_world.out hello_world.cpp
compilation information
$ ./hello_world.out
Hello World.
```
