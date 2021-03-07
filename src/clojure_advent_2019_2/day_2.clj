(ns clojure-advent-2019-2.day_2
  (:gen-class))

;On the way to your gravity assist around the Moon, your ship computer beeps angrily about a "1202 program alarm".
;On the radio, an Elf is already explaining how to handle the situation: "Don't worry, that's perfectly norma--" The
;ship computer bursts into flames. You notify the Elves that the computer's magic smoke seems to have escaped. "That
;computer ran Intcode programs like the gravity assist program it was working on; surely there are enough spare parts up
;there to build a new Intcode computer!"
;
;An Intcode program is a list of integers separated by commas (like 1,0,0,3,99). To run one, start by looking at the
;first integer (called position 0). Here, you will find an opcode - either 1, 2, or 99. The opcode indicates what to do;
;for example, 99 means that the program is finished and should immediately halt. Encountering an unknown opcode means
;something went wrong. Opcode 1 adds together numbers read from two positions and stores the result in a third position.
;The three integers immediately after the opcode tell you these three positions - the first two indicate the positions
;from which you should read the input values, and the third indicates the position at which the output should be stored.
;For example, if your Intcode computer encounters 1,10,20,30, it should read the values at positions 10 and 20, add
;those values, and then overwrite the value at position 30 with their sum. Opcode 2 works exactly like opcode 1, except
;it multiplies the two inputs instead of adding them. Again, the three integers after the opcode indicate where the
;inputs and outputs are, not their values. Once you're done processing an opcode, move to the next one by stepping
;forward 4 positions.

(defn intCodeCalculator
  "read in a comma separated list (string) that follows the intCode format"
  ([intCode] (intCodeCalculator intCode 0))
  ([intCode pointer]
   (println (nth intCode pointer))
    (let [codeChunk (subvec intCode pointer (+ pointer 4))]
      (case (nth codeChunk 0)
        1 (intCodeCalculator (assoc intCode (nth codeChunk 3) (+ (nth codeChunk 1) (nth codeChunk 2))) (+ pointer 4))
        2 (intCodeCalculator (assoc intCode (nth codeChunk 3) (* (nth codeChunk 1) (nth codeChunk 2))) (+ pointer 4))
        99 (println (concat "the final intCode is: " intCode))
      )
    )
  )
)

; expect (intCodeCalculator [1 1 1 4 99 5 6 0 99]) to be [30 1 1 4 2 5 6 0 99]