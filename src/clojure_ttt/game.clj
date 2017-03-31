(ns clojure-ttt.game
  (use [clojure-ttt.board]))

(defn game-over? [board]
  (or (draw? board) (any-wins? board)))

(defn- read-move []
  (read-string (read-line)))

(defn- find-turn [board]
  (cond
    (even? (count (available-positions board))) "x"
    :else "o"))

(defn make-move [board]
  (let [move (read-move)]
    (cond 
      (valid-position? board move) (mark-board board move (find-turn board))
      :else board)))

(defn start-game [board]
  (println board)
  (when-not (game-over? board)
    (recur (make-move board))))

(defn -main [& args]
  (start-game (create-board 3)))
