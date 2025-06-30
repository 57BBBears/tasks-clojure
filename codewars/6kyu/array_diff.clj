(ns array-diff
  (:require [clojure.test :refer [is deftest]]))

(defn array-difference
  "Finds difference between two arrays.
   Seq[Int] -> Seq[Int]"
  [numbers exceptions] 
  (remove #((set exceptions) %) numbers)
)

(defn array-difference1
  "Finds difference between two arrays.
   Seq[Int] -> Seq[Int]"
  [numbers exceptions]
  (let [exc-set (set exceptions)] (remove exc-set numbers))
  )

(deftest test-cases
  (is (= (array-difference [1 2 3] [2]) [1 3]))
  (is (= (array-difference [1 2 2] [1]) [2 2]))
  (is (= (array-difference [1 2 2] [2]) [1]))
  (is (= (array-difference [1 2 2] []) [1 2 2]))
  (is (= (array-difference1 [1 2 3] [2]) [1 3]))
  (is (= (array-difference1 [1 2 2] [1]) [2 2]))
  (is (= (array-difference1 [1 2 2] [2]) [1]))
  (is (= (array-difference1 [1 2 2] []) [1 2 2]))
  )