(ns bouncing-ball
  (:require [clojure.test :refer [is deftest]]))

(defn count-bounces
  "Count bounces on a window height depending on a height and a bounce rate.
   Float Float Float -> Int"
  [height bounce window]
  (if (and (> height 0) (> bounce 0) (< bounce 1) (> height window ))
    (->> height
         (iterate (partial * bounce))
         (take-while (partial < window))
         count
         (* 2)
         dec
         )
    -1)
  )

(deftest test-cases 
  (is (= (count-bounces 3 0.66 1.5) 3))
  (is (= (count-bounces 3 1 1.5) -1))
  (is (= (count-bounces 2 0.5 1) 1))
  )