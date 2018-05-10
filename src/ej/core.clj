(ns ej.core
  (:gen-class)
  (:require [clojure.edn :as edn]
            [cheshire.core :as json]))

(defn stream-buffer [buffer]
  (doseq [ln (line-seq (java.io.BufferedReader. buffer))]
    (-> ln
        edn/read-string
        json/generate-string
        println)))

(defn process-file [file-name & [time?]]
  (if time?
    (-> file-name
        slurp
        edn/read-string
        json/generate-string
        println
        time)
    (-> file-name
        slurp
        edn/read-string
        json/generate-string
        println)))

(defn -main [& [option value]]
  (case option
    "-f" (process-file value)
    "-ft" (process-file value true)
    (stream-buffer *in*)))
