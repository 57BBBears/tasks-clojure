(ns codewars.8kyu.square_n_sum
  (:require [clojure.test :refer :all]
            ))


(defn square-sum [lst]
  (reduce #(+ %1 (* %2 %2)) 0 lst)
)

(deftest basic-tests
  (is (= (square-sum [1, 2]) 5))
  (is (= (square-sum [5, 3, 4]) 50))
  (is (= (square-sum []) 0))
  )