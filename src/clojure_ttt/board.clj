(ns clojure-ttt.board)

(defn create-board [size]
  (vec (take (* size size) (repeat "-"))))

(defn mark-board [board position player]
  (assoc board position player))

(defn rows [board]
  (partition 3 board))

(defn columns [board]
  (apply map vector (partition 3 board)))
