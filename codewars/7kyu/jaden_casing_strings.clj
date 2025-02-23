(ns jaden-casing-strings
  (:require [clojure.test :refer [is deftest]])
  (:require [clojure.string :refer [split join capitalize]])
  )

(defn jaden-case [string]
  ;; Camel casing the string
  (join " "
        (map capitalize 
             (split string #" ")))
  )

(defn jaden-case-ver1 [string]
  ;; Camel casing the string
  (->> (split string #" ")
       (map capitalize)
       (join " ")
       )
  )

(deftest test-cases
  (is (= "How Can Mirrors Be Real If Our Eyes Aren't Real"
         (jaden-case "How can mirrors be real if our eyes aren't real")))
  (is (= "How Can Mirrors Be Real If Our Eyes Aren't Real"
         (jaden-case-ver1 "How can mirrors be real if our eyes aren't real")))
)