(ns clojure-ttt.computer-spec
  (:require [speclj.core :refer :all]
  [clojure-ttt.computer :refer :all]))

(describe "computer"
  (it "returns the last available position"
    (should= ["o" "x" "x"
              "x" "x" "o"
              "o" "x" "o"] (find-best-move 
                        ["o" "-" "x"
                         "x" "x" "o"
                         "o" "x" "o"] "x")))

  (it "blocks and goes for the win"
    (should= ["x" "-" "x"
              "o" "o" "x"
              "o" "x" "x"] (find-best-move 
                        ["x" "-" "-"
                         "o" "o" "x"
                         "o" "x" "x"] "x")))

  (it "blocks the win"
    (should= ["o" "x" "-"
              "o" "-" "-"
              "x" "-" "-"] (find-best-move 
                        ["o" "x" "-"
                         "o" "-" "-"
                         "-" "-" "-"] "x")))
  (it "goes for the win"
    (should= ["x" "o" "o"
              "x" "o" "-"
              "x" "-" "-"] (find-best-move 
                        ["x" "o" "o"
                         "x" "o" "-"
                         "-" "-" "-"] "x")))
  )
