(ns clojure-ttt.board)

(defn create-board [size]
  (vec (take (* size size) (repeat "-"))))

(defn mark-board [board position player]
  (assoc board position player))

(defn rows [board size]
  (partition size board))

(defn columns [board size]
  (apply map vector (partition size board)))

(defn right-diagonal [board size]
  [(map #(nth board %) 
    (range 0 (* size size) (inc size)))])

(defn left-diagonal [board size]
  [(map #(nth board %) 
    (range (dec size) (dec (* size size)) (dec size)))])
