(ns clj-couchdb.core
	(:require [clj-http.client :as client]
		      [clj-json.core :as json]))

(defn fetch [base db id]
	(json/parse-string (:body (client/get (str base "/" db "/" id)))))

(defn insert [base db docs]
	(client/post (str base "/" db) {:body (json/generate-string docs)
		                            :content-type :json
		                            :accept :json}))
