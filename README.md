<img src="https://www.yegor256.com/images/books/elegant-objects/cactus.svg" height="92px" />

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](http://www.rultor.com/b/objectionary/eo)](http://www.rultor.com/p/objectionary/eo)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

![Lines of code](https://img.shields.io/tokei/lines/github/objectionary/eo-intellij-plugin)
![Hits-of-Code](https://hitsofcode.com/github/objectionary/eo-intellij-plugin)
![Build](https://img.shields.io/github/workflow/status/objectionary/eo-intellij-plugin/Java%20CI)
[![codecov](https://codecov.io/gh/objectionary/eo-intellij-plugin/branch/master/graph/badge.svg)](https://codecov.io/gh/objectionary/eo-intellij-plugin)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/objectionary/eo/blob/master/LICENSE.txt)

This is Intellij plugin for [EO](https://github.com/objectionary/eo).

Installing is possible from [IntelliJ IDEA](https://www.jetbrains.com/idea/)
and other [JetBrains](https://www.jetbrains.com/) family products, such
as [PyCharm](https://www.jetbrains.com/ru-ru/pycharm/), [CLion](https://www.jetbrains.com/ru-ru/clion/), and so on. Just type "EO" in plugins search tab and you will find it.

You may also install it from [its page](https://plugins.jetbrains.com/plugin/19256-eo/versions)
at JetBrains Marketplace.

## How to Contribute

Fork repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full gradle build:

```bash
$ gradle build
```

You will need [Gradle](https://gradle.org/guides/) and Java 14+ installed.

## Structure

Project has two parts: manually written and auto-generated.

In `src/main` you may find source code. Classes listed there are not auto-generated. They describe EO language and `.eo` extension.

The second part is auto-generated classes. They should be generated from `.g4` file and moved into
`src/java/org/eolang/jetbrains/parser`. The grammar will be downloaded automatically
during `build` gradle task. Needed class will be generated at the same time.

Resources (icons and `plugin.xml`) are located in `src/resources`.

We use [Rultor](https://github.com/yegor256/rultor) for publishing (see `.rultor.yml`).

## How it Works

Plugin is implemented in Java and ANTLR4 grammar.

[ANTLR4 adapter](https://github.com/antlr/antlr4-intellij-adaptor) is used for generating `EOLexer` and `EOParser` classes.
