# EO-intellij-plugin

This is Intellij plugin for **[EO language](https://github.com/objectionary/eo)**. Plugin implemented on Java and ANTLR4 grammar.

 **[ANTLR 4 adapter](https://github.com/antlr/antlr4-intellij-adaptor)** was used for generating lexer and parser classes.
First version contains syntax highlighting

## Usage
In process of publishing...
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## Structure
In `src/main` you may find source code.

In `main/antlr/org/antlr/jetbrains/eo/parser` you may find description of EO grammar.
Generating of needed classes is possible in grammar file (right click --> generate ANTLR recognising)

`java/org/antlr/jetbrains/eo/parser` - auto-generated classes should be here. Create this folder

All other folders and files in `java/org/antlr/jetbrains/eo` are not auto-generated. These files describe highlighting colors, extension of language and etc.
Resources (icons and plugin.xml) are located in `src/resources`.
## License
[MIT](https://choosealicense.com/licenses/mit/)