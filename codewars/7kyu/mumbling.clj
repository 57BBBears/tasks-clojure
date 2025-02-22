(ns mumbling
  (:require [clojure.test :refer [is deftest]])
  (:require [clojure.string :refer [join capitalize]])
  )

(defn accum [letters]
  (join "-" 
        (map-indexed #(capitalize
                       (apply str
                              (repeat (inc %1) %2))
                       )letters)
        )
  )

(deftest test-cases
  (is (= (accum "abcd") "A-Bb-Ccc-Dddd"))
  (is (= (accum "RqaEzty") "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"))
  (is (= (accum "cwAt") "C-Ww-Aaa-Tttt"))
  )