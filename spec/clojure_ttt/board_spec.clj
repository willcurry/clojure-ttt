(ns clojure-ttt.board-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.board :refer :all]))

(describe "board"
  (it "creates a board"
    (should= ["-" "-" "-" "-" "-" "-" "-" "-" "-"] 
      (create-board 3)))

  (it "marks board correctly"
    (should= ["-" "x" "-" "-" "-" "-" "-" "-" "-"] 
      (mark-board (create-board 3) 1 "x")))

  (it "should know if someone has won row"
    (should= true (any-wins? ["x" "x" "x" "-" "-" "-" "-" "-" "-"])))

  (it "should know if someone has won column"
    (should= true (any-wins? ["x" "-" "-" "x" "-" "-" "x" "-" "-"])))

  (it "should know if someone has won left diagonal"
    (should= true (any-wins? ["-" "-" "x" "-" "x" "-" "x" "-" "-"])))

  (it "should know if someone has won right diagonal"
    (should= true (any-wins? ["x" "-" "-" "-" "x" "-" "-" "-" "x"])))

  (it "should know if there is no wins"
    (should= false (any-wins? ["-" "-" "o" "-" "x" "-" "x" "-" "-"])))

  (it "should know if there is a draw"
    (should= true (draw? ["x"])))

  (it "should know if a position is valid"
    (should= true (valid-position? ["x" "-"] 1)))

  (it "should know if a position is not valid"
    (should= false (valid-position? ["x" "-"] 0)))

  (it "should know all available positions"
    (should= [1 2] (available-positions ["x" "-" "-"])))

  (it "should return an empty list when no positions free"
    (should= [] (available-positions ["x"])))

  (it "should return all positions if all positions are free"
    (should= [0 1 2] (available-positions ["-" "-" "-"])))
  
  (it "know whos turn it is"
    (should= "x" (find-turn ["o" "-" "-"])))

  (it "know who went last"
    (should= "o" (last-move ["o" "-" "-"]))))
