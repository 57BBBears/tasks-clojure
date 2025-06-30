(ns find-odd-int
  (:require [clojure.test :refer [is deftest]]))

(defn find-odd-int
  "Finds a number with an odd appearance frequency.
   Seq[Int] -> Int"
  [numbers] 
  (some (fn [[k v]] (when (odd? v) k)) (frequencies numbers))
)

(deftest test-cases
  (is (= (find-odd-int [7]) 7))
  (is (= (find-odd-int [0]) 0))
  (is (= (find-odd-int [1 1 2]) 2))
  (is (= (find-odd-int [0 1 0 1 0]) 0))
  (is (= (find-odd-int [1 2 2 3 3 3 4 3 3 3 2 2 1]) 4))
  )