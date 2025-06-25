(ns categorize-member
  (:require [clojure.test :refer [is, deftest]]))

(defn open-or-senior
  "Categorize the members by thier age and handicap.
   Vector[Vector[Int Int]] -> Vector[String]"
  [members] 
  (map (fn [[age handicap]] (if (and (> age 54) (> handicap 7)) "Senior" "Open")) members) 
  )

(deftest test-cases
  (is (= (open-or-senior [[18, 20], [45, 2], [61, 12], [37, 6], [21, 21], [78, 9]])  [ "Open" "Open" "Senior" "Open" "Open" "Senior"]))
  (is (= (open-or-senior [[21 2] [65 8] [33 13]])  ["Open" "Senior" "Open"]))
  )