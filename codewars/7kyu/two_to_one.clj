(ns two-to-one
  (:require [clojure.test :refer [is, deftest]]))

(defn longest
  "Creates a longest sorted string of unique letters from two strings.
   Str Str -> Str"
  [string1, string2]
  (->> (str string1 string2)
       distinct
       sort
       (apply str)))



(deftest test-cases
  (is (= (longest "xyaabbbccccdefww" "xxxxyyyyabklmopq") "abcdefklmopqwxy"))
  (is (= (longest "abcdefghijklmnopqrstuvwxyz" "abcdefghijklmnopqrstuvwxyz") "abcdefghijklmnopqrstuvwxyz"))
  )