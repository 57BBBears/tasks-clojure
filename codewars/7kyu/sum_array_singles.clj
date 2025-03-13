(ns sum-array-singles
  (:require [clojure.test :refer [is deftest]])
  )

(defn sum-singles [nums]
  (->> nums
       (filter #(= (filter #{%} nums) [%]))
       (apply +))
  )

(deftest test-cases
  (is (= (sum-singles [1 1 3 2 2 5]) 8))
  (is (= (sum-singles [0 2 2 2 10]) 10))
  (is (= (sum-singles [-3 1 2 1 2 3 2]) 0))
  )