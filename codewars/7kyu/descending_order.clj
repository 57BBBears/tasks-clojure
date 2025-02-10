(ns descending-order
  (:require [clojure.test :refer [is, deftest]]))

(defn digits [number]
  ;; Split a number with digits.
  (if (pos? number)
    (conj (digits (quot number 10)) (mod number 10))
    []))

(defn get-total-number [nums]
  ;; Get a number from sorted digits.
  (reduce + (map * nums 
                 (iterate (partial * 10) 1)
                 )
          )
  )

(defn desc-order [number]
  (->> number
       digits
       sort
       get-total-number)
  )

(deftest test-cases
  (is (= (desc-order 15) 51))
  (is (= (desc-order 1) 1))
  (is (= (desc-order 0) 0))
  )