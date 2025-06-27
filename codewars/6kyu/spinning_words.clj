(ns spinning-words
  (:require [clojure.test :refer [is deftest]]
            [clojure.string :as str]))

(defn spin-words
  "Reverse a word if it's longer than 4 letters.
   String -> String"
  [string]
  (str/replace string #"\w{5,}" #(str/reverse %))
  )

(deftest test-cases
  (is (= (spin-words "Mary had a little lamb") "Mary had a elttil lamb"))
  (is (= (spin-words "Sally sells sea shells on the sea shore") "yllaS slles sea sllehs on the sea erohs"))
  (is (= (spin-words "Hello") "olleH"))
  )