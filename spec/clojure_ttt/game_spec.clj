(ns clojure-ttt.game-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.game :refer :all]
            [clojure-ttt.board :refer :all]))

(describe "game"
  (it "knows if the game is over"
    (should= true (game-over? ["x"])))

  (it "knows if the game is not over"
    (should= false (game-over? ["-"])))

  (it "should make a move" 
      (should= ["o" "x" "-"]
        (with-in-str "1" 
          (make-move ["o" "-" "-"]))))

  (it "does not let you make moves in invalid cells"
    (should= ["-"]
      (with-in-str "10"
        make-move ["-"]))))
