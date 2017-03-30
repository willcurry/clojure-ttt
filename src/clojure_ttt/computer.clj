(ns clojure-ttt.computer
  (use [clojure-ttt.board]))

  (defn opposite-player [player]
    (if (= player "x") "o" "x"))

  (defn minimax [board player]
      (some #(cond 
        (any-wins? (mark-board board % (opposite-player player)) 3) %
        (any-wins? (mark-board board % player) 3) %)
          (available-positions board)))
