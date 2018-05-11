(ns ej.core
  (:gen-class)
  (:require [clojure.edn :as edn]
            [cheshire.core :as json]))

(defn read-n-spit [edn-str]
  (-> edn-str
      edn/read-string
      json/generate-string
      println))

(defn stream-buffer [buffer]
  (doseq [ln (line-seq (java.io.BufferedReader. buffer))]
    (read-n-spit ln)))

(defn process-file [file-name & [time?]]
  (if time?
    (-> file-name
        slurp
        read-n-spit
        time)
    (-> file-name
        slurp
        read-n-spit)))

(defn -main [& [option value]]
  (case option
    "-f" (process-file value)
    "-ft" (process-file value true)
    (stream-buffer *in*)))
