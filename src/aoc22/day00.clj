(ns aoc22.day00
  (:require [clojure.java.io :as io]
    [clojure.string :as str]))

(def input (->>
             (slurp (io/resource "aoc22/day00.txt"))
             (str/split-lines)
             (map #(str/split % #" "))))


(defn part-1 [_])

(defn part-2 [_])
