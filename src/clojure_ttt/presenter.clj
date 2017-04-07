(ns clojure-ttt.presenter)

(defn- clear-console []
  (println "\033[H\033[2J"))

(defn show-gamemode-options []
  (clear-console)
  (println "Type 0 to play human vs human. \n1 to play vs a computer. \n2 to watch two computers play."))

(defn show-board [board]
  (println board))
