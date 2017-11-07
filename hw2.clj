(defn shift13 [start n]
  (let [s (int start)
        c (int n)]
    (char (if (<= s c (+ s 25))
            (+ s (mod (+ (- c s) 13) 26))
            n))))

(defn rot13 [st]
  (->> (map (fn [x]
              (let [n (int x)]
                (cond
                 (<= 65 n 90) (shift13 \A x)
                 (<= 97 n 122) (shift13 \a x)
                 :else x)))
            (seq st))
       (apply str)))

(rot13 "Alan Garvey")


(defn zap-chars [chars coll]
  	(apply str (remove #((set chars) %) coll)))

(zap-chars "Aa" "Alan Garvey")


(defn shallow-reverse [lst]
  (if-not (empty? lst)
    (cons
      (last lst)
      (shallow-reverse (butlast lst))
      )
    ()
    )
  )

(shallow-reverse '(1 (2 3) 4))

(defn deep-reverse[lst]
  (if (or (not (list? lst)) (empty? lst)) lst
      (concat (deep-reverse (rest lst))
	    (list (deep-reverse (first lst))))))

(deep-reverse '(1 (2 (3 4 5)) (2 3)))
