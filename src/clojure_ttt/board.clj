(ns clojure-ttt.board)

(defn create-board [size]
  (take (* size size) (repeat "-")))

(defn mark-board [position board player]
  (assoc position player))
