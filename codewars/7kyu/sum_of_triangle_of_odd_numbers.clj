(ns sum-of-triangle-of-odd-numbers
  (:require [clojure.math :refer [pow]])
  (:require [clojure.test :refer [is deftest]])
  )

(defn get-row-first-number [row_num]
  (inc (apply + 
              (take row_num
                      (iterate (partial + 2) 0)
                      )))
  )

  (defn sum 
  "Return sum of odd number in a row of the triangle.
       1
      3 5
     7 9 11
     etc. 2 --> 3+5=8
     Int -> Int"
    [row_num] 
  (apply + 
         (range (get-row-first-number row_num) 
                (get-row-first-number (inc row_num)) 
                2)
     )
  )

(defn get_nth_odd [nth]
  (inc (* (dec nth) 2))
  )

 (defn get-nth-of-row-first-el [row_num]
  (inc (apply +
              (take row_num
                    (iterate inc 0))))
 )

(defn sum1 [row_num]
  (apply +
         (range 
          (get_nth_odd 
           (get-nth-of-row-first-el row_num))
          (get_nth_odd
           (get-nth-of-row-first-el (inc row_num)))
          2)
    )
  )
 
 (defn math-sum [row_num]
   (int (pow row_num 3))
   )

(deftest test-cases
  (is (= (sum 1) 1))
  (is (= (sum 2) 8))
  (is (= (sum 3) 27))
  (is (= (sum 4) 64))
  (is (= (sum 5) 125))
  (is (= (sum 6) 216))

  (is (= (sum1 1) 1))
  (is (= (sum1 2) 8))
  (is (= (sum1 3) 27))
  (is (= (sum1 4) 64))
  (is (= (sum1 5) 125))
  (is (= (sum1 6) 216))

  (is (= (math-sum 1) 1))
  (is (= (math-sum 2) 8))
  (is (= (math-sum 3) 27))
  (is (= (math-sum 4) 64))
  (is (= (math-sum 5) 125))
  (is (= (math-sum 6) 216))
  )