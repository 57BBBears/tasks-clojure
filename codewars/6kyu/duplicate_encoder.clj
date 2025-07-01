(ns duplicate-encoder
  (:require [clojure.test :refer [is deftest]]))

(defn encode-letters
  "Encodes duplicate letters as ')' and single ones as '('.
   Accept only letters, numbers and spaces.
   Str -> Str"
  [string]
  (let [string-lower (clojure.string/lower-case string)]
    (reduce #(str %1 
                  (if (< 1 (count (re-seq (re-pattern (str %2)) string-lower))) ")" "("))
            "" string-lower))
  )

(defn encode
  "Encodes duplicate letters as ')' and single ones as '('.
   Str -> Str"
  [string]
  (let [string-lower (clojure.string/lower-case string)
        letter-freqs (frequencies string-lower)]
    (reduce #(str %1 (if (< 1 (letter-freqs %2)) ")" "(")) "" string-lower))
  )

(deftest test-cases
  (is (= (encode-letters "din") "((("))
  (is (= (encode-letters "recede") "()()()"))
  (is (= (encode-letters "Success") ")())())"))

  (is (= (encode "din") "((("))
  (is (= (encode "recede") "()()()"))
  (is (= (encode "Success") ")())())"))
  (is (= (encode "(( @") "))(("))
  )