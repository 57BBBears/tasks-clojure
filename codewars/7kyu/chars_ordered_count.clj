(ns chars-ordered-count
  (:require [clojure.test :refer [is deftest]]
            [clojure.string :as str])
  )

(defn ordered-count
  "Return a seq of letters with their frequincy counts.
   Str -> Seq"
  [string]
  (->> string
       frequencies
       (map #(apply list %)))
  )

(defn apperance-order
  "Return a letters appearance order.
   Str -> Hash-map"
  [string]
  (->> string
       (map-indexed #(vector %2 %1))
       reverse
       (into {}))
  )

(defn ordered-count-appearance
  "Sort letters frequencies by their appearance.
   Str -> Seq"
  [string]
  (->> string
       frequencies
       (map #(apply list %))
       (sort-by (apperance-order string)))
  )

 (deftest test-cases
  (is (= (ordered-count "abracadabra") '((\a 5) (\b 2) (\r 2) (\c 1) (\d 1))))
  (is (= (ordered-count "Code Wars")) '((\C 1) (\o 1) (\d 1) (\e 1) (\space 1) (\W 1) (\a 1) (\r 1) (\s 1)))
  (is (= (ordered-count "aaa1bb22zzz")) '((\a 3) (\1 1) (\b 2) (\2 2) (\z 3)))
    )

(deftest test-cases
  (is (= (ordered-count-appearance "abracadabra") '((\a 5) (\b 2) (\r 2) (\c 1) (\d 1))))
  (is (= (ordered-count-appearance "Code Wars")) '((\C 1) (\o 1) (\d 1) (\e 1) (\space 1) (\W 1) (\a 1) (\r 1) (\s 1)))
  (is (= (ordered-count-appearance "aaa1bb22zzz")) '((\a 3) (\1 1) (\b 2) (\2 2) (\z 3)))
  )