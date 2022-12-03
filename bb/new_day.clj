(ns new-day
  (:require
   [babashka.fs :as fs]
   [clojure.string :as str]))

(defn new-day
  {:org.babashka/cli {:coerce {:day :string
                               :year :string}}}
  [{:keys [year day]
    :or {year "22"}}]
  (let [new-year (str "aoc" year)
        new-day (str "day" day)
        day00 (slurp (fs/file "src" "aoc22" "day00.clj"))
        replaced (str/replace day00 "aoc22" new-year)
        replaced (str/replace replaced "day00" new-day)]
    (fs/create-dirs "src" new-year)
    (fs/create-dirs "resources" new-year)
    (let [new-day-resource (fs/file "resources" new-year (str new-day ".txt"))]
      (if-not (fs/exists? new-day-resource)
        (fs/copy (fs/file "resources" "aoc22" "day00.txt")
                 new-day-resource)
        (println (format "Day %s/%s resource already exists." new-year new-day))))
    (let [new-day (fs/file "src" new-year (str new-day ".clj"))]
      (if-not (fs/exists? new-day)
        (spit new-day replaced)
        (println (format "Day %s/%s already exists." new-year new-day))))))
