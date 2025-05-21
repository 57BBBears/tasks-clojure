(ns complementary-dna
  (:require [clojure.test :refer [is, deftest]]
            [clojure.string :as string]))

(defn complement-dna-string [part]
  (let [dna-map {"A" "T", "T" "A", "C" "G", "G" "C"}]
    (string/replace part #"[ATGC]" dna-map))
  )

(defn complement-dna 
  "Replace a part of DNA with the complement part.
   Str -> Str"
  [part]
  (let [dna-map {\A "T", \T "A", \C "G", \G "C"}]
    (apply str (map #(dna-map %) part)))
  )

(deftest test-cases
  (is (= (complement-dna-string "ATTGC") "TAACG"))
  (is (= (complement-dna-string "GTAT") "CATA"))
  (is (= (complement-dna-string "TAGC") "ATCG"))
  
  (is (= (complement-dna "ATTGC") "TAACG"))
  (is (= (complement-dna "GTAT") "CATA"))
  (is (= (complement-dna "TAGC") "ATCG"))
  )