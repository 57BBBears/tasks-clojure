(ns population-growth
  (:require [clojure.test :refer [is, deftest]]))

(defn growth
  "Returns how many years will take to reach a population with a curtain growth params like 
   start population, growth percent, extra variation, final populagtion.
   Int, Float, Int, Int -> Int"
  [p0 percent aug p]
  (loop [ppl p0, i 0]
    (if (>= ppl p) i
        (recur (int (+ ppl aug (* ppl (/ percent 100.0)))) (inc i))))
  )

(deftest test-cases
  (is (= (growth 1000 2 50 1200) 3))
  (is (= (growth 1500 5 100 5000) 15))
  (is (= (growth 1500000 2.5 10000 2000000) 10))
  )