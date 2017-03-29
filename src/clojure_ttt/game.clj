(ns clojure-ttt.game
  (use [clojure-ttt.board]))

(defn game-over? [board]
  (or (draw? board) (any-wins? board (size board))))

(defn- read-move []
  (read-string (read-line)))

(defn make-move [board player]
  (mark-board board (read-move) player))

(defn- find-turn [turn]
  (if (= turn "x") "o" "x"))

(defn start-game [board turn]
  (println board)
  (when-not (game-over? board)
    (let [player (find-turn turn)]
      (recur (make-move board player) player))))

(defn -main [& args]
  (start-game (create-board 3) "x"))
