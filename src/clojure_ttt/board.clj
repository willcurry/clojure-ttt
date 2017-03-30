(ns clojure-ttt.board)

(defn create-board [size]
  (vec (take (* size size) (repeat "-"))))

(defn mark-board [board position player]
  (assoc board position player))

(defn- rows [board size]
  (partition size board))

(defn- columns [board size]
  (apply map vector (partition size board)))

(defn- right-diagonal [board size]
  [(map #(nth board %) 
    (range 0 (* size size) (inc size)))])

(defn- left-diagonal [board size]
  [(map #(nth board %) 
    (range (dec size) (dec (* size size)) (dec size)))])

(defn- winning-lines [board size]
  [(rows board size) (columns board size) (right-diagonal board size) (left-diagonal board size)])

(defn- has-win? [line]
  (some #(and (= 1 (count (distinct %))) (not (some #{"-"} %))) line))

(defn any-wins? [board size]
  (true? (some #(has-win? %) (winning-lines board size))))

(defn draw? [board]
  (not (some #{"-"} board)))

(defn size [board]
  (int (Math/sqrt (count board))))

(defn valid-position? [board position]
  (and (= "-" (nth board position)) 
    (and (< position 0) (> position (size)))))

(defn available-positions [board]
  (->> (zipmap (iterate inc 0) board)
       (filter (fn [[position cell]] (= cell "-")))
       (map (fn [[position cell]] position))))
