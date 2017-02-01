#Jsh : the Java Shell
###### by Deloche Tristan

## Description
Jsh aims to be a zsh-like shell.
As such, it implements various features ranging from
expected builtins (ls, cat, rm...) to support for
3rd-party console applications.

Although it will probably be very feature-lacking for
a while it is also just a side project to see how to
implement such an application in Java, and how fast it
can get.

## Installation

    > git clone https://github.com/Tristan971/jsh.git
    > mvn clean
    > mvn package

The runnable file will be located in `target/jsh-<version>.jar`.

You can then run it as any java application with `java -jar jsh-<version>.jar`

## Contributing

Contributions are welcomed, as long as they follow
the coding style used in the rest of the project.