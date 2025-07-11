(ns rectangle-into-squares
  (:require [clojure.test :refer [is deftest]]))

(defn rectangle->squares
  "Split a rectanle into squares.
   Int, Int -> Vector"
  ([side1 side2] 
   (if (= side1 side2) nil (rectangle->squares side1 side2 [])))
  ([side1 side2 result]
   (if (= side1 side2)
     (conj result side1)
     (recur (min side1 side2)
            (- (max side1 side2) (min side1 side2))
            (conj result (min side1 side2))))
   )
  )

(deftest test-cases
  (is (= (rectangle->squares 1 1) nil))
  (is (= (rectangle->squares 5 3) [3, 2, 1, 1]))
  (is (= (rectangle->squares 3 5) [3, 2, 1, 1]))
  )