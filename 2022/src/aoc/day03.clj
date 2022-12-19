(ns aoc.day03
  (:require [aoc.util :as util]
            [clojure.set :as set]
            [clojure.string :as str]))

(def input
  "Input data from file"
  (util/read-input "03" true))

(def priorities
  "Map of letters with their respectives values"
  (zipmap "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" (range 1 53)))

(defn parse-rucksacks 
  "List of rucksacks"
  [input]
  (str/split-lines input))

(defn split-ruckstack 
  "Divide ruckstacks in half"
  [str]
  (let [len (count str)
        first-part (subs str 0 (/ len 2))
        second-part (subs str (/ len 2) len)]
    [first-part second-part]))

(defn common-letter 
  "Given a collection of strings returns the common letters"
  [strv]
  (->> strv
       (map set)
       (apply set/intersection)
       (vec)))

(defn part-01 []
  (->> input
       (parse-rucksacks)
       (map split-ruckstack)
       (map common-letter)
       (flatten)
       (map priorities)
       (apply +)))

(defn part-02 []
  (->> input
       (parse-rucksacks)
       (partition-all 3)
       (map common-letter)
       (flatten)
       (map priorities)
       (apply +)))