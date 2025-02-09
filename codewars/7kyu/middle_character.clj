(ns middle-character
    (:require [clojure.string :as str])
)

(defn get-middle-character
  [string]
  (let [length (count string)]
    (if (even? length)       
      (subs string (- (/ length 2) 1) (+ (/ length 2) 1))
      (subs string (/ length 2) (+ (/ length 2) 1))
        ))
)

(get-middle-character "This")
(get-middle-character "Thi")