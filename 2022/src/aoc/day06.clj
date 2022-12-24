(ns aoc.day06
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(def input 
  "Input data from file"
  (str/split-lines (util/read-input "06" true)))

(defn first-marker
  "Returns the position of the first occurrence of a marker in a string"
  [v-str n-digits]
  (loop [s v-str n n-digits]
    (if (apply distinct? (take n-digits s))
      n
      (recur (drop 1 s) (inc n)))))

(defn part-01
  "characters need to be processed before the first start-of-packet marker taking 4"
  []
  (->> input
       (map #(first-marker % 4))))

(defn part-02
  "characters need to be processed before the first start-of-packet marker taking 14"
  []
  (->> input
       (map #(first-marker % 14))))