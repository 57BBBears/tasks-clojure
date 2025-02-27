(ns sum-of-numbers
  (:require [clojure.test :refer [is deftest]])
  )

(defn sum
  "Return sum of number between and including a and b. If a equals b return either.
   Int Int -> Int"
  [a b]
  (if (== a b) 
    a
    (+ (min a b) 
       (sum (inc (min a b)) 
            (max a b))
       )
    )
  )

(deftest test-cases
  (is (= (sum 1 0) 1))
  (is (= (sum 0 1) 1))
  (is (= (sum -1 0) -1))
  (is (= (sum 1 1) 1))
  (is (= (sum -1 2) 2))
  (is (= (sum -1 3) 5))
  )