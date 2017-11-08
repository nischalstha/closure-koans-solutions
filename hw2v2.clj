(let [alpha (into #{} (concat (map char (range (int \a) (inc (int \z))))
                              (map char (range (int \A) (inc (int \Z))))))
      rot13-map (zipmap alpha (take 52 (drop 26 (cycle alpha))))]

  (defn rot13[s]
    (apply str (map #(get rot13-map % %) s))))

(defn zap-chars [toremove tostring]
  	(apply str (remove 
  	   #((set toremove) %) tostring)))


(defn shallow-reverse [lst]
  (if (empty? lst)
      lst
      (concat (shallow-reverse (rest lst)) (list (first lst)))))

(defn deep-reverse [lst]
  (if (empty? lst) ()
      (cons (if (seq? (last lst)) (deep-reverse (last lst))
                (last lst))
            (deep-reverse (butlast lst)))))
          
(rot13 "Alan Garvey")
(zap-chars "Aa" "Alan Garvey")
(shallow-reverse '(1 (2 3) 4))
(deep-reverse '(1 (2 (3 4 5)) (2 3)))

