(ns friend-or-foe
  (:require [clojure.test :refer [is, deftest]]))

(defn friends
  "Filter friends i.e. names consisting of 4 letters.
   Vector[Str] -> List[Str]"
  [names]
  (filter #(= (count %) 4) names)
  )

(defn friends-n
  "Filter friends i.e. names consisting of <number> letters."
  [number names]
  (filter #(= (count %) number) names))

(def friends4 (partial friends-n 4))


(deftest test-cases
  (is (= ["Ryan" "Mark"] (friends ["Ryan" "Kieran" "Mark"]))) 
  (is (= ["This" "Test" "Case"] (friends ["This" "Is" "A" "Test" "Case"])))
  (is (= ["Ryan" "Mark"] (friends4 ["Ryan" "Kieran" "Mark"])))
  (is (= ["This" "Test" "Case"] (friends4 ["This" "Is" "A" "Test" "Case"])))
)