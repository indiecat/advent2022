(ns aoc22.day03
  (:require [clojure.java.io :as io]
    [clojure.string :as str]
    [clojure.set :as set]))

(def xtable
  (zipmap "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" (range 1 53)))

(def input (->>
             (slurp (io/resource "aoc22/day03.txt"))
             (str/split-lines)
             (map #(map xtable %))))


(defn p1-common-item-priority [rucksack]
  (let [size (count rucksack)
        [comp1 comp2] (partition (/ size 2) rucksack)]
    (-> 
      (set/intersection
        (set comp1)
        (set comp2))
      first)))

(defn part-1 [_]
  (->> input
    (map p1-common-item-priority)
    (apply +)))


(defn p2-common-item-priority [three-rucksacks]
  (->> three-rucksacks
    (map set)
    (apply set/intersection)
    first))

(defn part-2 [_]
  (->> input
    (partition 3)
    (map p2-common-item-priority)
    (apply +)))
