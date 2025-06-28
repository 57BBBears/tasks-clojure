(ns count-duplicates
  (:require [clojure.test :refer [is deftest]]
            [clojure.string :as str]))

(defn count-duplicates
  "Count the number of duplicate characters.
   String -> Int"
  [string]
  (->> (str/lower-case string)
       frequencies
       (filter #(> (second %) 1))
       count)
  )

(deftest test-cases
  (is (= (count-duplicates "abcde") 0))
  (is (= (count-duplicates "aabbcde") 2))
  (is (= (count-duplicates "aabBcde") 2))
  (is (= (count-duplicates "indivisibility") 1))
  (is (= (count-duplicates "Indivisibilities") 2))
  (is (= (count-duplicates "aA11") 2))
  (is (= (count-duplicates "ABBA") 2))
  (is (= (count-duplicates "") 0))
  )