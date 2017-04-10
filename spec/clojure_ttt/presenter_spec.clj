(ns clojure-ttt.presenter-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.presenter :refer :all]))

(describe "presenter"
  (it "displays gamemode options"
    (should-contain "Type 0 to play human vs human"
      (with-out-str (show-gamemode-options))))

  (it "displays the board correctly"
    (should-contain "x--\nx--\n---"
      (with-out-str (show-board ["x" "-" "-" "x" "-" "-" "-" "-" "-"]))))

  (it "displays the winner"
    (should-contain "x has won the game!"
      (with-out-str (show-round-message ["x" "x" "x" "o" "-" "-" "-" "o" "o"]))))

  (it "displays if its a draw"
    (should-contain "draw"
      (with-out-str (show-round-message ["x" "x" "o" 
                                         "o" "x" "x"
                                         "x" "o" "o"])))))
