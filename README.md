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

## Performance
With just java:
```
> time java -jar target/ej-0.1.0-SNAPSHOT-standalone.jar -ft testfile.edn

{"hello":"world","some":123,"numbers":123.123}
"Elapsed time: 20.982972 msecs"
java -jar target/ej-0.1.0-SNAPSHOT-standalone.jar -ft testfile.edn  1.81s user 0.22s system 131% cpu 1.542 total
```

With binary compiled by Graal:
```
> time ej -ft testfile.edn

{"hello":"world","some":123,"numbers":123.123}
"Elapsed time: 1.363866 msecs"
ej -ft testfile.edn  0.01s user 0.00s system 64% cpu 0.013 total
```
## License

Copyright © 2018 Hugo

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
