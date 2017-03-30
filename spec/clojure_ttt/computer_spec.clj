(ns clojure-ttt.computer-spec
  (:require [speclj.core :refer :all]
  [clojure-ttt.computer :refer :all]))

(describe "computer"
  (it "returns the last available position"
    (should= 1 (minimax ["x" "-" "x"
                         "x" "x" "o"
                         "o" "x" "o"] "x")))

  (it "blocks and goes for the win"
    (should= 2 (minimax ["x" "-" "-"
                         "o" "o" "x"
                         "o" "x" "x"] "x")))
  )
