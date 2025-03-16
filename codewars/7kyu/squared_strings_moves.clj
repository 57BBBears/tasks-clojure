(ns squared-strings-moves
  (:require [clojure.test :refer [is deftest]]
            [clojure.string :as str])
  )

(defn vert-mirror
  "Str -> Str"
  [string]
  (->> (str/split string #"\n")
       (map #(apply str (reverse %)))
       (str/join "\n")))

(defn hor-mirror
  "Str -> Str"
  [string]
  (->> (str/split string #"\n")
       reverse
       (str/join "\n")))

(defn oper [func string]
  (func string))

  (deftest test-cases
    (is (= (oper vert-mirror "abcd\nefgh\nijkl\nmnop") "dcba\nhgfe\nlkji\nponm"))
    (is (= (oper hor-mirror "abcd\nefgh\nijkl\nmnop") "mnop\nijkl\nefgh\nabcd"))
    )