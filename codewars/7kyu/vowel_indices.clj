(ns vowel-indices
  (:require [clojure.test :refer [is deftest]])
  )

(defn vowel-indices 
  "Find positions of the vowels in a string.
   Str -> Vector[Int]"
  [letters]
  (let [vowels #{\A \a \E \e \I \i \O \o \U \u \Y \y}]
    (keep-indexed 
     (fn [index letter]
       (when (some vowels [letter]) (inc index)))
     letters)))

  (deftest test-cases
    (is (= (vowel-indices "Mmmm") []))
    (is (= (vowel-indices "Super") [2 4]))
    (is (= (vowel-indices "Yo Mama") [1 2 5 7]))
    )