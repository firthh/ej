# ej

A command line tool to quickly turn `edn` to `json`. 

## Usage

By default it streams from stdin and prints json to stdout.
An example of how you might use it in that way:
```bash
./o.sh | ej | jq
```

Optionally you can use it to parse a file:
```
ej -f testfile.edn
```

For debugging you can output the elapsed time to parse out output the JSON:
```
ej -ft testfile.edn
```

## Building

### Requirements
 - leiningen
 - java?
 - GraalVM - https://github.com/oracle/graal

Then just:
```bash
build.sh
```
(assuming you've downloaded things to the same place I have....)

## License

Copyright © 2018 Hugo

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
