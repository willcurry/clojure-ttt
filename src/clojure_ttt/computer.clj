(ns clojure-ttt.computer
  (use [clojure-ttt.board]))

  (defn minimax [board player]
      (some #(cond 
        (any-wins? (mark-board board % player) 3) %)
          (available-positions board)))
