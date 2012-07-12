(ns matrix.core
  (:use [lumiere.lumiere])
  (:use clojure.contrib.str-utils)
  (:gen-class))


(def chars-by-random
          (map char (concat (range 33 58) (range 66 92) (range 97 127))))

(defn random-char []
        (nth chars-by-random (rand-int (count chars-by-random))))

(defn random-string [length]
  (str-join " " (take length (repeatedly random-char))))

(def matrix (agent nil))

(defn ani-matrix [x]
  (send-off *agent* #'ani-matrix)
  (println (str (bold (green (random-string 100)))))
  (. Thread (sleep 700)))

;  (send-off matrix ani-matrix)

(defn -main [& args]
  (loop []
    (println (str (bold (green (random-string 100)))))
    (. Thread (sleep 200))    
    (recur))
  )

