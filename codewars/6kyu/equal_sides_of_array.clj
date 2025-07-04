(ns equal-sides-of-array
  (:require [clojure.test :refer [is deftest]]))

(defn find-even-index
  "Finds the index of an element that is a pivot for an equal sides of an array.
   Seq[Int] -> Int"
  [numbers]
  (loop [i 0]
  (cond 
    (= i (count numbers)) -1 
    (= (apply + (take i numbers)) (apply + (drop (inc i) numbers))) i 
    :else (recur (inc i))
    ))
  )

(deftest test-cases 
  (is (= (find-even-index [1,2,3,4,3,2,1]) 3))
  (is (= (find-even-index [1,100,50,-51,1,1]) 1))
  (is (= (find-even-index [1,2,3,4,5,6]) -1))
  (is (= (find-even-index [20,10,30,10,10,15,35]) 3))
  )