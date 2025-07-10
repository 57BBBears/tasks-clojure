(ns roman-numerals
  (:require [clojure.test :refer [is deftest]]))

(defn replace-num
  "Replace a number with a relative letter with a roman number. 
   Str, Int -> Str"
  [letter num]
  (cond
    (= 0 num) ""
    (>= 3 num) (repeat num letter)
    (= letter "I") ({4 "IV" 5 "V" 6 "VI" 7 "VII" 8 "VIII" 9 "IX"} num)
    (= letter "X") ({4 "XL" 5 "L" 6 "LX" 7 "LXX" 8 "LXXX" 9 "XC"} num)
    (= letter "C") ({4 "CD" 5 "D" 6 "DC" 7 "DCC" 8 "DCCC" 9 "CM"} num))
  )

(defn encode
  "Turns arabic numerals into romans.
   Int -> Str" 
  [number]
  (->> (reverse (str number))
       (map #(replace-num %1 (Integer/parseInt (str %2))) ["I" "X" "C" "M"])
       (reduce #(str (apply str %2) %1) ""))
)

(deftest test-cases
  (is (= (encode 1) "I"))
  (is (= (encode 1990) "MCMXC"))
  (is (= (encode 2008) "MMVIII"))
  (is (= (encode 1666) "MDCLXVI"))
  )   