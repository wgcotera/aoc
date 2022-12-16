(ns aoc.day01
  (:require [aoc.util :as util]
            [clojure.string :as str]))


(def input
  "Data from file"
  (util/read-input "01" "input"))

(def elves-calories
  "List of total calories carried per Elf"
  (->> (str/split input #"\n\n")
       (map str/split-lines)
       (map #(map read-string %))
       (map #(apply + %))))

(defn part-01
  "Max calories carried by an Elf"
  []
  (apply max elves-calories))

(defn part-02
  "Sum of the top 3 calories carried by the Elves"
  []
  (->> (sort elves-calories)
       (reverse)
       (take 3)
       (apply +)))


(comment

  ;; Learning

  (map #(* % %) (range 101))
  (defn square [x] (* x x))

  (def square1 (fn [x] (* x x)))
  (map (fn [e] (* e e)) (range 101)))
