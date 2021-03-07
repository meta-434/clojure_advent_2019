(ns clojure-advent-2019-2.day_2
  (:gen-class))

(defn intCodeCalculator
  "read in a vector that follows the intCode format"
  ([intCode] (intCodeCalculator intCode 0))
  ([intCode pointer]
    (let [codeChunk (subvec intCode pointer (+ pointer 4))]
      (case (nth codeChunk 0)
        1 (intCodeCalculator (assoc intCode (nth codeChunk 3) (+ (nth codeChunk 1) (nth codeChunk 2))) (+ pointer 4))
        2 (intCodeCalculator (assoc intCode (nth codeChunk 3) (* (nth codeChunk 1) (nth codeChunk 2))) (+ pointer 4))
        99 (println (concat "the final intCode is: " intCode))
      )
    )
  )
)