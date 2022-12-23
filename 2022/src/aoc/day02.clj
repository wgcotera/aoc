(ns aoc.day02
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(def input
  "Input data from file"
  (str/split-lines (util/read-input "02" false)))

  ;; PART 1

  ;; OPONENT A,B,C
  ;; ME X,Y,Z

  ;; "A" and "X" --> ROCK = 1 
  ;; "B" and "Y" --> PAPER = 2
  ;; "C" and "Z" --> SISSORS = 3

  ;; LOSE = 0
  ;; DRAW = 3
  ;; WIN = 6

(def plays-1
  "Results of rounds according to part 1"
  (zipmap ["B X" "C Y" "A Z" "A X" "B Y" "C Z" "C X" "A Y" "B Z"] [1 2 3 4 5 6 7 8 9]))

  ;; PART 2

  ;; OPONENT and ME A(ROCK = 1), B(PAPER = 2), C(SISSORS = 3)

  ;; X --> LOSE = 0
  ;; Y --> DRAW = 3
  ;; Z --> WIN = 6

(def plays-2
  "Results of rounds according to part 2"
  (zipmap ["B X" "C X" "A X" "A Y" "B Y" "C Y" "C Z" "A Z" "B Z"] [1 2 3 4 5 6 7 8 9]))


(defn part-01
  "Total score if everything goes exactly according to the strategy guide"
  []
  (->> input
       (map plays-1)
       (reduce +)))

(defn part-02
  "Total score if everything goes exactly according to the strategy guide"
  []
  (->> input
       (map plays-2)
       (reduce +)))