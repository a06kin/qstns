(ns first-test
  (:use
    [clojure.test])
  (:import [java.util HashSet]))

(defn new-empty-set []
  (HashSet.))

(deftest test-empty-set
  (is (= 0 (.size (new-empty-set))))
  (is (= true (.isEmpty (new-empty-set))))
  (is (= (new-empty-set) (new-empty-set))))

(deftest test-add-remove
  (is (= (new-empty-set)
        (doto (new-empty-set)
          (.add "xyz")
          (.remove "xyz")))))