(ns clojure-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.board :refer :all]))

(describe "board"
  (it "creates a board"
    (should= ["-" "-" "-" "-" "-" "-" "-" "-" "-"] (create-board 3)))

  (it "marks board correctly"
    (should= ["-" "x" "-" "-" "-" "-" "-" "-" "-"] (mark-board (create-board 3) 1 "x")))

  (it "should know the rows"
    (should= ["x" "-" "x"] (first (rows ["x" "-" "x" "-" "-" "-" "-" "-" "-"]))))
  )
