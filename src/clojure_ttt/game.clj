(ns clojure-ttt.game
  (use [clojure-ttt.board]))

(defn game-over? [board]
  (or (draw? board) (any-wins? board)))

(defn- read-move []
  (read-string (read-line)))

(defn make-move [board player]
  (let [move (read-move)]
    (cond 
      (valid-position? board move) (mark-board board move player)
      :else board)))

(defn start-game [board]
  (println board)
  (when-not (game-over? board)
    (recur (make-move board (find-turn board)))))

(defn- ask-for-settings []
  (println "\033[H\033[2J")
  (println "Type 0 to play human vs human. \n1 to play vs a computer. \n2 to watch two computers play!")
  (let [input (read-move)]
    (cond 
      (= 1 input) (start-game (create-board 3))
      :else (start-game (create-board 3)))))

(defn -main [& args]
  (ask-for-settings))
