(ns clj-couchdb.core
	(:require [clj-http.client :as client]
		      [clj-json.core :as json]))

(defn fetch [base db id & [user pass]]
	(json/parse-string (:body (client/get (str base "/" db "/" id) {:basic-auth [user pass]}))))

(defn insert [base db doc & [user pass]]
	(client/post (str base "/" db) {:body (json/generate-string doc)
		                            :basic-auth [user pass]
		                            :content-type :json
		                            :accept :json}))
