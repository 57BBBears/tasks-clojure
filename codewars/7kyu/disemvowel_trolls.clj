(ns disemvowel-trolls
  (:require [clojure.string :as str])
  (:require [clojure.test :refer [is]])
  )

(defn disemvowel
  [string]
  (str/replace string #"[AaEeIiOoUu]" "")
)

;; (use '[clojure.test :only [is]])
(is (= (disemvowel "This website is for losers LOL!") "Ths wbst s fr lsrs LL!"))