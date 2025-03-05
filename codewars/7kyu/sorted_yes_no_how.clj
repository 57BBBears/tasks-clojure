(ns sorted-yes-no-how
  (:require [clojure.test :refer [is deftest]])
  )

(defn sorted-how? 
  "Check if numbers are sorted and how
     Seq of Int -> String"
  [numbers]
  (let [asc (sort numbers), numbers (apply list numbers)] 
    (if (= numbers asc)
      "yes, ascending"
      (if (= numbers (reverse asc))
        "yes, descending"
        "no")))
  )

(defn sorted-two?
  "Int, Int --> String"
  [num1 num2]
  (if (= num1 num2) 
    "no" 
    (if (< num1 num2) "yes, ascending" "yes, descending")))

(defn sorted-how-loop
  "Seq of Int -> String"
  [numbers] 
  (loop [numbers numbers, 
           cur_sorting (sorted-two? (first numbers) (last numbers))]
      (if (< (count numbers) 2) cur_sorting
          (if (or (= (first numbers) (second numbers)) 
                  (not= cur_sorting (sorted-two? (first numbers) (second numbers)))) "no"
              (recur (rest numbers) cur_sorting)))
      )
)

(deftest test-cases
  (is (= (sorted-how-loop []) "no"))
  (is (= (sorted-how-loop [1 4 3 0 2]) "no"))
  (is (= (sorted-how-loop [1 2 3]) "yes, ascending"))
  (is (= (sorted-how-loop [4 0 -10]) "yes, descending"))
  (is (= (sorted-how-loop [110 22 82]) "no"))
  )