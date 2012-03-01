(ns clj-couchdb.core
	(:require [clj-http.client :as client]
		  [cheshire.core :as json]))

(defn fetch [db id & [params]]
  (json/parse-string (:body (client/get (str db "/" id) params)) true))

(defn insert [db doc & [params]]
  (client/post
   db
   (merge {:body (json/generate-string doc)
           :content-type :json
           :accept :json}
          params)))

(defn view [db design-doc name & [params]]
  (json/parse-string (:body (client/get (db "/_design/" design-doc "/_view/" name) params))))
