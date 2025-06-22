(ns printer-errors
  (:require [clojure.test :refer [is, deftest]]
            [clojure.string :refer [includes?]]))

(defn printer-errors
  "Find error count and length of a given string. Errors are constant string.
   Str -> Str"
  [string]
  (let [error_count (count (filter #(includes? "nopqrstuvwxyz" (str %)) string))
        all_count (count string)] 
    (str error_count "/" all_count))
  )

(deftest test-cases
  (is (= (printer-errors "aaabbbbhaijjjm") "0/14"))
  (is (= (printer-errors "aaaxbbbbyyhwawiwjjjwwm") "8/22"))
  )