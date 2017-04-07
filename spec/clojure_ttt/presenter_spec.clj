(ns clojure-ttt.presenter-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.presenter :refer :all]))

(describe "presenter"
  (it "displays gamemode options"
    (should-contain "\nType 0 to play human vs human"
      (with-out-str (show-gamemode-options))))

  (it "displays the board correctly"
    (should-contain "x--\nx--\n---"
      (with-out-str (show-board ["x" "-" "-" "x" "-" "-" "-" "-" "-"])))))
