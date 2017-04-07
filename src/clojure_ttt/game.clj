(ns clojure-ttt.game
  (use [clojure-ttt.board]
       [clojure-ttt.computer]
       [clojure-ttt.presenter]))

(defn game-over? [board]
  (or (draw? board) (any-wins? board)))

(defn- read-move []
  (read-string (read-line)))

(defn make-move [board player]
  (let [move (read-move)]
    (cond 
      (valid-position? board move) (mark-board board move player)
      :else board)))

(defn make-move-computer [board player]
  (mark-board board (find-best-move board player) player))

(defn play-until-over [board gamemode]
  (show-board board)
  (when-not (game-over? board)
    (let [turn (find-turn board)]
        (cond 
          (and (= gamemode :hvc) (= turn "o")) (recur (make-move-computer board turn) gamemode)
          (= gamemode :cvc) (recur (make-move-computer board turn) gamemode)
          :else (recur (make-move board turn) gamemode)))))

(defn- ask-for-settings [board]
  (show-gamemode-options)
  (let [input (read-move)]
    (cond 
      (= input 1) (play-until-over board :hvc)
      (= input 2) (play-until-over board :cvc)
      :else (play-until-over board :hvh))))

(defn -main [& args]
  (ask-for-settings (create-board 3)))
