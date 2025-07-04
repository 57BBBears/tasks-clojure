(ns are-they-same
  (:require [clojure.test :refer [is deftest]]))

(defn same?
  "Compares two sequances of numbers. 
   It's the same if sqare of each number from the first seq equals a number from the second seq.
   Seq[Int] Seq[Int] -> Boolean"
  [a b]
  (and (boolean a) (boolean b) 
       (= (sort (map #(* % %) a)) (sort b)))
  )

(deftest test-cases 
  (is (= (same? [121, 144, 19, 161, 19, 144, 19, 11] [121, 14641, 20736, 361, 25921, 361, 20736, 361]) true))
  (is (= (same? [121, 144, 19, 161, 19, 144, 19, 11] [121, 14641, 20736, 361, 25921, 361, 20736, 362]) false))
  (is (= (same? [1 1 2] [6 0 0]) false))
  (is (= (same? [] []) true))
  (is (= (same? nil nil) false))
  )