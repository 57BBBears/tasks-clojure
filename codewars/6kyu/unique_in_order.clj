(ns unique-in-order
  (:require [clojure.test :refer [is deftest]]))

(defn unique
  "Returns unique elements.
   Seq -> Seq"
  [order] 
  (reduce #(if (= (last %1) %2) %1 (conj %1 %2)) [] order)
)

(deftest test-cases
  (is (= (unique "AAAABBBCCDAABBB") [\A \B \C \D \A \B]))
  (is (= (unique [1, 2, 2, 3, 3]) [1, 2, 3]))
  (is (= (unique [1, 3, 2, 2, 3, 3]) [1, 3, 2, 3]))
  )