(ns clojure-advent-2019-2.day-3)


(defn wire-path-parser
  "read in wire path in format X#,Y#,... where X is enum U,D,L,R and # is
   how often command is repeated."
  ([path-commands]
   (def hash-mapped-path
     (reduce
       (fn [command]
         (dotimes [n (Character/digit (nth command 0) 10)]
           (def piss (conj [] n))))
       (clojure.string/split path-commands #",")))
   (print "piss" piss) ))

;an intersection at 4,4 leaves it 8 mh away.
;an intersection at 7,1 leaves it 8 mh away.
(defn fuck-parsing-bullshit
  ([mapped-commands]
   (println (nth mapped-commands 0))))

(fuck-parsing-bullshit [{:0 [0]},{:0 [0]}])