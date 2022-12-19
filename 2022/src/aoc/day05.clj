(ns aoc.day05
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(def input
  "Input data from file"
  (util/read-input "05" false))

(def stacks
  "Vector with the stacks (list of characters)"
  (->> (str/split input #"\n\n")
       first
       str/split-lines
       pop
       (apply mapv str)
       (map #(re-find #"[A-Z]+" %))
       (filter some?)
       (map #(apply list %))
       vec))

(def instructions
  "List of vectors with the moves that has to be apply to stacks"
  (->> (str/split input #"\n\n")
       (second)
       (str/split-lines)
       (map #(re-seq #"\d+" %))
       (map #(map read-string %))
       (map vec)))

(defn apply-moves
  "Retrieve elements from a stack to another (one by one)"
  [stacks [n from to]]
  (loop [n n
         source (stacks (dec from))
         target (stacks (dec to))]
    (if (pos? n)
      (recur
       (dec n)
       (pop source)
       (conj target (peek source)))
      (assoc stacks
             (dec from) source
             (dec to) target))))

(defn apply-moves2
  "Retrieve element from a stack to another (all at once)"
  [stacks [n from to]]
  (let [n n
        source (stacks (dec from))
        target (stacks (dec to))]
    (assoc stacks
           (dec from) (pop source)
           (dec to) (into '() (flatten (conj target (take n source)))))))

(defn part-01
  "what crate ends up on top of each stack with apply-moves?"
  []
  (->> instructions
       (reduce apply-moves stacks)
       (map first)
       (apply str)))

(defn part-02
  "what crate ends up on top of each stack with apply-moves1?"
  []
  (->> instructions
       (reduce apply-moves2 stacks)
       (map first)
       (apply str)))

(comment
  ;; To convert a string to a list of characters use seq or into
  ;; seq returns a sequence of characters 
  (seq "abcdef")
  ;; into returns a list of characters
  (into '() "abcdef")

  ;; flatten returns a sequence not a list
  (seq? (flatten '(((\M) \Z \N) \P)))
  ;; To convert a seq to list use into
  (list? (into '() (flatten '(((\M) \Z \N) \P)))))