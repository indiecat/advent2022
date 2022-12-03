(ns aoc22.day01
  (:require [clojure.java.io :as io]
    [clojure.string :as str]))

(def input
  (->>
  (str/split (slurp (io/resource "aoc22/day01.txt")) #"\n\n")
  (map str/split-lines)
  (map #(apply + (map parse-long %)))))

(defn part-1 [_]
  (->> input
    (apply max)))

(defn part-2 [_]
  (->> input
    sort
    (take-last 3)
    (apply +)))

  
  
