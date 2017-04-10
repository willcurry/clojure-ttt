(ns clojure-ttt.presenter
  (use [clojure-ttt.board]))

(defn- clear-console []
  (println "\033[H\033[2J"))

(defn- welcome-user []
  (println "\033[35mWelcome! Please select a gamemode.")
  (println "------------------------------------------"))

(defn show-gamemode-options []
  (clear-console)
  (welcome-user)
  (println "\033[36mType 0 to play human vs human. \n1 to play vs a computer. \n2 to watch two computers play."))

(defn show-board [board]
  (let [partitioned-board (map #(apply str %) (partition 3 board))]
    (print "\033[31m")
    (println (apply str(interpose "\n" partitioned-board)))))

(defn show-round-message [board]
  (println (str "\033[35m" "--------------------------"))
  (cond
    (any-wins? board) (println (str (last-move board) " has won the game!"))
    (draw? board) (println "The game is a draw!")
    :else (println (str (find-turn board) " please make your move."))))

(defn show-options []
  (println "Press 1 to play again, anything else to quit."))
