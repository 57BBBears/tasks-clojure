(ns persistent-bugger
  (:require [clojure.test :refer [is deftest]]))

(defn bugger
  "Count digits of a number multiplies untill only one digit left.
   Int -> Int"
  [number]
  (loop [current number
         i 0]
    (if (> current 9)
      (recur (apply * (map #(Integer/parseInt (str %)) (str current))) (inc i))
      i)
    )
  )

(deftest test-cases
  (is (= (bugger 39) 3))
  (is (= (bugger 999) 4))
  (is (= (bugger 4) 0))
  (is (= (bugger 123) 1))
  (is (= (bugger 25) 2))
  )