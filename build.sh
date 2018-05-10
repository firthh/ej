export JAVA_HOME=~/Downloads/graalvm-1.0.0-rc1/Contents/Home
export PATH=$PATH:~/Downloads/graalvm-1.0.0-rc1/Contents/Home/bin

lein uberjar
native-image -jar target/ej-0.1.0-SNAPSHOT-standalone.jar -H:Name="ej" -H:+ReportUnsupportedElementsAtRuntime
