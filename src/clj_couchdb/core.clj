(ns clj-couchdb.core
	(:require [clj-http.client :as client]
		      [clj-json.core :as json]))

(defn fetch [base db id & [params]]
	(json/parse-string (:body (client/get (str base "/" db "/" id) params))))

(defn insert [base db doc & [params]]
	(client/post (str base "/" db) (merge {:body (json/generate-string doc)
		                                   :content-type :json
		                                   :accept :json} params)))

(defn view [base db design-doc name & [params]]
	(json/parse-string (:body (client/get (str base "/" db "/_design/" design-doc "/_view/" name) params))))