# clj-couchdb

A simple client for accessing couchdb.  

*Caution: this version is my first go at it, so the API is likely to change*

## Usage

````clojure
(require '[clj-couchdb.core :as couch])

(def base "https://gorsuch.cloudant.com")

(def db "sandbox")

(couch/insert base db {:id "abc"
		               :title "Yo dawg, I hear you like Clojure!" 
                       :body "[insert all of the wonderful things I want to say about Clojure here]"})

(couch/fetch base db "abc")
````

## License

Copyright (C) Michael Gorsuch <michael.gorsuch@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
