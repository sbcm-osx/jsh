#Jsh : the Java Shell
###### by Deloche Tristan
[![Travis-CI Badge](https://travis-ci.org/Tristan971/jsh.svg?branch=master)](https://travis-ci.org/Tristan971/jsh)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/cab48657f0534b0d93b090bc663eab24)](https://www.codacy.com/app/Tristan971/jsh)
[![Dependency Status](https://www.versioneye.com/user/projects/5893129cb890130016a5acb5/badge.svg)](https://www.versioneye.com/user/projects/5893129cb890130016a5acb5)

<br/>

#### Contents of this file :
  * [Description](#description)
  * [Installation](#installation)
  * [Contributing](#contributing)


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