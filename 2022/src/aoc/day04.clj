(ns aoc.day04
  (:require [aoc.util :as util]
            [clojure.set :as set]
            [clojure.string :as str]))

(def input
  "Input data from file"
  (util/read-input "04" false))

(defn set-from-str
  "Takes a range given as a string ('2-4') and returns a set ('{2 3 4}')"
  [str]
  (let [[n1 n2] (map #(Integer/valueOf %) (str/split str #"-"))]
    (set (range n1 (inc n2)))))

(defn subset-in-one-direction
  "Between two sets, checks if one is subset of the other"
  [set1 set2]
  (or (set/subset? set1 set2)
      (set/subset? set2 set1)))

(defn common
  "Applies set-from-string to the input data"
  [input]
  (->> input
       (str/split-lines)
       (map #(str/split % #","))
       (map #(map set-from-str %))))

(defn part-01
  "In how many assignment pairs does one range fully contain the other?"
  []
  (->> input
       (common)
       (map #(subset-in-one-direction (first %) (second %)))
       (filter true?)
       (count)))


(defn part-02
  "In how many assignment pairs do the ranges overlap?"
  []
  (->> input
       (common)
       (map #(set/intersection (first %) (second %)))
       (filter not-empty)
       (count)))