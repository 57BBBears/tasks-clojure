(ns maximum-product
  (:require [clojure.test :refer [is deftest]])
  )

(defn max-product-reduce [numbers]
  (first (reduce 
          (fn [[sum prev] cur] 
            (vector (max sum (* prev cur)) cur)) 
          [(/ -1.0 0.0) (second numbers)] numbers))
)

(defn max-product
  "Return max multiplication of the adjucent numbers.
   Vector[Int] -> Int"
  [numbers]
  (apply max 
         (map * numbers (rest numbers))))

(deftest test-cases
  (is (= (max-product [1 1 3 2 2 5]) 10))
  (is (= (max-product [1 -1 1 -2 ]) -1))
  (is (= (max-product [0 2 2 -10]) 4))
  (is (= (max-product [-3 1 0 2 0 2]) 0))
  (is (= (max-product [-23, 4, -5, 99, -27, 329, -2, 7, -921]) -14))
  )