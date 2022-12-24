(ns aoc.util
  (:require [clojure.java.io :as io]))

(defn read-input [day sample?]
  (if sample?
    (slurp (io/resource (format "day_%s_sample.in" day)))
    (slurp (io/resource (format "day_%s.in" day)))))