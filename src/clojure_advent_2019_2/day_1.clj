(ns clojure-advent-2019-2.day_1
    (:gen-class)
    (:require [clojure-advent-2019-2.day-1-data :as data]))

;; Part 1 - calculating total fuel
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Santa has become stranded at the edge of the Solar System while delivering presents to other planets! To accurately
;; calculate his position in space, safely align his warp drive, and return to Earth in time to save Christmas, he needs
;; you to bring him measurements from fifty stars.

;; Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second
;; puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

;; The Elves quickly load you into a spacecraft and prepare to launch.

;; At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of
;; fuel required yet.

;; Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module,
;; take its mass, divide by three, round down, and subtract 2.

;; For example:

;; For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
;; For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
;; For a mass of 1969, the fuel required is 654.
;; For a mass of 100756, the fuel required is 33583.


;; The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.

;; What is the sum of the fuel requirements for all of the modules on your spacecraft?

;; To begin, get your puzzle input.

(defn fuelCalculator
      "Calculate the fuel for a given module based on its mass.
      Divide mass by 3, round down to Integer then subtract 2
        Argument: mass - an integer
        Return: fuel-required - as an integer"
      [mass]
      ;(println type (Math/floor(/ 3 2)))
      (- (quot mass 3) 2))

(defn fuelCounterUpper
      "sum the result of fuelCalculator being called on the elements
      of the given vector of masses
        Argument: input_vector - a [vector] of integers
        Return: total-fuel-required - an integer"
      [input_vector]
      (reduce + (map fuelCalculator input_vector))
      )


(defn -main
      "Run me and I will tell you the answer to the problem, eventually"
      [& args]
      (fuelCounterUpper data/puzzle-input))

;(-main)

