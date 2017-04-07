(ns clojure-ttt.computer
  (use [clojure-ttt.board]))

  (defn- score [board depth marks]
    (cond 
      (and (any-wins? board) (= (last-move board) (first marks))) depth
      (and (any-wins? board) (= (last-move board) (second marks))) (- depth)
      :else 0))

  (defn- all-rounds-played [board player positions]
      (loop [map {}
        postions-sequence (seq positions)]
        (if postions-sequence
          (recur (assoc map (first postions-sequence) (mark-board board (first postions-sequence) player)) (next postions-sequence)) 
          map)))

  (defn- initial-score [marks player]
    (if (= (first marks) player) 
      {:score -1000 :board nil} 
      {:score 1000 :board nil}))

  (defn- favours-computer? [marks player new-score current-best]
    (if (= (first marks) player) 
      (> new-score (:score current-best)) 
      (< new-score (:score current-best))))

  (defn- game-over? [board]
    (or (any-wins? board) (draw? board)))

  (defn- minimax [board player depth marks]
    (if (or (= depth 0) (game-over? board))
      {:score (score board depth marks) :board board}
      
      (reduce (fn [current-best played-round]
        (let [played-board (second played-round)
          played-move (first played-round)
          new-scored-move (minimax played-board (last-move board) (dec depth) marks)
          new-score (:score new-scored-move)]
        (if (favours-computer? marks player new-score current-best)
          {:score new-score :board played-board :move played-move}
          current-best)))
        (initial-score marks player)
      (all-rounds-played board player (available-positions board)))))

  (defn find-best-move [board player]
    (:move (minimax board player (min 8 (count (available-positions board))) ["x" "o"])))
