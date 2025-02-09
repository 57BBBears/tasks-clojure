(ns codewars.7kyu.high_and_low
  (:require [clojure.test :refer :all])
  (:require [clojure.string :as str])
  )

(defn cur-max-min [vtr num]
 [
  (let [cur-max (first vtr)]
     (if cur-max (max cur-max num) num)
     ) 
  (let [cur-min (second vtr)]
    (if cur-min (min cur-min num) num))
  ]
  )

(defn str-to-ints 
  ([s]
   (str-to-ints s #" "))
  ([s re] 
   ( map #(Integer/parseInt %) (str/split s re))
   )
  )
  

(defn high-and-low [s]
    (str/join " "
     (reduce cur-max-min [] (str-to-ints s))
     )
    )


(high-and-low "8 3 -5 42 -1 0 0 -9 4 7 4 -4")

(deftest basic-tests
  (is (= (high-and-low "8 3 -5 42 -1 0 0 -9 4 7 4 -4") "42 -9"))
  (is (= (high-and-low "1 2 3") "3 1"))
  )