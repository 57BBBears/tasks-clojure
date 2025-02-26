(ns shortest-word
  (:require [clojure.test :refer [is deftest]])
  (:require [clojure.string :refer [split]])
  )

(defn find-shortest [words]
  (->> (split words #" ")
       (map count)
       (apply min)
       )
  )

(deftest test-cases
  (is (= (find-shortest "abc d") 1))
  (is (= (find-shortest "one brown foxy") 3))
  (is (= (find-shortest "t") 1))
  )