(defn positive-sum [xs] 
  (reduce #(+ %1 
  (if (pos? %2) %2 0)) 
  0 xs)
  )

  (defn positive-sum1 [xs] 
  (reduce + (filter pos? xs))
  )

(positive-sum1 [1 -2 1 0 1 -5])