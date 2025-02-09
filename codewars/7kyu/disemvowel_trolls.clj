(ns disemvowel-trolls
    (:require [clojure.string :as str])
)

(defn disemvowel
  [string]
  (str/replace string #"[aeiou]" "")
)

(is (= (disemvowel "This website is for losers LOL!") "Ths wbst s fr lsrs LL!"))