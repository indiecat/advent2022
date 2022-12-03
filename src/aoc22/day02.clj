(ns aoc22.day02
  (:require [clojure.java.io :as io]
    [clojure.string :as str]))

(def input (->>
             (slurp (io/resource "aoc22/day02.txt"))
             (str/split-lines)
             (map #(str/split % #" "))))

(defn p1-shape-score [round]
  ({"X" 1
    "Y" 2
    "Z" 3} (second round)))

(defn p1-outcome-score [round]
  (let [wins #{["A" "Y"]
              ["B" "Z"]
              ["C" "X"]}
        losses #{["A" "Z"]
                ["B" "X"]
                ["C" "Y"]}
        draws #{["A" "X"]
               ["B" "Y"]
               ["C" "Z"]}]
    (cond 
      (wins round) 6
      (draws round) 3
      (losses round) 0)))

(defn part-1 [_]
  (->> input
    (map #(+ (p1-shape-score %) (p1-outcome-score %)))
    (apply +)))

(defn p2-shape-score [round]
  (let [rock #{["A" "Y"]
              ["B" "X"]
              ["C" "Z"]}
        paper #{["A" "Z"]
                ["B" "Y"]
                ["C" "X"]}
        scissors #{["A" "X"]
               ["B" "Z"]
               ["C" "Y"]}]
    (cond 
      (rock round) 1
      (paper round) 2
      (scissors round) 3)))

(defn p2-outcome-score [round]
  ({"X" 0
    "Y" 3
    "Z" 6} (second round)))

(defn part-2 [_]
  (->> input
    (map #(+ (p2-shape-score %) (p2-outcome-score %)))
    (apply +)))

  
