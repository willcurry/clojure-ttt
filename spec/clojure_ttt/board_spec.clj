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
    (should= true (any-wins? ["x" "x" "x" "-" "-" "-" "-" "-" "-"] 3)))

  (it "should know if someone has won column"
    (should= true (any-wins? ["x" "-" "-" "x" "-" "-" "x" "-" "-"] 3)))

  (it "should know if someone has won left diagonal"
    (should= true (any-wins? ["-" "-" "x" "-" "x" "-" "x" "-" "-"] 3)))

  (it "should know if someone has won right diagonal"
    (should= true (any-wins? ["x" "-" "-" "-" "x" "-" "-" "-" "x"] 3)))

  (it "should know if there is no wins"
    (should= false (any-wins? ["-" "-" "o" "-" "x" "-" "x" "-" "-"] 3)))

  (it "should know if there is a draw"
    (should= true (draw? ["x"])))
  )
