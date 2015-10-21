(ns ic.lv)

(def current-slide (atom 1))
(def slides (atom {}))

(defn add-slide [key text]
  (swap! slides assoc key text))

(def sep-slide "----------------------------------------")

(defn slide
  ([] (slide @current-slide))
  ([key] (println sep-slide)
   (println (@slides key))
   (println sep-slide)
   (str "[slide:" key "]")) )

(defn next-slide []
  (swap! current-slide inc)
  (slide))

(def sl slide)
(def nsl next-slide)

(add-slide 1 "Clojure is a LISP dialect.
-> prefix notation
-> (operator operand-1 operand-2 ... operand-n)
example inc (3) becomes (inc 3)")

(comment 1
         ;; inc (3)
         (inc 3)
         ;; inc (inc (3))
         (inc (inc (3)))
  )

(add-slide 2 "If first element is not an operator
-> error")

(comment 2
         ("text" 1 3)
         )

(add-slide 3 "+ or and - are just operands.
Operators can accept different number of arguments.
Arity is strict. Wrong arity -> Exception")

(comment 3
         (+ 1 3 4)
         (+ 1 3)
         (+)
         +
         (source +)
         ;; error ArityException
         (inc 2 4)
  )

(add-slide 4 "Prefix notation ->
no need for op preference
2 * 3 + 4 or 4 + 2 * 3 -> (+ 4 (* 2 3))")

(comment 4
  (+ 4 (* 2 3)))

(add-slide 5 "Evaluation of expressions
(+ (* 2 3) (- 5 1))
-> (+ 6 (- 5 1))
-> (+ 6 4)
-> 10")

(comment 5
  (+ (* 2 3) (- 5 1))
  )

(add-slide 6 "An operators can be a:
- Function
- Macro
- Special Form")
