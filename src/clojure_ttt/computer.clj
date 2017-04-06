(ns clojure-ttt.computer
  (use [clojure-ttt.board]))

  (defn- score [board depth marks]
    (cond 
      (and (any-wins? board) (= (last-move board) (first marks))) depth
      (and (any-wins? board) (= (last-move board) (second marks))) (- depth)
      :else 0))

  (defn- all-moves-played [board mark positions]
    (map #(mark-board board % mark) positions))

  (defn- initial-score [marks player]
    (if (= (first marks) player) 
      {:score -1000 :board nil} 
      {:score 1000 :board nil}))

  (defn- favours-computer? [marks player new-score current-best]
    (if (= (first marks) player) 
      (> new-score (:score current-best)) 
      (< new-score (:score current-best))))

  (defn- minimax [board player depth marks]
    (if (or (= depth 0) (or (any-wins? board) (draw? board)))
      {:score (score board depth marks) :board board}
      
      (reduce (fn [current-best played-board]
        (let 
         [new-scored-move (minimax played-board (last-move board) (dec depth) marks)
          new-score (:score new-scored-move)]

        (if (favours-computer? marks player new-score current-best)
          {:score new-score :board played-board}
          current-best)))
        (initial-score marks player)
      (all-moves-played board player (available-positions board)))))

  (defn find-best-move [board player]
    (:board (minimax board player 8 ["x" "o"])))
