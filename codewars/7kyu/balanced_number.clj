(ns balanced-number
  (:require [clojure.test :refer [is, deftest]]))

(defn digits 
  "Split a number into digits.
   Int -> Seq[int]"
  [number]
  (->> number
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn get-take-count
  "Return the amount of numbers to take.
   Seq[Int] -> Double"
  [numbers]
  (-> (count numbers)
      (/ 2)
      Math/ceil
      dec)
  )

(defn sum-first-or-last
  "Accept take or take-last as a func and return a sum of first or last numbers of the sequance."
  [func]
  (partial (fn [numbers] 
             (reduce + (func (get-take-count numbers) numbers))
             )
           )
  )

(defn balanced? 
  "Compare sum of the left and right ends of a number."
  [number] 
  (let [numbers (digits number)]
    (if (= 
         ((sum-first-or-last take) numbers)
         ((sum-first-or-last take-last) numbers))
      "Balanced"
      "Not Balanced")
      )
    )

(deftest test-cases
  (is (= (balanced? 1234) "Not Balanced"))
  (is (= (balanced? 14223) "Balanced"))
  (is (= (balanced? 7) "Balanced"))
  (is (= (balanced? 295591) "Not Balanced"))
  (is (= (balanced? 959) "Balanced"))
  (is (= (balanced? 27102983) "Not Balanced"))
  )