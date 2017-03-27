(ns clojure-ttt.board)

(defn create-board [size]
  (take (* size size) (repeat "-")))
